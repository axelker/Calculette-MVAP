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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, TYPE=19, IDENTIFIANT=20, CONDITION=21, WS=22, ENTIER=23, FLOAT=24, 
		NEWLINE=25, COMMENTARY=26, OPERATION=27, UNMATCH=28;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "TYPE", "IDENTIFIANT", "CONDITION", "WS", "ENTIER", "FLOAT", 
			"EXPONENT", "NEWLINE", "COMMENTARY", "COMMENTAIRE", "COMMENTAIREETOILE", 
			"OPERATION", "UNMATCH"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\36\u00f0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3"+
		"\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\5\24\u0084\n\24\3\25\3\25\7\25\u0088\n\25\f\25"+
		"\16\25\u008b\13\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0096"+
		"\n\26\3\27\6\27\u0099\n\27\r\27\16\27\u009a\3\27\3\27\3\30\6\30\u00a0"+
		"\n\30\r\30\16\30\u00a1\3\31\6\31\u00a5\n\31\r\31\16\31\u00a6\3\31\3\31"+
		"\7\31\u00ab\n\31\f\31\16\31\u00ae\13\31\3\31\5\31\u00b1\n\31\3\31\3\31"+
		"\6\31\u00b5\n\31\r\31\16\31\u00b6\3\31\5\31\u00ba\n\31\3\31\6\31\u00bd"+
		"\n\31\r\31\16\31\u00be\3\31\5\31\u00c2\n\31\3\32\3\32\5\32\u00c6\n\32"+
		"\3\32\6\32\u00c9\n\32\r\32\16\32\u00ca\3\33\5\33\u00ce\n\33\3\33\3\33"+
		"\3\34\3\34\5\34\u00d4\n\34\3\34\3\34\3\35\3\35\7\35\u00da\n\35\f\35\16"+
		"\35\u00dd\13\35\3\36\3\36\3\36\3\36\7\36\u00e3\n\36\f\36\16\36\u00e6\13"+
		"\36\3\36\3\36\3\36\3\37\3\37\3 \3 \3 \3 \3\u00e4\2!\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\2\65\33\67\349\2;\2=\35?\36\3\2\n\5\2C\\"+
		"aac|\6\2\62;C\\aac|\4\2>>@@\4\2\13\13\"\"\4\2GGgg\4\2--//\3\2\f\f\5\2"+
		",-//\61\61\2\u0102\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2=\3\2\2\2\2"+
		"?\3\2\2\2\3A\3\2\2\2\5F\3\2\2\2\7H\3\2\2\2\tJ\3\2\2\2\13P\3\2\2\2\rR\3"+
		"\2\2\2\17T\3\2\2\2\21V\3\2\2\2\23X\3\2\2\2\25Z\3\2\2\2\27^\3\2\2\2\31"+
		"`\3\2\2\2\33b\3\2\2\2\35e\3\2\2\2\37j\3\2\2\2!p\3\2\2\2#r\3\2\2\2%t\3"+
		"\2\2\2\'\u0083\3\2\2\2)\u0085\3\2\2\2+\u0095\3\2\2\2-\u0098\3\2\2\2/\u009f"+
		"\3\2\2\2\61\u00c1\3\2\2\2\63\u00c3\3\2\2\2\65\u00cd\3\2\2\2\67\u00d3\3"+
		"\2\2\29\u00d7\3\2\2\2;\u00de\3\2\2\2=\u00ea\3\2\2\2?\u00ec\3\2\2\2AB\7"+
		"t\2\2BC\7g\2\2CD\7c\2\2DE\7f\2\2E\4\3\2\2\2FG\7*\2\2G\6\3\2\2\2HI\7+\2"+
		"\2I\b\3\2\2\2JK\7y\2\2KL\7t\2\2LM\7k\2\2MN\7v\2\2NO\7g\2\2O\n\3\2\2\2"+
		"PQ\7\61\2\2Q\f\3\2\2\2RS\7,\2\2S\16\3\2\2\2TU\7-\2\2U\20\3\2\2\2VW\7/"+
		"\2\2W\22\3\2\2\2XY\7=\2\2Y\24\3\2\2\2Z[\7x\2\2[\\\7c\2\2\\]\7t\2\2]\26"+
		"\3\2\2\2^_\7<\2\2_\30\3\2\2\2`a\7?\2\2a\32\3\2\2\2bc\7-\2\2cd\7?\2\2d"+
		"\34\3\2\2\2ef\7v\2\2fg\7t\2\2gh\7w\2\2hi\7g\2\2i\36\3\2\2\2jk\7h\2\2k"+
		"l\7c\2\2lm\7n\2\2mn\7u\2\2no\7g\2\2o \3\2\2\2pq\7}\2\2q\"\3\2\2\2rs\7"+
		"\177\2\2s$\3\2\2\2tu\7y\2\2uv\7j\2\2vw\7k\2\2wx\7n\2\2xy\7g\2\2y&\3\2"+
		"\2\2z{\7k\2\2{|\7p\2\2|\u0084\7v\2\2}~\7f\2\2~\177\7q\2\2\177\u0080\7"+
		"w\2\2\u0080\u0081\7d\2\2\u0081\u0082\7n\2\2\u0082\u0084\7g\2\2\u0083z"+
		"\3\2\2\2\u0083}\3\2\2\2\u0084(\3\2\2\2\u0085\u0089\t\2\2\2\u0086\u0088"+
		"\t\3\2\2\u0087\u0086\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089"+
		"\u008a\3\2\2\2\u008a*\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008d\7#\2\2\u008d"+
		"\u0096\7?\2\2\u008e\u008f\7>\2\2\u008f\u0096\7@\2\2\u0090\u0096\t\4\2"+
		"\2\u0091\u0092\7>\2\2\u0092\u0096\7?\2\2\u0093\u0094\7@\2\2\u0094\u0096"+
		"\7?\2\2\u0095\u008c\3\2\2\2\u0095\u008e\3\2\2\2\u0095\u0090\3\2\2\2\u0095"+
		"\u0091\3\2\2\2\u0095\u0093\3\2\2\2\u0096,\3\2\2\2\u0097\u0099\t\5\2\2"+
		"\u0098\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b"+
		"\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d\b\27\2\2\u009d.\3\2\2\2\u009e"+
		"\u00a0\4\62;\2\u009f\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u009f\3\2"+
		"\2\2\u00a1\u00a2\3\2\2\2\u00a2\60\3\2\2\2\u00a3\u00a5\4\62;\2\u00a4\u00a3"+
		"\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\u00ac\7\60\2\2\u00a9\u00ab\4\62;\2\u00aa\u00a9\3"+
		"\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"+
		"\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b1\5\63\32\2\u00b0\u00af\3"+
		"\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00c2\3\2\2\2\u00b2\u00b4\7\60\2\2\u00b3"+
		"\u00b5\4\62;\2\u00b4\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b4\3\2"+
		"\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00ba\5\63\32\2\u00b9"+
		"\u00b8\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00c2\3\2\2\2\u00bb\u00bd\4\62"+
		";\2\u00bc\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bc\3\2\2\2\u00be"+
		"\u00bf\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c2\5\63\32\2\u00c1\u00a4\3"+
		"\2\2\2\u00c1\u00b2\3\2\2\2\u00c1\u00bc\3\2\2\2\u00c2\62\3\2\2\2\u00c3"+
		"\u00c5\t\6\2\2\u00c4\u00c6\t\7\2\2\u00c5\u00c4\3\2\2\2\u00c5\u00c6\3\2"+
		"\2\2\u00c6\u00c8\3\2\2\2\u00c7\u00c9\4\62;\2\u00c8\u00c7\3\2\2\2\u00c9"+
		"\u00ca\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\64\3\2\2"+
		"\2\u00cc\u00ce\7\17\2\2\u00cd\u00cc\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce"+
		"\u00cf\3\2\2\2\u00cf\u00d0\7\f\2\2\u00d0\66\3\2\2\2\u00d1\u00d4\59\35"+
		"\2\u00d2\u00d4\5;\36\2\u00d3\u00d1\3\2\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00d5"+
		"\3\2\2\2\u00d5\u00d6\b\34\2\2\u00d68\3\2\2\2\u00d7\u00db\7\'\2\2\u00d8"+
		"\u00da\n\b\2\2\u00d9\u00d8\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2"+
		"\2\2\u00db\u00dc\3\2\2\2\u00dc:\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00df"+
		"\7\61\2\2\u00df\u00e0\7,\2\2\u00e0\u00e4\3\2\2\2\u00e1\u00e3\13\2\2\2"+
		"\u00e2\u00e1\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e4\u00e2"+
		"\3\2\2\2\u00e5\u00e7\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00e8\7,\2\2\u00e8"+
		"\u00e9\7\61\2\2\u00e9<\3\2\2\2\u00ea\u00eb\t\t\2\2\u00eb>\3\2\2\2\u00ec"+
		"\u00ed\13\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\b \2\2\u00ef@\3\2\2\2"+
		"\25\2\u0083\u0089\u0095\u009a\u00a1\u00a6\u00ac\u00b0\u00b6\u00b9\u00be"+
		"\u00c1\u00c5\u00ca\u00cd\u00d3\u00db\u00e4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}