// Generated from C:/Users/Pedro/Desktop/Universidade-ISEP/2ANO/2� Semestre/LAPR4/Projeto Java/base.core/src/main/java/eapli/base/surveymanagement/application\Survey.g4 by ANTLR 4.10.1
package eapli.base.surveymanagement.application.eapli.base.surveymanagement.application;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SurveyParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SurveyVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SurveyParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(SurveyParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code surveys}
	 * labeled alternative in {@link SurveyParser#survey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSurveys(SurveyParser.SurveysContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(SurveyParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyParser#alphanumeric}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlphanumeric(SurveyParser.AlphanumericContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyParser#title}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTitle(SurveyParser.TitleContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyParser#obli}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObli(SurveyParser.ObliContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyParser#wMessage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWMessage(SurveyParser.WMessageContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyParser#section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSection(SurveyParser.SectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyParser#otherId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOtherId(SurveyParser.OtherIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyParser#rep}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRep(SurveyParser.RepContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent(SurveyParser.ContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(SurveyParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyParser#phrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhrase(SurveyParser.PhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyParser#signal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignal(SurveyParser.SignalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(SurveyParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SurveyParser#end}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnd(SurveyParser.EndContext ctx);
}