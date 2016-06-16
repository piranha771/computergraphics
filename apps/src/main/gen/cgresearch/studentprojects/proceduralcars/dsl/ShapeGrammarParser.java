// Generated from C:/Users/Piranha/Source/computergraphics/apps/src/main/java/cgresearch/studentprojects/proceduralcars/dsl\ShapeGrammar.g4 by ANTLR 4.5.1
package cgresearch.studentprojects.proceduralcars.dsl;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ShapeGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, ARROW=12, END=13, NUMBER=14, INT=15, FLOAT=16, WS=17, 
		PATH=18, ATTR_TYPE=19, RESOURCE_TYPE=20, IDENTIFIER=21;
	public static final int
		RULE_shape_grammar = 0, RULE_decoration = 1, RULE_include_statement = 2, 
		RULE_attr = 3, RULE_resource = 4, RULE_start_entry = 5, RULE_shape_rule = 6, 
		RULE_func = 7, RULE_parameter = 8, RULE_expr = 9, RULE_addition_exp = 10, 
		RULE_multiply_exp = 11, RULE_atom_exp = 12, RULE_object_identifier = 13;
	public static final String[] ruleNames = {
		"shape_grammar", "decoration", "include_statement", "attr", "resource", 
		"start_entry", "shape_rule", "func", "parameter", "expr", "addition_exp", 
		"multiply_exp", "atom_exp", "object_identifier"
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

	@Override
	public String getGrammarFileName() { return "ShapeGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ShapeGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Shape_grammarContext extends ParserRuleContext {
		public Start_entryContext start_entry() {
			return getRuleContext(Start_entryContext.class,0);
		}
		public List<DecorationContext> decoration() {
			return getRuleContexts(DecorationContext.class);
		}
		public DecorationContext decoration(int i) {
			return getRuleContext(DecorationContext.class,i);
		}
		public List<Shape_ruleContext> shape_rule() {
			return getRuleContexts(Shape_ruleContext.class);
		}
		public Shape_ruleContext shape_rule(int i) {
			return getRuleContext(Shape_ruleContext.class,i);
		}
		public Shape_grammarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shape_grammar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShapeGrammarListener ) ((ShapeGrammarListener)listener).enterShape_grammar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShapeGrammarListener ) ((ShapeGrammarListener)listener).exitShape_grammar(this);
		}
	}

	public final Shape_grammarContext shape_grammar() throws RecognitionException {
		Shape_grammarContext _localctx = new Shape_grammarContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_shape_grammar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << RESOURCE_TYPE))) != 0)) {
				{
				{
				setState(28);
				decoration();
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(34);
			start_entry();
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << RESOURCE_TYPE))) != 0)) {
				{
				{
				setState(35);
				decoration();
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(42); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(41);
				shape_rule();
				}
				}
				setState(44); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER );
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

	public static class DecorationContext extends ParserRuleContext {
		public Include_statementContext include_statement() {
			return getRuleContext(Include_statementContext.class,0);
		}
		public AttrContext attr() {
			return getRuleContext(AttrContext.class,0);
		}
		public ResourceContext resource() {
			return getRuleContext(ResourceContext.class,0);
		}
		public DecorationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decoration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShapeGrammarListener ) ((ShapeGrammarListener)listener).enterDecoration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShapeGrammarListener ) ((ShapeGrammarListener)listener).exitDecoration(this);
		}
	}

	public final DecorationContext decoration() throws RecognitionException {
		DecorationContext _localctx = new DecorationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decoration);
		try {
			setState(49);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				include_statement();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				attr();
				}
				break;
			case RESOURCE_TYPE:
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				resource();
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

	public static class Include_statementContext extends ParserRuleContext {
		public TerminalNode PATH() { return getToken(ShapeGrammarParser.PATH, 0); }
		public TerminalNode END() { return getToken(ShapeGrammarParser.END, 0); }
		public Include_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_include_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShapeGrammarListener ) ((ShapeGrammarListener)listener).enterInclude_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShapeGrammarListener ) ((ShapeGrammarListener)listener).exitInclude_statement(this);
		}
	}

	public final Include_statementContext include_statement() throws RecognitionException {
		Include_statementContext _localctx = new Include_statementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_include_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(T__0);
			setState(52);
			match(PATH);
			setState(53);
			match(END);
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

	public static class AttrContext extends ParserRuleContext {
		public TerminalNode ATTR_TYPE() { return getToken(ShapeGrammarParser.ATTR_TYPE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ShapeGrammarParser.IDENTIFIER, 0); }
		public TerminalNode END() { return getToken(ShapeGrammarParser.END, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(ShapeGrammarParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(ShapeGrammarParser.NUMBER, i);
		}
		public AttrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShapeGrammarListener ) ((ShapeGrammarListener)listener).enterAttr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShapeGrammarListener ) ((ShapeGrammarListener)listener).exitAttr(this);
		}
	}

	public final AttrContext attr() throws RecognitionException {
		AttrContext _localctx = new AttrContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_attr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(T__1);
			setState(56);
			match(ATTR_TYPE);
			setState(57);
			match(IDENTIFIER);
			setState(63);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(58);
				match(T__2);
				setState(59);
				match(NUMBER);
				setState(60);
				match(T__3);
				setState(61);
				match(NUMBER);
				setState(62);
				match(T__4);
				}
			}

			setState(65);
			match(END);
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

	public static class ResourceContext extends ParserRuleContext {
		public TerminalNode RESOURCE_TYPE() { return getToken(ShapeGrammarParser.RESOURCE_TYPE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ShapeGrammarParser.IDENTIFIER, 0); }
		public TerminalNode PATH() { return getToken(ShapeGrammarParser.PATH, 0); }
		public TerminalNode END() { return getToken(ShapeGrammarParser.END, 0); }
		public ResourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resource; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShapeGrammarListener ) ((ShapeGrammarListener)listener).enterResource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShapeGrammarListener ) ((ShapeGrammarListener)listener).exitResource(this);
		}
	}

	public final ResourceContext resource() throws RecognitionException {
		ResourceContext _localctx = new ResourceContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_resource);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(RESOURCE_TYPE);
			setState(68);
			match(IDENTIFIER);
			setState(69);
			match(PATH);
			setState(70);
			match(END);
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

	public static class Start_entryContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ShapeGrammarParser.IDENTIFIER, 0); }
		public TerminalNode END() { return getToken(ShapeGrammarParser.END, 0); }
		public Start_entryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start_entry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShapeGrammarListener ) ((ShapeGrammarListener)listener).enterStart_entry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShapeGrammarListener ) ((ShapeGrammarListener)listener).exitStart_entry(this);
		}
	}

	public final Start_entryContext start_entry() throws RecognitionException {
		Start_entryContext _localctx = new Start_entryContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_start_entry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(T__5);
			setState(73);
			match(IDENTIFIER);
			setState(74);
			match(END);
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

	public static class Shape_ruleContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ShapeGrammarParser.IDENTIFIER, 0); }
		public TerminalNode ARROW() { return getToken(ShapeGrammarParser.ARROW, 0); }
		public TerminalNode END() { return getToken(ShapeGrammarParser.END, 0); }
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public Shape_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shape_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShapeGrammarListener ) ((ShapeGrammarListener)listener).enterShape_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShapeGrammarListener ) ((ShapeGrammarListener)listener).exitShape_rule(this);
		}
	}

	public final Shape_ruleContext shape_rule() throws RecognitionException {
		Shape_ruleContext _localctx = new Shape_ruleContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_shape_rule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(IDENTIFIER);
			setState(77);
			match(ARROW);
			{
			setState(78);
			func();
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(79);
				match(T__3);
				setState(80);
				func();
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(86);
			match(END);
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

	public static class FuncContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ShapeGrammarParser.IDENTIFIER, 0); }
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShapeGrammarListener ) ((ShapeGrammarListener)listener).enterFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShapeGrammarListener ) ((ShapeGrammarListener)listener).exitFunc(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(IDENTIFIER);
			setState(89);
			match(T__2);
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(90);
				parameter();
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(91);
					match(T__3);
					setState(92);
					parameter();
					}
					}
					setState(97);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(103);
			match(T__4);
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

	public static class ParameterContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShapeGrammarListener ) ((ShapeGrammarListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShapeGrammarListener ) ((ShapeGrammarListener)listener).exitParameter(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parameter);
		try {
			setState(107);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				func();
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

	public static class ExprContext extends ParserRuleContext {
		public Addition_expContext addition_exp() {
			return getRuleContext(Addition_expContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShapeGrammarListener ) ((ShapeGrammarListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShapeGrammarListener ) ((ShapeGrammarListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			addition_exp();
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

	public static class Addition_expContext extends ParserRuleContext {
		public List<Multiply_expContext> multiply_exp() {
			return getRuleContexts(Multiply_expContext.class);
		}
		public Multiply_expContext multiply_exp(int i) {
			return getRuleContext(Multiply_expContext.class,i);
		}
		public Addition_expContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addition_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShapeGrammarListener ) ((ShapeGrammarListener)listener).enterAddition_exp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShapeGrammarListener ) ((ShapeGrammarListener)listener).exitAddition_exp(this);
		}
	}

	public final Addition_expContext addition_exp() throws RecognitionException {
		Addition_expContext _localctx = new Addition_expContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_addition_exp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			multiply_exp();
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6 || _la==T__7) {
				{
				setState(116);
				switch (_input.LA(1)) {
				case T__6:
					{
					setState(112);
					match(T__6);
					setState(113);
					multiply_exp();
					}
					break;
				case T__7:
					{
					setState(114);
					match(T__7);
					setState(115);
					multiply_exp();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(120);
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

	public static class Multiply_expContext extends ParserRuleContext {
		public List<Atom_expContext> atom_exp() {
			return getRuleContexts(Atom_expContext.class);
		}
		public Atom_expContext atom_exp(int i) {
			return getRuleContext(Atom_expContext.class,i);
		}
		public Multiply_expContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiply_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShapeGrammarListener ) ((ShapeGrammarListener)listener).enterMultiply_exp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShapeGrammarListener ) ((ShapeGrammarListener)listener).exitMultiply_exp(this);
		}
	}

	public final Multiply_expContext multiply_exp() throws RecognitionException {
		Multiply_expContext _localctx = new Multiply_expContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_multiply_exp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			atom_exp();
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8 || _la==T__9) {
				{
				setState(126);
				switch (_input.LA(1)) {
				case T__8:
					{
					setState(122);
					match(T__8);
					setState(123);
					atom_exp();
					}
					break;
				case T__9:
					{
					setState(124);
					match(T__9);
					setState(125);
					atom_exp();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(130);
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

	public static class Atom_expContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ShapeGrammarParser.NUMBER, 0); }
		public Object_identifierContext object_identifier() {
			return getRuleContext(Object_identifierContext.class,0);
		}
		public Addition_expContext addition_exp() {
			return getRuleContext(Addition_expContext.class,0);
		}
		public Atom_expContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShapeGrammarListener ) ((ShapeGrammarListener)listener).enterAtom_exp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShapeGrammarListener ) ((ShapeGrammarListener)listener).exitAtom_exp(this);
		}
	}

	public final Atom_expContext atom_exp() throws RecognitionException {
		Atom_expContext _localctx = new Atom_expContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_atom_exp);
		try {
			setState(137);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				match(NUMBER);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				object_identifier();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(133);
				match(T__2);
				setState(134);
				addition_exp();
				setState(135);
				match(T__4);
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

	public static class Object_identifierContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(ShapeGrammarParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(ShapeGrammarParser.IDENTIFIER, i);
		}
		public Object_identifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShapeGrammarListener ) ((ShapeGrammarListener)listener).enterObject_identifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShapeGrammarListener ) ((ShapeGrammarListener)listener).exitObject_identifier(this);
		}
	}

	public final Object_identifierContext object_identifier() throws RecognitionException {
		Object_identifierContext _localctx = new Object_identifierContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_object_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(IDENTIFIER);
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(140);
				match(T__10);
				setState(141);
				match(IDENTIFIER);
				}
				}
				setState(146);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\27\u0096\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\7\2 \n\2\f\2\16\2#\13\2"+
		"\3\2\3\2\7\2\'\n\2\f\2\16\2*\13\2\3\2\6\2-\n\2\r\2\16\2.\3\3\3\3\3\3\5"+
		"\3\64\n\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5B\n\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\7\bT\n\b"+
		"\f\b\16\bW\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\7\t`\n\t\f\t\16\tc\13\t\7"+
		"\te\n\t\f\t\16\th\13\t\3\t\3\t\3\n\3\n\5\nn\n\n\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\7\fw\n\f\f\f\16\fz\13\f\3\r\3\r\3\r\3\r\3\r\7\r\u0081\n\r\f\r"+
		"\16\r\u0084\13\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u008c\n\16\3\17\3"+
		"\17\3\17\7\17\u0091\n\17\f\17\16\17\u0094\13\17\3\17\2\2\20\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\2\2\u0098\2!\3\2\2\2\4\63\3\2\2\2\6\65\3\2"+
		"\2\2\b9\3\2\2\2\nE\3\2\2\2\fJ\3\2\2\2\16N\3\2\2\2\20Z\3\2\2\2\22m\3\2"+
		"\2\2\24o\3\2\2\2\26q\3\2\2\2\30{\3\2\2\2\32\u008b\3\2\2\2\34\u008d\3\2"+
		"\2\2\36 \5\4\3\2\37\36\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"$\3\2"+
		"\2\2#!\3\2\2\2$(\5\f\7\2%\'\5\4\3\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3"+
		"\2\2\2),\3\2\2\2*(\3\2\2\2+-\5\16\b\2,+\3\2\2\2-.\3\2\2\2.,\3\2\2\2./"+
		"\3\2\2\2/\3\3\2\2\2\60\64\5\6\4\2\61\64\5\b\5\2\62\64\5\n\6\2\63\60\3"+
		"\2\2\2\63\61\3\2\2\2\63\62\3\2\2\2\64\5\3\2\2\2\65\66\7\3\2\2\66\67\7"+
		"\24\2\2\678\7\17\2\28\7\3\2\2\29:\7\4\2\2:;\7\25\2\2;A\7\27\2\2<=\7\5"+
		"\2\2=>\7\20\2\2>?\7\6\2\2?@\7\20\2\2@B\7\7\2\2A<\3\2\2\2AB\3\2\2\2BC\3"+
		"\2\2\2CD\7\17\2\2D\t\3\2\2\2EF\7\26\2\2FG\7\27\2\2GH\7\24\2\2HI\7\17\2"+
		"\2I\13\3\2\2\2JK\7\b\2\2KL\7\27\2\2LM\7\17\2\2M\r\3\2\2\2NO\7\27\2\2O"+
		"P\7\16\2\2PU\5\20\t\2QR\7\6\2\2RT\5\20\t\2SQ\3\2\2\2TW\3\2\2\2US\3\2\2"+
		"\2UV\3\2\2\2VX\3\2\2\2WU\3\2\2\2XY\7\17\2\2Y\17\3\2\2\2Z[\7\27\2\2[f\7"+
		"\5\2\2\\a\5\22\n\2]^\7\6\2\2^`\5\22\n\2_]\3\2\2\2`c\3\2\2\2a_\3\2\2\2"+
		"ab\3\2\2\2be\3\2\2\2ca\3\2\2\2d\\\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2"+
		"\2gi\3\2\2\2hf\3\2\2\2ij\7\7\2\2j\21\3\2\2\2kn\5\24\13\2ln\5\20\t\2mk"+
		"\3\2\2\2ml\3\2\2\2n\23\3\2\2\2op\5\26\f\2p\25\3\2\2\2qx\5\30\r\2rs\7\t"+
		"\2\2sw\5\30\r\2tu\7\n\2\2uw\5\30\r\2vr\3\2\2\2vt\3\2\2\2wz\3\2\2\2xv\3"+
		"\2\2\2xy\3\2\2\2y\27\3\2\2\2zx\3\2\2\2{\u0082\5\32\16\2|}\7\13\2\2}\u0081"+
		"\5\32\16\2~\177\7\f\2\2\177\u0081\5\32\16\2\u0080|\3\2\2\2\u0080~\3\2"+
		"\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083"+
		"\31\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u008c\7\20\2\2\u0086\u008c\5\34"+
		"\17\2\u0087\u0088\7\5\2\2\u0088\u0089\5\26\f\2\u0089\u008a\7\7\2\2\u008a"+
		"\u008c\3\2\2\2\u008b\u0085\3\2\2\2\u008b\u0086\3\2\2\2\u008b\u0087\3\2"+
		"\2\2\u008c\33\3\2\2\2\u008d\u0092\7\27\2\2\u008e\u008f\7\r\2\2\u008f\u0091"+
		"\7\27\2\2\u0090\u008e\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2"+
		"\u0092\u0093\3\2\2\2\u0093\35\3\2\2\2\u0094\u0092\3\2\2\2\21!(.\63AUa"+
		"fmvx\u0080\u0082\u008b\u0092";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}