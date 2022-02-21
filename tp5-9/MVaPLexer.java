// Generated from MVaP.g4 by ANTLR 4.9

    import java.util.HashMap;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MVaPLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "WS", "ENTIER", 
			"FLOAT", "EXPONENT", "ADD", "SUB", "MUL", "DIV", "INF", "INFEQ", "SUP", 
			"SUPEQ", "EQUAL", "NEQ", "FADD", "FSUB", "FMUL", "FDIV", "FINF", "FINFEQ", 
			"FSUP", "FSUPEQ", "FEQUAL", "FNEQ", "ITOF", "FTOI", "RETURN", "POP", 
			"POPF", "READ", "READF", "WRITE", "WRITEF", "PADD", "PUSHGP", "PUSHFP", 
			"DUP", "PUSHI", "PUSHG", "STOREG", "PUSHL", "STOREL", "PUSHR", "STORER", 
			"FREE", "ALLOC", "PUSHF", "CALL", "JUMP", "JUMPF", "JUMPI", "HALT", "LABEL", 
			"IDENTIFIANT", "NEWLINE"
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


	public MVaPLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MVaP.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2?\u01e9\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3"+
		"\t\6\t\u008f\n\t\r\t\16\t\u0090\3\t\3\t\3\n\5\n\u0096\n\n\3\n\6\n\u0099"+
		"\n\n\r\n\16\n\u009a\3\13\6\13\u009e\n\13\r\13\16\13\u009f\3\13\3\13\7"+
		"\13\u00a4\n\13\f\13\16\13\u00a7\13\13\3\13\5\13\u00aa\n\13\3\13\3\13\6"+
		"\13\u00ae\n\13\r\13\16\13\u00af\3\13\5\13\u00b3\n\13\3\13\6\13\u00b6\n"+
		"\13\r\13\16\13\u00b7\3\13\5\13\u00bb\n\13\3\f\3\f\5\f\u00bf\n\f\3\f\6"+
		"\f\u00c2\n\f\r\f\16\f\u00c3\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3"+
		"\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3"+
		"\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3"+
		"\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3"+
		"#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3"+
		"*\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3.\3.\3.\3.\3"+
		".\3.\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3"+
		"\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3"+
		"\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3"+
		"\65\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\38\38"+
		"\38\38\38\39\39\39\39\39\39\3:\3:\3:\3:\3:\3:\3;\3;\3;\3;\3;\3;\3<\3<"+
		"\3<\3<\3<\3=\3=\3=\3=\3=\3=\3>\3>\7>\u01d7\n>\f>\16>\u01da\13>\3?\3?\7"+
		"?\u01de\n?\f?\16?\u01e1\13?\5?\u01e3\n?\3?\5?\u01e6\n?\3?\3?\2\2@\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\2\31\r\33\16\35\17\37\20"+
		"!\21#\22%\23\'\24)\25+\26-\27/\30\61\31\63\32\65\33\67\349\35;\36=\37"+
		"? A!C\"E#G$I%K&M\'O(Q)S*U+W,Y-[.]/_\60a\61c\62e\63g\64i\65k\66m\67o8q"+
		"9s:u;w<y={>}?\3\2\b\4\2\13\13\"\"\4\2--//\4\2GGgg\5\2C\\aac|\6\2\62;C"+
		"\\aac|\4\2\f\f\17\17\2\u01f8\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3"+
		"\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2"+
		"\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2"+
		"_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3"+
		"\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2"+
		"\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\3\177\3\2\2\2\5\u0081\3\2\2\2\7\u0083"+
		"\3\2\2\2\t\u0085\3\2\2\2\13\u0087\3\2\2\2\r\u0089\3\2\2\2\17\u008b\3\2"+
		"\2\2\21\u008e\3\2\2\2\23\u0095\3\2\2\2\25\u00ba\3\2\2\2\27\u00bc\3\2\2"+
		"\2\31\u00c5\3\2\2\2\33\u00c9\3\2\2\2\35\u00cd\3\2\2\2\37\u00d1\3\2\2\2"+
		"!\u00d5\3\2\2\2#\u00d9\3\2\2\2%\u00df\3\2\2\2\'\u00e3\3\2\2\2)\u00e9\3"+
		"\2\2\2+\u00ef\3\2\2\2-\u00f3\3\2\2\2/\u00f8\3\2\2\2\61\u00fd\3\2\2\2\63"+
		"\u0102\3\2\2\2\65\u0107\3\2\2\2\67\u010c\3\2\2\29\u0113\3\2\2\2;\u0118"+
		"\3\2\2\2=\u011f\3\2\2\2?\u0126\3\2\2\2A\u012b\3\2\2\2C\u0130\3\2\2\2E"+
		"\u0135\3\2\2\2G\u013c\3\2\2\2I\u0140\3\2\2\2K\u0145\3\2\2\2M\u014a\3\2"+
		"\2\2O\u0150\3\2\2\2Q\u0156\3\2\2\2S\u015d\3\2\2\2U\u0162\3\2\2\2W\u0169"+
		"\3\2\2\2Y\u0170\3\2\2\2[\u0174\3\2\2\2]\u017a\3\2\2\2_\u0180\3\2\2\2a"+
		"\u0187\3\2\2\2c\u018d\3\2\2\2e\u0194\3\2\2\2g\u019a\3\2\2\2i\u01a1\3\2"+
		"\2\2k\u01a6\3\2\2\2m\u01ac\3\2\2\2o\u01b2\3\2\2\2q\u01b7\3\2\2\2s\u01bd"+
		"\3\2\2\2u\u01c3\3\2\2\2w\u01c9\3\2\2\2y\u01ce\3\2\2\2{\u01d4\3\2\2\2}"+
		"\u01e2\3\2\2\2\177\u0080\7/\2\2\u0080\4\3\2\2\2\u0081\u0082\7\61\2\2\u0082"+
		"\6\3\2\2\2\u0083\u0084\7,\2\2\u0084\b\3\2\2\2\u0085\u0086\7-\2\2\u0086"+
		"\n\3\2\2\2\u0087\u0088\7*\2\2\u0088\f\3\2\2\2\u0089\u008a\7+\2\2\u008a"+
		"\16\3\2\2\2\u008b\u008c\7=\2\2\u008c\20\3\2\2\2\u008d\u008f\t\2\2\2\u008e"+
		"\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2"+
		"\2\2\u0091\u0092\3\2\2\2\u0092\u0093\b\t\2\2\u0093\22\3\2\2\2\u0094\u0096"+
		"\t\3\2\2\u0095\u0094\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0098\3\2\2\2\u0097"+
		"\u0099\4\62;\2\u0098\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u0098\3\2"+
		"\2\2\u009a\u009b\3\2\2\2\u009b\24\3\2\2\2\u009c\u009e\4\62;\2\u009d\u009c"+
		"\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\u00a5\7\60\2\2\u00a2\u00a4\4\62;\2\u00a3\u00a2\3"+
		"\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6"+
		"\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00aa\5\27\f\2\u00a9\u00a8\3"+
		"\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00bb\3\2\2\2\u00ab\u00ad\7\60\2\2\u00ac"+
		"\u00ae\4\62;\2\u00ad\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00ad\3\2"+
		"\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b2\3\2\2\2\u00b1\u00b3\5\27\f\2\u00b2"+
		"\u00b1\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00bb\3\2\2\2\u00b4\u00b6\4\62"+
		";\2\u00b5\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7"+
		"\u00b8\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bb\5\27\f\2\u00ba\u009d\3"+
		"\2\2\2\u00ba\u00ab\3\2\2\2\u00ba\u00b5\3\2\2\2\u00bb\26\3\2\2\2\u00bc"+
		"\u00be\t\4\2\2\u00bd\u00bf\t\3\2\2\u00be\u00bd\3\2\2\2\u00be\u00bf\3\2"+
		"\2\2\u00bf\u00c1\3\2\2\2\u00c0\u00c2\4\62;\2\u00c1\u00c0\3\2\2\2\u00c2"+
		"\u00c3\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\30\3\2\2"+
		"\2\u00c5\u00c6\7C\2\2\u00c6\u00c7\7F\2\2\u00c7\u00c8\7F\2\2\u00c8\32\3"+
		"\2\2\2\u00c9\u00ca\7U\2\2\u00ca\u00cb\7W\2\2\u00cb\u00cc\7D\2\2\u00cc"+
		"\34\3\2\2\2\u00cd\u00ce\7O\2\2\u00ce\u00cf\7W\2\2\u00cf\u00d0\7N\2\2\u00d0"+
		"\36\3\2\2\2\u00d1\u00d2\7F\2\2\u00d2\u00d3\7K\2\2\u00d3\u00d4\7X\2\2\u00d4"+
		" \3\2\2\2\u00d5\u00d6\7K\2\2\u00d6\u00d7\7P\2\2\u00d7\u00d8\7H\2\2\u00d8"+
		"\"\3\2\2\2\u00d9\u00da\7K\2\2\u00da\u00db\7P\2\2\u00db\u00dc\7H\2\2\u00dc"+
		"\u00dd\7G\2\2\u00dd\u00de\7S\2\2\u00de$\3\2\2\2\u00df\u00e0\7U\2\2\u00e0"+
		"\u00e1\7W\2\2\u00e1\u00e2\7R\2\2\u00e2&\3\2\2\2\u00e3\u00e4\7U\2\2\u00e4"+
		"\u00e5\7W\2\2\u00e5\u00e6\7R\2\2\u00e6\u00e7\7G\2\2\u00e7\u00e8\7S\2\2"+
		"\u00e8(\3\2\2\2\u00e9\u00ea\7G\2\2\u00ea\u00eb\7S\2\2\u00eb\u00ec\7W\2"+
		"\2\u00ec\u00ed\7C\2\2\u00ed\u00ee\7N\2\2\u00ee*\3\2\2\2\u00ef\u00f0\7"+
		"P\2\2\u00f0\u00f1\7G\2\2\u00f1\u00f2\7S\2\2\u00f2,\3\2\2\2\u00f3\u00f4"+
		"\7H\2\2\u00f4\u00f5\7C\2\2\u00f5\u00f6\7F\2\2\u00f6\u00f7\7F\2\2\u00f7"+
		".\3\2\2\2\u00f8\u00f9\7H\2\2\u00f9\u00fa\7U\2\2\u00fa\u00fb\7W\2\2\u00fb"+
		"\u00fc\7D\2\2\u00fc\60\3\2\2\2\u00fd\u00fe\7H\2\2\u00fe\u00ff\7O\2\2\u00ff"+
		"\u0100\7W\2\2\u0100\u0101\7N\2\2\u0101\62\3\2\2\2\u0102\u0103\7H\2\2\u0103"+
		"\u0104\7F\2\2\u0104\u0105\7K\2\2\u0105\u0106\7X\2\2\u0106\64\3\2\2\2\u0107"+
		"\u0108\7H\2\2\u0108\u0109\7K\2\2\u0109\u010a\7P\2\2\u010a\u010b\7H\2\2"+
		"\u010b\66\3\2\2\2\u010c\u010d\7H\2\2\u010d\u010e\7K\2\2\u010e\u010f\7"+
		"P\2\2\u010f\u0110\7H\2\2\u0110\u0111\7G\2\2\u0111\u0112\7S\2\2\u01128"+
		"\3\2\2\2\u0113\u0114\7H\2\2\u0114\u0115\7U\2\2\u0115\u0116\7W\2\2\u0116"+
		"\u0117\7R\2\2\u0117:\3\2\2\2\u0118\u0119\7H\2\2\u0119\u011a\7U\2\2\u011a"+
		"\u011b\7W\2\2\u011b\u011c\7R\2\2\u011c\u011d\7G\2\2\u011d\u011e\7S\2\2"+
		"\u011e<\3\2\2\2\u011f\u0120\7H\2\2\u0120\u0121\7G\2\2\u0121\u0122\7S\2"+
		"\2\u0122\u0123\7W\2\2\u0123\u0124\7C\2\2\u0124\u0125\7N\2\2\u0125>\3\2"+
		"\2\2\u0126\u0127\7H\2\2\u0127\u0128\7P\2\2\u0128\u0129\7G\2\2\u0129\u012a"+
		"\7S\2\2\u012a@\3\2\2\2\u012b\u012c\7K\2\2\u012c\u012d\7V\2\2\u012d\u012e"+
		"\7Q\2\2\u012e\u012f\7H\2\2\u012fB\3\2\2\2\u0130\u0131\7H\2\2\u0131\u0132"+
		"\7V\2\2\u0132\u0133\7Q\2\2\u0133\u0134\7K\2\2\u0134D\3\2\2\2\u0135\u0136"+
		"\7T\2\2\u0136\u0137\7G\2\2\u0137\u0138\7V\2\2\u0138\u0139\7W\2\2\u0139"+
		"\u013a\7T\2\2\u013a\u013b\7P\2\2\u013bF\3\2\2\2\u013c\u013d\7R\2\2\u013d"+
		"\u013e\7Q\2\2\u013e\u013f\7R\2\2\u013fH\3\2\2\2\u0140\u0141\7R\2\2\u0141"+
		"\u0142\7Q\2\2\u0142\u0143\7R\2\2\u0143\u0144\7H\2\2\u0144J\3\2\2\2\u0145"+
		"\u0146\7T\2\2\u0146\u0147\7G\2\2\u0147\u0148\7C\2\2\u0148\u0149\7F\2\2"+
		"\u0149L\3\2\2\2\u014a\u014b\7T\2\2\u014b\u014c\7G\2\2\u014c\u014d\7C\2"+
		"\2\u014d\u014e\7F\2\2\u014e\u014f\7H\2\2\u014fN\3\2\2\2\u0150\u0151\7"+
		"Y\2\2\u0151\u0152\7T\2\2\u0152\u0153\7K\2\2\u0153\u0154\7V\2\2\u0154\u0155"+
		"\7G\2\2\u0155P\3\2\2\2\u0156\u0157\7Y\2\2\u0157\u0158\7T\2\2\u0158\u0159"+
		"\7K\2\2\u0159\u015a\7V\2\2\u015a\u015b\7G\2\2\u015b\u015c\7H\2\2\u015c"+
		"R\3\2\2\2\u015d\u015e\7R\2\2\u015e\u015f\7C\2\2\u015f\u0160\7F\2\2\u0160"+
		"\u0161\7F\2\2\u0161T\3\2\2\2\u0162\u0163\7R\2\2\u0163\u0164\7W\2\2\u0164"+
		"\u0165\7U\2\2\u0165\u0166\7J\2\2\u0166\u0167\7I\2\2\u0167\u0168\7R\2\2"+
		"\u0168V\3\2\2\2\u0169\u016a\7R\2\2\u016a\u016b\7W\2\2\u016b\u016c\7U\2"+
		"\2\u016c\u016d\7J\2\2\u016d\u016e\7H\2\2\u016e\u016f\7R\2\2\u016fX\3\2"+
		"\2\2\u0170\u0171\7F\2\2\u0171\u0172\7W\2\2\u0172\u0173\7R\2\2\u0173Z\3"+
		"\2\2\2\u0174\u0175\7R\2\2\u0175\u0176\7W\2\2\u0176\u0177\7U\2\2\u0177"+
		"\u0178\7J\2\2\u0178\u0179\7K\2\2\u0179\\\3\2\2\2\u017a\u017b\7R\2\2\u017b"+
		"\u017c\7W\2\2\u017c\u017d\7U\2\2\u017d\u017e\7J\2\2\u017e\u017f\7I\2\2"+
		"\u017f^\3\2\2\2\u0180\u0181\7U\2\2\u0181\u0182\7V\2\2\u0182\u0183\7Q\2"+
		"\2\u0183\u0184\7T\2\2\u0184\u0185\7G\2\2\u0185\u0186\7I\2\2\u0186`\3\2"+
		"\2\2\u0187\u0188\7R\2\2\u0188\u0189\7W\2\2\u0189\u018a\7U\2\2\u018a\u018b"+
		"\7J\2\2\u018b\u018c\7N\2\2\u018cb\3\2\2\2\u018d\u018e\7U\2\2\u018e\u018f"+
		"\7V\2\2\u018f\u0190\7Q\2\2\u0190\u0191\7T\2\2\u0191\u0192\7G\2\2\u0192"+
		"\u0193\7N\2\2\u0193d\3\2\2\2\u0194\u0195\7R\2\2\u0195\u0196\7W\2\2\u0196"+
		"\u0197\7U\2\2\u0197\u0198\7J\2\2\u0198\u0199\7T\2\2\u0199f\3\2\2\2\u019a"+
		"\u019b\7U\2\2\u019b\u019c\7V\2\2\u019c\u019d\7Q\2\2\u019d\u019e\7T\2\2"+
		"\u019e\u019f\7G\2\2\u019f\u01a0\7T\2\2\u01a0h\3\2\2\2\u01a1\u01a2\7H\2"+
		"\2\u01a2\u01a3\7T\2\2\u01a3\u01a4\7G\2\2\u01a4\u01a5\7G\2\2\u01a5j\3\2"+
		"\2\2\u01a6\u01a7\7C\2\2\u01a7\u01a8\7N\2\2\u01a8\u01a9\7N\2\2\u01a9\u01aa"+
		"\7Q\2\2\u01aa\u01ab\7E\2\2\u01abl\3\2\2\2\u01ac\u01ad\7R\2\2\u01ad\u01ae"+
		"\7W\2\2\u01ae\u01af\7U\2\2\u01af\u01b0\7J\2\2\u01b0\u01b1\7H\2\2\u01b1"+
		"n\3\2\2\2\u01b2\u01b3\7E\2\2\u01b3\u01b4\7C\2\2\u01b4\u01b5\7N\2\2\u01b5"+
		"\u01b6\7N\2\2\u01b6p\3\2\2\2\u01b7\u01b8\7L\2\2\u01b8\u01b9\7W\2\2\u01b9"+
		"\u01ba\7O\2\2\u01ba\u01bb\7R\2\2\u01bb\u01bc\7\"\2\2\u01bcr\3\2\2\2\u01bd"+
		"\u01be\7L\2\2\u01be\u01bf\7W\2\2\u01bf\u01c0\7O\2\2\u01c0\u01c1\7R\2\2"+
		"\u01c1\u01c2\7H\2\2\u01c2t\3\2\2\2\u01c3\u01c4\7L\2\2\u01c4\u01c5\7W\2"+
		"\2\u01c5\u01c6\7O\2\2\u01c6\u01c7\7R\2\2\u01c7\u01c8\7K\2\2\u01c8v\3\2"+
		"\2\2\u01c9\u01ca\7J\2\2\u01ca\u01cb\7C\2\2\u01cb\u01cc\7N\2\2\u01cc\u01cd"+
		"\7V\2\2\u01cdx\3\2\2\2\u01ce\u01cf\7N\2\2\u01cf\u01d0\7C\2\2\u01d0\u01d1"+
		"\7D\2\2\u01d1\u01d2\7G\2\2\u01d2\u01d3\7N\2\2\u01d3z\3\2\2\2\u01d4\u01d8"+
		"\t\5\2\2\u01d5\u01d7\t\6\2\2\u01d6\u01d5\3\2\2\2\u01d7\u01da\3\2\2\2\u01d8"+
		"\u01d6\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9|\3\2\2\2\u01da\u01d8\3\2\2\2"+
		"\u01db\u01df\7%\2\2\u01dc\u01de\n\7\2\2\u01dd\u01dc\3\2\2\2\u01de\u01e1"+
		"\3\2\2\2\u01df\u01dd\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0\u01e3\3\2\2\2\u01e1"+
		"\u01df\3\2\2\2\u01e2\u01db\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e5\3\2"+
		"\2\2\u01e4\u01e6\7\17\2\2\u01e5\u01e4\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6"+
		"\u01e7\3\2\2\2\u01e7\u01e8\7\f\2\2\u01e8~\3\2\2\2\23\2\u0090\u0095\u009a"+
		"\u009f\u00a5\u00a9\u00af\u00b2\u00b7\u00ba\u00be\u00c3\u01d8\u01df\u01e2"+
		"\u01e5\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}