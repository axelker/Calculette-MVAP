// Generated from Calculette.g4 by ANTLR 4.9

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
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, TYPE=22, BOOL=23, IDENTIFIANT=24, 
		CONDITION=25, WS=26, ENTIER=27, FLOAT=28, NEWLINE=29, COMMENTARY=30, OPERATION=31, 
		OPLOGIQUE=32, NEGLOGIQUE=33, UNMATCH=34;
	public static final int
		RULE_start = 0, RULE_calcul = 1, RULE_instruction = 2, RULE_expression = 3, 
		RULE_finInstruction = 4, RULE_decl = 5, RULE_assignation = 6, RULE_condition = 7, 
		RULE_bloc = 8, RULE_boucle = 9, RULE_si = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "calcul", "instruction", "expression", "finInstruction", "decl", 
			"assignation", "condition", "bloc", "boucle", "si"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'read'", "'('", "')'", "'write'", "'/'", "'*'", "'+'", "'-'", 
			"';'", "'var'", "':'", "'='", "'+='", "'{'", "'}'", "'while'", "'for'", 
			"'repeat'", "'until'", "'if'", "'else'", null, null, null, null, null, 
			null, null, null, null, null, null, "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "TYPE", "BOOL", 
			"IDENTIFIANT", "CONDITION", "WS", "ENTIER", "FLOAT", "NEWLINE", "COMMENTARY", 
			"OPERATION", "OPLOGIQUE", "NEGLOGIQUE", "UNMATCH"
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			calcul();
			setState(23);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterCalcul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitCalcul(this);
		}
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
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(25);
				((CalculContext)_localctx).decl = decl();
				 _localctx.code += ((CalculContext)_localctx).decl.code; 
				}
				}
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(36);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(33);
					match(NEWLINE);
					}
					} 
				}
				setState(38);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__7) | (1L << T__8) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__19) | (1L << IDENTIFIANT) | (1L << ENTIER) | (1L << NEWLINE))) != 0)) {
				{
				{
				setState(39);
				((CalculContext)_localctx).instruction = instruction();
				 _localctx.code += ((CalculContext)_localctx).instruction.code; 
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 _localctx.code += "HALT\n"; 
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public AssignationContext assignation() {
			return getRuleContext(AssignationContext.class,0);
		}
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public BoucleContext boucle() {
			return getRuleContext(BoucleContext.class,0);
		}
		public SiContext si() {
			return getRuleContext(SiContext.class,0);
		}
		public BlocContext bloc() {
			return getRuleContext(BlocContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitInstruction(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instruction);
		try {
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				((InstructionContext)_localctx).expression = expression(0);
				setState(50);
				finInstruction();
				 
				            ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).expression.code;
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				((InstructionContext)_localctx).assignation = assignation();
				setState(54);
				finInstruction();
				 
				            ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).assignation.code;
				        
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(57);
				match(T__0);
				setState(58);
				match(T__1);
				setState(59);
				((InstructionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(60);
				match(T__2);
				setState(61);
				finInstruction();

				            ((InstructionContext)_localctx).code = "READ\n";
				            AdresseType at = tablesSymboles.getAdresseType((((InstructionContext)_localctx).IDENTIFIANT!=null?((InstructionContext)_localctx).IDENTIFIANT.getText():null));
				            int adresse = at.adresse;
				            _localctx.code+="STOREG " +adresse+"\n";
				        
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(64);
				match(T__3);
				setState(65);
				match(T__1);
				setState(66);
				((InstructionContext)_localctx).expression = expression(0);
				setState(67);
				match(T__2);
				setState(68);
				finInstruction();
				 
				            ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).expression.code + "WRITE\nPOP\n";
				        
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(71);
				((InstructionContext)_localctx).boucle = boucle();

				            ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).boucle.code;
				        
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(74);
				((InstructionContext)_localctx).si = si();

				        ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).si.code; 
				    
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(77);
				((InstructionContext)_localctx).bloc = bloc();

				            ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).bloc.code;
				        
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(80);
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
		public ExpressionContext a;
		public Token ENTIER;
		public Token IDENTIFIANT;
		public Token op;
		public ExpressionContext b;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ENTIER() { return getToken(CalculetteParser.ENTIER, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitExpression(this);
		}
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
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				setState(86);
				match(T__1);
				setState(87);
				((ExpressionContext)_localctx).a = expression(0);
				setState(88);
				match(T__2);
				((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code;
				}
				break;
			case ENTIER:
				{
				setState(91);
				((ExpressionContext)_localctx).ENTIER = match(ENTIER);
				((ExpressionContext)_localctx).code =  "PUSHI " + (((ExpressionContext)_localctx).ENTIER!=null?((ExpressionContext)_localctx).ENTIER.getText():null) +"\n";
				}
				break;
			case T__7:
				{
				setState(93);
				match(T__7);
				setState(94);
				((ExpressionContext)_localctx).ENTIER = match(ENTIER);
				((ExpressionContext)_localctx).code = "PUSHI -" + (((ExpressionContext)_localctx).ENTIER!=null?((ExpressionContext)_localctx).ENTIER.getText():null) +"\n";
				}
				break;
			case IDENTIFIANT:
				{
				setState(96);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				 
				                AdresseType at = tablesSymboles.getAdresseType((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null));
				                int adresse = at.adresse;
				                ((ExpressionContext)_localctx).code =  "PUSHG " +adresse+"\n";
				            
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(112);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(110);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(100);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(101);
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
						setState(102);
						((ExpressionContext)_localctx).b = expression(6);
						((ExpressionContext)_localctx).code =  evalexpr(((ExpressionContext)_localctx).a.code,(((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null),((ExpressionContext)_localctx).b.code);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(105);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(106);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__6 || _la==T__7) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(107);
						((ExpressionContext)_localctx).b = expression(5);
						((ExpressionContext)_localctx).code =  evalexpr(((ExpressionContext)_localctx).a.code,(((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null),((ExpressionContext)_localctx).b.code);
						}
						break;
					}
					} 
				}
				setState(114);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterFinInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitFinInstruction(this);
		}
	}

	public final FinInstructionContext finInstruction() throws RecognitionException {
		FinInstructionContext _localctx = new FinInstructionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_finInstruction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(116); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(115);
					_la = _input.LA(1);
					if ( !(_la==T__8 || _la==NEWLINE) ) {
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
				setState(118); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_decl);
		try {
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				match(T__9);
				setState(121);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(122);
				match(T__10);
				setState(123);
				((DeclContext)_localctx).TYPE = match(TYPE);
				setState(124);
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
				setState(127);
				match(T__9);
				setState(128);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(129);
				match(T__10);
				setState(130);
				((DeclContext)_localctx).TYPE = match(TYPE);
				setState(131);
				match(T__11);
				setState(132);
				((DeclContext)_localctx).expression = expression(0);
				setState(133);
				finInstruction();

				            if((((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null).equals("int")){
				                tablesSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null),"int");
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterAssignation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitAssignation(this);
		}
	}

	public final AssignationContext assignation() throws RecognitionException {
		AssignationContext _localctx = new AssignationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(139);
			((AssignationContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__11 || _la==T__12) ) {
				((AssignationContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(140);
			((AssignationContext)_localctx).expression = expression(0);
			  
			            AdresseType at = tablesSymboles.getAdresseType((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));
			            int adresse = at.adresse;
			            if((((AssignationContext)_localctx).op!=null?((AssignationContext)_localctx).op.getText():null).equals("=")){    
			                ((AssignationContext)_localctx).code =  ((AssignationContext)_localctx).expression.code + "STOREG " + adresse +"\n";
			            }
			            if((((AssignationContext)_localctx).op!=null?((AssignationContext)_localctx).op.getText():null).equals("+=")){
			                ((AssignationContext)_localctx).code =  ((AssignationContext)_localctx).expression.code + "PUSHG " +adresse +"\n"+"ADD\n"+"STOREG " +adresse +"\n";
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitCondition(this);
		}
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
			setState(155);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEGLOGIQUE:
				{
				setState(144);
				match(NEGLOGIQUE);
				setState(145);
				((ConditionContext)_localctx).condition = condition(4);
				((ConditionContext)_localctx).code = ((ConditionContext)_localctx).condition.code + "PUSHI 0\n" + "EQUAL\n";
				}
				break;
			case T__1:
			case T__7:
			case IDENTIFIANT:
			case ENTIER:
				{
				setState(148);
				((ConditionContext)_localctx).a = expression(0);
				setState(149);
				((ConditionContext)_localctx).CONDITION = match(CONDITION);
				setState(150);
				((ConditionContext)_localctx).b = expression(0);

				            ((ConditionContext)_localctx).code = ((ConditionContext)_localctx).a.code;
				            _localctx.code+=((ConditionContext)_localctx).b.code;
				            _localctx.code+=evalCondition((((ConditionContext)_localctx).CONDITION!=null?((ConditionContext)_localctx).CONDITION.getText():null))+"\n";
				        
				}
				break;
			case BOOL:
				{
				setState(153);
				((ConditionContext)_localctx).BOOL = match(BOOL);
				 ((ConditionContext)_localctx).code =  evalBOOL((((ConditionContext)_localctx).BOOL!=null?((ConditionContext)_localctx).BOOL.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(164);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
					setState(157);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(158);
					((ConditionContext)_localctx).OPLOGIQUE = match(OPLOGIQUE);
					setState(159);
					((ConditionContext)_localctx).c2 = ((ConditionContext)_localctx).condition = condition(3);

					                      ((ConditionContext)_localctx).code = evalOPLOGIQUE(((ConditionContext)_localctx).c1.code,(((ConditionContext)_localctx).OPLOGIQUE!=null?((ConditionContext)_localctx).OPLOGIQUE.getText():null),((ConditionContext)_localctx).c2.code);
					                  
					}
					} 
				}
				setState(166);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterBloc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitBloc(this);
		}
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
			setState(167);
			match(T__13);
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__7) | (1L << T__8) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__19) | (1L << IDENTIFIANT) | (1L << ENTIER) | (1L << NEWLINE))) != 0)) {
				{
				{
				setState(168);
				((BlocContext)_localctx).instruction = instruction();
				 _localctx.code+=((BlocContext)_localctx).instruction.code;
				}
				}
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(176);
			match(T__14);
			setState(180);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(177);
					match(NEWLINE);
					}
					} 
				}
				setState(182);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterBoucle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitBoucle(this);
		}
	}

	public final BoucleContext boucle() throws RecognitionException {
		BoucleContext _localctx = new BoucleContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_boucle);
		 ((BoucleContext)_localctx).code =  new String(); 
		        //Générer deux labels un pour le debut et un pour la fin
		        String labelDebut = getNewLabel();
		        String labelFin=getNewLabel();
		    
		try {
			setState(209);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__15:
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				match(T__15);
				setState(184);
				match(T__1);
				setState(185);
				((BoucleContext)_localctx).condition = condition(0);
				setState(186);
				match(T__2);
				setState(187);
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
			case T__16:
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				match(T__16);
				setState(191);
				match(T__1);
				setState(192);
				((BoucleContext)_localctx).init = assignation();
				setState(193);
				match(T__8);
				setState(194);
				((BoucleContext)_localctx).condition = condition(0);
				setState(195);
				match(T__8);
				setState(196);
				((BoucleContext)_localctx).incr = assignation();
				setState(197);
				match(T__2);
				setState(198);
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
			case T__17:
				enterOuterAlt(_localctx, 3);
				{
				setState(201);
				match(T__17);
				setState(202);
				((BoucleContext)_localctx).instruction = instruction();
				setState(203);
				match(T__18);
				setState(204);
				match(T__1);
				setState(205);
				((BoucleContext)_localctx).condition = condition(0);
				setState(206);
				match(T__2);

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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterSi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitSi(this);
		}
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
			setState(211);
			match(T__19);
			setState(212);
			match(T__1);
			setState(213);
			((SiContext)_localctx).condition = condition(0);
			setState(214);
			match(T__2);
			setState(215);
			((SiContext)_localctx).i = instruction();

			            
			            _localctx.code+=((SiContext)_localctx).condition.code;
			            _localctx.code+="JUMPF "+ labelElse+"\n";
			            _localctx.code+=((SiContext)_localctx).i.code;
			            _localctx.code+="JUMP " + labelFin +"\n";
			            _localctx.code+="LABEL "+labelElse+"\n";
			        
			setState(221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(217);
				match(T__20);
				setState(218);
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
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$\u00e4\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\2\3\3\3\3\3\3\7\3\37\n\3\f\3\16\3\"\13\3\3\3\7\3"+
		"%\n\3\f\3\16\3(\13\3\3\3\3\3\3\3\7\3-\n\3\f\3\16\3\60\13\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4V\n"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5e\n\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5q\n\5\f\5\16\5t\13\5\3\6\6\6w\n"+
		"\6\r\6\16\6x\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\5\7\u008b\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\5\t\u009e\n\t\3\t\3\t\3\t\3\t\3\t\7\t\u00a5\n\t\f\t"+
		"\16\t\u00a8\13\t\3\n\3\n\3\n\3\n\7\n\u00ae\n\n\f\n\16\n\u00b1\13\n\3\n"+
		"\3\n\7\n\u00b5\n\n\f\n\16\n\u00b8\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\5\13\u00d4\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\5\f\u00e0\n\f\3\f\3\f\3\f\2\4\b\20\r\2\4\6\b\n\f\16\20"+
		"\22\24\26\2\6\3\2\7\b\3\2\t\n\4\2\13\13\37\37\3\2\16\17\2\u00f1\2\30\3"+
		"\2\2\2\4 \3\2\2\2\6U\3\2\2\2\bd\3\2\2\2\nv\3\2\2\2\f\u008a\3\2\2\2\16"+
		"\u008c\3\2\2\2\20\u009d\3\2\2\2\22\u00a9\3\2\2\2\24\u00d3\3\2\2\2\26\u00d5"+
		"\3\2\2\2\30\31\5\4\3\2\31\32\7\2\2\3\32\3\3\2\2\2\33\34\5\f\7\2\34\35"+
		"\b\3\1\2\35\37\3\2\2\2\36\33\3\2\2\2\37\"\3\2\2\2 \36\3\2\2\2 !\3\2\2"+
		"\2!&\3\2\2\2\" \3\2\2\2#%\7\37\2\2$#\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3"+
		"\2\2\2\'.\3\2\2\2(&\3\2\2\2)*\5\6\4\2*+\b\3\1\2+-\3\2\2\2,)\3\2\2\2-\60"+
		"\3\2\2\2.,\3\2\2\2./\3\2\2\2/\61\3\2\2\2\60.\3\2\2\2\61\62\b\3\1\2\62"+
		"\5\3\2\2\2\63\64\5\b\5\2\64\65\5\n\6\2\65\66\b\4\1\2\66V\3\2\2\2\678\5"+
		"\16\b\289\5\n\6\29:\b\4\1\2:V\3\2\2\2;<\7\3\2\2<=\7\4\2\2=>\7\32\2\2>"+
		"?\7\5\2\2?@\5\n\6\2@A\b\4\1\2AV\3\2\2\2BC\7\6\2\2CD\7\4\2\2DE\5\b\5\2"+
		"EF\7\5\2\2FG\5\n\6\2GH\b\4\1\2HV\3\2\2\2IJ\5\24\13\2JK\b\4\1\2KV\3\2\2"+
		"\2LM\5\26\f\2MN\b\4\1\2NV\3\2\2\2OP\5\22\n\2PQ\b\4\1\2QV\3\2\2\2RS\5\n"+
		"\6\2ST\b\4\1\2TV\3\2\2\2U\63\3\2\2\2U\67\3\2\2\2U;\3\2\2\2UB\3\2\2\2U"+
		"I\3\2\2\2UL\3\2\2\2UO\3\2\2\2UR\3\2\2\2V\7\3\2\2\2WX\b\5\1\2XY\7\4\2\2"+
		"YZ\5\b\5\2Z[\7\5\2\2[\\\b\5\1\2\\e\3\2\2\2]^\7\35\2\2^e\b\5\1\2_`\7\n"+
		"\2\2`a\7\35\2\2ae\b\5\1\2bc\7\32\2\2ce\b\5\1\2dW\3\2\2\2d]\3\2\2\2d_\3"+
		"\2\2\2db\3\2\2\2er\3\2\2\2fg\f\7\2\2gh\t\2\2\2hi\5\b\5\bij\b\5\1\2jq\3"+
		"\2\2\2kl\f\6\2\2lm\t\3\2\2mn\5\b\5\7no\b\5\1\2oq\3\2\2\2pf\3\2\2\2pk\3"+
		"\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2s\t\3\2\2\2tr\3\2\2\2uw\t\4\2\2vu"+
		"\3\2\2\2wx\3\2\2\2xv\3\2\2\2xy\3\2\2\2y\13\3\2\2\2z{\7\f\2\2{|\7\32\2"+
		"\2|}\7\r\2\2}~\7\30\2\2~\177\5\n\6\2\177\u0080\b\7\1\2\u0080\u008b\3\2"+
		"\2\2\u0081\u0082\7\f\2\2\u0082\u0083\7\32\2\2\u0083\u0084\7\r\2\2\u0084"+
		"\u0085\7\30\2\2\u0085\u0086\7\16\2\2\u0086\u0087\5\b\5\2\u0087\u0088\5"+
		"\n\6\2\u0088\u0089\b\7\1\2\u0089\u008b\3\2\2\2\u008az\3\2\2\2\u008a\u0081"+
		"\3\2\2\2\u008b\r\3\2\2\2\u008c\u008d\7\32\2\2\u008d\u008e\t\5\2\2\u008e"+
		"\u008f\5\b\5\2\u008f\u0090\b\b\1\2\u0090\17\3\2\2\2\u0091\u0092\b\t\1"+
		"\2\u0092\u0093\7#\2\2\u0093\u0094\5\20\t\6\u0094\u0095\b\t\1\2\u0095\u009e"+
		"\3\2\2\2\u0096\u0097\5\b\5\2\u0097\u0098\7\33\2\2\u0098\u0099\5\b\5\2"+
		"\u0099\u009a\b\t\1\2\u009a\u009e\3\2\2\2\u009b\u009c\7\31\2\2\u009c\u009e"+
		"\b\t\1\2\u009d\u0091\3\2\2\2\u009d\u0096\3\2\2\2\u009d\u009b\3\2\2\2\u009e"+
		"\u00a6\3\2\2\2\u009f\u00a0\f\4\2\2\u00a0\u00a1\7\"\2\2\u00a1\u00a2\5\20"+
		"\t\5\u00a2\u00a3\b\t\1\2\u00a3\u00a5\3\2\2\2\u00a4\u009f\3\2\2\2\u00a5"+
		"\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\21\3\2\2"+
		"\2\u00a8\u00a6\3\2\2\2\u00a9\u00af\7\20\2\2\u00aa\u00ab\5\6\4\2\u00ab"+
		"\u00ac\b\n\1\2\u00ac\u00ae\3\2\2\2\u00ad\u00aa\3\2\2\2\u00ae\u00b1\3\2"+
		"\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b2\3\2\2\2\u00b1"+
		"\u00af\3\2\2\2\u00b2\u00b6\7\21\2\2\u00b3\u00b5\7\37\2\2\u00b4\u00b3\3"+
		"\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7"+
		"\23\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba\7\22\2\2\u00ba\u00bb\7\4\2"+
		"\2\u00bb\u00bc\5\20\t\2\u00bc\u00bd\7\5\2\2\u00bd\u00be\5\6\4\2\u00be"+
		"\u00bf\b\13\1\2\u00bf\u00d4\3\2\2\2\u00c0\u00c1\7\23\2\2\u00c1\u00c2\7"+
		"\4\2\2\u00c2\u00c3\5\16\b\2\u00c3\u00c4\7\13\2\2\u00c4\u00c5\5\20\t\2"+
		"\u00c5\u00c6\7\13\2\2\u00c6\u00c7\5\16\b\2\u00c7\u00c8\7\5\2\2\u00c8\u00c9"+
		"\5\6\4\2\u00c9\u00ca\b\13\1\2\u00ca\u00d4\3\2\2\2\u00cb\u00cc\7\24\2\2"+
		"\u00cc\u00cd\5\6\4\2\u00cd\u00ce\7\25\2\2\u00ce\u00cf\7\4\2\2\u00cf\u00d0"+
		"\5\20\t\2\u00d0\u00d1\7\5\2\2\u00d1\u00d2\b\13\1\2\u00d2\u00d4\3\2\2\2"+
		"\u00d3\u00b9\3\2\2\2\u00d3\u00c0\3\2\2\2\u00d3\u00cb\3\2\2\2\u00d4\25"+
		"\3\2\2\2\u00d5\u00d6\7\26\2\2\u00d6\u00d7\7\4\2\2\u00d7\u00d8\5\20\t\2"+
		"\u00d8\u00d9\7\5\2\2\u00d9\u00da\5\6\4\2\u00da\u00df\b\f\1\2\u00db\u00dc"+
		"\7\27\2\2\u00dc\u00dd\5\6\4\2\u00dd\u00de\b\f\1\2\u00de\u00e0\3\2\2\2"+
		"\u00df\u00db\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2"+
		"\b\f\1\2\u00e2\27\3\2\2\2\21 &.Udprx\u008a\u009d\u00a6\u00af\u00b6\u00d3"+
		"\u00df";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}