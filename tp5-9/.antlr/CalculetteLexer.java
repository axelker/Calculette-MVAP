// Generated from /home/axel/Bureau/automate/tp5-9/Calculette.g4 by ANTLR 4.8

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
public class CalculetteLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, TYPE=12, IDENTIFIANT=13, WS=14, ENTIER=15, FLOAT=16, 
		NEWLINE=17, COMMENTARY=18, UNMATCH=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "TYPE", "IDENTIFIANT", "WS", "ENTIER", "FLOAT", "EXPONENT", 
			"NEWLINE", "COMMENTARY", "COMMENTAIRE", "COMMENTAIREETOILE", "UNMATCH"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'write'", "'('", "')'", "'/'", "'*'", "'+'", "'-'", "';'", "'var'", 
			"':'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"TYPE", "IDENTIFIANT", "WS", "ENTIER", "FLOAT", "NEWLINE", "COMMENTARY", 
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


	public CalculetteLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Calculette.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u00bd\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r"+
		"U\n\r\3\16\3\16\7\16Y\n\16\f\16\16\16\\\13\16\3\17\6\17_\n\17\r\17\16"+
		"\17`\3\17\3\17\3\20\6\20f\n\20\r\20\16\20g\3\21\6\21k\n\21\r\21\16\21"+
		"l\3\21\3\21\7\21q\n\21\f\21\16\21t\13\21\3\21\5\21w\n\21\3\21\3\21\6\21"+
		"{\n\21\r\21\16\21|\3\21\5\21\u0080\n\21\3\21\6\21\u0083\n\21\r\21\16\21"+
		"\u0084\3\21\5\21\u0088\n\21\3\22\3\22\5\22\u008c\n\22\3\22\6\22\u008f"+
		"\n\22\r\22\16\22\u0090\3\23\3\23\7\23\u0095\n\23\f\23\16\23\u0098\13\23"+
		"\5\23\u009a\n\23\3\23\5\23\u009d\n\23\3\23\3\23\3\24\3\24\5\24\u00a3\n"+
		"\24\3\25\3\25\7\25\u00a7\n\25\f\25\16\25\u00aa\13\25\3\25\3\25\3\26\3"+
		"\26\3\26\3\26\7\26\u00b2\n\26\f\26\16\26\u00b5\13\26\3\26\3\26\3\26\3"+
		"\27\3\27\3\27\3\27\3\u00b3\2\30\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\2%\23\'\24)\2+\2-\25\3\2\t"+
		"\5\2C\\aac|\6\2\62;C\\aac|\4\2\13\13\"\"\4\2GGgg\4\2--//\4\2\f\f\17\17"+
		"\3\2\f\f\2\u00cd\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2-\3\2\2\2\3/\3\2\2\2\5\65\3\2\2\2\7"+
		"\67\3\2\2\2\t9\3\2\2\2\13;\3\2\2\2\r=\3\2\2\2\17?\3\2\2\2\21A\3\2\2\2"+
		"\23C\3\2\2\2\25G\3\2\2\2\27I\3\2\2\2\31T\3\2\2\2\33V\3\2\2\2\35^\3\2\2"+
		"\2\37e\3\2\2\2!\u0087\3\2\2\2#\u0089\3\2\2\2%\u0099\3\2\2\2\'\u00a2\3"+
		"\2\2\2)\u00a4\3\2\2\2+\u00ad\3\2\2\2-\u00b9\3\2\2\2/\60\7y\2\2\60\61\7"+
		"t\2\2\61\62\7k\2\2\62\63\7v\2\2\63\64\7g\2\2\64\4\3\2\2\2\65\66\7*\2\2"+
		"\66\6\3\2\2\2\678\7+\2\28\b\3\2\2\29:\7\61\2\2:\n\3\2\2\2;<\7,\2\2<\f"+
		"\3\2\2\2=>\7-\2\2>\16\3\2\2\2?@\7/\2\2@\20\3\2\2\2AB\7=\2\2B\22\3\2\2"+
		"\2CD\7x\2\2DE\7c\2\2EF\7t\2\2F\24\3\2\2\2GH\7<\2\2H\26\3\2\2\2IJ\7?\2"+
		"\2J\30\3\2\2\2KL\7k\2\2LM\7p\2\2MU\7v\2\2NO\7f\2\2OP\7q\2\2PQ\7w\2\2Q"+
		"R\7d\2\2RS\7n\2\2SU\7g\2\2TK\3\2\2\2TN\3\2\2\2U\32\3\2\2\2VZ\t\2\2\2W"+
		"Y\t\3\2\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\34\3\2\2\2\\Z\3\2"+
		"\2\2]_\t\4\2\2^]\3\2\2\2_`\3\2\2\2`^\3\2\2\2`a\3\2\2\2ab\3\2\2\2bc\b\17"+
		"\2\2c\36\3\2\2\2df\4\62;\2ed\3\2\2\2fg\3\2\2\2ge\3\2\2\2gh\3\2\2\2h \3"+
		"\2\2\2ik\4\62;\2ji\3\2\2\2kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2mn\3\2\2\2nr\7"+
		"\60\2\2oq\4\62;\2po\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2sv\3\2\2\2tr"+
		"\3\2\2\2uw\5#\22\2vu\3\2\2\2vw\3\2\2\2w\u0088\3\2\2\2xz\7\60\2\2y{\4\62"+
		";\2zy\3\2\2\2{|\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\177\3\2\2\2~\u0080\5#\22"+
		"\2\177~\3\2\2\2\177\u0080\3\2\2\2\u0080\u0088\3\2\2\2\u0081\u0083\4\62"+
		";\2\u0082\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0082\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0088\5#\22\2\u0087j\3\2\2\2"+
		"\u0087x\3\2\2\2\u0087\u0082\3\2\2\2\u0088\"\3\2\2\2\u0089\u008b\t\5\2"+
		"\2\u008a\u008c\t\6\2\2\u008b\u008a\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e"+
		"\3\2\2\2\u008d\u008f\4\62;\2\u008e\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091$\3\2\2\2\u0092\u0096\7%\2\2\u0093"+
		"\u0095\n\7\2\2\u0094\u0093\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2"+
		"\2\2\u0096\u0097\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0099"+
		"\u0092\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009c\3\2\2\2\u009b\u009d\7\17"+
		"\2\2\u009c\u009b\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\3\2\2\2\u009e"+
		"\u009f\7\f\2\2\u009f&\3\2\2\2\u00a0\u00a3\5)\25\2\u00a1\u00a3\5+\26\2"+
		"\u00a2\u00a0\3\2\2\2\u00a2\u00a1\3\2\2\2\u00a3(\3\2\2\2\u00a4\u00a8\7"+
		"\'\2\2\u00a5\u00a7\n\b\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8"+
		"\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa\u00a8\3\2"+
		"\2\2\u00ab\u00ac\7\f\2\2\u00ac*\3\2\2\2\u00ad\u00ae\7\61\2\2\u00ae\u00af"+
		"\7,\2\2\u00af\u00b3\3\2\2\2\u00b0\u00b2\13\2\2\2\u00b1\u00b0\3\2\2\2\u00b2"+
		"\u00b5\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4\u00b6\3\2"+
		"\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b7\7,\2\2\u00b7\u00b8\7\61\2\2\u00b8"+
		",\3\2\2\2\u00b9\u00ba\13\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\b\27\2"+
		"\2\u00bc.\3\2\2\2\26\2TZ`glrv|\177\u0084\u0087\u008b\u0090\u0096\u0099"+
		"\u009c\u00a2\u00a8\u00b3\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}