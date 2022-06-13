package eapli.base.surveymanagement.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class QuestionTextTest {

    private static final String QUESTION_TEXT = "Question 1";

    @Test(expected = IllegalArgumentException.class)
    public void ensureQuestionTextMustBeLessThan100() {
        new QuestionText("Question 1 - How do you rate the professionalism of our service personnel? This is a test length aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }

    @Test
    public void ensureQuestionTextHasRightValue() {
        final QuestionText instance = new QuestionText(QUESTION_TEXT);
        assertEquals(QUESTION_TEXT, instance.toString());
    }

    @Test
    public void testEquals() {
        final QuestionText instance = new QuestionText(QUESTION_TEXT);
        String questionText = "Question 1";
        QuestionText instance2 = new QuestionText(questionText);

        assertEquals(instance, instance2);
    }

    @Test
    public void testToString() {
        final QuestionText instance = new QuestionText(QUESTION_TEXT);
        String expected = "Question 1";

        assertEquals(expected, instance.toString());
    }
}