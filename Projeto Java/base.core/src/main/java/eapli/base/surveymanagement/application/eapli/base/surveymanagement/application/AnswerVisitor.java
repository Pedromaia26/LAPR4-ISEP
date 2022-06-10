// Generated from C:/Users/Pedro/Desktop/Universidade-ISEP/2ANO/2� Semestre/PROJETO/Projeto Java/base.core/src/main/java/eapli/base/surveymanagement/application\Answer.g4 by ANTLR 4.10.1
package eapli.base.surveymanagement.application.eapli.base.surveymanagement.application;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AnswerParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AnswerVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AnswerParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(AnswerParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code answers}
	 * labeled alternative in {@link AnswerParser#answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswers(AnswerParser.AnswersContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerParser#alphanumeric}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlphanumeric(AnswerParser.AlphanumericContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerParser#otherId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOtherId(AnswerParser.OtherIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerParser#phrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhrase(AnswerParser.PhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerParser#signal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignal(AnswerParser.SignalContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption(AnswerParser.OptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(AnswerParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(AnswerParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnswerParser#end}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnd(AnswerParser.EndContext ctx);
}