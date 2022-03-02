grammar Calculette;

@header {
    import java.util.HashMap;
}

@members {

     private int _cur_label = 1;
    /** générateur de nom d'étiquettes pour les boucles */
    private String getNewLabel() { return "Label" +(_cur_label++); }

    //Tables des symboles
    private TablesSymboles tablesSymboles = new TablesSymboles();
    
    //Methode évaluant une expression
    private String evalexpr (String x, String op, String y) {
        if ( op.equals("*") ){
            return x+y+"MUL\n";
        }
        if ( op.equals("+") ){
            return x+y+"ADD\n";
        } 
        if ( op.equals("/") ){
            return x+y+"DIV\n";
        }
        if ( op.equals("-") ){
            return x+y+"SUB\n";
        }
        else {
           System.err.println("Opérateur arithmétique incorrect : '"+op+"'");
           throw new IllegalArgumentException("Opérateur arithmétique incorrect : '"+op+"'");
        }
    }

    private String evalCondition(String condition){
        switch(condition){
            case "<=":
                return "INFEQ";
            case ">=":
                return "SUPEQ";
            case "<":
                return "INF";
            case ">":
                return "SUP";
            case "==":
                return "EQUAL";
            case "!=":
                return "NEQ";
            case "<>":
                return "NEQ";
            default:
                return "";
        }
       
    }
}



start
    : calcul EOF
    ;

calcul returns [ String code ]
@init{ $code = new String(); }   // On initialise code, pour ensuite l'utiliser comme accumulateur
@after{ System.out.println($code); } // Affiche contenu pile
    : 
        (decl { $code += $decl.code; })*

        NEWLINE*

        (instruction { $code += $instruction.code; })*

        { $code += "HALT\n"; }
    ;

instruction returns [ String code ] 
    : expression finInstruction 
        { 
            $code=$expression.code;
        }
    | assignation finInstruction
        { 
            $code=$assignation.code;
        }
    | 'read' '(' IDENTIFIANT ')' finInstruction 
        {
            $code="READ\n";
            AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
            int adresse = at.adresse;
            $code+="STOREG " +adresse+"\n";
        }
    | 'write' '(' expression ')' finInstruction
        { 
            $code=$expression.code + "WRITE\nPOP\n";
        }
    | boucle
        {
            $code=$boucle.code;
        }
    | finInstruction
        {
            $code="";
        }
    ;

expression returns [ String code ]
    : '(' a=expression ')' {$code = $a.code;}
    | a=expression op=('/' | '*') b=expression {$code = evalexpr($a.code,$op.text,$b.code);}
    | a=expression op=('+' | '-') b=expression {$code = evalexpr($a.code,$op.text,$b.code);}
    | ENTIER {$code= "PUSHI " + $ENTIER.text +"\n";} 
    | '-' ENTIER {$code="PUSHI -" + $ENTIER.text +"\n";}
    | IDENTIFIANT { 
                AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
                int adresse = at.adresse;
                $code = "PUSHG " +adresse+"\n";
            }
    ;

finInstruction : ( NEWLINE | ';' )+ ;

decl returns [ String code ] 
    :
        'var' IDENTIFIANT ':' TYPE finInstruction
        {
            if($TYPE.text.equals("int")){
                tablesSymboles.putVar($IDENTIFIANT.text,"int");
                $code="PUSHI 0\n";
            }
            if($TYPE.text.equals("double")){
                tablesSymboles.putVar($IDENTIFIANT.text,"double");
                $code="PUSHF 0.0\n";
            }
        }
        |
        'var' IDENTIFIANT ':' TYPE '=' expression finInstruction
        {
            if($TYPE.text.equals("int")){
                tablesSymboles.putVar($IDENTIFIANT.text,"int");
                $code=$expression.code;
            }
        
        }
    ; 

assignation returns [ String code ] 
    : IDENTIFIANT op=('=' |'+=') expression
        {  
            AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
            int adresse = at.adresse;
            if($op.text.equals("=")){    
                $code = $expression.code + "STOREG " + adresse +"\n";
            }
            if($op.text.equals("+=")){
                $code= $expression.code + "PUSHG " +adresse +"\n"+"ADD\n"+"STOREG " +adresse +"\n";
             }
        }
    ;
condition returns [String code]
    : 'true'  { $code = "  PUSHI 1\n"; }
    | 'false' { $code = "  PUSHI 0\n"; }
    | a=expression CONDITION b=expression
        {
            $code=$a.code;
            $code+=$b.code;
            $code+=evalCondition($CONDITION.text)+"\n";
        }
    ;
bloc returns [String code ]
@init{ $code = new String();}
    : '{' (instruction{ $code+=$instruction.code;})* '}'
           
    ;
boucle returns [ String code ]
    : 'while' '(' condition ')' 
        {
            //Générer deux labels un pour le debut et un pour la fin
            String labelDebut = getNewLabel();
            String labelFin=getNewLabel();

            //Label debut 
            $code="LABEL " + labelDebut+"\n";
            $code+=$condition.code;
            //Condition du jump selon 1 ou 0 dans la pile
            $code+="JUMPF "+ labelFin+"\n";
        } 
        //Peut etre suivis d'un bloc ou d'une instruction
        (bloc {$code+= $bloc.code;} | instruction {$code+=$instruction.code;})
        {
            $code+="JUMP " +labelDebut+"\n";
            $code+="LABEL "+labelFin+"\n";
        }

    ;

// lexer
TYPE : 'int' | 'double' ;

IDENTIFIANT : ('a'..'z' | 'A'..'Z' | '_')('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;

CONDITION : ('!=' | '<>' | '<' |'>' | '<=' |'>=');

WS :   (' '|'\t')+  -> skip;

ENTIER : ('0'..'9')+  ;

FLOAT
    :   ('0'..'9')+ '.' ('0'..'9')* EXPONENT?
    |   '.' ('0'..'9')+ EXPONENT?
    |   ('0'..'9')+ EXPONENT
    ;

fragment
EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

NEWLINE : '\r'? '\n';

// Skip les commentaires
COMMENTARY
    :   (COMMENTAIRE | COMMENTAIREETOILE) ->skip
    ;

    fragment  
    COMMENTAIRE : ('%') ~('\n')*;   // COmmence par % suivis de rien ou tous les caractères sauf le \n

    fragment  
    COMMENTAIREETOILE : ('/*') (.)*? ('*/');

OPERATION : '*' | '+' | '-' | '/';

UNMATCH 
    : .->skip
    ;
