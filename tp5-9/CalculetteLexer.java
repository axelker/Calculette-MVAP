// Generated from Calculette.g4 by ANTLR 4.9

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
			"T__17", "T__18", "T__19", "T__20", "TYPE", "BOOL", "IDENTIFIANT", "CONDITION", 
			"WS", "ENTIER", "FLOAT", "EXPONENT", "NEWLINE", "COMMENTARY", "COMMENTAIRE", 
			"COMMENTAIREETOILE", "OPERATION", "OPLOGIQUE", "NEGLOGIQUE", "UNMATCH"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u011f\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u009e\n\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u00a9\n\30\3\31\3\31"+
		"\7\31\u00ad\n\31\f\31\16\31\u00b0\13\31\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\5\32\u00bd\n\32\3\33\6\33\u00c0\n\33\r\33\16"+
		"\33\u00c1\3\33\3\33\3\34\6\34\u00c7\n\34\r\34\16\34\u00c8\3\35\6\35\u00cc"+
		"\n\35\r\35\16\35\u00cd\3\35\3\35\7\35\u00d2\n\35\f\35\16\35\u00d5\13\35"+
		"\3\35\5\35\u00d8\n\35\3\35\3\35\6\35\u00dc\n\35\r\35\16\35\u00dd\3\35"+
		"\5\35\u00e1\n\35\3\35\6\35\u00e4\n\35\r\35\16\35\u00e5\3\35\5\35\u00e9"+
		"\n\35\3\36\3\36\5\36\u00ed\n\36\3\36\6\36\u00f0\n\36\r\36\16\36\u00f1"+
		"\3\37\5\37\u00f5\n\37\3\37\3\37\3 \3 \5 \u00fb\n \3 \3 \3!\3!\7!\u0101"+
		"\n!\f!\16!\u0104\13!\3\"\3\"\3\"\3\"\7\"\u010a\n\"\f\"\16\"\u010d\13\""+
		"\3\"\3\"\3\"\3#\3#\3$\3$\3$\3$\5$\u0118\n$\3%\3%\3&\3&\3&\3&\3\u010b\2"+
		"\'\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\2"+
		"=\37? A\2C\2E!G\"I#K$\3\2\n\5\2C\\aac|\6\2\62;C\\aac|\4\2>>@@\4\2\13\13"+
		"\"\"\4\2GGgg\4\2--//\3\2\f\f\5\2,-//\61\61\2\u0134\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2E\3"+
		"\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\3M\3\2\2\2\5R\3\2\2\2\7T\3\2\2"+
		"\2\tV\3\2\2\2\13\\\3\2\2\2\r^\3\2\2\2\17`\3\2\2\2\21b\3\2\2\2\23d\3\2"+
		"\2\2\25f\3\2\2\2\27j\3\2\2\2\31l\3\2\2\2\33n\3\2\2\2\35q\3\2\2\2\37s\3"+
		"\2\2\2!u\3\2\2\2#{\3\2\2\2%\177\3\2\2\2\'\u0086\3\2\2\2)\u008c\3\2\2\2"+
		"+\u008f\3\2\2\2-\u009d\3\2\2\2/\u00a8\3\2\2\2\61\u00aa\3\2\2\2\63\u00bc"+
		"\3\2\2\2\65\u00bf\3\2\2\2\67\u00c6\3\2\2\29\u00e8\3\2\2\2;\u00ea\3\2\2"+
		"\2=\u00f4\3\2\2\2?\u00fa\3\2\2\2A\u00fe\3\2\2\2C\u0105\3\2\2\2E\u0111"+
		"\3\2\2\2G\u0117\3\2\2\2I\u0119\3\2\2\2K\u011b\3\2\2\2MN\7t\2\2NO\7g\2"+
		"\2OP\7c\2\2PQ\7f\2\2Q\4\3\2\2\2RS\7*\2\2S\6\3\2\2\2TU\7+\2\2U\b\3\2\2"+
		"\2VW\7y\2\2WX\7t\2\2XY\7k\2\2YZ\7v\2\2Z[\7g\2\2[\n\3\2\2\2\\]\7\61\2\2"+
		"]\f\3\2\2\2^_\7,\2\2_\16\3\2\2\2`a\7-\2\2a\20\3\2\2\2bc\7/\2\2c\22\3\2"+
		"\2\2de\7=\2\2e\24\3\2\2\2fg\7x\2\2gh\7c\2\2hi\7t\2\2i\26\3\2\2\2jk\7<"+
		"\2\2k\30\3\2\2\2lm\7?\2\2m\32\3\2\2\2no\7-\2\2op\7?\2\2p\34\3\2\2\2qr"+
		"\7}\2\2r\36\3\2\2\2st\7\177\2\2t \3\2\2\2uv\7y\2\2vw\7j\2\2wx\7k\2\2x"+
		"y\7n\2\2yz\7g\2\2z\"\3\2\2\2{|\7h\2\2|}\7q\2\2}~\7t\2\2~$\3\2\2\2\177"+
		"\u0080\7t\2\2\u0080\u0081\7g\2\2\u0081\u0082\7r\2\2\u0082\u0083\7g\2\2"+
		"\u0083\u0084\7c\2\2\u0084\u0085\7v\2\2\u0085&\3\2\2\2\u0086\u0087\7w\2"+
		"\2\u0087\u0088\7p\2\2\u0088\u0089\7v\2\2\u0089\u008a\7k\2\2\u008a\u008b"+
		"\7n\2\2\u008b(\3\2\2\2\u008c\u008d\7k\2\2\u008d\u008e\7h\2\2\u008e*\3"+
		"\2\2\2\u008f\u0090\7g\2\2\u0090\u0091\7n\2\2\u0091\u0092\7u\2\2\u0092"+
		"\u0093\7g\2\2\u0093,\3\2\2\2\u0094\u0095\7k\2\2\u0095\u0096\7p\2\2\u0096"+
		"\u009e\7v\2\2\u0097\u0098\7f\2\2\u0098\u0099\7q\2\2\u0099\u009a\7w\2\2"+
		"\u009a\u009b\7d\2\2\u009b\u009c\7n\2\2\u009c\u009e\7g\2\2\u009d\u0094"+
		"\3\2\2\2\u009d\u0097\3\2\2\2\u009e.\3\2\2\2\u009f\u00a0\7v\2\2\u00a0\u00a1"+
		"\7t\2\2\u00a1\u00a2\7w\2\2\u00a2\u00a9\7g\2\2\u00a3\u00a4\7h\2\2\u00a4"+
		"\u00a5\7c\2\2\u00a5\u00a6\7n\2\2\u00a6\u00a7\7u\2\2\u00a7\u00a9\7g\2\2"+
		"\u00a8\u009f\3\2\2\2\u00a8\u00a3\3\2\2\2\u00a9\60\3\2\2\2\u00aa\u00ae"+
		"\t\2\2\2\u00ab\u00ad\t\3\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae"+
		"\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\62\3\2\2\2\u00b0\u00ae\3\2\2"+
		"\2\u00b1\u00b2\7#\2\2\u00b2\u00bd\7?\2\2\u00b3\u00b4\7>\2\2\u00b4\u00bd"+
		"\7@\2\2\u00b5\u00bd\t\4\2\2\u00b6\u00b7\7>\2\2\u00b7\u00bd\7?\2\2\u00b8"+
		"\u00b9\7@\2\2\u00b9\u00bd\7?\2\2\u00ba\u00bb\7?\2\2\u00bb\u00bd\7?\2\2"+
		"\u00bc\u00b1\3\2\2\2\u00bc\u00b3\3\2\2\2\u00bc\u00b5\3\2\2\2\u00bc\u00b6"+
		"\3\2\2\2\u00bc\u00b8\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\64\3\2\2\2\u00be"+
		"\u00c0\t\5\2\2\u00bf\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00bf\3\2"+
		"\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\b\33\2\2\u00c4"+
		"\66\3\2\2\2\u00c5\u00c7\4\62;\2\u00c6\u00c5\3\2\2\2\u00c7\u00c8\3\2\2"+
		"\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c98\3\2\2\2\u00ca\u00cc"+
		"\4\62;\2\u00cb\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd"+
		"\u00ce\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d3\7\60\2\2\u00d0\u00d2\4"+
		"\62;\2\u00d1\u00d0\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3"+
		"\u00d4\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d8\5;"+
		"\36\2\u00d7\u00d6\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00e9\3\2\2\2\u00d9"+
		"\u00db\7\60\2\2\u00da\u00dc\4\62;\2\u00db\u00da\3\2\2\2\u00dc\u00dd\3"+
		"\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00e0\3\2\2\2\u00df"+
		"\u00e1\5;\36\2\u00e0\u00df\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e9\3\2"+
		"\2\2\u00e2\u00e4\4\62;\2\u00e3\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5"+
		"\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e9\5;"+
		"\36\2\u00e8\u00cb\3\2\2\2\u00e8\u00d9\3\2\2\2\u00e8\u00e3\3\2\2\2\u00e9"+
		":\3\2\2\2\u00ea\u00ec\t\6\2\2\u00eb\u00ed\t\7\2\2\u00ec\u00eb\3\2\2\2"+
		"\u00ec\u00ed\3\2\2\2\u00ed\u00ef\3\2\2\2\u00ee\u00f0\4\62;\2\u00ef\u00ee"+
		"\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2"+
		"<\3\2\2\2\u00f3\u00f5\7\17\2\2\u00f4\u00f3\3\2\2\2\u00f4\u00f5\3\2\2\2"+
		"\u00f5\u00f6\3\2\2\2\u00f6\u00f7\7\f\2\2\u00f7>\3\2\2\2\u00f8\u00fb\5"+
		"A!\2\u00f9\u00fb\5C\"\2\u00fa\u00f8\3\2\2\2\u00fa\u00f9\3\2\2\2\u00fb"+
		"\u00fc\3\2\2\2\u00fc\u00fd\b \2\2\u00fd@\3\2\2\2\u00fe\u0102\7\'\2\2\u00ff"+
		"\u0101\n\b\2\2\u0100\u00ff\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2"+
		"\2\2\u0102\u0103\3\2\2\2\u0103B\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u0106"+
		"\7\61\2\2\u0106\u0107\7,\2\2\u0107\u010b\3\2\2\2\u0108\u010a\13\2\2\2"+
		"\u0109\u0108\3\2\2\2\u010a\u010d\3\2\2\2\u010b\u010c\3\2\2\2\u010b\u0109"+
		"\3\2\2\2\u010c\u010e\3\2\2\2\u010d\u010b\3\2\2\2\u010e\u010f\7,\2\2\u010f"+
		"\u0110\7\61\2\2\u0110D\3\2\2\2\u0111\u0112\t\t\2\2\u0112F\3\2\2\2\u0113"+
		"\u0114\7(\2\2\u0114\u0118\7(\2\2\u0115\u0116\7~\2\2\u0116\u0118\7~\2\2"+
		"\u0117\u0113\3\2\2\2\u0117\u0115\3\2\2\2\u0118H\3\2\2\2\u0119\u011a\7"+
		"#\2\2\u011aJ\3\2\2\2\u011b\u011c\13\2\2\2\u011c\u011d\3\2\2\2\u011d\u011e"+
		"\b&\2\2\u011eL\3\2\2\2\27\2\u009d\u00a8\u00ae\u00bc\u00c1\u00c8\u00cd"+
		"\u00d3\u00d7\u00dd\u00e0\u00e5\u00e8\u00ec\u00f1\u00f4\u00fa\u0102\u010b"+
		"\u0117\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}