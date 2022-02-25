grammar Calculette;

@header {
    import java.util.HashMap;
}

@members {
    
    private TablesSymboles tablesSymboles = new TablesSymboles();

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
                $code=$expression.code +"\n";
            }
        
        }
    ; 

assignation returns [ String code ] 
    : IDENTIFIANT '=' expression
        {  
            AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
            int adresse = at.adresse;
            $code = $expression.code + "STOREG " + adresse +"\n";
        }
    ;

// lexer
TYPE : 'int' | 'double' ;

IDENTIFIANT : ('a'..'z' | 'A'..'Z' | '_')('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;

WS :   (' '|'\t')+  -> skip;

ENTIER : ('0'..'9')+  ;

FLOAT
    :   ('0'..'9')+ '.' ('0'..'9')* EXPONENT?
    |   '.' ('0'..'9')+ EXPONENT?
    |   ('0'..'9')+ EXPONENT
    ;

fragment
EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

NEWLINE : ('#' ~('\n'|'\r')*)? '\r'? '\n' ; // and Comment

COMMENTARY
    :   (COMMENTAIRE | COMMENTAIREETOILE)
    ;

    fragment  
    COMMENTAIRE : ('%') ~('\n')* ('\n');   // COmmence par % suivis de rien ou tous les caractères sauf le \n et termine par un \n

    fragment  
    COMMENTAIREETOILE : ('/*') (.)*? ('*/');

OPERATION : '*' | '+' | '-' | '/';

UNMATCH 
    : .->skip
    ;
