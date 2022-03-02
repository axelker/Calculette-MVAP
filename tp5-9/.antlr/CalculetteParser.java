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
		T__17=18, TYPE=19, IDENTIFIANT=20, CONDITION=21, WS=22, ENTIER=23, FLOAT=24, 
		NEWLINE=25, COMMENTARY=26, OPERATION=27, UNMATCH=28;
	public static final int
		RULE_start = 0, RULE_calcul = 1, RULE_instruction = 2, RULE_expression = 3, 
		RULE_finInstruction = 4, RULE_decl = 5, RULE_assignation = 6, RULE_condition = 7, 
		RULE_bloc = 8, RULE_boucle = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "calcul", "instruction", "expression", "finInstruction", "decl", 
			"assignation", "condition", "bloc", "boucle"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'read'", "'('", "')'", "'write'", "'/'", "'*'", "'+'", "'-'", 
			"';'", "'var'", "':'", "'='", "'+='", "'true'", "'false'", "'{'", "'}'", 
			"'while'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "TYPE", "IDENTIFIANT", "CONDITION", 
			"WS", "ENTIER", "FLOAT", "NEWLINE", "COMMENTARY", "OPERATION", "UNMATCH"
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
			setState(20);
			calcul();
			setState(21);
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
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(23);
				((CalculContext)_localctx).decl = decl();
				 _localctx.code += ((CalculContext)_localctx).decl.code; 
				}
				}
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(34);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(31);
					match(NEWLINE);
					}
					} 
				}
				setState(36);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__7) | (1L << T__8) | (1L << T__17) | (1L << IDENTIFIANT) | (1L << ENTIER) | (1L << NEWLINE))) != 0)) {
				{
				{
				setState(37);
				((CalculContext)_localctx).instruction = instruction();
				 _localctx.code += ((CalculContext)_localctx).instruction.code; 
				}
				}
				setState(44);
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
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instruction);
		try {
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				((InstructionContext)_localctx).expression = expression(0);
				setState(48);
				finInstruction();
				 
				            ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).expression.code;
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				((InstructionContext)_localctx).assignation = assignation();
				setState(52);
				finInstruction();
				 
				            ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).assignation.code;
				        
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(55);
				match(T__0);
				setState(56);
				match(T__1);
				setState(57);
				((InstructionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(58);
				match(T__2);
				setState(59);
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
				setState(62);
				match(T__3);
				setState(63);
				match(T__1);
				setState(64);
				((InstructionContext)_localctx).expression = expression(0);
				setState(65);
				match(T__2);
				setState(66);
				finInstruction();
				 
				            ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).expression.code + "WRITE\nPOP\n";
				        
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(69);
				((InstructionContext)_localctx).boucle = boucle();

				            ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).boucle.code;
				        
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(72);
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
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				setState(78);
				match(T__1);
				setState(79);
				((ExpressionContext)_localctx).a = expression(0);
				setState(80);
				match(T__2);
				((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code;
				}
				break;
			case ENTIER:
				{
				setState(83);
				((ExpressionContext)_localctx).ENTIER = match(ENTIER);
				((ExpressionContext)_localctx).code =  "PUSHI " + (((ExpressionContext)_localctx).ENTIER!=null?((ExpressionContext)_localctx).ENTIER.getText():null) +"\n";
				}
				break;
			case T__7:
				{
				setState(85);
				match(T__7);
				setState(86);
				((ExpressionContext)_localctx).ENTIER = match(ENTIER);
				((ExpressionContext)_localctx).code = "PUSHI -" + (((ExpressionContext)_localctx).ENTIER!=null?((ExpressionContext)_localctx).ENTIER.getText():null) +"\n";
				}
				break;
			case IDENTIFIANT:
				{
				setState(88);
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
			setState(104);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(102);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(92);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(93);
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
						setState(94);
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
						setState(97);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(98);
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
						setState(99);
						((ExpressionContext)_localctx).b = expression(5);
						((ExpressionContext)_localctx).code =  evalexpr(((ExpressionContext)_localctx).a.code,(((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null),((ExpressionContext)_localctx).b.code);
						}
						break;
					}
					} 
				}
				setState(106);
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
	}

	public final FinInstructionContext finInstruction() throws RecognitionException {
		FinInstructionContext _localctx = new FinInstructionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_finInstruction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(108); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(107);
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
				setState(110); 
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
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_decl);
		try {
			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				match(T__9);
				setState(113);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(114);
				match(T__10);
				setState(115);
				((DeclContext)_localctx).TYPE = match(TYPE);
				setState(116);
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
				setState(119);
				match(T__9);
				setState(120);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(121);
				match(T__10);
				setState(122);
				((DeclContext)_localctx).TYPE = match(TYPE);
				setState(123);
				match(T__11);
				setState(124);
				((DeclContext)_localctx).expression = expression(0);
				setState(125);
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
	}

	public final AssignationContext assignation() throws RecognitionException {
		AssignationContext _localctx = new AssignationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(131);
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
			setState(132);
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
		public ExpressionContext a;
		public Token CONDITION;
		public ExpressionContext b;
		public TerminalNode CONDITION() { return getToken(CalculetteParser.CONDITION, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_condition);
		try {
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				match(T__13);
				 ((ConditionContext)_localctx).code =  "  PUSHI 1\n"; 
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				match(T__14);
				 ((ConditionContext)_localctx).code =  "  PUSHI 0\n"; 
				}
				break;
			case T__1:
			case T__7:
			case IDENTIFIANT:
			case ENTIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(139);
				((ConditionContext)_localctx).a = expression(0);
				setState(140);
				((ConditionContext)_localctx).CONDITION = match(CONDITION);
				setState(141);
				((ConditionContext)_localctx).b = expression(0);

				            ((ConditionContext)_localctx).code = ((ConditionContext)_localctx).a.code;
				            _localctx.code+=((ConditionContext)_localctx).b.code;
				            _localctx.code+=evalCondition((((ConditionContext)_localctx).CONDITION!=null?((ConditionContext)_localctx).CONDITION.getText():null))+"\n";
				        
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

	public static class BlocContext extends ParserRuleContext {
		public String code;
		public InstructionContext instruction;
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(T__15);
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__7) | (1L << T__8) | (1L << T__17) | (1L << IDENTIFIANT) | (1L << ENTIER) | (1L << NEWLINE))) != 0)) {
				{
				{
				setState(147);
				((BlocContext)_localctx).instruction = instruction();
				 _localctx.code+=((BlocContext)_localctx).instruction.code;
				}
				}
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(155);
			match(T__16);
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
		public BlocContext bloc;
		public InstructionContext instruction;
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public BlocContext bloc() {
			return getRuleContext(BlocContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public BoucleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boucle; }
	}

	public final BoucleContext boucle() throws RecognitionException {
		BoucleContext _localctx = new BoucleContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_boucle);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(T__17);
			setState(158);
			match(T__1);
			setState(159);
			((BoucleContext)_localctx).condition = condition();
			setState(160);
			match(T__2);

			            //Générer deux labels un pour le debut et un pour la fin
			            String labelDebut = getNewLabel();
			            String labelFin=getNewLabel();

			            //Label debut 
			            ((BoucleContext)_localctx).code = "LABEL " + labelDebut+"\n";
			            _localctx.code+=((BoucleContext)_localctx).condition.code;
			            //Condition du jump selon 1 ou 0 dans la pile
			            _localctx.code+="JUMPF "+ labelFin+"\n";
			        
			setState(168);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__15:
				{
				setState(162);
				((BoucleContext)_localctx).bloc = bloc();
				_localctx.code+= ((BoucleContext)_localctx).bloc.code;
				}
				break;
			case T__0:
			case T__1:
			case T__3:
			case T__7:
			case T__8:
			case T__17:
			case IDENTIFIANT:
			case ENTIER:
			case NEWLINE:
				{
				setState(165);
				((BoucleContext)_localctx).instruction = instruction();
				_localctx.code+=((BoucleContext)_localctx).instruction.code;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			            _localctx.code+="JUMP " +labelDebut+"\n";
			            _localctx.code+="LABEL "+labelFin+"\n";
			        
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\36\u00af\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\3\2\3\2\3\3\3\3\3\3\7\3\35\n\3\f\3\16\3 \13\3\3\3\7\3#\n\3\f"+
		"\3\16\3&\13\3\3\3\3\3\3\3\7\3+\n\3\f\3\16\3.\13\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4N\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\5\5]\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\7\5i\n\5\f\5\16\5l\13\5\3\6\6\6o\n\6\r\6\16\6p\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0083\n\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0093\n\t\3\n\3\n\3\n"+
		"\3\n\7\n\u0099\n\n\f\n\16\n\u009c\13\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00ab\n\13\3\13\3\13\3\13\2\3\b\f"+
		"\2\4\6\b\n\f\16\20\22\24\2\6\3\2\7\b\3\2\t\n\4\2\13\13\33\33\3\2\16\17"+
		"\2\u00b7\2\26\3\2\2\2\4\36\3\2\2\2\6M\3\2\2\2\b\\\3\2\2\2\nn\3\2\2\2\f"+
		"\u0082\3\2\2\2\16\u0084\3\2\2\2\20\u0092\3\2\2\2\22\u0094\3\2\2\2\24\u009f"+
		"\3\2\2\2\26\27\5\4\3\2\27\30\7\2\2\3\30\3\3\2\2\2\31\32\5\f\7\2\32\33"+
		"\b\3\1\2\33\35\3\2\2\2\34\31\3\2\2\2\35 \3\2\2\2\36\34\3\2\2\2\36\37\3"+
		"\2\2\2\37$\3\2\2\2 \36\3\2\2\2!#\7\33\2\2\"!\3\2\2\2#&\3\2\2\2$\"\3\2"+
		"\2\2$%\3\2\2\2%,\3\2\2\2&$\3\2\2\2\'(\5\6\4\2()\b\3\1\2)+\3\2\2\2*\'\3"+
		"\2\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2\2\2-/\3\2\2\2.,\3\2\2\2/\60\b\3\1\2\60"+
		"\5\3\2\2\2\61\62\5\b\5\2\62\63\5\n\6\2\63\64\b\4\1\2\64N\3\2\2\2\65\66"+
		"\5\16\b\2\66\67\5\n\6\2\678\b\4\1\28N\3\2\2\29:\7\3\2\2:;\7\4\2\2;<\7"+
		"\26\2\2<=\7\5\2\2=>\5\n\6\2>?\b\4\1\2?N\3\2\2\2@A\7\6\2\2AB\7\4\2\2BC"+
		"\5\b\5\2CD\7\5\2\2DE\5\n\6\2EF\b\4\1\2FN\3\2\2\2GH\5\24\13\2HI\b\4\1\2"+
		"IN\3\2\2\2JK\5\n\6\2KL\b\4\1\2LN\3\2\2\2M\61\3\2\2\2M\65\3\2\2\2M9\3\2"+
		"\2\2M@\3\2\2\2MG\3\2\2\2MJ\3\2\2\2N\7\3\2\2\2OP\b\5\1\2PQ\7\4\2\2QR\5"+
		"\b\5\2RS\7\5\2\2ST\b\5\1\2T]\3\2\2\2UV\7\31\2\2V]\b\5\1\2WX\7\n\2\2XY"+
		"\7\31\2\2Y]\b\5\1\2Z[\7\26\2\2[]\b\5\1\2\\O\3\2\2\2\\U\3\2\2\2\\W\3\2"+
		"\2\2\\Z\3\2\2\2]j\3\2\2\2^_\f\7\2\2_`\t\2\2\2`a\5\b\5\bab\b\5\1\2bi\3"+
		"\2\2\2cd\f\6\2\2de\t\3\2\2ef\5\b\5\7fg\b\5\1\2gi\3\2\2\2h^\3\2\2\2hc\3"+
		"\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2k\t\3\2\2\2lj\3\2\2\2mo\t\4\2\2nm"+
		"\3\2\2\2op\3\2\2\2pn\3\2\2\2pq\3\2\2\2q\13\3\2\2\2rs\7\f\2\2st\7\26\2"+
		"\2tu\7\r\2\2uv\7\25\2\2vw\5\n\6\2wx\b\7\1\2x\u0083\3\2\2\2yz\7\f\2\2z"+
		"{\7\26\2\2{|\7\r\2\2|}\7\25\2\2}~\7\16\2\2~\177\5\b\5\2\177\u0080\5\n"+
		"\6\2\u0080\u0081\b\7\1\2\u0081\u0083\3\2\2\2\u0082r\3\2\2\2\u0082y\3\2"+
		"\2\2\u0083\r\3\2\2\2\u0084\u0085\7\26\2\2\u0085\u0086\t\5\2\2\u0086\u0087"+
		"\5\b\5\2\u0087\u0088\b\b\1\2\u0088\17\3\2\2\2\u0089\u008a\7\20\2\2\u008a"+
		"\u0093\b\t\1\2\u008b\u008c\7\21\2\2\u008c\u0093\b\t\1\2\u008d\u008e\5"+
		"\b\5\2\u008e\u008f\7\27\2\2\u008f\u0090\5\b\5\2\u0090\u0091\b\t\1\2\u0091"+
		"\u0093\3\2\2\2\u0092\u0089\3\2\2\2\u0092\u008b\3\2\2\2\u0092\u008d\3\2"+
		"\2\2\u0093\21\3\2\2\2\u0094\u009a\7\22\2\2\u0095\u0096\5\6\4\2\u0096\u0097"+
		"\b\n\1\2\u0097\u0099\3\2\2\2\u0098\u0095\3\2\2\2\u0099\u009c\3\2\2\2\u009a"+
		"\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009d\3\2\2\2\u009c\u009a\3\2"+
		"\2\2\u009d\u009e\7\23\2\2\u009e\23\3\2\2\2\u009f\u00a0\7\24\2\2\u00a0"+
		"\u00a1\7\4\2\2\u00a1\u00a2\5\20\t\2\u00a2\u00a3\7\5\2\2\u00a3\u00aa\b"+
		"\13\1\2\u00a4\u00a5\5\22\n\2\u00a5\u00a6\b\13\1\2\u00a6\u00ab\3\2\2\2"+
		"\u00a7\u00a8\5\6\4\2\u00a8\u00a9\b\13\1\2\u00a9\u00ab\3\2\2\2\u00aa\u00a4"+
		"\3\2\2\2\u00aa\u00a7\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\b\13\1\2"+
		"\u00ad\25\3\2\2\2\16\36$,M\\hjp\u0082\u0092\u009a\u00aa";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}