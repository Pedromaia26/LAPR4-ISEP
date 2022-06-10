// Generated from C:/Users/Pedro/Desktop/Universidade-ISEP/2ANO/2� Semestre/PROJETO/Projeto Java/base.core/src/main/java/eapli/base/surveymanagement/application\Answer.g4 by ANTLR 4.10.1
package eapli.base.surveymanagement.application.eapli.base.surveymanagement.application;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AnswerParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NEWLINE=1, FREE_TEXT=2, NUMERIC=3, SINGLE_CHOICE_INPUT=4, SINGLE_CHOICE=5, 
		MULTIPLE_CHOICE_INPUT=6, MULTIPLE_CHOICE=7, SORTING_OPTIONS=8, SCALING_OPTIONS=9, 
		INT=10, WORD=11, SPACE=12, COMMA=13, DOT=14, EXCL=15, INTE=16, ELLIP=17, 
		HIFFEN=18, FIM=19, RIGHT_PARENTHESES=20;
	public static final int
		RULE_prog = 0, RULE_answer = 1, RULE_alphanumeric = 2, RULE_otherId = 3, 
		RULE_phrase = 4, RULE_signal = 5, RULE_option = 6, RULE_text = 7, RULE_type = 8, 
		RULE_end = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "answer", "alphanumeric", "otherId", "phrase", "signal", "option", 
			"text", "type", "end"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'Free-text'", "'Numeric'", "'Single-Choice with input value'", 
			"'Single-Choice'", "'Multiple-Choice with input value'", "'Multiple-Choice'", 
			"'Sorting Options'", "'Scaling Options'", null, null, "' '", "','", "'.'", 
			"'!'", "'?'", "'...'", "'-'", "';'", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NEWLINE", "FREE_TEXT", "NUMERIC", "SINGLE_CHOICE_INPUT", "SINGLE_CHOICE", 
			"MULTIPLE_CHOICE_INPUT", "MULTIPLE_CHOICE", "SORTING_OPTIONS", "SCALING_OPTIONS", 
			"INT", "WORD", "SPACE", "COMMA", "DOT", "EXCL", "INTE", "ELLIP", "HIFFEN", 
			"FIM", "RIGHT_PARENTHESES"
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
	public String getGrammarFileName() { return "Answer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AnswerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public List<OtherIdContext> otherId() {
			return getRuleContexts(OtherIdContext.class);
		}
		public OtherIdContext otherId(int i) {
			return getRuleContext(OtherIdContext.class,i);
		}
		public List<EndContext> end() {
			return getRuleContexts(EndContext.class);
		}
		public EndContext end(int i) {
			return getRuleContext(EndContext.class,i);
		}
		public List<AnswerContext> answer() {
			return getRuleContexts(AnswerContext.class);
		}
		public AnswerContext answer(int i) {
			return getRuleContext(AnswerContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVisitor ) return ((AnswerVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(20);
				otherId();
				setState(21);
				end();
				setState(22);
				answer();
				}
				}
				setState(26); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==INT );
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

	public static class AnswerContext extends ParserRuleContext {
		public AnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answer; }
	 
		public AnswerContext() { }
		public void copyFrom(AnswerContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AnswersContext extends AnswerContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public AnswersContext(AnswerContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).enterAnswers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).exitAnswers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVisitor ) return ((AnswerVisitor<? extends T>)visitor).visitAnswers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerContext answer() throws RecognitionException {
		AnswerContext _localctx = new AnswerContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_answer);
		try {
			_localctx = new AnswersContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			type();
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

	public static class AlphanumericContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(AnswerParser.INT, 0); }
		public TerminalNode WORD() { return getToken(AnswerParser.WORD, 0); }
		public AlphanumericContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alphanumeric; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).enterAlphanumeric(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).exitAlphanumeric(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVisitor ) return ((AnswerVisitor<? extends T>)visitor).visitAlphanumeric(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlphanumericContext alphanumeric() throws RecognitionException {
		AlphanumericContext _localctx = new AlphanumericContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_alphanumeric);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==WORD) ) {
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

	public static class OtherIdContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(AnswerParser.INT, 0); }
		public OtherIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_otherId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).enterOtherId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).exitOtherId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVisitor ) return ((AnswerVisitor<? extends T>)visitor).visitOtherId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OtherIdContext otherId() throws RecognitionException {
		OtherIdContext _localctx = new OtherIdContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_otherId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(INT);
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

	public static class PhraseContext extends ParserRuleContext {
		public List<TerminalNode> WORD() { return getTokens(AnswerParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(AnswerParser.WORD, i);
		}
		public List<TerminalNode> INT() { return getTokens(AnswerParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(AnswerParser.INT, i);
		}
		public List<TerminalNode> SPACE() { return getTokens(AnswerParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(AnswerParser.SPACE, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AnswerParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AnswerParser.COMMA, i);
		}
		public PhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).enterPhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).exitPhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVisitor ) return ((AnswerVisitor<? extends T>)visitor).visitPhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PhraseContext phrase() throws RecognitionException {
		PhraseContext _localctx = new PhraseContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_phrase);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==WORD) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(42);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(36);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(35);
						match(COMMA);
						}
					}

					setState(38);
					match(SPACE);
					setState(39);
					_la = _input.LA(1);
					if ( !(_la==INT || _la==WORD) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					} 
				}
				setState(44);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public static class SignalContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(AnswerParser.COMMA, 0); }
		public TerminalNode ELLIP() { return getToken(AnswerParser.ELLIP, 0); }
		public TerminalNode DOT() { return getToken(AnswerParser.DOT, 0); }
		public TerminalNode INTE() { return getToken(AnswerParser.INTE, 0); }
		public TerminalNode EXCL() { return getToken(AnswerParser.EXCL, 0); }
		public SignalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).enterSignal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).exitSignal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVisitor ) return ((AnswerVisitor<? extends T>)visitor).visitSignal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignalContext signal() throws RecognitionException {
		SignalContext _localctx = new SignalContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_signal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMA) | (1L << DOT) | (1L << EXCL) | (1L << INTE) | (1L << ELLIP))) != 0)) ) {
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

	public static class OptionContext extends ParserRuleContext {
		public AlphanumericContext alphanumeric() {
			return getRuleContext(AlphanumericContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(AnswerParser.NEWLINE, 0); }
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).enterOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).exitOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVisitor ) return ((AnswerVisitor<? extends T>)visitor).visitOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_option);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			alphanumeric();
			setState(48);
			match(NEWLINE);
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

	public static class TextContext extends ParserRuleContext {
		public List<PhraseContext> phrase() {
			return getRuleContexts(PhraseContext.class);
		}
		public PhraseContext phrase(int i) {
			return getRuleContext(PhraseContext.class,i);
		}
		public List<SignalContext> signal() {
			return getRuleContexts(SignalContext.class);
		}
		public SignalContext signal(int i) {
			return getRuleContext(SignalContext.class,i);
		}
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).exitText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVisitor ) return ((AnswerVisitor<? extends T>)visitor).visitText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(50);
				phrase();
				setState(51);
				signal();
				}
				}
				setState(55); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==INT || _la==WORD );
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode FREE_TEXT() { return getToken(AnswerParser.FREE_TEXT, 0); }
		public EndContext end() {
			return getRuleContext(EndContext.class,0);
		}
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(AnswerParser.NEWLINE, 0); }
		public TerminalNode NUMERIC() { return getToken(AnswerParser.NUMERIC, 0); }
		public TerminalNode INT() { return getToken(AnswerParser.INT, 0); }
		public TerminalNode SINGLE_CHOICE() { return getToken(AnswerParser.SINGLE_CHOICE, 0); }
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public TerminalNode SINGLE_CHOICE_INPUT() { return getToken(AnswerParser.SINGLE_CHOICE_INPUT, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public TerminalNode MULTIPLE_CHOICE() { return getToken(AnswerParser.MULTIPLE_CHOICE, 0); }
		public TerminalNode MULTIPLE_CHOICE_INPUT() { return getToken(AnswerParser.MULTIPLE_CHOICE_INPUT, 0); }
		public TerminalNode SORTING_OPTIONS() { return getToken(AnswerParser.SORTING_OPTIONS, 0); }
		public TerminalNode SCALING_OPTIONS() { return getToken(AnswerParser.SCALING_OPTIONS, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVisitor ) return ((AnswerVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_type);
		try {
			int _alt;
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FREE_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				match(FREE_TEXT);
				setState(58);
				end();
				setState(59);
				text();
				setState(60);
				match(NEWLINE);
				}
				break;
			case NUMERIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				match(NUMERIC);
				setState(63);
				end();
				setState(64);
				match(INT);
				setState(65);
				match(NEWLINE);
				}
				break;
			case SINGLE_CHOICE:
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				match(SINGLE_CHOICE);
				setState(68);
				end();
				setState(69);
				option();
				}
				break;
			case SINGLE_CHOICE_INPUT:
				enterOuterAlt(_localctx, 4);
				{
				setState(71);
				match(SINGLE_CHOICE_INPUT);
				setState(72);
				end();
				setState(77);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(73);
					option();
					}
					break;
				case 2:
					{
					{
					setState(74);
					phrase();
					setState(75);
					match(NEWLINE);
					}
					}
					break;
				}
				}
				break;
			case MULTIPLE_CHOICE:
				enterOuterAlt(_localctx, 5);
				{
				setState(79);
				match(MULTIPLE_CHOICE);
				setState(80);
				end();
				setState(82); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(81);
						option();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(84); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case MULTIPLE_CHOICE_INPUT:
				enterOuterAlt(_localctx, 6);
				{
				setState(86);
				match(MULTIPLE_CHOICE_INPUT);
				setState(87);
				end();
				setState(89); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(88);
						option();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(91); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(96);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(93);
					phrase();
					setState(94);
					match(NEWLINE);
					}
					break;
				}
				}
				break;
			case SORTING_OPTIONS:
				enterOuterAlt(_localctx, 7);
				{
				setState(98);
				match(SORTING_OPTIONS);
				setState(99);
				end();
				setState(101); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(100);
						option();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(103); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case SCALING_OPTIONS:
				enterOuterAlt(_localctx, 8);
				{
				setState(105);
				match(SCALING_OPTIONS);
				setState(106);
				end();
				setState(108); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(107);
						option();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(110); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class EndContext extends ParserRuleContext {
		public TerminalNode FIM() { return getToken(AnswerParser.FIM, 0); }
		public TerminalNode NEWLINE() { return getToken(AnswerParser.NEWLINE, 0); }
		public TerminalNode DOT() { return getToken(AnswerParser.DOT, 0); }
		public EndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_end; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).enterEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswerListener ) ((AnswerListener)listener).exitEnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswerVisitor ) return ((AnswerVisitor<? extends T>)visitor).visitEnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EndContext end() throws RecognitionException {
		EndContext _localctx = new EndContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_end);
		try {
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				match(FIM);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				match(NEWLINE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(116);
				match(FIM);
				setState(117);
				match(NEWLINE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(118);
				match(DOT);
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

	public static final String _serializedATN =
		"\u0004\u0001\u0014z\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0004\u0000\u0019\b\u0000\u000b\u0000\f\u0000\u001a\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0003\u0004%\b\u0004\u0001\u0004\u0001\u0004\u0005\u0004)\b\u0004"+
		"\n\u0004\f\u0004,\t\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0004\u00076\b\u0007"+
		"\u000b\u0007\f\u00077\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\bN\b\b\u0001\b\u0001"+
		"\b\u0001\b\u0004\bS\b\b\u000b\b\f\bT\u0001\b\u0001\b\u0001\b\u0004\bZ"+
		"\b\b\u000b\b\f\b[\u0001\b\u0001\b\u0001\b\u0003\ba\b\b\u0001\b\u0001\b"+
		"\u0001\b\u0004\bf\b\b\u000b\b\f\bg\u0001\b\u0001\b\u0001\b\u0004\bm\b"+
		"\b\u000b\b\f\bn\u0003\bq\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003"+
		"\tx\b\t\u0001\t\u0000\u0000\n\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0000\u0002\u0001\u0000\n\u000b\u0001\u0000\r\u0011\u0083\u0000"+
		"\u0018\u0001\u0000\u0000\u0000\u0002\u001c\u0001\u0000\u0000\u0000\u0004"+
		"\u001e\u0001\u0000\u0000\u0000\u0006 \u0001\u0000\u0000\u0000\b\"\u0001"+
		"\u0000\u0000\u0000\n-\u0001\u0000\u0000\u0000\f/\u0001\u0000\u0000\u0000"+
		"\u000e5\u0001\u0000\u0000\u0000\u0010p\u0001\u0000\u0000\u0000\u0012w"+
		"\u0001\u0000\u0000\u0000\u0014\u0015\u0003\u0006\u0003\u0000\u0015\u0016"+
		"\u0003\u0012\t\u0000\u0016\u0017\u0003\u0002\u0001\u0000\u0017\u0019\u0001"+
		"\u0000\u0000\u0000\u0018\u0014\u0001\u0000\u0000\u0000\u0019\u001a\u0001"+
		"\u0000\u0000\u0000\u001a\u0018\u0001\u0000\u0000\u0000\u001a\u001b\u0001"+
		"\u0000\u0000\u0000\u001b\u0001\u0001\u0000\u0000\u0000\u001c\u001d\u0003"+
		"\u0010\b\u0000\u001d\u0003\u0001\u0000\u0000\u0000\u001e\u001f\u0007\u0000"+
		"\u0000\u0000\u001f\u0005\u0001\u0000\u0000\u0000 !\u0005\n\u0000\u0000"+
		"!\u0007\u0001\u0000\u0000\u0000\"*\u0007\u0000\u0000\u0000#%\u0005\r\u0000"+
		"\u0000$#\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000%&\u0001\u0000"+
		"\u0000\u0000&\'\u0005\f\u0000\u0000\')\u0007\u0000\u0000\u0000($\u0001"+
		"\u0000\u0000\u0000),\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000"+
		"*+\u0001\u0000\u0000\u0000+\t\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000"+
		"\u0000-.\u0007\u0001\u0000\u0000.\u000b\u0001\u0000\u0000\u0000/0\u0003"+
		"\u0004\u0002\u000001\u0005\u0001\u0000\u00001\r\u0001\u0000\u0000\u0000"+
		"23\u0003\b\u0004\u000034\u0003\n\u0005\u000046\u0001\u0000\u0000\u0000"+
		"52\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u000075\u0001\u0000\u0000"+
		"\u000078\u0001\u0000\u0000\u00008\u000f\u0001\u0000\u0000\u00009:\u0005"+
		"\u0002\u0000\u0000:;\u0003\u0012\t\u0000;<\u0003\u000e\u0007\u0000<=\u0005"+
		"\u0001\u0000\u0000=q\u0001\u0000\u0000\u0000>?\u0005\u0003\u0000\u0000"+
		"?@\u0003\u0012\t\u0000@A\u0005\n\u0000\u0000AB\u0005\u0001\u0000\u0000"+
		"Bq\u0001\u0000\u0000\u0000CD\u0005\u0005\u0000\u0000DE\u0003\u0012\t\u0000"+
		"EF\u0003\f\u0006\u0000Fq\u0001\u0000\u0000\u0000GH\u0005\u0004\u0000\u0000"+
		"HM\u0003\u0012\t\u0000IN\u0003\f\u0006\u0000JK\u0003\b\u0004\u0000KL\u0005"+
		"\u0001\u0000\u0000LN\u0001\u0000\u0000\u0000MI\u0001\u0000\u0000\u0000"+
		"MJ\u0001\u0000\u0000\u0000Nq\u0001\u0000\u0000\u0000OP\u0005\u0007\u0000"+
		"\u0000PR\u0003\u0012\t\u0000QS\u0003\f\u0006\u0000RQ\u0001\u0000\u0000"+
		"\u0000ST\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000TU\u0001\u0000"+
		"\u0000\u0000Uq\u0001\u0000\u0000\u0000VW\u0005\u0006\u0000\u0000WY\u0003"+
		"\u0012\t\u0000XZ\u0003\f\u0006\u0000YX\u0001\u0000\u0000\u0000Z[\u0001"+
		"\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000"+
		"\\`\u0001\u0000\u0000\u0000]^\u0003\b\u0004\u0000^_\u0005\u0001\u0000"+
		"\u0000_a\u0001\u0000\u0000\u0000`]\u0001\u0000\u0000\u0000`a\u0001\u0000"+
		"\u0000\u0000aq\u0001\u0000\u0000\u0000bc\u0005\b\u0000\u0000ce\u0003\u0012"+
		"\t\u0000df\u0003\f\u0006\u0000ed\u0001\u0000\u0000\u0000fg\u0001\u0000"+
		"\u0000\u0000ge\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hq\u0001"+
		"\u0000\u0000\u0000ij\u0005\t\u0000\u0000jl\u0003\u0012\t\u0000km\u0003"+
		"\f\u0006\u0000lk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000nl\u0001"+
		"\u0000\u0000\u0000no\u0001\u0000\u0000\u0000oq\u0001\u0000\u0000\u0000"+
		"p9\u0001\u0000\u0000\u0000p>\u0001\u0000\u0000\u0000pC\u0001\u0000\u0000"+
		"\u0000pG\u0001\u0000\u0000\u0000pO\u0001\u0000\u0000\u0000pV\u0001\u0000"+
		"\u0000\u0000pb\u0001\u0000\u0000\u0000pi\u0001\u0000\u0000\u0000q\u0011"+
		"\u0001\u0000\u0000\u0000rx\u0005\u0013\u0000\u0000sx\u0005\u0001\u0000"+
		"\u0000tu\u0005\u0013\u0000\u0000ux\u0005\u0001\u0000\u0000vx\u0005\u000e"+
		"\u0000\u0000wr\u0001\u0000\u0000\u0000ws\u0001\u0000\u0000\u0000wt\u0001"+
		"\u0000\u0000\u0000wv\u0001\u0000\u0000\u0000x\u0013\u0001\u0000\u0000"+
		"\u0000\f\u001a$*7MT[`gnpw";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}