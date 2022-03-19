// Generated from /home/axel/Bureau/automate/tp5-9/Calculette.g4 by ANTLR 4.8

    import java.util.HashMap;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculetteParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, TYPE=22, BOOL=23, RETURN=24, READ=25, 
		WRITE=26, IDENTIFIANT=27, CONDITION=28, WS=29, ENTIER=30, FLOAT=31, NEWLINE=32, 
		COMMENTARY=33, OPERATION=34, OPLOGIQUE=35, NEGLOGIQUE=36, UNMATCH=37;
	public static final int
		RULE_start = 0, RULE_calcul = 1, RULE_instruction = 2, RULE_expression = 3, 
		RULE_finInstruction = 4, RULE_decl = 5, RULE_assignation = 6, RULE_condition = 7, 
		RULE_bloc = 8, RULE_boucle = 9, RULE_si = 10, RULE_fonction = 11, RULE_params = 12, 
		RULE_args = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "calcul", "instruction", "expression", "finInstruction", "decl", 
			"assignation", "condition", "bloc", "boucle", "si", "fonction", "params", 
			"args"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'/'", "'*'", "'+'", "'-'", "';'", "'var'", "':'", 
			"'='", "'+='", "'{'", "'}'", "'while'", "'for'", "'repeat'", "'until'", 
			"'if'", "'else'", "'fun'", "','", null, null, "'return'", "'read'", "'write'", 
			null, null, null, null, null, null, null, null, null, "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "TYPE", "BOOL", 
			"RETURN", "READ", "WRITE", "IDENTIFIANT", "CONDITION", "WS", "ENTIER", 
			"FLOAT", "NEWLINE", "COMMENTARY", "OPERATION", "OPLOGIQUE", "NEGLOGIQUE", 
			"UNMATCH"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Calculette.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



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


	public CalculetteParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public CalculContext calcul() {
			return getRuleContext(CalculContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CalculetteParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			calcul();
			setState(29);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CalculContext extends ParserRuleContext {
		public String code;
		public DeclContext decl;
		public FonctionContext fonction;
		public InstructionContext instruction;
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteParser.NEWLINE, i);
		}
		public List<FonctionContext> fonction() {
			return getRuleContexts(FonctionContext.class);
		}
		public FonctionContext fonction(int i) {
			return getRuleContext(FonctionContext.class,i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public CalculContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calcul; }
	}

	public final CalculContext calcul() throws RecognitionException {
		CalculContext _localctx = new CalculContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_calcul);
		 ((CalculContext)_localctx).code =  new String(); 
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(31);
				((CalculContext)_localctx).decl = decl();
				 _localctx.code += ((CalculContext)_localctx).decl.code; 
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 _localctx.code += "  JUMP Main\n"; 
			setState(43);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(40);
					match(NEWLINE);
					}
					} 
				}
				setState(45);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(51);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(46);
					((CalculContext)_localctx).fonction = fonction();
					 _localctx.code += ((CalculContext)_localctx).fonction.code; 
					}
					} 
				}
				setState(53);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(57);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(54);
					match(NEWLINE);
					}
					} 
				}
				setState(59);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			 _localctx.code += "LABEL Main\n"; 
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << T__6) | (1L << T__11) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__19) | (1L << RETURN) | (1L << READ) | (1L << WRITE) | (1L << IDENTIFIANT) | (1L << ENTIER) | (1L << FLOAT) | (1L << NEWLINE))) != 0)) {
				{
				{
				setState(61);
				((CalculContext)_localctx).instruction = instruction();
				 _localctx.code += ((CalculContext)_localctx).instruction.code; 
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 _localctx.code += "  HALT\n"; 
			}
			_ctx.stop = _input.LT(-1);
			 System.out.println(_localctx.code); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstructionContext extends ParserRuleContext {
		public String code;
		public ExpressionContext expression;
		public AssignationContext assignation;
		public Token IDENTIFIANT;
		public BoucleContext boucle;
		public SiContext si;
		public BlocContext bloc;
		public FonctionContext fonction;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public AssignationContext assignation() {
			return getRuleContext(AssignationContext.class,0);
		}
		public TerminalNode READ() { return getToken(CalculetteParser.READ, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public TerminalNode WRITE() { return getToken(CalculetteParser.WRITE, 0); }
		public BoucleContext boucle() {
			return getRuleContext(BoucleContext.class,0);
		}
		public SiContext si() {
			return getRuleContext(SiContext.class,0);
		}
		public BlocContext bloc() {
			return getRuleContext(BlocContext.class,0);
		}
		public FonctionContext fonction() {
			return getRuleContext(FonctionContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(CalculetteParser.RETURN, 0); }
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instruction);
		try {
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				((InstructionContext)_localctx).expression = expression(0);
				setState(72);
				finInstruction();
				 
				            ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).expression.code;
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				((InstructionContext)_localctx).assignation = assignation();
				setState(76);
				finInstruction();
				 
				            ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).assignation.code;
				        
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				match(READ);
				setState(80);
				match(T__0);
				setState(81);
				((InstructionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(82);
				match(T__1);
				setState(83);
				finInstruction();

				            AdresseType at = tablesSymboles.getAdresseType((((InstructionContext)_localctx).IDENTIFIANT!=null?((InstructionContext)_localctx).IDENTIFIANT.getText():null));
				            int adresse = at.adresse;
				            String type = at.type;

				            if(type.equals("int")){
				                ((InstructionContext)_localctx).code = "READ\n";
				                _localctx.code+="STOREG " +adresse+"\n";
				            }
				             if(type.equals("double")){
				                ((InstructionContext)_localctx).code = "READF\n";
				                 _localctx.code+="STOREG " +(adresse+1)+"\n";
				                _localctx.code+="STOREG " +adresse+"\n";
				             }
				        
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(86);
				match(WRITE);
				setState(87);
				match(T__0);
				setState(88);
				((InstructionContext)_localctx).expression = expression(0);
				setState(89);
				match(T__1);
				setState(90);
				finInstruction();
				 
				            if(((InstructionContext)_localctx).expression.type.equals("int")){
				                ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).expression.code + "WRITE\nPOP\n";
				            }
				            if(((InstructionContext)_localctx).expression.type.equals("double")){
				                ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).expression.code + "WRITEF\nPOP\nPOP\n";
				            }
				        
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(93);
				((InstructionContext)_localctx).boucle = boucle();

				            ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).boucle.code;
				        
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(96);
				((InstructionContext)_localctx).si = si();

				        ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).si.code; 
				    
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(99);
				((InstructionContext)_localctx).bloc = bloc();

				            ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).bloc.code;
				        
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(102);
				((InstructionContext)_localctx).fonction = fonction();

				        ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).fonction.code;
				    
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(105);
				match(RETURN);
				setState(106);
				((InstructionContext)_localctx).expression = expression(0);

				        ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).expression.code;
				        AdresseType at = tablesSymboles.getAdresseType("return");
				        int adresse = at.adresse;
				        AdresseType atdouble = tablesSymboles.getAdresseType("returndouble");

				        if(atdouble!=null){
				            _localctx.code+="STOREL "+ (atdouble.adresse+1) + "\n";
				            _localctx.code+="STOREL "+atdouble.adresse+"\n";
				        }
				        else{ 
				        _localctx.code+="STOREL "+adresse+"\n";
				        }
				        _localctx.code+="RETURN \n";
				    
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(109);
				finInstruction();

				            ((InstructionContext)_localctx).code = "";
				        
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public String code;
		public String type;
		public ExpressionContext a;
		public Token ENTIER;
		public Token FLOAT;
		public Token IDENTIFIANT;
		public ArgsContext args;
		public Token op;
		public ExpressionContext b;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ENTIER() { return getToken(CalculetteParser.ENTIER, 0); }
		public TerminalNode FLOAT() { return getToken(CalculetteParser.FLOAT, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(115);
				match(T__0);
				setState(116);
				((ExpressionContext)_localctx).a = expression(0);
				setState(117);
				match(T__1);
				((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code; ((ExpressionContext)_localctx).type = ((ExpressionContext)_localctx).a.type;
				}
				break;
			case 2:
				{
				setState(120);
				((ExpressionContext)_localctx).ENTIER = match(ENTIER);
				((ExpressionContext)_localctx).code =  "PUSHI " + (((ExpressionContext)_localctx).ENTIER!=null?((ExpressionContext)_localctx).ENTIER.getText():null) +"\n"; ((ExpressionContext)_localctx).type = "int";
				}
				break;
			case 3:
				{
				setState(122);
				match(T__5);
				setState(123);
				((ExpressionContext)_localctx).ENTIER = match(ENTIER);
				((ExpressionContext)_localctx).code = "PUSHI -" + (((ExpressionContext)_localctx).ENTIER!=null?((ExpressionContext)_localctx).ENTIER.getText():null) +"\n"; ((ExpressionContext)_localctx).type = "int";
				}
				break;
			case 4:
				{
				setState(125);
				((ExpressionContext)_localctx).FLOAT = match(FLOAT);
				((ExpressionContext)_localctx).code = "PUSHF "+(((ExpressionContext)_localctx).FLOAT!=null?((ExpressionContext)_localctx).FLOAT.getText():null) +"\n"; ((ExpressionContext)_localctx).type = "double";
				}
				break;
			case 5:
				{
				setState(127);
				match(T__5);
				setState(128);
				((ExpressionContext)_localctx).FLOAT = match(FLOAT);
				((ExpressionContext)_localctx).code = "PUSHF -"+(((ExpressionContext)_localctx).FLOAT!=null?((ExpressionContext)_localctx).FLOAT.getText():null) +"\n"; ((ExpressionContext)_localctx).type = "double";
				}
				break;
			case 6:
				{
				setState(130);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(131);
				match(T__0);
				setState(132);
				((ExpressionContext)_localctx).args = args();
				setState(133);
				match(T__1);
				  
				            //Recuperer type de la fonction
				            String type = tablesSymboles.getFunction((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null));
				            ((ExpressionContext)_localctx).type = type;

				            ((ExpressionContext)_localctx).code = "PUSHI 0\n"; // Reserver l'espce pour un int 
				            _localctx.code+=((ExpressionContext)_localctx).args.code;
				            _localctx.code+="CALL "+(((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null)+"\n";
				            int tailleArgument = ((ExpressionContext)_localctx).args.size;
				            while(tailleArgument!=0){
				                _localctx.code+="POP \n";
				                tailleArgument--;
				            }
				        
				}
				break;
			case 7:
				{
				setState(136);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				 
				                AdresseType at = tablesSymboles.getAdresseType((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null));
				                int adresse = at.adresse;
				                String type = at.type;
				                ((ExpressionContext)_localctx).type = type;

				                if(adresse>=0){
				                    if(type.equals("int")){
				                        ((ExpressionContext)_localctx).code =  "PUSHG " +adresse+"\n";
				                    }
				                    if(type.equals("double")){
				                         ((ExpressionContext)_localctx).code =  "PUSHG " +adresse+"\n";
				                         _localctx.code+= "PUSHG "+(adresse+1)+"\n";
				                    }
				                }
				                else {
				                     ((ExpressionContext)_localctx).code =  "PUSHL " +adresse+"\n";
				                }
				            
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(152);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(150);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(140);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(141);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__2 || _la==T__3) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(142);
						((ExpressionContext)_localctx).b = expression(9);
						((ExpressionContext)_localctx).code =  evalexpr(((ExpressionContext)_localctx).a.code,(((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null),((ExpressionContext)_localctx).b.code,((ExpressionContext)_localctx).a.type,((ExpressionContext)_localctx).b.type); ((ExpressionContext)_localctx).type = ((ExpressionContext)_localctx).a.type;
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(145);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(146);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__4 || _la==T__5) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(147);
						((ExpressionContext)_localctx).b = expression(8);
						((ExpressionContext)_localctx).code =  evalexpr(((ExpressionContext)_localctx).a.code,(((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null),((ExpressionContext)_localctx).b.code,((ExpressionContext)_localctx).a.type,((ExpressionContext)_localctx).b.type); ((ExpressionContext)_localctx).type = ((ExpressionContext)_localctx).a.type;
						}
						break;
					}
					} 
				}
				setState(154);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FinInstructionContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteParser.NEWLINE, i);
		}
		public FinInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finInstruction; }
	}

	public final FinInstructionContext finInstruction() throws RecognitionException {
		FinInstructionContext _localctx = new FinInstructionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_finInstruction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(156); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(155);
					_la = _input.LA(1);
					if ( !(_la==T__6 || _la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(158); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public Token TYPE;
		public ExpressionContext expression;
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public TerminalNode TYPE() { return getToken(CalculetteParser.TYPE, 0); }
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_decl);
		try {
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				match(T__7);
				setState(161);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(162);
				match(T__8);
				setState(163);
				((DeclContext)_localctx).TYPE = match(TYPE);
				setState(164);
				finInstruction();

				            if((((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null).equals("int")){
				                tablesSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null),"int");
				                ((DeclContext)_localctx).code = "PUSHI 0\n";
				            }
				            if((((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null).equals("double")){
				                tablesSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null),"double");
				                ((DeclContext)_localctx).code = "PUSHF 0.0\n";
				            }
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				match(T__7);
				setState(168);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(169);
				match(T__8);
				setState(170);
				((DeclContext)_localctx).TYPE = match(TYPE);
				setState(171);
				match(T__9);
				setState(172);
				((DeclContext)_localctx).expression = expression(0);
				setState(173);
				finInstruction();

				            if((((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null).equals("int")){
				                tablesSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null),"int");
				                ((DeclContext)_localctx).code = ((DeclContext)_localctx).expression.code;
				            }
				            if((((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null).equals("double")){
				                tablesSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null),"double");
				                ((DeclContext)_localctx).code = ((DeclContext)_localctx).expression.code;
				            }
				        
				        
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignationContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public Token op;
		public ExpressionContext expression;
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignation; }
	}

	public final AssignationContext assignation() throws RecognitionException {
		AssignationContext _localctx = new AssignationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(179);
			((AssignationContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__9 || _la==T__10) ) {
				((AssignationContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(180);
			((AssignationContext)_localctx).expression = expression(0);
			  
			            AdresseType at = tablesSymboles.getAdresseType((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));
			            int adresse = at.adresse;
			            String type = at.type;
			            ((AssignationContext)_localctx).code =  ((AssignationContext)_localctx).expression.code;

			            if((((AssignationContext)_localctx).op!=null?((AssignationContext)_localctx).op.getText():null).equals("=")){    
			                if(adresse>=0){
			                    if(type.equals("int")){
			                        _localctx.code+="STOREG " + adresse +"\n";
			                    }
			                    if(type.equals("double")){
			                        _localctx.code += "STOREG " + (adresse+1) +"\n";
			                        _localctx.code += "STOREG " + adresse +"\n";
			                    }
			                }
			                else {
			                    _localctx.code += "STOREL " + adresse +"\n";
			                }
			            }
			            if((((AssignationContext)_localctx).op!=null?((AssignationContext)_localctx).op.getText():null).equals("+=")){
			                if(adresse>=0){
			                    _localctx.code+=  "PUSHG " +adresse +"\n"+"ADD\n"+"STOREG " +adresse +"\n";
			                }
			                else {
			                    _localctx.code+="PUSHL " +adresse +"\n"+"ADD\n"+"STOREL " +adresse +"\n";
			                }
			             }

			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public String code;
		public ConditionContext c1;
		public ConditionContext condition;
		public ExpressionContext a;
		public Token CONDITION;
		public ExpressionContext b;
		public Token BOOL;
		public Token OPLOGIQUE;
		public ConditionContext c2;
		public TerminalNode NEGLOGIQUE() { return getToken(CalculetteParser.NEGLOGIQUE, 0); }
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public TerminalNode CONDITION() { return getToken(CalculetteParser.CONDITION, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BOOL() { return getToken(CalculetteParser.BOOL, 0); }
		public TerminalNode OPLOGIQUE() { return getToken(CalculetteParser.OPLOGIQUE, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	}

	public final ConditionContext condition() throws RecognitionException {
		return condition(0);
	}

	private ConditionContext condition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionContext _localctx = new ConditionContext(_ctx, _parentState);
		ConditionContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_condition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEGLOGIQUE:
				{
				setState(184);
				match(NEGLOGIQUE);
				setState(185);
				((ConditionContext)_localctx).condition = condition(4);
				((ConditionContext)_localctx).code = ((ConditionContext)_localctx).condition.code + "PUSHI 0\n" + "EQUAL\n";
				}
				break;
			case T__0:
			case T__5:
			case IDENTIFIANT:
			case ENTIER:
			case FLOAT:
				{
				setState(188);
				((ConditionContext)_localctx).a = expression(0);
				setState(189);
				((ConditionContext)_localctx).CONDITION = match(CONDITION);
				setState(190);
				((ConditionContext)_localctx).b = expression(0);

				            ((ConditionContext)_localctx).code = ((ConditionContext)_localctx).a.code;
				            _localctx.code+=((ConditionContext)_localctx).b.code;
				            _localctx.code+=evalCondition((((ConditionContext)_localctx).CONDITION!=null?((ConditionContext)_localctx).CONDITION.getText():null))+"\n";
				        
				}
				break;
			case BOOL:
				{
				setState(193);
				((ConditionContext)_localctx).BOOL = match(BOOL);
				 ((ConditionContext)_localctx).code =  evalBOOL((((ConditionContext)_localctx).BOOL!=null?((ConditionContext)_localctx).BOOL.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(204);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConditionContext(_parentctx, _parentState);
					_localctx.c1 = _prevctx;
					_localctx.c1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_condition);
					setState(197);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(198);
					((ConditionContext)_localctx).OPLOGIQUE = match(OPLOGIQUE);
					setState(199);
					((ConditionContext)_localctx).c2 = ((ConditionContext)_localctx).condition = condition(3);

					                      ((ConditionContext)_localctx).code = evalOPLOGIQUE(((ConditionContext)_localctx).c1.code,(((ConditionContext)_localctx).OPLOGIQUE!=null?((ConditionContext)_localctx).OPLOGIQUE.getText():null),((ConditionContext)_localctx).c2.code);
					                  
					}
					} 
				}
				setState(206);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BlocContext extends ParserRuleContext {
		public String code;
		public InstructionContext instruction;
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteParser.NEWLINE, i);
		}
		public BlocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloc; }
	}

	public final BlocContext bloc() throws RecognitionException {
		BlocContext _localctx = new BlocContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_bloc);
		 ((BlocContext)_localctx).code =  new String();
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(T__11);
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << T__6) | (1L << T__11) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__19) | (1L << RETURN) | (1L << READ) | (1L << WRITE) | (1L << IDENTIFIANT) | (1L << ENTIER) | (1L << FLOAT) | (1L << NEWLINE))) != 0)) {
				{
				{
				setState(208);
				((BlocContext)_localctx).instruction = instruction();
				 _localctx.code+=((BlocContext)_localctx).instruction.code;
				}
				}
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(216);
			match(T__12);
			setState(220);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(217);
					match(NEWLINE);
					}
					} 
				}
				setState(222);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoucleContext extends ParserRuleContext {
		public String code;
		public ConditionContext condition;
		public InstructionContext instruction;
		public AssignationContext init;
		public AssignationContext incr;
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public List<AssignationContext> assignation() {
			return getRuleContexts(AssignationContext.class);
		}
		public AssignationContext assignation(int i) {
			return getRuleContext(AssignationContext.class,i);
		}
		public BoucleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boucle; }
	}

	public final BoucleContext boucle() throws RecognitionException {
		BoucleContext _localctx = new BoucleContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_boucle);
		 ((BoucleContext)_localctx).code =  new String(); 
		        //Générer deux labels un pour le debut et un pour la fin
		        String labelDebut = getNewLabel();
		        String labelFin=getNewLabel();
		    
		try {
			setState(249);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
				enterOuterAlt(_localctx, 1);
				{
				setState(223);
				match(T__13);
				setState(224);
				match(T__0);
				setState(225);
				((BoucleContext)_localctx).condition = condition(0);
				setState(226);
				match(T__1);
				setState(227);
				((BoucleContext)_localctx).instruction = instruction();

				            
				            //Label debut 
				            ((BoucleContext)_localctx).code = "LABEL " + labelDebut+"\n";
				            _localctx.code+=((BoucleContext)_localctx).condition.code;
				            //Condition du jump selon 1 ou 0 dans la pile
				            _localctx.code+="JUMPF "+ labelFin+"\n";
				            _localctx.code+=((BoucleContext)_localctx).instruction.code;
				            _localctx.code+="JUMP " +labelDebut+"\n";
				            _localctx.code+="LABEL "+labelFin+"\n";

				        
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 2);
				{
				setState(230);
				match(T__14);
				setState(231);
				match(T__0);
				setState(232);
				((BoucleContext)_localctx).init = assignation();
				setState(233);
				match(T__6);
				setState(234);
				((BoucleContext)_localctx).condition = condition(0);
				setState(235);
				match(T__6);
				setState(236);
				((BoucleContext)_localctx).incr = assignation();
				setState(237);
				match(T__1);
				setState(238);
				((BoucleContext)_localctx).instruction = instruction();

				            ((BoucleContext)_localctx).code = ((BoucleContext)_localctx).init.code;
				            _localctx.code+="LABEL " + labelDebut+"\n";
				            _localctx.code+=((BoucleContext)_localctx).condition.code;
				            _localctx.code+="JUMPF "+ labelFin+"\n";
				            _localctx.code+=((BoucleContext)_localctx).instruction.code;
				            _localctx.code+=((BoucleContext)_localctx).incr.code;
				            _localctx.code+="JUMP " +labelDebut+"\n";
				            _localctx.code+="LABEL "+labelFin+"\n";

				    
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 3);
				{
				setState(241);
				match(T__15);
				setState(242);
				((BoucleContext)_localctx).instruction = instruction();
				setState(243);
				match(T__16);
				setState(244);
				match(T__0);
				setState(245);
				((BoucleContext)_localctx).condition = condition(0);
				setState(246);
				match(T__1);

				        _localctx.code+="LABEL " + labelDebut+"\n";
				        _localctx.code+=((BoucleContext)_localctx).instruction.code;
				        _localctx.code+=((BoucleContext)_localctx).condition.code;
				        _localctx.code+="JUMPF "+ labelDebut+"\n";
				        _localctx.code+="LABEL "+labelFin+"\n";

				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SiContext extends ParserRuleContext {
		public String code;
		public ConditionContext condition;
		public InstructionContext i;
		public InstructionContext e;
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public SiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_si; }
	}

	public final SiContext si() throws RecognitionException {
		SiContext _localctx = new SiContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_si);

		        ((SiContext)_localctx).code =  new String();
		        String labelElse = getNewLabel();
		        String labelFin=getNewLabel();
		    
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(T__17);
			setState(252);
			match(T__0);
			setState(253);
			((SiContext)_localctx).condition = condition(0);
			setState(254);
			match(T__1);
			setState(255);
			((SiContext)_localctx).i = instruction();

			            
			            _localctx.code+=((SiContext)_localctx).condition.code;
			            _localctx.code+="JUMPF "+ labelElse+"\n";
			            _localctx.code+=((SiContext)_localctx).i.code;
			            _localctx.code+="JUMP " + labelFin +"\n";
			            _localctx.code+="LABEL "+labelElse+"\n";
			        
			setState(261);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(257);
				match(T__18);
				setState(258);
				((SiContext)_localctx).e = instruction();

				            _localctx.code+=((SiContext)_localctx).e.code;
				        
				}
				break;
			}
			_localctx.code+="LABEL " +labelFin +"\n";
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FonctionContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public Token TYPE;
		public BlocContext bloc;
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public TerminalNode TYPE() { return getToken(CalculetteParser.TYPE, 0); }
		public BlocContext bloc() {
			return getRuleContext(BlocContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public FonctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fonction; }
	}

	public final FonctionContext fonction() throws RecognitionException {
		FonctionContext _localctx = new FonctionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_fonction);
		 tablesSymboles.newTableLocale(); 
		        ((FonctionContext)_localctx).code = new String();
		        
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(T__19);
			setState(266);
			((FonctionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(267);
			match(T__8);
			setState(268);
			((FonctionContext)_localctx).TYPE = match(TYPE);

			            _localctx.code+="LABEL "+(((FonctionContext)_localctx).IDENTIFIANT!=null?((FonctionContext)_localctx).IDENTIFIANT.getText():null)+"\n";
			            //truc à faire par rapport au "type" de la fonction et code pour la "variable" de retour 
			            tablesSymboles.newFunction((((FonctionContext)_localctx).IDENTIFIANT!=null?((FonctionContext)_localctx).IDENTIFIANT.getText():null),(((FonctionContext)_localctx).TYPE!=null?((FonctionContext)_localctx).TYPE.getText():null));  
			            tablesSymboles.putVar("return",(((FonctionContext)_localctx).TYPE!=null?((FonctionContext)_localctx).TYPE.getText():null)); 

			            if((((FonctionContext)_localctx).TYPE!=null?((FonctionContext)_localctx).TYPE.getText():null).equals("double")){
			                tablesSymboles.putVar("returndouble",(((FonctionContext)_localctx).TYPE!=null?((FonctionContext)_localctx).TYPE.getText():null)); 
			            }   
				    
			setState(270);
			match(T__0);
			setState(272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(271);
				params();
				}
			}

			setState(274);
			match(T__1);
			setState(275);
			((FonctionContext)_localctx).bloc = bloc();

			            _localctx.code+=((FonctionContext)_localctx).bloc.code;
			            _localctx.code+="RETURN\n";
			        
			}
			_ctx.stop = _input.LT(-1);
			 tablesSymboles.dropTableLocale(); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public Token TYPE;
		public Token IDENTIFIANT;
		public List<TerminalNode> TYPE() { return getTokens(CalculetteParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(CalculetteParser.TYPE, i);
		}
		public List<TerminalNode> IDENTIFIANT() { return getTokens(CalculetteParser.IDENTIFIANT); }
		public TerminalNode IDENTIFIANT(int i) {
			return getToken(CalculetteParser.IDENTIFIANT, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			((ParamsContext)_localctx).TYPE = match(TYPE);
			setState(279);
			((ParamsContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			 
			            // code java gérant une variable locale (arg0)
			            tablesSymboles.putVar((((ParamsContext)_localctx).IDENTIFIANT!=null?((ParamsContext)_localctx).IDENTIFIANT.getText():null),(((ParamsContext)_localctx).TYPE!=null?((ParamsContext)_localctx).TYPE.getText():null));
			            
			        
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__20) {
				{
				{
				setState(281);
				match(T__20);
				setState(282);
				((ParamsContext)_localctx).TYPE = match(TYPE);
				setState(283);
				((ParamsContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				 
				                // code java gérant une variable locale (argi)
				                tablesSymboles.putVar((((ParamsContext)_localctx).IDENTIFIANT!=null?((ParamsContext)_localctx).IDENTIFIANT.getText():null),(((ParamsContext)_localctx).TYPE!=null?((ParamsContext)_localctx).TYPE.getText():null));
				            
				}
				}
				setState(289);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public String code;
		public int size;
		public ExpressionContext expression;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_args);
		 ((ArgsContext)_localctx).code =  new String(); ((ArgsContext)_localctx).size =  0; 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << IDENTIFIANT) | (1L << ENTIER) | (1L << FLOAT))) != 0)) {
				{
				setState(290);
				((ArgsContext)_localctx).expression = expression(0);
				 
				        // code java pour première expression pour arg
				        _localctx.code+=((ArgsContext)_localctx).expression.code;
				        _localctx.size+=1;
				    
				setState(298);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__20) {
					{
					{
					setState(292);
					match(T__20);
					setState(293);
					((ArgsContext)_localctx).expression = expression(0);
					 
					        // code java pour expression suivante pour arg
					         _localctx.code+=((ArgsContext)_localctx).expression.code;
					         _localctx.size+=1;
					    
					}
					}
					setState(300);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 7:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		}
		return true;
	}
	private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\'\u0132\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\3\3\3\3\3\7\3%\n"+
		"\3\f\3\16\3(\13\3\3\3\3\3\7\3,\n\3\f\3\16\3/\13\3\3\3\3\3\3\3\7\3\64\n"+
		"\3\f\3\16\3\67\13\3\3\3\7\3:\n\3\f\3\16\3=\13\3\3\3\3\3\3\3\3\3\7\3C\n"+
		"\3\f\3\16\3F\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4s\n\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\5\5\u008d\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\7\5\u0099\n\5\f\5\16\5\u009c\13\5\3\6\6\6\u009f\n\6\r\6\16\6\u00a0\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00b3"+
		"\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\5\t\u00c6\n\t\3\t\3\t\3\t\3\t\3\t\7\t\u00cd\n\t\f\t\16\t\u00d0\13\t"+
		"\3\n\3\n\3\n\3\n\7\n\u00d6\n\n\f\n\16\n\u00d9\13\n\3\n\3\n\7\n\u00dd\n"+
		"\n\f\n\16\n\u00e0\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\5\13\u00fc\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\5\f\u0108\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0113\n\r\3\r\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0120\n\16\f\16\16"+
		"\16\u0123\13\16\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u012b\n\17\f\17\16"+
		"\17\u012e\13\17\5\17\u0130\n\17\3\17\2\4\b\20\20\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\2\6\3\2\5\6\3\2\7\b\4\2\t\t\"\"\3\2\f\r\2\u0147\2\36\3"+
		"\2\2\2\4&\3\2\2\2\6r\3\2\2\2\b\u008c\3\2\2\2\n\u009e\3\2\2\2\f\u00b2\3"+
		"\2\2\2\16\u00b4\3\2\2\2\20\u00c5\3\2\2\2\22\u00d1\3\2\2\2\24\u00fb\3\2"+
		"\2\2\26\u00fd\3\2\2\2\30\u010b\3\2\2\2\32\u0118\3\2\2\2\34\u012f\3\2\2"+
		"\2\36\37\5\4\3\2\37 \7\2\2\3 \3\3\2\2\2!\"\5\f\7\2\"#\b\3\1\2#%\3\2\2"+
		"\2$!\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\')\3\2\2\2(&\3\2\2\2)-\b\3"+
		"\1\2*,\7\"\2\2+*\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\65\3\2\2\2/-\3"+
		"\2\2\2\60\61\5\30\r\2\61\62\b\3\1\2\62\64\3\2\2\2\63\60\3\2\2\2\64\67"+
		"\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66;\3\2\2\2\67\65\3\2\2\28:\7\"\2"+
		"\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<>\3\2\2\2=;\3\2\2\2>D\b\3\1"+
		"\2?@\5\6\4\2@A\b\3\1\2AC\3\2\2\2B?\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2"+
		"\2EG\3\2\2\2FD\3\2\2\2GH\b\3\1\2H\5\3\2\2\2IJ\5\b\5\2JK\5\n\6\2KL\b\4"+
		"\1\2Ls\3\2\2\2MN\5\16\b\2NO\5\n\6\2OP\b\4\1\2Ps\3\2\2\2QR\7\33\2\2RS\7"+
		"\3\2\2ST\7\35\2\2TU\7\4\2\2UV\5\n\6\2VW\b\4\1\2Ws\3\2\2\2XY\7\34\2\2Y"+
		"Z\7\3\2\2Z[\5\b\5\2[\\\7\4\2\2\\]\5\n\6\2]^\b\4\1\2^s\3\2\2\2_`\5\24\13"+
		"\2`a\b\4\1\2as\3\2\2\2bc\5\26\f\2cd\b\4\1\2ds\3\2\2\2ef\5\22\n\2fg\b\4"+
		"\1\2gs\3\2\2\2hi\5\30\r\2ij\b\4\1\2js\3\2\2\2kl\7\32\2\2lm\5\b\5\2mn\b"+
		"\4\1\2ns\3\2\2\2op\5\n\6\2pq\b\4\1\2qs\3\2\2\2rI\3\2\2\2rM\3\2\2\2rQ\3"+
		"\2\2\2rX\3\2\2\2r_\3\2\2\2rb\3\2\2\2re\3\2\2\2rh\3\2\2\2rk\3\2\2\2ro\3"+
		"\2\2\2s\7\3\2\2\2tu\b\5\1\2uv\7\3\2\2vw\5\b\5\2wx\7\4\2\2xy\b\5\1\2y\u008d"+
		"\3\2\2\2z{\7 \2\2{\u008d\b\5\1\2|}\7\b\2\2}~\7 \2\2~\u008d\b\5\1\2\177"+
		"\u0080\7!\2\2\u0080\u008d\b\5\1\2\u0081\u0082\7\b\2\2\u0082\u0083\7!\2"+
		"\2\u0083\u008d\b\5\1\2\u0084\u0085\7\35\2\2\u0085\u0086\7\3\2\2\u0086"+
		"\u0087\5\34\17\2\u0087\u0088\7\4\2\2\u0088\u0089\b\5\1\2\u0089\u008d\3"+
		"\2\2\2\u008a\u008b\7\35\2\2\u008b\u008d\b\5\1\2\u008ct\3\2\2\2\u008cz"+
		"\3\2\2\2\u008c|\3\2\2\2\u008c\177\3\2\2\2\u008c\u0081\3\2\2\2\u008c\u0084"+
		"\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u009a\3\2\2\2\u008e\u008f\f\n\2\2\u008f"+
		"\u0090\t\2\2\2\u0090\u0091\5\b\5\13\u0091\u0092\b\5\1\2\u0092\u0099\3"+
		"\2\2\2\u0093\u0094\f\t\2\2\u0094\u0095\t\3\2\2\u0095\u0096\5\b\5\n\u0096"+
		"\u0097\b\5\1\2\u0097\u0099\3\2\2\2\u0098\u008e\3\2\2\2\u0098\u0093\3\2"+
		"\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\t\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u009f\t\4\2\2\u009e\u009d\3\2\2\2"+
		"\u009f\u00a0\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\13"+
		"\3\2\2\2\u00a2\u00a3\7\n\2\2\u00a3\u00a4\7\35\2\2\u00a4\u00a5\7\13\2\2"+
		"\u00a5\u00a6\7\30\2\2\u00a6\u00a7\5\n\6\2\u00a7\u00a8\b\7\1\2\u00a8\u00b3"+
		"\3\2\2\2\u00a9\u00aa\7\n\2\2\u00aa\u00ab\7\35\2\2\u00ab\u00ac\7\13\2\2"+
		"\u00ac\u00ad\7\30\2\2\u00ad\u00ae\7\f\2\2\u00ae\u00af\5\b\5\2\u00af\u00b0"+
		"\5\n\6\2\u00b0\u00b1\b\7\1\2\u00b1\u00b3\3\2\2\2\u00b2\u00a2\3\2\2\2\u00b2"+
		"\u00a9\3\2\2\2\u00b3\r\3\2\2\2\u00b4\u00b5\7\35\2\2\u00b5\u00b6\t\5\2"+
		"\2\u00b6\u00b7\5\b\5\2\u00b7\u00b8\b\b\1\2\u00b8\17\3\2\2\2\u00b9\u00ba"+
		"\b\t\1\2\u00ba\u00bb\7&\2\2\u00bb\u00bc\5\20\t\6\u00bc\u00bd\b\t\1\2\u00bd"+
		"\u00c6\3\2\2\2\u00be\u00bf\5\b\5\2\u00bf\u00c0\7\36\2\2\u00c0\u00c1\5"+
		"\b\5\2\u00c1\u00c2\b\t\1\2\u00c2\u00c6\3\2\2\2\u00c3\u00c4\7\31\2\2\u00c4"+
		"\u00c6\b\t\1\2\u00c5\u00b9\3\2\2\2\u00c5\u00be\3\2\2\2\u00c5\u00c3\3\2"+
		"\2\2\u00c6\u00ce\3\2\2\2\u00c7\u00c8\f\4\2\2\u00c8\u00c9\7%\2\2\u00c9"+
		"\u00ca\5\20\t\5\u00ca\u00cb\b\t\1\2\u00cb\u00cd\3\2\2\2\u00cc\u00c7\3"+
		"\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf"+
		"\21\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d7\7\16\2\2\u00d2\u00d3\5\6\4"+
		"\2\u00d3\u00d4\b\n\1\2\u00d4\u00d6\3\2\2\2\u00d5\u00d2\3\2\2\2\u00d6\u00d9"+
		"\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00da\3\2\2\2\u00d9"+
		"\u00d7\3\2\2\2\u00da\u00de\7\17\2\2\u00db\u00dd\7\"\2\2\u00dc\u00db\3"+
		"\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df"+
		"\23\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e2\7\20\2\2\u00e2\u00e3\7\3\2"+
		"\2\u00e3\u00e4\5\20\t\2\u00e4\u00e5\7\4\2\2\u00e5\u00e6\5\6\4\2\u00e6"+
		"\u00e7\b\13\1\2\u00e7\u00fc\3\2\2\2\u00e8\u00e9\7\21\2\2\u00e9\u00ea\7"+
		"\3\2\2\u00ea\u00eb\5\16\b\2\u00eb\u00ec\7\t\2\2\u00ec\u00ed\5\20\t\2\u00ed"+
		"\u00ee\7\t\2\2\u00ee\u00ef\5\16\b\2\u00ef\u00f0\7\4\2\2\u00f0\u00f1\5"+
		"\6\4\2\u00f1\u00f2\b\13\1\2\u00f2\u00fc\3\2\2\2\u00f3\u00f4\7\22\2\2\u00f4"+
		"\u00f5\5\6\4\2\u00f5\u00f6\7\23\2\2\u00f6\u00f7\7\3\2\2\u00f7\u00f8\5"+
		"\20\t\2\u00f8\u00f9\7\4\2\2\u00f9\u00fa\b\13\1\2\u00fa\u00fc\3\2\2\2\u00fb"+
		"\u00e1\3\2\2\2\u00fb\u00e8\3\2\2\2\u00fb\u00f3\3\2\2\2\u00fc\25\3\2\2"+
		"\2\u00fd\u00fe\7\24\2\2\u00fe\u00ff\7\3\2\2\u00ff\u0100\5\20\t\2\u0100"+
		"\u0101\7\4\2\2\u0101\u0102\5\6\4\2\u0102\u0107\b\f\1\2\u0103\u0104\7\25"+
		"\2\2\u0104\u0105\5\6\4\2\u0105\u0106\b\f\1\2\u0106\u0108\3\2\2\2\u0107"+
		"\u0103\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a\b\f"+
		"\1\2\u010a\27\3\2\2\2\u010b\u010c\7\26\2\2\u010c\u010d\7\35\2\2\u010d"+
		"\u010e\7\13\2\2\u010e\u010f\7\30\2\2\u010f\u0110\b\r\1\2\u0110\u0112\7"+
		"\3\2\2\u0111\u0113\5\32\16\2\u0112\u0111\3\2\2\2\u0112\u0113\3\2\2\2\u0113"+
		"\u0114\3\2\2\2\u0114\u0115\7\4\2\2\u0115\u0116\5\22\n\2\u0116\u0117\b"+
		"\r\1\2\u0117\31\3\2\2\2\u0118\u0119\7\30\2\2\u0119\u011a\7\35\2\2\u011a"+
		"\u0121\b\16\1\2\u011b\u011c\7\27\2\2\u011c\u011d\7\30\2\2\u011d\u011e"+
		"\7\35\2\2\u011e\u0120\b\16\1\2\u011f\u011b\3\2\2\2\u0120\u0123\3\2\2\2"+
		"\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\33\3\2\2\2\u0123\u0121"+
		"\3\2\2\2\u0124\u0125\5\b\5\2\u0125\u012c\b\17\1\2\u0126\u0127\7\27\2\2"+
		"\u0127\u0128\5\b\5\2\u0128\u0129\b\17\1\2\u0129\u012b\3\2\2\2\u012a\u0126"+
		"\3\2\2\2\u012b\u012e\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d"+
		"\u0130\3\2\2\2\u012e\u012c\3\2\2\2\u012f\u0124\3\2\2\2\u012f\u0130\3\2"+
		"\2\2\u0130\35\3\2\2\2\27&-\65;Dr\u008c\u0098\u009a\u00a0\u00b2\u00c5\u00ce"+
		"\u00d7\u00de\u00fb\u0107\u0112\u0121\u012c\u012f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}