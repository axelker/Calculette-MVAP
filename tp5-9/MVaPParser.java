// Generated from MVaP.g4 by ANTLR 4.9

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
public class MVaPParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, WS=8, ENTIER=9, 
		FLOAT=10, ADD=11, SUB=12, MUL=13, DIV=14, INF=15, INFEQ=16, SUP=17, SUPEQ=18, 
		EQUAL=19, NEQ=20, FADD=21, FSUB=22, FMUL=23, FDIV=24, FINF=25, FINFEQ=26, 
		FSUP=27, FSUPEQ=28, FEQUAL=29, FNEQ=30, ITOF=31, FTOI=32, RETURN=33, POP=34, 
		POPF=35, READ=36, READF=37, WRITE=38, WRITEF=39, PADD=40, PUSHGP=41, PUSHFP=42, 
		DUP=43, PUSHI=44, PUSHG=45, STOREG=46, PUSHL=47, STOREL=48, PUSHR=49, 
		STORER=50, FREE=51, ALLOC=52, PUSHF=53, CALL=54, JUMP=55, JUMPF=56, JUMPI=57, 
		HALT=58, LABEL=59, IDENTIFIANT=60, NEWLINE=61;
	public static final int
		RULE_program = 0, RULE_instr = 1, RULE_commande1 = 2, RULE_instr1 = 3, 
		RULE_commande2 = 4, RULE_instr2 = 5, RULE_instr2f = 6, RULE_commandeSaut = 7, 
		RULE_saut = 8, RULE_label = 9, RULE_calcul = 10, RULE_instruction = 11, 
		RULE_expression = 12, RULE_finInstruction = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "instr", "commande1", "instr1", "commande2", "instr2", "instr2f", 
			"commandeSaut", "saut", "label", "calcul", "instruction", "expression", 
			"finInstruction"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'-'", "'/'", "'*'", "'+'", "'('", "')'", "';'", null, null, null, 
			"'ADD'", "'SUB'", "'MUL'", "'DIV'", "'INF'", "'INFEQ'", "'SUP'", "'SUPEQ'", 
			"'EQUAL'", "'NEQ'", "'FADD'", "'FSUB'", "'FMUL'", "'FDIV'", "'FINF'", 
			"'FINFEQ'", "'FSUP'", "'FSUPEQ'", "'FEQUAL'", "'FNEQ'", "'ITOF'", "'FTOI'", 
			"'RETURN'", "'POP'", "'POPF'", "'READ'", "'READF'", "'WRITE'", "'WRITEF'", 
			"'PADD'", "'PUSHGP'", "'PUSHFP'", "'DUP'", "'PUSHI'", "'PUSHG'", "'STOREG'", 
			"'PUSHL'", "'STOREL'", "'PUSHR'", "'STORER'", "'FREE'", "'ALLOC'", "'PUSHF'", 
			"'CALL'", "'JUMP '", "'JUMPF'", "'JUMPI'", "'HALT'", "'LABEL'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "WS", "ENTIER", "FLOAT", 
			"ADD", "SUB", "MUL", "DIV", "INF", "INFEQ", "SUP", "SUPEQ", "EQUAL", 
			"NEQ", "FADD", "FSUB", "FMUL", "FDIV", "FINF", "FINFEQ", "FSUP", "FSUPEQ", 
			"FEQUAL", "FNEQ", "ITOF", "FTOI", "RETURN", "POP", "POPF", "READ", "READF", 
			"WRITE", "WRITEF", "PADD", "PUSHGP", "PUSHFP", "DUP", "PUSHI", "PUSHG", 
			"STOREG", "PUSHL", "STOREL", "PUSHR", "STORER", "FREE", "ALLOC", "PUSHF", 
			"CALL", "JUMP", "JUMPF", "JUMPI", "HALT", "LABEL", "IDENTIFIANT", "NEWLINE"
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
	public String getGrammarFileName() { return "MVaP.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    /** La map pour mémoriser les addresses des étiquettes */
	    private HashMap<String, Integer> labels = new HashMap<String, Integer>();
	    /** adresse instruction */
	    private int instrAddress = 0;
	    /** Récupère le dictionnaire des étiquettes */
	    public HashMap<String, Integer> getLabels() { return labels; }
	    public int getProgramSize() { return instrAddress; }
	     private String evalexpr (String x, String op, String y) {
	        if ( op.equals("*") ){
	            return "x"+"y"+"MUL\n";
	        }
	        if ( op.equals("+") ){
	            return "x"+"y"+"ADD\n";
	        } 
	        if ( op.equals("/") ){
	            return "x"+"y"+"DIV\n";
	        }
	        if ( op.equals("-") ){
	            return "x"+"y"+"SUB\n";
	        }
	        else {
	           System.err.println("Opérateur arithmétique incorrect : '"+op+"'");
	           throw new IllegalArgumentException("Opérateur arithmétique incorrect : '"+op+"'");
	        }
	    }

	public MVaPParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<InstrContext> instr() {
			return getRuleContexts(InstrContext.class);
		}
		public InstrContext instr(int i) {
			return getRuleContext(InstrContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MVaPListener ) ((MVaPListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MVaPListener ) ((MVaPListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(28);
				instr();
				}
				}
				setState(31); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << INF) | (1L << INFEQ) | (1L << SUP) | (1L << SUPEQ) | (1L << EQUAL) | (1L << NEQ) | (1L << FADD) | (1L << FSUB) | (1L << FMUL) | (1L << FDIV) | (1L << FINF) | (1L << FINFEQ) | (1L << FSUP) | (1L << FSUPEQ) | (1L << FEQUAL) | (1L << FNEQ) | (1L << ITOF) | (1L << FTOI) | (1L << RETURN) | (1L << POP) | (1L << POPF) | (1L << READ) | (1L << READF) | (1L << WRITE) | (1L << WRITEF) | (1L << PADD) | (1L << PUSHGP) | (1L << PUSHFP) | (1L << DUP) | (1L << PUSHI) | (1L << PUSHG) | (1L << STOREG) | (1L << PUSHL) | (1L << STOREL) | (1L << PUSHR) | (1L << STORER) | (1L << FREE) | (1L << ALLOC) | (1L << PUSHF) | (1L << CALL) | (1L << JUMP) | (1L << JUMPF) | (1L << JUMPI) | (1L << HALT) | (1L << LABEL) | (1L << NEWLINE))) != 0) );
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

	public static class InstrContext extends ParserRuleContext {
		public Instr1Context instr1() {
			return getRuleContext(Instr1Context.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(MVaPParser.NEWLINE, 0); }
		public Instr2Context instr2() {
			return getRuleContext(Instr2Context.class,0);
		}
		public Instr2fContext instr2f() {
			return getRuleContext(Instr2fContext.class,0);
		}
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public SautContext saut() {
			return getRuleContext(SautContext.class,0);
		}
		public InstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MVaPListener ) ((MVaPListener)listener).enterInstr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MVaPListener ) ((MVaPListener)listener).exitInstr(this);
		}
	}

	public final InstrContext instr() throws RecognitionException {
		InstrContext _localctx = new InstrContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instr);
		try {
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD:
			case SUB:
			case MUL:
			case DIV:
			case INF:
			case INFEQ:
			case SUP:
			case SUPEQ:
			case EQUAL:
			case NEQ:
			case FADD:
			case FSUB:
			case FMUL:
			case FDIV:
			case FINF:
			case FINFEQ:
			case FSUP:
			case FSUPEQ:
			case FEQUAL:
			case FNEQ:
			case ITOF:
			case FTOI:
			case RETURN:
			case POP:
			case POPF:
			case READ:
			case READF:
			case WRITE:
			case WRITEF:
			case PADD:
			case PUSHGP:
			case PUSHFP:
			case DUP:
			case HALT:
				enterOuterAlt(_localctx, 1);
				{
				setState(33);
				instr1();
				setState(34);
				match(NEWLINE);
				}
				break;
			case PUSHI:
			case PUSHG:
			case STOREG:
			case PUSHL:
			case STOREL:
			case PUSHR:
			case STORER:
			case FREE:
			case ALLOC:
				enterOuterAlt(_localctx, 2);
				{
				setState(36);
				instr2();
				setState(37);
				match(NEWLINE);
				}
				break;
			case PUSHF:
				enterOuterAlt(_localctx, 3);
				{
				setState(39);
				instr2f();
				setState(40);
				match(NEWLINE);
				}
				break;
			case LABEL:
				enterOuterAlt(_localctx, 4);
				{
				setState(42);
				label();
				setState(43);
				match(NEWLINE);
				}
				break;
			case CALL:
			case JUMP:
			case JUMPF:
			case JUMPI:
				enterOuterAlt(_localctx, 5);
				{
				setState(45);
				saut();
				setState(46);
				match(NEWLINE);
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 6);
				{
				setState(48);
				match(NEWLINE);
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

	public static class Commande1Context extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(MVaPParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(MVaPParser.SUB, 0); }
		public TerminalNode MUL() { return getToken(MVaPParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(MVaPParser.DIV, 0); }
		public TerminalNode INF() { return getToken(MVaPParser.INF, 0); }
		public TerminalNode INFEQ() { return getToken(MVaPParser.INFEQ, 0); }
		public TerminalNode SUP() { return getToken(MVaPParser.SUP, 0); }
		public TerminalNode SUPEQ() { return getToken(MVaPParser.SUPEQ, 0); }
		public TerminalNode EQUAL() { return getToken(MVaPParser.EQUAL, 0); }
		public TerminalNode NEQ() { return getToken(MVaPParser.NEQ, 0); }
		public TerminalNode FADD() { return getToken(MVaPParser.FADD, 0); }
		public TerminalNode FSUB() { return getToken(MVaPParser.FSUB, 0); }
		public TerminalNode FMUL() { return getToken(MVaPParser.FMUL, 0); }
		public TerminalNode FDIV() { return getToken(MVaPParser.FDIV, 0); }
		public TerminalNode FINF() { return getToken(MVaPParser.FINF, 0); }
		public TerminalNode FINFEQ() { return getToken(MVaPParser.FINFEQ, 0); }
		public TerminalNode FSUP() { return getToken(MVaPParser.FSUP, 0); }
		public TerminalNode FSUPEQ() { return getToken(MVaPParser.FSUPEQ, 0); }
		public TerminalNode FEQUAL() { return getToken(MVaPParser.FEQUAL, 0); }
		public TerminalNode FNEQ() { return getToken(MVaPParser.FNEQ, 0); }
		public TerminalNode ITOF() { return getToken(MVaPParser.ITOF, 0); }
		public TerminalNode FTOI() { return getToken(MVaPParser.FTOI, 0); }
		public TerminalNode RETURN() { return getToken(MVaPParser.RETURN, 0); }
		public TerminalNode POP() { return getToken(MVaPParser.POP, 0); }
		public TerminalNode POPF() { return getToken(MVaPParser.POPF, 0); }
		public TerminalNode READ() { return getToken(MVaPParser.READ, 0); }
		public TerminalNode READF() { return getToken(MVaPParser.READF, 0); }
		public TerminalNode WRITE() { return getToken(MVaPParser.WRITE, 0); }
		public TerminalNode WRITEF() { return getToken(MVaPParser.WRITEF, 0); }
		public TerminalNode PADD() { return getToken(MVaPParser.PADD, 0); }
		public TerminalNode PUSHGP() { return getToken(MVaPParser.PUSHGP, 0); }
		public TerminalNode PUSHFP() { return getToken(MVaPParser.PUSHFP, 0); }
		public TerminalNode DUP() { return getToken(MVaPParser.DUP, 0); }
		public TerminalNode HALT() { return getToken(MVaPParser.HALT, 0); }
		public Commande1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commande1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MVaPListener ) ((MVaPListener)listener).enterCommande1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MVaPListener ) ((MVaPListener)listener).exitCommande1(this);
		}
	}

	public final Commande1Context commande1() throws RecognitionException {
		Commande1Context _localctx = new Commande1Context(_ctx, getState());
		enterRule(_localctx, 4, RULE_commande1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << INF) | (1L << INFEQ) | (1L << SUP) | (1L << SUPEQ) | (1L << EQUAL) | (1L << NEQ) | (1L << FADD) | (1L << FSUB) | (1L << FMUL) | (1L << FDIV) | (1L << FINF) | (1L << FINFEQ) | (1L << FSUP) | (1L << FSUPEQ) | (1L << FEQUAL) | (1L << FNEQ) | (1L << ITOF) | (1L << FTOI) | (1L << RETURN) | (1L << POP) | (1L << POPF) | (1L << READ) | (1L << READF) | (1L << WRITE) | (1L << WRITEF) | (1L << PADD) | (1L << PUSHGP) | (1L << PUSHFP) | (1L << DUP) | (1L << HALT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Instr1Context extends ParserRuleContext {
		public Commande1Context c;
		public Commande1Context commande1() {
			return getRuleContext(Commande1Context.class,0);
		}
		public Instr1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instr1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MVaPListener ) ((MVaPListener)listener).enterInstr1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MVaPListener ) ((MVaPListener)listener).exitInstr1(this);
		}
	}

	public final Instr1Context instr1() throws RecognitionException {
		Instr1Context _localctx = new Instr1Context(_ctx, getState());
		enterRule(_localctx, 6, RULE_instr1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			((Instr1Context)_localctx).c = commande1();
			 instrAddress++; 
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

	public static class Commande2Context extends ParserRuleContext {
		public TerminalNode PUSHI() { return getToken(MVaPParser.PUSHI, 0); }
		public TerminalNode PUSHG() { return getToken(MVaPParser.PUSHG, 0); }
		public TerminalNode STOREG() { return getToken(MVaPParser.STOREG, 0); }
		public TerminalNode PUSHL() { return getToken(MVaPParser.PUSHL, 0); }
		public TerminalNode STOREL() { return getToken(MVaPParser.STOREL, 0); }
		public TerminalNode PUSHR() { return getToken(MVaPParser.PUSHR, 0); }
		public TerminalNode STORER() { return getToken(MVaPParser.STORER, 0); }
		public TerminalNode FREE() { return getToken(MVaPParser.FREE, 0); }
		public TerminalNode ALLOC() { return getToken(MVaPParser.ALLOC, 0); }
		public Commande2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commande2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MVaPListener ) ((MVaPListener)listener).enterCommande2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MVaPListener ) ((MVaPListener)listener).exitCommande2(this);
		}
	}

	public final Commande2Context commande2() throws RecognitionException {
		Commande2Context _localctx = new Commande2Context(_ctx, getState());
		enterRule(_localctx, 8, RULE_commande2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PUSHI) | (1L << PUSHG) | (1L << STOREG) | (1L << PUSHL) | (1L << STOREL) | (1L << PUSHR) | (1L << STORER) | (1L << FREE) | (1L << ALLOC))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Instr2Context extends ParserRuleContext {
		public Commande2Context commande2() {
			return getRuleContext(Commande2Context.class,0);
		}
		public TerminalNode ENTIER() { return getToken(MVaPParser.ENTIER, 0); }
		public Instr2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instr2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MVaPListener ) ((MVaPListener)listener).enterInstr2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MVaPListener ) ((MVaPListener)listener).exitInstr2(this);
		}
	}

	public final Instr2Context instr2() throws RecognitionException {
		Instr2Context _localctx = new Instr2Context(_ctx, getState());
		enterRule(_localctx, 10, RULE_instr2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			commande2();
			setState(59);
			match(ENTIER);
			 instrAddress+=2; /* 2 entiers pour stocker l'instruction */ 
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

	public static class Instr2fContext extends ParserRuleContext {
		public TerminalNode PUSHF() { return getToken(MVaPParser.PUSHF, 0); }
		public TerminalNode FLOAT() { return getToken(MVaPParser.FLOAT, 0); }
		public Instr2fContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instr2f; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MVaPListener ) ((MVaPListener)listener).enterInstr2f(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MVaPListener ) ((MVaPListener)listener).exitInstr2f(this);
		}
	}

	public final Instr2fContext instr2f() throws RecognitionException {
		Instr2fContext _localctx = new Instr2fContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_instr2f);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(PUSHF);
			setState(63);
			match(FLOAT);
			 instrAddress+=3; /* 1 entier pour le code op et 2 pour le flottant */ 
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

	public static class CommandeSautContext extends ParserRuleContext {
		public TerminalNode JUMP() { return getToken(MVaPParser.JUMP, 0); }
		public TerminalNode JUMPF() { return getToken(MVaPParser.JUMPF, 0); }
		public TerminalNode JUMPI() { return getToken(MVaPParser.JUMPI, 0); }
		public TerminalNode CALL() { return getToken(MVaPParser.CALL, 0); }
		public CommandeSautContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commandeSaut; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MVaPListener ) ((MVaPListener)listener).enterCommandeSaut(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MVaPListener ) ((MVaPListener)listener).exitCommandeSaut(this);
		}
	}

	public final CommandeSautContext commandeSaut() throws RecognitionException {
		CommandeSautContext _localctx = new CommandeSautContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_commandeSaut);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CALL) | (1L << JUMP) | (1L << JUMPF) | (1L << JUMPI))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class SautContext extends ParserRuleContext {
		public CommandeSautContext commandeSaut() {
			return getRuleContext(CommandeSautContext.class,0);
		}
		public TerminalNode IDENTIFIANT() { return getToken(MVaPParser.IDENTIFIANT, 0); }
		public SautContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_saut; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MVaPListener ) ((MVaPListener)listener).enterSaut(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MVaPListener ) ((MVaPListener)listener).exitSaut(this);
		}
	}

	public final SautContext saut() throws RecognitionException {
		SautContext _localctx = new SautContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_saut);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			commandeSaut();
			setState(69);
			match(IDENTIFIANT);
			 instrAddress+=2; /* 2 entiers pour stocker l'instruction */ 
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

	public static class LabelContext extends ParserRuleContext {
		public Token IDENTIFIANT;
		public TerminalNode LABEL() { return getToken(MVaPParser.LABEL, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(MVaPParser.IDENTIFIANT, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MVaPListener ) ((MVaPListener)listener).enterLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MVaPListener ) ((MVaPListener)listener).exitLabel(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(LABEL);
			setState(73);
			((LabelContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			 labels.put((((LabelContext)_localctx).IDENTIFIANT!=null?((LabelContext)_localctx).IDENTIFIANT.getText():null), instrAddress); 
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
		public InstructionContext instruction;
		public List<TerminalNode> NEWLINE() { return getTokens(MVaPParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(MVaPParser.NEWLINE, i);
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
			if ( listener instanceof MVaPListener ) ((MVaPListener)listener).enterCalcul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MVaPListener ) ((MVaPListener)listener).exitCalcul(this);
		}
	}

	public final CalculContext calcul() throws RecognitionException {
		CalculContext _localctx = new CalculContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_calcul);
		 ((CalculContext)_localctx).code =  new String(); 
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(76);
					match(NEWLINE);
					}
					} 
				}
				setState(81);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__4) | (1L << T__6) | (1L << ENTIER) | (1L << NEWLINE))) != 0)) {
				{
				{
				setState(82);
				((CalculContext)_localctx).instruction = instruction();
				 _localctx.code += ((CalculContext)_localctx).instruction.code; 
				}
				}
				setState(89);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MVaPListener ) ((MVaPListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MVaPListener ) ((MVaPListener)listener).exitInstruction(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_instruction);
		try {
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__4:
			case ENTIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				((InstructionContext)_localctx).expression = expression(0);
				setState(93);
				finInstruction();
				 
				            ((InstructionContext)_localctx).code = ((InstructionContext)_localctx).expression.code;
				        
				}
				break;
			case T__6:
			case NEWLINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				finInstruction();

				            ((InstructionContext)_localctx).code = "";
				        
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

	public static class ExpressionContext extends ParserRuleContext {
		public String code;
		public ExpressionContext a;
		public Token ENTIER;
		public Token op;
		public ExpressionContext b;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ENTIER() { return getToken(MVaPParser.ENTIER, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MVaPListener ) ((MVaPListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MVaPListener ) ((MVaPListener)listener).exitExpression(this);
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(102);
				match(T__0);
				setState(103);
				((ExpressionContext)_localctx).a = expression(5);
				((ExpressionContext)_localctx).code = "-" + ((ExpressionContext)_localctx).a.code;
				}
				break;
			case T__4:
				{
				setState(106);
				match(T__4);
				setState(107);
				((ExpressionContext)_localctx).a = expression(0);
				setState(108);
				match(T__5);
				((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code;
				}
				break;
			case ENTIER:
				{
				setState(111);
				((ExpressionContext)_localctx).ENTIER = match(ENTIER);
				((ExpressionContext)_localctx).code =  "PUSHI " + (((ExpressionContext)_localctx).ENTIER!=null?Integer.valueOf(((ExpressionContext)_localctx).ENTIER.getText()):0) +"\n";
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(127);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(125);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(115);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(116);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__1 || _la==T__2) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(117);
						((ExpressionContext)_localctx).b = expression(5);
						((ExpressionContext)_localctx).code =  evalexpr(((ExpressionContext)_localctx).a.code,(((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null),((ExpressionContext)_localctx).b.code);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(120);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(121);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__0 || _la==T__3) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(122);
						((ExpressionContext)_localctx).b = expression(4);
						((ExpressionContext)_localctx).code =  evalexpr(((ExpressionContext)_localctx).a.code,(((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null),((ExpressionContext)_localctx).b.code);
						}
						break;
					}
					} 
				}
				setState(129);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		public List<TerminalNode> NEWLINE() { return getTokens(MVaPParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(MVaPParser.NEWLINE, i);
		}
		public FinInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MVaPListener ) ((MVaPListener)listener).enterFinInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MVaPListener ) ((MVaPListener)listener).exitFinInstruction(this);
		}
	}

	public final FinInstructionContext finInstruction() throws RecognitionException {
		FinInstructionContext _localctx = new FinInstructionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_finInstruction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(131); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(130);
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
				setState(133); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3?\u008a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\6\2 \n\2\r\2\16\2!\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\64\n\3\3"+
		"\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\7\fP\n\f\f\f\16\fS\13\f\3\f\3\f\3"+
		"\f\7\fX\n\f\f\f\16\f[\13\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\rf\n"+
		"\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16t\n"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0080\n\16"+
		"\f\16\16\16\u0083\13\16\3\17\6\17\u0086\n\17\r\17\16\17\u0087\3\17\2\3"+
		"\32\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\b\4\2\r-<<\3\2.\66\3\28;"+
		"\3\2\4\5\4\2\3\3\6\6\4\2\t\t??\2\u0089\2\37\3\2\2\2\4\63\3\2\2\2\6\65"+
		"\3\2\2\2\b\67\3\2\2\2\n:\3\2\2\2\f<\3\2\2\2\16@\3\2\2\2\20D\3\2\2\2\22"+
		"F\3\2\2\2\24J\3\2\2\2\26Q\3\2\2\2\30e\3\2\2\2\32s\3\2\2\2\34\u0085\3\2"+
		"\2\2\36 \5\4\3\2\37\36\3\2\2\2 !\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"\3\3"+
		"\2\2\2#$\5\b\5\2$%\7?\2\2%\64\3\2\2\2&\'\5\f\7\2\'(\7?\2\2(\64\3\2\2\2"+
		")*\5\16\b\2*+\7?\2\2+\64\3\2\2\2,-\5\24\13\2-.\7?\2\2.\64\3\2\2\2/\60"+
		"\5\22\n\2\60\61\7?\2\2\61\64\3\2\2\2\62\64\7?\2\2\63#\3\2\2\2\63&\3\2"+
		"\2\2\63)\3\2\2\2\63,\3\2\2\2\63/\3\2\2\2\63\62\3\2\2\2\64\5\3\2\2\2\65"+
		"\66\t\2\2\2\66\7\3\2\2\2\678\5\6\4\289\b\5\1\29\t\3\2\2\2:;\t\3\2\2;\13"+
		"\3\2\2\2<=\5\n\6\2=>\7\13\2\2>?\b\7\1\2?\r\3\2\2\2@A\7\67\2\2AB\7\f\2"+
		"\2BC\b\b\1\2C\17\3\2\2\2DE\t\4\2\2E\21\3\2\2\2FG\5\20\t\2GH\7>\2\2HI\b"+
		"\n\1\2I\23\3\2\2\2JK\7=\2\2KL\7>\2\2LM\b\13\1\2M\25\3\2\2\2NP\7?\2\2O"+
		"N\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2RY\3\2\2\2SQ\3\2\2\2TU\5\30\r\2"+
		"UV\b\f\1\2VX\3\2\2\2WT\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\\\3\2\2"+
		"\2[Y\3\2\2\2\\]\b\f\1\2]\27\3\2\2\2^_\5\32\16\2_`\5\34\17\2`a\b\r\1\2"+
		"af\3\2\2\2bc\5\34\17\2cd\b\r\1\2df\3\2\2\2e^\3\2\2\2eb\3\2\2\2f\31\3\2"+
		"\2\2gh\b\16\1\2hi\7\3\2\2ij\5\32\16\7jk\b\16\1\2kt\3\2\2\2lm\7\7\2\2m"+
		"n\5\32\16\2no\7\b\2\2op\b\16\1\2pt\3\2\2\2qr\7\13\2\2rt\b\16\1\2sg\3\2"+
		"\2\2sl\3\2\2\2sq\3\2\2\2t\u0081\3\2\2\2uv\f\6\2\2vw\t\5\2\2wx\5\32\16"+
		"\7xy\b\16\1\2y\u0080\3\2\2\2z{\f\5\2\2{|\t\6\2\2|}\5\32\16\6}~\b\16\1"+
		"\2~\u0080\3\2\2\2\177u\3\2\2\2\177z\3\2\2\2\u0080\u0083\3\2\2\2\u0081"+
		"\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\33\3\2\2\2\u0083\u0081\3\2\2\2"+
		"\u0084\u0086\t\7\2\2\u0085\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0085"+
		"\3\2\2\2\u0087\u0088\3\2\2\2\u0088\35\3\2\2\2\13!\63QYes\177\u0081\u0087";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}