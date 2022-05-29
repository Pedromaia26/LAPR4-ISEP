package eapli.base.surveymanagement.domain;

import eapli.base.Warehouse.domain.*;
import eapli.base.Warehouse.domain.Section;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.CategoryCode;
import eapli.base.categorymanagement.domain.CategoryDescription;
import eapli.base.productmanagement.domain.*;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class QuestionTest {

    private static final String IDENTIFIER = "Question 1";
    private static final String QUESTION_TEXT = "Please rate our products quality";
    private static final String INSTRUCTION_MESSAGE = "Please rate from 1 to 5";
    private static final String VERIFY_QUESTION_TYPE = "Single-Choice";
    private static final String VERIFY_OBLIGATORINESS = "Mandatory";
    private static final String EXTRA_INFO = "Thank you for answering!";


    @Test
    public void ensureQuestionWithAllAttributes() {
        new Question(new Identifier(IDENTIFIER), new QuestionText(QUESTION_TEXT), new Message(INSTRUCTION_MESSAGE),
                new VerifyQuestionType(VERIFY_QUESTION_TYPE), new VerifyObligatoriness(VERIFY_OBLIGATORINESS),
        new Message(EXTRA_INFO));
        assertTrue(true);
    }

    @Test
    public void ensureQuestionWithoutInstructionMessage() {
        new Question(new Identifier(IDENTIFIER), new QuestionText(QUESTION_TEXT),
                new VerifyQuestionType(VERIFY_QUESTION_TYPE), new VerifyObligatoriness(VERIFY_OBLIGATORINESS),
                new Message(EXTRA_INFO));
        assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveIdentifier() {
        new Question(null, new QuestionText(QUESTION_TEXT), new Message(INSTRUCTION_MESSAGE),
                new VerifyQuestionType(VERIFY_QUESTION_TYPE), new VerifyObligatoriness(VERIFY_OBLIGATORINESS),
                new Message(EXTRA_INFO));
    }

    @Test
    public void ensureCanChangeIdentifier() throws IOException {
        final Question question = new Question(new Identifier(IDENTIFIER), new QuestionText(QUESTION_TEXT), new Message(INSTRUCTION_MESSAGE),
                new VerifyQuestionType(VERIFY_QUESTION_TYPE), new VerifyObligatoriness(VERIFY_OBLIGATORINESS),
                new Message(EXTRA_INFO));

        final Identifier identifier = new Identifier("Question 2");

        question.modifyId(identifier);

        assertEquals(identifier, question.identifier());
    }



    @Test
    public void ensureCanChangeQuestionText() throws IOException {
        final Question question = new Question(new Identifier(IDENTIFIER), new QuestionText(QUESTION_TEXT), new Message(INSTRUCTION_MESSAGE),
                new VerifyQuestionType(VERIFY_QUESTION_TYPE), new VerifyObligatoriness(VERIFY_OBLIGATORINESS),
                new Message(EXTRA_INFO));

        final QuestionText questionText = new QuestionText("Please rate our personnel service");

        question.modifyQuestionText(questionText);

        assertEquals(questionText, question.QuestionText());
    }

    @Test
    public void ensureCanChangeInstructionMessage() throws IOException {
        final Question question = new Question(new Identifier(IDENTIFIER), new QuestionText(QUESTION_TEXT), new Message(INSTRUCTION_MESSAGE),
                new VerifyQuestionType(VERIFY_QUESTION_TYPE), new VerifyObligatoriness(VERIFY_OBLIGATORINESS),
                new Message(EXTRA_INFO));

        final Message instructionMessage = new Message("We greatly appreciate your feedback");

        question.modifyInstruction(instructionMessage);

        assertEquals(instructionMessage, question.Instruction());
    }

    @Test
    public void ensureCanChangeQuestionType() throws IOException {
        final Question question = new Question(new Identifier(IDENTIFIER), new QuestionText(QUESTION_TEXT), new Message(INSTRUCTION_MESSAGE),
                new VerifyQuestionType(VERIFY_QUESTION_TYPE), new VerifyObligatoriness(VERIFY_OBLIGATORINESS),
                new Message(EXTRA_INFO));

        final VerifyQuestionType questionType = new VerifyQuestionType("Free-text");

        question.modifyVerifyQuestionType(questionType);

        assertEquals(questionType, question.QuestionType());
    }


    @Test
    public void ensureCanChangeObligatorinessType() throws IOException {
        final Question question = new Question(new Identifier(IDENTIFIER), new QuestionText(QUESTION_TEXT), new Message(INSTRUCTION_MESSAGE),
                new VerifyQuestionType(VERIFY_QUESTION_TYPE), new VerifyObligatoriness(VERIFY_OBLIGATORINESS),
                new Message(EXTRA_INFO));

        final VerifyObligatoriness obligatoriness = new VerifyObligatoriness("optional");

        question.modifyVerifyObligatoriness(obligatoriness);

        assertEquals(obligatoriness, question.Obligatoriness());
    }

    @Test
    public void ensureCanChangeExtraMessage() throws IOException {
        final Question question = new Question(new Identifier(IDENTIFIER), new QuestionText(QUESTION_TEXT), new Message(INSTRUCTION_MESSAGE),
                new VerifyQuestionType(VERIFY_QUESTION_TYPE), new VerifyObligatoriness(VERIFY_OBLIGATORINESS),
                new Message(EXTRA_INFO));

        final Message extraInfo = new Message("Thank you!");

        question.modifyExtraInfo(extraInfo);

        assertEquals(extraInfo, question.ExtraInfo());
    }
}