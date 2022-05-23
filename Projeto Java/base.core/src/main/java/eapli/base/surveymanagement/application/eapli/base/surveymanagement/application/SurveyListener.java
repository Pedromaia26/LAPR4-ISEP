// Generated from C:/Users/Pedro/Desktop/Universidade-ISEP/2ANO/2� Semestre/LAPR4/Projeto Java/base.core/src/main/java/eapli/base/surveymanagement/application\Survey.g4 by ANTLR 4.10.1
package eapli.base.surveymanagement.application.eapli.base.surveymanagement.application;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SurveyParser}.
 */
public interface SurveyListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SurveyParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(SurveyParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(SurveyParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code surveys}
	 * labeled alternative in {@link SurveyParser#survey}.
	 * @param ctx the parse tree
	 */
	void enterSurveys(SurveyParser.SurveysContext ctx);
	/**
	 * Exit a parse tree produced by the {@code surveys}
	 * labeled alternative in {@link SurveyParser#survey}.
	 * @param ctx the parse tree
	 */
	void exitSurveys(SurveyParser.SurveysContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(SurveyParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(SurveyParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyParser#alphanumeric}.
	 * @param ctx the parse tree
	 */
	void enterAlphanumeric(SurveyParser.AlphanumericContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyParser#alphanumeric}.
	 * @param ctx the parse tree
	 */
	void exitAlphanumeric(SurveyParser.AlphanumericContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyParser#title}.
	 * @param ctx the parse tree
	 */
	void enterTitle(SurveyParser.TitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyParser#title}.
	 * @param ctx the parse tree
	 */
	void exitTitle(SurveyParser.TitleContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyParser#obli}.
	 * @param ctx the parse tree
	 */
	void enterObli(SurveyParser.ObliContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyParser#obli}.
	 * @param ctx the parse tree
	 */
	void exitObli(SurveyParser.ObliContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyParser#wMessage}.
	 * @param ctx the parse tree
	 */
	void enterWMessage(SurveyParser.WMessageContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyParser#wMessage}.
	 * @param ctx the parse tree
	 */
	void exitWMessage(SurveyParser.WMessageContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyParser#section}.
	 * @param ctx the parse tree
	 */
	void enterSection(SurveyParser.SectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyParser#section}.
	 * @param ctx the parse tree
	 */
	void exitSection(SurveyParser.SectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyParser#otherId}.
	 * @param ctx the parse tree
	 */
	void enterOtherId(SurveyParser.OtherIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyParser#otherId}.
	 * @param ctx the parse tree
	 */
	void exitOtherId(SurveyParser.OtherIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyParser#rep}.
	 * @param ctx the parse tree
	 */
	void enterRep(SurveyParser.RepContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyParser#rep}.
	 * @param ctx the parse tree
	 */
	void exitRep(SurveyParser.RepContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyParser#content}.
	 * @param ctx the parse tree
	 */
	void enterContent(SurveyParser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyParser#content}.
	 * @param ctx the parse tree
	 */
	void exitContent(SurveyParser.ContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(SurveyParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(SurveyParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyParser#phrase}.
	 * @param ctx the parse tree
	 */
	void enterPhrase(SurveyParser.PhraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyParser#phrase}.
	 * @param ctx the parse tree
	 */
	void exitPhrase(SurveyParser.PhraseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyParser#signal}.
	 * @param ctx the parse tree
	 */
	void enterSignal(SurveyParser.SignalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyParser#signal}.
	 * @param ctx the parse tree
	 */
	void exitSignal(SurveyParser.SignalContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(SurveyParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(SurveyParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SurveyParser#end}.
	 * @param ctx the parse tree
	 */
	void enterEnd(SurveyParser.EndContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurveyParser#end}.
	 * @param ctx the parse tree
	 */
	void exitEnd(SurveyParser.EndContext ctx);
}