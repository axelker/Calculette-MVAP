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
		T__17=18, T__18=19, T__19=20, T__20=21, TYPE=22, BOOL=23, RETURN=24, READ=25, 
		WRITE=26, IDENTIFIANT=27, CONDITION=28, WS=29, ENTIER=30, FLOAT=31, NEWLINE=32, 
		COMMENTARY=33, OPERATION=34, OPLOGIQUE=35, NEGLOGIQUE=36, UNMATCH=37;
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
			"T__17", "T__18", "T__19", "T__20", "TYPE", "BOOL", "RETURN", "READ", 
			"WRITE", "IDENTIFIANT", "CONDITION", "WS", "ENTIER", "FLOAT", "EXPONENT", 
			"NEWLINE", "COMMENTARY", "COMMENTAIRE", "COMMENTAIREETOILE", "OPERATION", 
			"OPLOGIQUE", "NEGLOGIQUE", "UNMATCH"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\'\u0132\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u009f\n\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u00aa\n\30\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\34\3\34\7\34\u00c0\n\34\f\34\16\34\u00c3\13\34\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u00d0\n\35\3\36\6\36"+
		"\u00d3\n\36\r\36\16\36\u00d4\3\36\3\36\3\37\6\37\u00da\n\37\r\37\16\37"+
		"\u00db\3 \6 \u00df\n \r \16 \u00e0\3 \3 \7 \u00e5\n \f \16 \u00e8\13 "+
		"\3 \5 \u00eb\n \3 \3 \6 \u00ef\n \r \16 \u00f0\3 \5 \u00f4\n \3 \6 \u00f7"+
		"\n \r \16 \u00f8\3 \5 \u00fc\n \3!\3!\5!\u0100\n!\3!\6!\u0103\n!\r!\16"+
		"!\u0104\3\"\5\"\u0108\n\"\3\"\3\"\3#\3#\5#\u010e\n#\3#\3#\3$\3$\7$\u0114"+
		"\n$\f$\16$\u0117\13$\3%\3%\3%\3%\7%\u011d\n%\f%\16%\u0120\13%\3%\3%\3"+
		"%\3&\3&\3\'\3\'\3\'\3\'\5\'\u012b\n\'\3(\3(\3)\3)\3)\3)\3\u011e\2*\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\2C\"E#G\2I\2K$M%O&Q\'\3\2\n\5\2C\\aac|\6\2\62;C\\aac|\4\2>>@@\4\2\13"+
		"\13\"\"\4\2GGgg\4\2--//\3\2\f\f\5\2,-//\61\61\2\u0147\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2"+
		"\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2"+
		"\2?\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q"+
		"\3\2\2\2\3S\3\2\2\2\5U\3\2\2\2\7W\3\2\2\2\tY\3\2\2\2\13[\3\2\2\2\r]\3"+
		"\2\2\2\17_\3\2\2\2\21a\3\2\2\2\23e\3\2\2\2\25g\3\2\2\2\27i\3\2\2\2\31"+
		"l\3\2\2\2\33n\3\2\2\2\35p\3\2\2\2\37v\3\2\2\2!z\3\2\2\2#\u0081\3\2\2\2"+
		"%\u0087\3\2\2\2\'\u008a\3\2\2\2)\u008f\3\2\2\2+\u0093\3\2\2\2-\u009e\3"+
		"\2\2\2/\u00a9\3\2\2\2\61\u00ab\3\2\2\2\63\u00b2\3\2\2\2\65\u00b7\3\2\2"+
		"\2\67\u00bd\3\2\2\29\u00cf\3\2\2\2;\u00d2\3\2\2\2=\u00d9\3\2\2\2?\u00fb"+
		"\3\2\2\2A\u00fd\3\2\2\2C\u0107\3\2\2\2E\u010d\3\2\2\2G\u0111\3\2\2\2I"+
		"\u0118\3\2\2\2K\u0124\3\2\2\2M\u012a\3\2\2\2O\u012c\3\2\2\2Q\u012e\3\2"+
		"\2\2ST\7*\2\2T\4\3\2\2\2UV\7+\2\2V\6\3\2\2\2WX\7\61\2\2X\b\3\2\2\2YZ\7"+
		",\2\2Z\n\3\2\2\2[\\\7-\2\2\\\f\3\2\2\2]^\7/\2\2^\16\3\2\2\2_`\7=\2\2`"+
		"\20\3\2\2\2ab\7x\2\2bc\7c\2\2cd\7t\2\2d\22\3\2\2\2ef\7<\2\2f\24\3\2\2"+
		"\2gh\7?\2\2h\26\3\2\2\2ij\7-\2\2jk\7?\2\2k\30\3\2\2\2lm\7}\2\2m\32\3\2"+
		"\2\2no\7\177\2\2o\34\3\2\2\2pq\7y\2\2qr\7j\2\2rs\7k\2\2st\7n\2\2tu\7g"+
		"\2\2u\36\3\2\2\2vw\7h\2\2wx\7q\2\2xy\7t\2\2y \3\2\2\2z{\7t\2\2{|\7g\2"+
		"\2|}\7r\2\2}~\7g\2\2~\177\7c\2\2\177\u0080\7v\2\2\u0080\"\3\2\2\2\u0081"+
		"\u0082\7w\2\2\u0082\u0083\7p\2\2\u0083\u0084\7v\2\2\u0084\u0085\7k\2\2"+
		"\u0085\u0086\7n\2\2\u0086$\3\2\2\2\u0087\u0088\7k\2\2\u0088\u0089\7h\2"+
		"\2\u0089&\3\2\2\2\u008a\u008b\7g\2\2\u008b\u008c\7n\2\2\u008c\u008d\7"+
		"u\2\2\u008d\u008e\7g\2\2\u008e(\3\2\2\2\u008f\u0090\7h\2\2\u0090\u0091"+
		"\7w\2\2\u0091\u0092\7p\2\2\u0092*\3\2\2\2\u0093\u0094\7.\2\2\u0094,\3"+
		"\2\2\2\u0095\u0096\7k\2\2\u0096\u0097\7p\2\2\u0097\u009f\7v\2\2\u0098"+
		"\u0099\7f\2\2\u0099\u009a\7q\2\2\u009a\u009b\7w\2\2\u009b\u009c\7d\2\2"+
		"\u009c\u009d\7n\2\2\u009d\u009f\7g\2\2\u009e\u0095\3\2\2\2\u009e\u0098"+
		"\3\2\2\2\u009f.\3\2\2\2\u00a0\u00a1\7v\2\2\u00a1\u00a2\7t\2\2\u00a2\u00a3"+
		"\7w\2\2\u00a3\u00aa\7g\2\2\u00a4\u00a5\7h\2\2\u00a5\u00a6\7c\2\2\u00a6"+
		"\u00a7\7n\2\2\u00a7\u00a8\7u\2\2\u00a8\u00aa\7g\2\2\u00a9\u00a0\3\2\2"+
		"\2\u00a9\u00a4\3\2\2\2\u00aa\60\3\2\2\2\u00ab\u00ac\7t\2\2\u00ac\u00ad"+
		"\7g\2\2\u00ad\u00ae\7v\2\2\u00ae\u00af\7w\2\2\u00af\u00b0\7t\2\2\u00b0"+
		"\u00b1\7p\2\2\u00b1\62\3\2\2\2\u00b2\u00b3\7t\2\2\u00b3\u00b4\7g\2\2\u00b4"+
		"\u00b5\7c\2\2\u00b5\u00b6\7f\2\2\u00b6\64\3\2\2\2\u00b7\u00b8\7y\2\2\u00b8"+
		"\u00b9\7t\2\2\u00b9\u00ba\7k\2\2\u00ba\u00bb\7v\2\2\u00bb\u00bc\7g\2\2"+
		"\u00bc\66\3\2\2\2\u00bd\u00c1\t\2\2\2\u00be\u00c0\t\3\2\2\u00bf\u00be"+
		"\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2"+
		"8\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00c5\7#\2\2\u00c5\u00d0\7?\2\2\u00c6"+
		"\u00c7\7>\2\2\u00c7\u00d0\7@\2\2\u00c8\u00d0\t\4\2\2\u00c9\u00ca\7>\2"+
		"\2\u00ca\u00d0\7?\2\2\u00cb\u00cc\7@\2\2\u00cc\u00d0\7?\2\2\u00cd\u00ce"+
		"\7?\2\2\u00ce\u00d0\7?\2\2\u00cf\u00c4\3\2\2\2\u00cf\u00c6\3\2\2\2\u00cf"+
		"\u00c8\3\2\2\2\u00cf\u00c9\3\2\2\2\u00cf\u00cb\3\2\2\2\u00cf\u00cd\3\2"+
		"\2\2\u00d0:\3\2\2\2\u00d1\u00d3\t\5\2\2\u00d2\u00d1\3\2\2\2\u00d3\u00d4"+
		"\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6"+
		"\u00d7\b\36\2\2\u00d7<\3\2\2\2\u00d8\u00da\4\62;\2\u00d9\u00d8\3\2\2\2"+
		"\u00da\u00db\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc>\3"+
		"\2\2\2\u00dd\u00df\4\62;\2\u00de\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0"+
		"\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e6\7\60"+
		"\2\2\u00e3\u00e5\4\62;\2\u00e4\u00e3\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6"+
		"\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2"+
		"\2\2\u00e9\u00eb\5A!\2\u00ea\u00e9\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00fc"+
		"\3\2\2\2\u00ec\u00ee\7\60\2\2\u00ed\u00ef\4\62;\2\u00ee\u00ed\3\2\2\2"+
		"\u00ef\u00f0\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f3"+
		"\3\2\2\2\u00f2\u00f4\5A!\2\u00f3\u00f2\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4"+
		"\u00fc\3\2\2\2\u00f5\u00f7\4\62;\2\u00f6\u00f5\3\2\2\2\u00f7\u00f8\3\2"+
		"\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa"+
		"\u00fc\5A!\2\u00fb\u00de\3\2\2\2\u00fb\u00ec\3\2\2\2\u00fb\u00f6\3\2\2"+
		"\2\u00fc@\3\2\2\2\u00fd\u00ff\t\6\2\2\u00fe\u0100\t\7\2\2\u00ff\u00fe"+
		"\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0102\3\2\2\2\u0101\u0103\4\62;\2\u0102"+
		"\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2"+
		"\2\2\u0105B\3\2\2\2\u0106\u0108\7\17\2\2\u0107\u0106\3\2\2\2\u0107\u0108"+
		"\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a\7\f\2\2\u010aD\3\2\2\2\u010b"+
		"\u010e\5G$\2\u010c\u010e\5I%\2\u010d\u010b\3\2\2\2\u010d\u010c\3\2\2\2"+
		"\u010e\u010f\3\2\2\2\u010f\u0110\b#\2\2\u0110F\3\2\2\2\u0111\u0115\7\'"+
		"\2\2\u0112\u0114\n\b\2\2\u0113\u0112\3\2\2\2\u0114\u0117\3\2\2\2\u0115"+
		"\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116H\3\2\2\2\u0117\u0115\3\2\2\2"+
		"\u0118\u0119\7\61\2\2\u0119\u011a\7,\2\2\u011a\u011e\3\2\2\2\u011b\u011d"+
		"\13\2\2\2\u011c\u011b\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011f\3\2\2\2"+
		"\u011e\u011c\3\2\2\2\u011f\u0121\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0122"+
		"\7,\2\2\u0122\u0123\7\61\2\2\u0123J\3\2\2\2\u0124\u0125\t\t\2\2\u0125"+
		"L\3\2\2\2\u0126\u0127\7(\2\2\u0127\u012b\7(\2\2\u0128\u0129\7~\2\2\u0129"+
		"\u012b\7~\2\2\u012a\u0126\3\2\2\2\u012a\u0128\3\2\2\2\u012bN\3\2\2\2\u012c"+
		"\u012d\7#\2\2\u012dP\3\2\2\2\u012e\u012f\13\2\2\2\u012f\u0130\3\2\2\2"+
		"\u0130\u0131\b)\2\2\u0131R\3\2\2\2\27\2\u009e\u00a9\u00c1\u00cf\u00d4"+
		"\u00db\u00e0\u00e6\u00ea\u00f0\u00f3\u00f8\u00fb\u00ff\u0104\u0107\u010d"+
		"\u0115\u011e\u012a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}