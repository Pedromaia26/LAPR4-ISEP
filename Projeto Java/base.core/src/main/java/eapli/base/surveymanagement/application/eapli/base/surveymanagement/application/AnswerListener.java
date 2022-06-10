// Generated from C:/Users/Pedro/Desktop/Universidade-ISEP/2ANO/2� Semestre/PROJETO/Projeto Java/base.core/src/main/java/eapli/base/surveymanagement/application\Answer.g4 by ANTLR 4.10.1
package eapli.base.surveymanagement.application.eapli.base.surveymanagement.application;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AnswerParser}.
 */
public interface AnswerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AnswerParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(AnswerParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(AnswerParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code answers}
	 * labeled alternative in {@link AnswerParser#answer}.
	 * @param ctx the parse tree
	 */
	void enterAnswers(AnswerParser.AnswersContext ctx);
	/**
	 * Exit a parse tree produced by the {@code answers}
	 * labeled alternative in {@link AnswerParser#answer}.
	 * @param ctx the parse tree
	 */
	void exitAnswers(AnswerParser.AnswersContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerParser#alphanumeric}.
	 * @param ctx the parse tree
	 */
	void enterAlphanumeric(AnswerParser.AlphanumericContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerParser#alphanumeric}.
	 * @param ctx the parse tree
	 */
	void exitAlphanumeric(AnswerParser.AlphanumericContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerParser#otherId}.
	 * @param ctx the parse tree
	 */
	void enterOtherId(AnswerParser.OtherIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerParser#otherId}.
	 * @param ctx the parse tree
	 */
	void exitOtherId(AnswerParser.OtherIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerParser#phrase}.
	 * @param ctx the parse tree
	 */
	void enterPhrase(AnswerParser.PhraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerParser#phrase}.
	 * @param ctx the parse tree
	 */
	void exitPhrase(AnswerParser.PhraseContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerParser#signal}.
	 * @param ctx the parse tree
	 */
	void enterSignal(AnswerParser.SignalContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerParser#signal}.
	 * @param ctx the parse tree
	 */
	void exitSignal(AnswerParser.SignalContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerParser#option}.
	 * @param ctx the parse tree
	 */
	void enterOption(AnswerParser.OptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerParser#option}.
	 * @param ctx the parse tree
	 */
	void exitOption(AnswerParser.OptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(AnswerParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(AnswerParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(AnswerParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(AnswerParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnswerParser#end}.
	 * @param ctx the parse tree
	 */
	void enterEnd(AnswerParser.EndContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnswerParser#end}.
	 * @param ctx the parse tree
	 */
	void exitEnd(AnswerParser.EndContext ctx);
}