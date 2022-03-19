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
    private String evalexpr (String x, String op, String y,String xtype,String ytype) {
        if(xtype.equals("int") && ytype.equals("int")){
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
        }
        if(xtype.equals("double") && ytype.equals("double")){
             if ( op.equals("*") ){
                return x+y+"FMUL\n";
            }
            if ( op.equals("+") ){
                return x+y+"FADD\n";
            } 
            if ( op.equals("/") ){
                return x+y+"FDIV\n";
            }
            if ( op.equals("-") ){
                return x+y+"FSUB\n";
            }
        }

        
           throw new IllegalArgumentException("ERREUR ENTRE LES TYPES ");
        
       
    }
    //Evalue une condition op
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
    //Evalue un boolean
    private String evalBOOL(String bool){
        if(bool.equals("true")){
            return "PUSHI 1\n";
        }
        return "PUSHI 0\n";

    }
    //Evalu le && et ou logique
    private String evalOPLOGIQUE(String c1,String op,String c2){
        //MULTIPLIER LES DEUX RESULTATS DE CONDITIONS DANS LA PILE 
        if(op.equals("&&")){
            return "" + c1 + c2 + "MUL\n";
        }
        //POUR LE OU additionner les deux resultats de condition dans la pile
        return "" + c1 + c2 +"ADD\n";
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
        { $code += "  JUMP Main\n"; }
        NEWLINE*
        
        (fonction { $code += $fonction.code; })* 
        NEWLINE*
        
        { $code += "LABEL Main\n"; }
        (instruction { $code += $instruction.code; })*

        { $code += "  HALT\n"; } 
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
    | READ '(' IDENTIFIANT ')' finInstruction 
        {
            AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
            int adresse = at.adresse;
            String type = at.type;

            if(type.equals("int")){
                $code="READ\n";
                $code+="STOREG " +adresse+"\n";
            }
             if(type.equals("double")){
                $code="READF\n";
                 $code+="STOREG " +(adresse+1)+"\n";
                $code+="STOREG " +adresse+"\n";
             }
        }
    | WRITE '(' expression ')' finInstruction
        { 
            if($expression.type.equals("int")){
                $code=$expression.code + "WRITE\nPOP\n";
            }
            if($expression.type.equals("double")){
                $code=$expression.code + "WRITEF\nPOP\nPOP\n";
            }
        }
    | boucle
        {
            $code=$boucle.code;
        }
    | si
    {
        $code=$si.code; 
    }
    | bloc
        {
            $code=$bloc.code;
        }
    | fonction
    {
        $code=$fonction.code;
    }
    | RETURN expression 
    {
        $code=$expression.code;
        AdresseType at = tablesSymboles.getAdresseType("return");
        int adresse = at.adresse;
        AdresseType atdouble = tablesSymboles.getAdresseType("returndouble");

        if(atdouble!=null){
            $code+="STOREL "+ (atdouble.adresse+1) + "\n";
            $code+="STOREL "+atdouble.adresse+"\n";
        }
        else{ 
            $code+="STOREL "+adresse+"\n";
        }
        $code+="RETURN \n";
    }
    | finInstruction
        {
            $code="";
        }
    ;

expression returns [ String code, String type ]
    : '(' a=expression ')' {$code = $a.code; $type=$a.type;}
    | a=expression op=('/' | '*') b=expression {$code = evalexpr($a.code,$op.text,$b.code,$a.type,$b.type); $type=$a.type;}
    | a=expression op=('+' | '-') b=expression {$code = evalexpr($a.code,$op.text,$b.code,$a.type,$b.type); $type=$a.type;}
    | ENTIER {$code= "PUSHI " + $ENTIER.text +"\n"; $type="int";} 
    | '-' ENTIER {$code="PUSHI -" + $ENTIER.text +"\n"; $type="int";}
    | FLOAT {$code="PUSHF "+$FLOAT.text +"\n"; $type="double";}
    | '-' FLOAT {$code="PUSHF -"+$FLOAT.text +"\n"; $type="double";}
    | IDENTIFIANT '(' args ')'                  // appel de fonction  
        {  
            //Recuperer type de la fonction
            String type = tablesSymboles.getFunction($IDENTIFIANT.text);
            $type=type;
            if(type.equals("int")){
                $code="PUSHI 0\n"; // Reserver l'espce pour un int 
            }
           if(type.equals("double")){
              $code="PUSHF 0.0\n"; // Reserver l'espce pour un float
            }
            $code+=$args.code;
            $code+="CALL "+$IDENTIFIANT.text+"\n";
            int tailleArgument = $args.size;
            while(tailleArgument!=0){
                $code+="POP \n";
                tailleArgument--;
            }
        }

    | IDENTIFIANT { 
                AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
                int adresse = at.adresse;
                String type = at.type;
                $type=type;

                if(adresse>=0){
                    if(type.equals("int")){
                        $code = "PUSHG " +adresse+"\n";
                    }
                    if(type.equals("double")){
                         $code = "PUSHG " +adresse+"\n";
                         $code+= "PUSHG "+(adresse+1)+"\n";
                    }
                }
                else {
                    if(type.equals("int")){
                        $code = "PUSHL " +adresse+"\n";
                    }
                    if(type.equals("double")){
                        $code="PUSHL " + adresse +"\n";
                        $code+="PUSHL " + (adresse+1) +"\n";
                    }
                }
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
            if($TYPE.text.equals("double")){
                tablesSymboles.putVar($IDENTIFIANT.text,"double");
                $code=$expression.code;
            }
        
        }
    ; 

assignation returns [ String code ] 
    : IDENTIFIANT op=('=' |'+=') expression
        {  
            AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
            int adresse = at.adresse;
            String type = at.type;
            $code = $expression.code;

            if($op.text.equals("=")){    
                if(adresse>=0){
                    if(type.equals("int")){
                        $code+="STOREG " + adresse +"\n";
                    }
                    if(type.equals("double")){
                        $code += "STOREG " + (adresse+1) +"\n";
                        $code += "STOREG " + adresse +"\n";
                    }
                }
                else {
                    if(type.equals("int")){
                        $code += "STOREL " + adresse +"\n";
                    }
                     if(type.equals("double")){
                        $code+="STOREL " +(adresse+1) +"\n";
                        $code+="STOREL " +adresse +"\n";
                     }
                }
            }
            if($op.text.equals("+=")){
                if(adresse>=0){
                    if(type.equals("int")){
                        $code+=  "PUSHG " +adresse +"\n"+"ADD\n"+"STOREG " +adresse +"\n";
                    }
                    if(type.equals("double")){
                        $code+= "PUSHG " +adresse+"\n";
                        $code+= "PUSHG "+(adresse+1)+"\n";
                        $code+= "FADD\n";
                        $code += "STOREG " + (adresse+1) +"\n";
                        $code += "STOREG " + adresse +"\n";
                     }
                }
                else {
                    if(type.equals("int")){
                        $code+="PUSHL " +adresse +"\n"+"ADD\n"+"STOREL " +adresse +"\n";
                    }
                    if(type.equals("double")){
                        $code+="PUSHL " + adresse +"\n";
                        $code+="PUSHL " + (adresse+1) +"\n";
                        $code+="FADD\n";
                        $code+="STOREL " +(adresse+1) +"\n";
                        $code+="STOREL " +adresse +"\n";

                    }
                }
             }

        }
    ;

condition returns [String code]
    : NEGLOGIQUE condition {$code=$condition.code + "PUSHI 0\n" + "EQUAL\n";}
    | a=expression CONDITION b=expression
        {
            $code=$a.code;
            $code+=$b.code;
            $code+=evalCondition($CONDITION.text)+"\n";
        }
    | c1=condition OPLOGIQUE c2=condition
        {
            $code=evalOPLOGIQUE($c1.code,$OPLOGIQUE.text,$c2.code);
        }
    | BOOL { $code = evalBOOL($BOOL.text);}
    ;

bloc returns [String code ]
@init{ $code = new String();}
//Concatenner les suites d'instructions
    : '{' (instruction{ $code+=$instruction.code;})* '}' NEWLINE*
           
    ;
boucle returns [ String code ]
@init { $code = new String(); 
        //Générer deux labels un pour le debut et un pour la fin
        String labelDebut = getNewLabel();
        String labelFin=getNewLabel();
    }
    : 'while' '(' condition ')' instruction
        {
            
            //Label debut 
            $code="LABEL " + labelDebut+"\n";
            $code+=$condition.code;
            //Condition du jump selon 1 ou 0 dans la pile
            $code+="JUMPF "+ labelFin+"\n";
            $code+=$instruction.code;
            $code+="JUMP " +labelDebut+"\n";
            $code+="LABEL "+labelFin+"\n";

        } 
    | 'for' '(' init=assignation ';' condition ';' incr=assignation ')' instruction
    {
            $code=$init.code;
            $code+="LABEL " + labelDebut+"\n";
            $code+=$condition.code;
            $code+="JUMPF "+ labelFin+"\n";
            $code+=$instruction.code;
            $code+=$incr.code;
            $code+="JUMP " +labelDebut+"\n";
            $code+="LABEL "+labelFin+"\n";

    }
    | 'repeat' instruction 'until' '(' condition ')'
    {
        $code+="LABEL " + labelDebut+"\n";
        $code+=$instruction.code;
        $code+=$condition.code;
        $code+="JUMPF "+ labelDebut+"\n";
        $code+="LABEL "+labelFin+"\n";

    }

    ;
si returns [ String code ]
@init{
        $code = new String();
        String labelElse = getNewLabel();
        String labelFin=getNewLabel();
    }
    :   'if' '(' condition ')' i=instruction
        {
            
            $code+=$condition.code;
            $code+="JUMPF "+ labelElse+"\n";
            $code+=$i.code;
            $code+="JUMP " + labelFin +"\n";
            $code+="LABEL "+labelElse+"\n";
        }
        ('else' e=instruction
        {
            $code+=$e.code;
        })?
        {$code+="LABEL " +labelFin +"\n";}

    ;
fonction returns [ String code ]
@init{ tablesSymboles.newTableLocale(); 
        $code=new String();
        } // instancier la table locale
@after{ tablesSymboles.dropTableLocale(); } // détruire la table locale
    : 'fun' IDENTIFIANT ':' TYPE 
    
        {
            $code+="LABEL "+$IDENTIFIANT.text+"\n";
            //truc à faire par rapport au "type" de la fonction et code pour la "variable" de retour 
            tablesSymboles.newFunction($IDENTIFIANT.text,$TYPE.text);  
            tablesSymboles.putVar("return",$TYPE.text); 

            if($TYPE.text.equals("double")){
                tablesSymboles.putVar("returndouble",$TYPE.text); 
            }   
	    }
        '('  params ? ')' bloc 
        {
            $code+=$bloc.code;
            $code+="RETURN\n";
        }
    ;
params
    : TYPE IDENTIFIANT 
        { 
            // code java gérant une variable locale (arg0)
            tablesSymboles.putVar($IDENTIFIANT.text,$TYPE.text);
            
        }  
        ( ',' TYPE IDENTIFIANT 
            { 
                // code java gérant une variable locale (argi)
                tablesSymboles.putVar($IDENTIFIANT.text,$TYPE.text);
            } 
        )*
    ;

 // init nécessaire à cause du ? final et donc args peut être vide (mais $args sera non null) 
args returns [ String code, int size] @init{ $code = new String(); $size = 0; }
    : ( expression
    { 
        // code java pour première expression pour arg
        $code+=$expression.code;
        //1 arg int prends une place dans la pile
        if($expression.type.equals("int")){
            $size+=1;
        }
        //1 arg double prend deux places dans la pile
        if($expression.type.equals("double")){
            $size+=2;
        }
    }
    ( ',' expression
    { 
        // code java pour expression suivante pour arg
         $code+=$expression.code;
         if($expression.type.equals("int")){
            $size+=1;
        }
        if($expression.type.equals("double")){
            $size+=2;
        }
    } 
    )* 
      )? 
    ;

// lexer
TYPE : 'int' | 'double' ;
BOOL : 'true' | 'false';
RETURN: 'return';
READ : 'read';
WRITE :'write';

IDENTIFIANT : ('a'..'z' | 'A'..'Z' | '_')('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;

CONDITION : ('!=' | '<>' | '<' |'>' | '<=' |'>=' |'==');

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

OPLOGIQUE : '&&' | '||';

NEGLOGIQUE : '!';

UNMATCH 
    : .->skip
    ;
