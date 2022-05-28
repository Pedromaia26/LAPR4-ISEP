// Generated from D:/LAPR4/Projeto Java/base.core/src/main/java/eapli/base/surveymanagement/application\Survey.g4 by ANTLR 4.10.1
package eapli.base.surveymanagement.application.eapli.base.surveymanagement.application;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SurveyParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NEWLINE=1, MANDATORY=2, OPTIONAL=3, CONDITION_DEPENDENT=4, FREE_TEXT=5, 
		NUMERIC=6, SINGLE_CHOICE_INPUT=7, SINGLE_CHOICE=8, MULTIPLE_CHOICE_INPUT=9, 
		MULTIPLE_CHOICE=10, SORTING_OPTIONS=11, SCALING_OPTIONS=12, FT_TEXT=13, 
		NUM_TEXT=14, SC_TEXT=15, SCI_TEXT=16, MC_TEXT=17, MCI_TEXT=18, SO_TEXT=19, 
		SCO_TEXT=20, INT=21, WORD=22, SPACE=23, COMMA=24, DOT=25, EXCL=26, INTE=27, 
		ELLIP=28, HIFFEN=29, FIM=30;
	public static final int
		RULE_prog = 0, RULE_survey = 1, RULE_id = 2, RULE_alphanumeric = 3, RULE_title = 4, 
		RULE_obli = 5, RULE_wMessage = 6, RULE_section = 7, RULE_otherId = 8, 
		RULE_rep = 9, RULE_content = 10, RULE_question = 11, RULE_phrase = 12, 
		RULE_signal = 13, RULE_type = 14, RULE_end = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "survey", "id", "alphanumeric", "title", "obli", "wMessage", 
			"section", "otherId", "rep", "content", "question", "phrase", "signal", 
			"type", "end"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'mandatory'", "'optional'", "'condition dependent'", "'Free-text'", 
			"'Numeric'", "'Single-Choice with input value'", "'Single-Choice'", "'Multiple-Choice with input value'", 
			"'Multiple-Choice'", "'Sorting Options'", "'Scaling Options'", "'it means the person answers the question by typing some text.'", 
			"'it means the person answers the question by typing a numeric value.'", 
			"'it means the person answers the question by selection one (and just one) of the provided options.'", 
			"'very similar to the single choice but the last option, if selected, implies that the person must type a numeric value or a free text.'", 
			"'very similar to the single choice, but instead of selection just one, the answering person might select more than one.'", 
			"'very similar to the multiple choice, but the last option, if selected, implies that the person must type a numeric value or a free text.'", 
			"'given two or more option the person answers the question by sorting the options as desired and in accordance with the instructions provided.'", 
			"'it means the person answers the question by selecting a value of a given scale (e.g.: unimportant, neutral, important) to each of the specified options.'", 
			null, null, "' '", "','", "'.'", "'!'", "'?'", "'...'", "'-'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NEWLINE", "MANDATORY", "OPTIONAL", "CONDITION_DEPENDENT", "FREE_TEXT", 
			"NUMERIC", "SINGLE_CHOICE_INPUT", "SINGLE_CHOICE", "MULTIPLE_CHOICE_INPUT", 
			"MULTIPLE_CHOICE", "SORTING_OPTIONS", "SCALING_OPTIONS", "FT_TEXT", "NUM_TEXT", 
			"SC_TEXT", "SCI_TEXT", "MC_TEXT", "MCI_TEXT", "SO_TEXT", "SCO_TEXT", 
			"INT", "WORD", "SPACE", "COMMA", "DOT", "EXCL", "INTE", "ELLIP", "HIFFEN", 
			"FIM"
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
	public String getGrammarFileName() { return "Survey.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SurveyParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public SurveyContext survey() {
			return getRuleContext(SurveyContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor) return ((SurveyVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			survey();
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

	public static class SurveyContext extends ParserRuleContext {
		public SurveyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_survey; }
	 
		public SurveyContext() { }
		public void copyFrom(SurveyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SurveysContext extends SurveyContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public List<EndContext> end() {
			return getRuleContexts(EndContext.class);
		}
		public EndContext end(int i) {
			return getRuleContext(EndContext.class,i);
		}
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public List<WMessageContext> wMessage() {
			return getRuleContexts(WMessageContext.class);
		}
		public WMessageContext wMessage(int i) {
			return getRuleContext(WMessageContext.class,i);
		}
		public List<SectionContext> section() {
			return getRuleContexts(SectionContext.class);
		}
		public SectionContext section(int i) {
			return getRuleContext(SectionContext.class,i);
		}
		public SurveysContext(SurveyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).enterSurveys(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).exitSurveys(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor) return ((SurveyVisitor<? extends T>)visitor).visitSurveys(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SurveyContext survey() throws RecognitionException {
		SurveyContext _localctx = new SurveyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_survey);
		int _la;
		try {
			int _alt;
			_localctx = new SurveysContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			id();
			setState(35);
			end();
			setState(36);
			title();
			setState(37);
			end();
			setState(39);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(38);
				wMessage();
				}
				break;
			}
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEWLINE) | (1L << DOT) | (1L << FIM))) != 0)) {
				{
				setState(41);
				end();
				}
			}

			setState(45); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(44);
					section();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(47); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
			setState(49);
			wMessage();
			setState(50);
			end();
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

	public static class IdContext extends ParserRuleContext {
		public List<AlphanumericContext> alphanumeric() {
			return getRuleContexts(AlphanumericContext.class);
		}
		public AlphanumericContext alphanumeric(int i) {
			return getRuleContext(AlphanumericContext.class,i);
		}
		public TerminalNode HIFFEN() { return getToken(SurveyParser.HIFFEN, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor) return ((SurveyVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_id);
		int _la;
		try {
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(53); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(52);
					alphanumeric();
					}
					}
					setState(55); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==INT || _la==WORD );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(58); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(57);
					alphanumeric();
					}
					}
					setState(60); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==INT || _la==WORD );
				setState(62);
				match(HIFFEN);
				setState(64); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(63);
					alphanumeric();
					}
					}
					setState(66); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==INT || _la==WORD );
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

	public static class AlphanumericContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(SurveyParser.INT, 0); }
		public TerminalNode WORD() { return getToken(SurveyParser.WORD, 0); }
		public AlphanumericContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alphanumeric; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).enterAlphanumeric(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).exitAlphanumeric(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor) return ((SurveyVisitor<? extends T>)visitor).visitAlphanumeric(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlphanumericContext alphanumeric() throws RecognitionException {
		AlphanumericContext _localctx = new AlphanumericContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_alphanumeric);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
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

	public static class TitleContext extends ParserRuleContext {
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public TitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_title; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).enterTitle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).exitTitle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor) return ((SurveyVisitor<? extends T>)visitor).visitTitle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TitleContext title() throws RecognitionException {
		TitleContext _localctx = new TitleContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_title);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			phrase();
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

	public static class ObliContext extends ParserRuleContext {
		public TerminalNode MANDATORY() { return getToken(SurveyParser.MANDATORY, 0); }
		public TerminalNode OPTIONAL() { return getToken(SurveyParser.OPTIONAL, 0); }
		public TerminalNode CONDITION_DEPENDENT() { return getToken(SurveyParser.CONDITION_DEPENDENT, 0); }
		public ObliContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_obli; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).enterObli(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).exitObli(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor) return ((SurveyVisitor<? extends T>)visitor).visitObli(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObliContext obli() throws RecognitionException {
		ObliContext _localctx = new ObliContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_obli);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MANDATORY) | (1L << OPTIONAL) | (1L << CONDITION_DEPENDENT))) != 0)) ) {
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

	public static class WMessageContext extends ParserRuleContext {
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
		public WMessageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wMessage; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).enterWMessage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).exitWMessage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor) return ((SurveyVisitor<? extends T>)visitor).visitWMessage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WMessageContext wMessage() throws RecognitionException {
		WMessageContext _localctx = new WMessageContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_wMessage);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(79); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(76);
					phrase();
					setState(77);
					signal();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(81); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
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

	public static class SectionContext extends ParserRuleContext {
		public OtherIdContext otherId() {
			return getRuleContext(OtherIdContext.class,0);
		}
		public List<EndContext> end() {
			return getRuleContexts(EndContext.class);
		}
		public EndContext end(int i) {
			return getRuleContext(EndContext.class,i);
		}
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public ObliContext obli() {
			return getRuleContext(ObliContext.class,0);
		}
		public WMessageContext wMessage() {
			return getRuleContext(WMessageContext.class,0);
		}
		public RepContext rep() {
			return getRuleContext(RepContext.class,0);
		}
		public List<ContentContext> content() {
			return getRuleContexts(ContentContext.class);
		}
		public ContentContext content(int i) {
			return getRuleContext(ContentContext.class,i);
		}
		public SectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).enterSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).exitSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor) return ((SurveyVisitor<? extends T>)visitor).visitSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SectionContext section() throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_section);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			otherId();
			setState(84);
			end();
			setState(85);
			title();
			setState(86);
			end();
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INT || _la==WORD) {
				{
				setState(87);
				wMessage();
				}
			}

			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEWLINE) | (1L << DOT) | (1L << FIM))) != 0)) {
				{
				setState(90);
				end();
				}
			}

			setState(93);
			obli();
			setState(94);
			end();
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(95);
				rep();
				}
				break;
			}
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEWLINE) | (1L << DOT) | (1L << FIM))) != 0)) {
				{
				setState(98);
				end();
				}
			}

			setState(102); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(101);
					content();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(104); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
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
		public TerminalNode INT() { return getToken(SurveyParser.INT, 0); }
		public OtherIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_otherId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).enterOtherId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).exitOtherId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor) return ((SurveyVisitor<? extends T>)visitor).visitOtherId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OtherIdContext otherId() throws RecognitionException {
		OtherIdContext _localctx = new OtherIdContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_otherId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
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

	public static class RepContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(SurveyParser.INT, 0); }
		public RepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).enterRep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).exitRep(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor) return ((SurveyVisitor<? extends T>)visitor).visitRep(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepContext rep() throws RecognitionException {
		RepContext _localctx = new RepContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_rep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
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

	public static class ContentContext extends ParserRuleContext {
		public OtherIdContext otherId() {
			return getRuleContext(OtherIdContext.class,0);
		}
		public List<EndContext> end() {
			return getRuleContexts(EndContext.class);
		}
		public EndContext end(int i) {
			return getRuleContext(EndContext.class,i);
		}
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public WMessageContext wMessage() {
			return getRuleContext(WMessageContext.class,0);
		}
		public ContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).enterContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).exitContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor) return ((SurveyVisitor<? extends T>)visitor).visitContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContentContext content() throws RecognitionException {
		ContentContext _localctx = new ContentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			otherId();
			setState(111);
			end();
			setState(112);
			question();
			setState(113);
			end();
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INT || _la==WORD) {
				{
				setState(114);
				wMessage();
				}
			}

			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEWLINE) | (1L << DOT) | (1L << FIM))) != 0)) {
				{
				setState(117);
				end();
				}
			}

			setState(120);
			type();
			setState(121);
			end();
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

	public static class QuestionContext extends ParserRuleContext {
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public TerminalNode INTE() { return getToken(SurveyParser.INTE, 0); }
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor) return ((SurveyVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			phrase();
			setState(124);
			match(INTE);
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
		public List<TerminalNode> WORD() { return getTokens(SurveyParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(SurveyParser.WORD, i);
		}
		public List<TerminalNode> INT() { return getTokens(SurveyParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(SurveyParser.INT, i);
		}
		public List<TerminalNode> SPACE() { return getTokens(SurveyParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(SurveyParser.SPACE, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SurveyParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SurveyParser.COMMA, i);
		}
		public PhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).enterPhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).exitPhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor) return ((SurveyVisitor<? extends T>)visitor).visitPhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PhraseContext phrase() throws RecognitionException {
		PhraseContext _localctx = new PhraseContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_phrase);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==WORD) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(134);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(128);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(127);
						match(COMMA);
						}
					}

					setState(130);
					match(SPACE);
					setState(131);
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
				setState(136);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
		public TerminalNode COMMA() { return getToken(SurveyParser.COMMA, 0); }
		public TerminalNode ELLIP() { return getToken(SurveyParser.ELLIP, 0); }
		public TerminalNode DOT() { return getToken(SurveyParser.DOT, 0); }
		public TerminalNode INTE() { return getToken(SurveyParser.INTE, 0); }
		public TerminalNode EXCL() { return getToken(SurveyParser.EXCL, 0); }
		public SignalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).enterSignal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).exitSignal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor) return ((SurveyVisitor<? extends T>)visitor).visitSignal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignalContext signal() throws RecognitionException {
		SignalContext _localctx = new SignalContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_signal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode FREE_TEXT() { return getToken(SurveyParser.FREE_TEXT, 0); }
		public List<EndContext> end() {
			return getRuleContexts(EndContext.class);
		}
		public EndContext end(int i) {
			return getRuleContext(EndContext.class,i);
		}
		public ObliContext obli() {
			return getRuleContext(ObliContext.class,0);
		}
		public TerminalNode FT_TEXT() { return getToken(SurveyParser.FT_TEXT, 0); }
		public TerminalNode NUMERIC() { return getToken(SurveyParser.NUMERIC, 0); }
		public TerminalNode NUM_TEXT() { return getToken(SurveyParser.NUM_TEXT, 0); }
		public TerminalNode SINGLE_CHOICE() { return getToken(SurveyParser.SINGLE_CHOICE, 0); }
		public TerminalNode SC_TEXT() { return getToken(SurveyParser.SC_TEXT, 0); }
		public TerminalNode SINGLE_CHOICE_INPUT() { return getToken(SurveyParser.SINGLE_CHOICE_INPUT, 0); }
		public TerminalNode SCI_TEXT() { return getToken(SurveyParser.SCI_TEXT, 0); }
		public TerminalNode MULTIPLE_CHOICE() { return getToken(SurveyParser.MULTIPLE_CHOICE, 0); }
		public TerminalNode MC_TEXT() { return getToken(SurveyParser.MC_TEXT, 0); }
		public TerminalNode MULTIPLE_CHOICE_INPUT() { return getToken(SurveyParser.MULTIPLE_CHOICE_INPUT, 0); }
		public TerminalNode MCI_TEXT() { return getToken(SurveyParser.MCI_TEXT, 0); }
		public TerminalNode SORTING_OPTIONS() { return getToken(SurveyParser.SORTING_OPTIONS, 0); }
		public TerminalNode SO_TEXT() { return getToken(SurveyParser.SO_TEXT, 0); }
		public TerminalNode SCALING_OPTIONS() { return getToken(SurveyParser.SCALING_OPTIONS, 0); }
		public TerminalNode SCO_TEXT() { return getToken(SurveyParser.SCO_TEXT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor) return ((SurveyVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_type);
		try {
			setState(187);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FREE_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				match(FREE_TEXT);
				setState(140);
				end();
				setState(141);
				obli();
				setState(142);
				end();
				setState(143);
				match(FT_TEXT);
				}
				break;
			case NUMERIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				match(NUMERIC);
				setState(146);
				end();
				setState(147);
				obli();
				setState(148);
				end();
				setState(149);
				match(NUM_TEXT);
				}
				break;
			case SINGLE_CHOICE:
				enterOuterAlt(_localctx, 3);
				{
				setState(151);
				match(SINGLE_CHOICE);
				setState(152);
				end();
				setState(153);
				obli();
				setState(154);
				end();
				setState(155);
				match(SC_TEXT);
				}
				break;
			case SINGLE_CHOICE_INPUT:
				enterOuterAlt(_localctx, 4);
				{
				setState(157);
				match(SINGLE_CHOICE_INPUT);
				setState(158);
				end();
				setState(159);
				obli();
				setState(160);
				end();
				setState(161);
				match(SCI_TEXT);
				}
				break;
			case MULTIPLE_CHOICE:
				enterOuterAlt(_localctx, 5);
				{
				setState(163);
				match(MULTIPLE_CHOICE);
				setState(164);
				end();
				setState(165);
				obli();
				setState(166);
				end();
				setState(167);
				match(MC_TEXT);
				}
				break;
			case MULTIPLE_CHOICE_INPUT:
				enterOuterAlt(_localctx, 6);
				{
				setState(169);
				match(MULTIPLE_CHOICE_INPUT);
				setState(170);
				end();
				setState(171);
				obli();
				setState(172);
				end();
				setState(173);
				match(MCI_TEXT);
				}
				break;
			case SORTING_OPTIONS:
				enterOuterAlt(_localctx, 7);
				{
				setState(175);
				match(SORTING_OPTIONS);
				setState(176);
				end();
				setState(177);
				obli();
				setState(178);
				end();
				setState(179);
				match(SO_TEXT);
				}
				break;
			case SCALING_OPTIONS:
				enterOuterAlt(_localctx, 8);
				{
				setState(181);
				match(SCALING_OPTIONS);
				setState(182);
				end();
				setState(183);
				obli();
				setState(184);
				end();
				setState(185);
				match(SCO_TEXT);
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
		public TerminalNode FIM() { return getToken(SurveyParser.FIM, 0); }
		public TerminalNode NEWLINE() { return getToken(SurveyParser.NEWLINE, 0); }
		public TerminalNode DOT() { return getToken(SurveyParser.DOT, 0); }
		public EndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_end; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).enterEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyListener) ((SurveyListener)listener).exitEnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyVisitor) return ((SurveyVisitor<? extends T>)visitor).visitEnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EndContext end() throws RecognitionException {
		EndContext _localctx = new EndContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_end);
		try {
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				match(FIM);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				match(NEWLINE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(191);
				match(FIM);
				setState(192);
				match(NEWLINE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(193);
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
		"\u0004\u0001\u001e\u00c5\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001(\b\u0001\u0001\u0001\u0003\u0001+\b\u0001"+
		"\u0001\u0001\u0004\u0001.\b\u0001\u000b\u0001\f\u0001/\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0004\u00026\b\u0002\u000b\u0002\f\u0002"+
		"7\u0001\u0002\u0004\u0002;\b\u0002\u000b\u0002\f\u0002<\u0001\u0002\u0001"+
		"\u0002\u0004\u0002A\b\u0002\u000b\u0002\f\u0002B\u0003\u0002E\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0004\u0006P\b\u0006\u000b\u0006"+
		"\f\u0006Q\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0003\u0007Y\b\u0007\u0001\u0007\u0003\u0007\\\b\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007a\b\u0007\u0001\u0007\u0003\u0007d\b\u0007"+
		"\u0001\u0007\u0004\u0007g\b\u0007\u000b\u0007\f\u0007h\u0001\b\u0001\b"+
		"\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\nt\b\n"+
		"\u0001\n\u0003\nw\b\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0003\f\u0081\b\f\u0001\f\u0001\f\u0005\f"+
		"\u0085\b\f\n\f\f\f\u0088\t\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00bc\b\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00c3"+
		"\b\u000f\u0001\u000f\u0000\u0000\u0010\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e\u0000\u0003\u0001\u0000"+
		"\u0015\u0016\u0001\u0000\u0002\u0004\u0001\u0000\u0018\u001c\u00cf\u0000"+
		" \u0001\u0000\u0000\u0000\u0002\"\u0001\u0000\u0000\u0000\u0004D\u0001"+
		"\u0000\u0000\u0000\u0006F\u0001\u0000\u0000\u0000\bH\u0001\u0000\u0000"+
		"\u0000\nJ\u0001\u0000\u0000\u0000\fO\u0001\u0000\u0000\u0000\u000eS\u0001"+
		"\u0000\u0000\u0000\u0010j\u0001\u0000\u0000\u0000\u0012l\u0001\u0000\u0000"+
		"\u0000\u0014n\u0001\u0000\u0000\u0000\u0016{\u0001\u0000\u0000\u0000\u0018"+
		"~\u0001\u0000\u0000\u0000\u001a\u0089\u0001\u0000\u0000\u0000\u001c\u00bb"+
		"\u0001\u0000\u0000\u0000\u001e\u00c2\u0001\u0000\u0000\u0000 !\u0003\u0002"+
		"\u0001\u0000!\u0001\u0001\u0000\u0000\u0000\"#\u0003\u0004\u0002\u0000"+
		"#$\u0003\u001e\u000f\u0000$%\u0003\b\u0004\u0000%\'\u0003\u001e\u000f"+
		"\u0000&(\u0003\f\u0006\u0000\'&\u0001\u0000\u0000\u0000\'(\u0001\u0000"+
		"\u0000\u0000(*\u0001\u0000\u0000\u0000)+\u0003\u001e\u000f\u0000*)\u0001"+
		"\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000+-\u0001\u0000\u0000\u0000"+
		",.\u0003\u000e\u0007\u0000-,\u0001\u0000\u0000\u0000./\u0001\u0000\u0000"+
		"\u0000/-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u000001\u0001\u0000"+
		"\u0000\u000012\u0003\f\u0006\u000023\u0003\u001e\u000f\u00003\u0003\u0001"+
		"\u0000\u0000\u000046\u0003\u0006\u0003\u000054\u0001\u0000\u0000\u0000"+
		"67\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u000078\u0001\u0000\u0000"+
		"\u00008E\u0001\u0000\u0000\u00009;\u0003\u0006\u0003\u0000:9\u0001\u0000"+
		"\u0000\u0000;<\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000<=\u0001"+
		"\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>@\u0005\u001d\u0000\u0000"+
		"?A\u0003\u0006\u0003\u0000@?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000"+
		"\u0000B@\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000CE\u0001\u0000"+
		"\u0000\u0000D5\u0001\u0000\u0000\u0000D:\u0001\u0000\u0000\u0000E\u0005"+
		"\u0001\u0000\u0000\u0000FG\u0007\u0000\u0000\u0000G\u0007\u0001\u0000"+
		"\u0000\u0000HI\u0003\u0018\f\u0000I\t\u0001\u0000\u0000\u0000JK\u0007"+
		"\u0001\u0000\u0000K\u000b\u0001\u0000\u0000\u0000LM\u0003\u0018\f\u0000"+
		"MN\u0003\u001a\r\u0000NP\u0001\u0000\u0000\u0000OL\u0001\u0000\u0000\u0000"+
		"PQ\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000"+
		"\u0000R\r\u0001\u0000\u0000\u0000ST\u0003\u0010\b\u0000TU\u0003\u001e"+
		"\u000f\u0000UV\u0003\b\u0004\u0000VX\u0003\u001e\u000f\u0000WY\u0003\f"+
		"\u0006\u0000XW\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000Y[\u0001"+
		"\u0000\u0000\u0000Z\\\u0003\u001e\u000f\u0000[Z\u0001\u0000\u0000\u0000"+
		"[\\\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]^\u0003\n\u0005"+
		"\u0000^`\u0003\u001e\u000f\u0000_a\u0003\u0012\t\u0000`_\u0001\u0000\u0000"+
		"\u0000`a\u0001\u0000\u0000\u0000ac\u0001\u0000\u0000\u0000bd\u0003\u001e"+
		"\u000f\u0000cb\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000df\u0001"+
		"\u0000\u0000\u0000eg\u0003\u0014\n\u0000fe\u0001\u0000\u0000\u0000gh\u0001"+
		"\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000"+
		"i\u000f\u0001\u0000\u0000\u0000jk\u0005\u0015\u0000\u0000k\u0011\u0001"+
		"\u0000\u0000\u0000lm\u0005\u0015\u0000\u0000m\u0013\u0001\u0000\u0000"+
		"\u0000no\u0003\u0010\b\u0000op\u0003\u001e\u000f\u0000pq\u0003\u0016\u000b"+
		"\u0000qs\u0003\u001e\u000f\u0000rt\u0003\f\u0006\u0000sr\u0001\u0000\u0000"+
		"\u0000st\u0001\u0000\u0000\u0000tv\u0001\u0000\u0000\u0000uw\u0003\u001e"+
		"\u000f\u0000vu\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wx\u0001"+
		"\u0000\u0000\u0000xy\u0003\u001c\u000e\u0000yz\u0003\u001e\u000f\u0000"+
		"z\u0015\u0001\u0000\u0000\u0000{|\u0003\u0018\f\u0000|}\u0005\u001b\u0000"+
		"\u0000}\u0017\u0001\u0000\u0000\u0000~\u0086\u0007\u0000\u0000\u0000\u007f"+
		"\u0081\u0005\u0018\u0000\u0000\u0080\u007f\u0001\u0000\u0000\u0000\u0080"+
		"\u0081\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082"+
		"\u0083\u0005\u0017\u0000\u0000\u0083\u0085\u0007\u0000\u0000\u0000\u0084"+
		"\u0080\u0001\u0000\u0000\u0000\u0085\u0088\u0001\u0000\u0000\u0000\u0086"+
		"\u0084\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087"+
		"\u0019\u0001\u0000\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0089"+
		"\u008a\u0007\u0002\u0000\u0000\u008a\u001b\u0001\u0000\u0000\u0000\u008b"+
		"\u008c\u0005\u0005\u0000\u0000\u008c\u008d\u0003\u001e\u000f\u0000\u008d"+
		"\u008e\u0003\n\u0005\u0000\u008e\u008f\u0003\u001e\u000f\u0000\u008f\u0090"+
		"\u0005\r\u0000\u0000\u0090\u00bc\u0001\u0000\u0000\u0000\u0091\u0092\u0005"+
		"\u0006\u0000\u0000\u0092\u0093\u0003\u001e\u000f\u0000\u0093\u0094\u0003"+
		"\n\u0005\u0000\u0094\u0095\u0003\u001e\u000f\u0000\u0095\u0096\u0005\u000e"+
		"\u0000\u0000\u0096\u00bc\u0001\u0000\u0000\u0000\u0097\u0098\u0005\b\u0000"+
		"\u0000\u0098\u0099\u0003\u001e\u000f\u0000\u0099\u009a\u0003\n\u0005\u0000"+
		"\u009a\u009b\u0003\u001e\u000f\u0000\u009b\u009c\u0005\u000f\u0000\u0000"+
		"\u009c\u00bc\u0001\u0000\u0000\u0000\u009d\u009e\u0005\u0007\u0000\u0000"+
		"\u009e\u009f\u0003\u001e\u000f\u0000\u009f\u00a0\u0003\n\u0005\u0000\u00a0"+
		"\u00a1\u0003\u001e\u000f\u0000\u00a1\u00a2\u0005\u0010\u0000\u0000\u00a2"+
		"\u00bc\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005\n\u0000\u0000\u00a4\u00a5"+
		"\u0003\u001e\u000f\u0000\u00a5\u00a6\u0003\n\u0005\u0000\u00a6\u00a7\u0003"+
		"\u001e\u000f\u0000\u00a7\u00a8\u0005\u0011\u0000\u0000\u00a8\u00bc\u0001"+
		"\u0000\u0000\u0000\u00a9\u00aa\u0005\t\u0000\u0000\u00aa\u00ab\u0003\u001e"+
		"\u000f\u0000\u00ab\u00ac\u0003\n\u0005\u0000\u00ac\u00ad\u0003\u001e\u000f"+
		"\u0000\u00ad\u00ae\u0005\u0012\u0000\u0000\u00ae\u00bc\u0001\u0000\u0000"+
		"\u0000\u00af\u00b0\u0005\u000b\u0000\u0000\u00b0\u00b1\u0003\u001e\u000f"+
		"\u0000\u00b1\u00b2\u0003\n\u0005\u0000\u00b2\u00b3\u0003\u001e\u000f\u0000"+
		"\u00b3\u00b4\u0005\u0013\u0000\u0000\u00b4\u00bc\u0001\u0000\u0000\u0000"+
		"\u00b5\u00b6\u0005\f\u0000\u0000\u00b6\u00b7\u0003\u001e\u000f\u0000\u00b7"+
		"\u00b8\u0003\n\u0005\u0000\u00b8\u00b9\u0003\u001e\u000f\u0000\u00b9\u00ba"+
		"\u0005\u0014\u0000\u0000\u00ba\u00bc\u0001\u0000\u0000\u0000\u00bb\u008b"+
		"\u0001\u0000\u0000\u0000\u00bb\u0091\u0001\u0000\u0000\u0000\u00bb\u0097"+
		"\u0001\u0000\u0000\u0000\u00bb\u009d\u0001\u0000\u0000\u0000\u00bb\u00a3"+
		"\u0001\u0000\u0000\u0000\u00bb\u00a9\u0001\u0000\u0000\u0000\u00bb\u00af"+
		"\u0001\u0000\u0000\u0000\u00bb\u00b5\u0001\u0000\u0000\u0000\u00bc\u001d"+
		"\u0001\u0000\u0000\u0000\u00bd\u00c3\u0005\u001e\u0000\u0000\u00be\u00c3"+
		"\u0005\u0001\u0000\u0000\u00bf\u00c0\u0005\u001e\u0000\u0000\u00c0\u00c3"+
		"\u0005\u0001\u0000\u0000\u00c1\u00c3\u0005\u0019\u0000\u0000\u00c2\u00bd"+
		"\u0001\u0000\u0000\u0000\u00c2\u00be\u0001\u0000\u0000\u0000\u00c2\u00bf"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c1\u0001\u0000\u0000\u0000\u00c3\u001f"+
		"\u0001\u0000\u0000\u0000\u0013\'*/7<BDQX[`chsv\u0080\u0086\u00bb\u00c2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}