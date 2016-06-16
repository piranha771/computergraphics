// Generated from C:/Users/Piranha/Source/computergraphics/apps/src/main/java/cgresearch/studentprojects/proceduralcars/dsl\ShapeGrammar.g4 by ANTLR 4.5.1
package cgresearch.studentprojects.proceduralcars.dsl;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ShapeGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, ARROW=12, END=13, NUMBER=14, INT=15, FLOAT=16, WS=17, 
		PATH=18, ATTR_TYPE=19, RESOURCE_TYPE=20, IDENTIFIER=21;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "ARROW", "END", "NUMBER", "INT", "FLOAT", "WS", "PATH", 
		"ATTR_TYPE", "RESOURCE_TYPE", "IDENTIFIER"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'include'", "'attr'", "'('", "','", "')'", "'start'", "'+'", "'-'", 
		"'*'", "'/'", "'.'", "'->'", "';'", null, null, null, null, null, null, 
		"'model'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"ARROW", "END", "NUMBER", "INT", "FLOAT", "WS", "PATH", "ATTR_TYPE", "RESOURCE_TYPE", 
		"IDENTIFIER"
	};
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


	public ShapeGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ShapeGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\27\u0099\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16"+
		"\3\17\3\17\5\17X\n\17\3\20\6\20[\n\20\r\20\16\20\\\3\21\6\21`\n\21\r\21"+
		"\16\21a\3\21\3\21\6\21f\n\21\r\21\16\21g\3\22\6\22k\n\22\r\22\16\22l\3"+
		"\22\3\22\3\23\3\23\6\23s\n\23\r\23\16\23t\3\23\3\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0085\n\24\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\26\6\26\u008e\n\26\r\26\16\26\u008f\3\26\3\26\6\26\u0094"+
		"\n\26\r\26\16\26\u0095\5\26\u0098\n\26\2\2\27\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27\3\2\7\3\2\62;\5\2\13\f\17\17\"\"\7\2/;C\\^^aac|\3\2c|\5\2\62;aac"+
		"|\u00a3\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2\5"+
		"\65\3\2\2\2\7:\3\2\2\2\t<\3\2\2\2\13>\3\2\2\2\r@\3\2\2\2\17F\3\2\2\2\21"+
		"H\3\2\2\2\23J\3\2\2\2\25L\3\2\2\2\27N\3\2\2\2\31P\3\2\2\2\33S\3\2\2\2"+
		"\35W\3\2\2\2\37Z\3\2\2\2!_\3\2\2\2#j\3\2\2\2%p\3\2\2\2\'\u0084\3\2\2\2"+
		")\u0086\3\2\2\2+\u0097\3\2\2\2-.\7k\2\2./\7p\2\2/\60\7e\2\2\60\61\7n\2"+
		"\2\61\62\7w\2\2\62\63\7f\2\2\63\64\7g\2\2\64\4\3\2\2\2\65\66\7c\2\2\66"+
		"\67\7v\2\2\678\7v\2\289\7t\2\29\6\3\2\2\2:;\7*\2\2;\b\3\2\2\2<=\7.\2\2"+
		"=\n\3\2\2\2>?\7+\2\2?\f\3\2\2\2@A\7u\2\2AB\7v\2\2BC\7c\2\2CD\7t\2\2DE"+
		"\7v\2\2E\16\3\2\2\2FG\7-\2\2G\20\3\2\2\2HI\7/\2\2I\22\3\2\2\2JK\7,\2\2"+
		"K\24\3\2\2\2LM\7\61\2\2M\26\3\2\2\2NO\7\60\2\2O\30\3\2\2\2PQ\7/\2\2QR"+
		"\7@\2\2R\32\3\2\2\2ST\7=\2\2T\34\3\2\2\2UX\5\37\20\2VX\5!\21\2WU\3\2\2"+
		"\2WV\3\2\2\2X\36\3\2\2\2Y[\t\2\2\2ZY\3\2\2\2[\\\3\2\2\2\\Z\3\2\2\2\\]"+
		"\3\2\2\2] \3\2\2\2^`\5\37\20\2_^\3\2\2\2`a\3\2\2\2a_\3\2\2\2ab\3\2\2\2"+
		"bc\3\2\2\2ce\7\60\2\2df\5\37\20\2ed\3\2\2\2fg\3\2\2\2ge\3\2\2\2gh\3\2"+
		"\2\2h\"\3\2\2\2ik\t\3\2\2ji\3\2\2\2kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2mn\3"+
		"\2\2\2no\b\22\2\2o$\3\2\2\2pr\7$\2\2qs\t\4\2\2rq\3\2\2\2st\3\2\2\2tr\3"+
		"\2\2\2tu\3\2\2\2uv\3\2\2\2vw\7$\2\2w&\3\2\2\2xy\7k\2\2yz\7p\2\2z\u0085"+
		"\7v\2\2{|\7h\2\2|}\7n\2\2}~\7q\2\2~\177\7c\2\2\177\u0085\7v\2\2\u0080"+
		"\u0081\7d\2\2\u0081\u0082\7q\2\2\u0082\u0083\7q\2\2\u0083\u0085\7n\2\2"+
		"\u0084x\3\2\2\2\u0084{\3\2\2\2\u0084\u0080\3\2\2\2\u0085(\3\2\2\2\u0086"+
		"\u0087\7o\2\2\u0087\u0088\7q\2\2\u0088\u0089\7f\2\2\u0089\u008a\7g\2\2"+
		"\u008a\u008b\7n\2\2\u008b*\3\2\2\2\u008c\u008e\t\5\2\2\u008d\u008c\3\2"+
		"\2\2\u008e\u008f\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090"+
		"\u0098\3\2\2\2\u0091\u0093\t\5\2\2\u0092\u0094\t\6\2\2\u0093\u0092\3\2"+
		"\2\2\u0094\u0095\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096"+
		"\u0098\3\2\2\2\u0097\u008d\3\2\2\2\u0097\u0091\3\2\2\2\u0098,\3\2\2\2"+
		"\r\2W\\aglt\u0084\u008f\u0095\u0097\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}