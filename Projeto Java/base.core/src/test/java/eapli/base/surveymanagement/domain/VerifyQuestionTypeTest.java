package eapli.base.surveymanagement.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class VerifyQuestionTypeTest {

    private static final String QUESTION_TYPE1 = "Free-text";
    private static final String QUESTION_TYPE2 = "Multiple-Choice";
    private static final String QUESTION_TYPE3 = "Multiple-Choice with input value";
    private static final String QUESTION_TYPE4 = "Numeric";
    private static final String QUESTION_TYPE5 = "Scaling Options";
    private static final String QUESTION_TYPE6 = "Single-Choice";
    private static final String QUESTION_TYPE7 = "Single-Choice with input value";
    private static final String QUESTION_TYPE8 = "Sorting Options";

    @Test
    public void ensureQuestionTypeCanBeEmpty() {
        VerifyQuestionType questionType = new VerifyQuestionType("");
        assertNull(questionType.questionType);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureQuestionTypeMustBeOneOfTheOption() {
        new VerifyQuestionType("Invalid Question Type");
    }

    @Test
    public void ensureObligatorinessHasRightValue() {
        final VerifyQuestionType instance1 = new VerifyQuestionType(QUESTION_TYPE1);
        final VerifyQuestionType instance2 = new VerifyQuestionType(QUESTION_TYPE2);
        final VerifyQuestionType instance3 = new VerifyQuestionType(QUESTION_TYPE3);
        final VerifyQuestionType instance4 = new VerifyQuestionType(QUESTION_TYPE4);
        final VerifyQuestionType instance5 = new VerifyQuestionType(QUESTION_TYPE5);
        final VerifyQuestionType instance6 = new VerifyQuestionType(QUESTION_TYPE6);
        final VerifyQuestionType instance7 = new VerifyQuestionType(QUESTION_TYPE7);
        final VerifyQuestionType instance8 = new VerifyQuestionType(QUESTION_TYPE8);
        assertEquals(QUESTION_TYPE1, instance1.questionType);
        assertEquals(QUESTION_TYPE2, instance2.questionType);
        assertEquals(QUESTION_TYPE3, instance3.questionType);
        assertEquals(QUESTION_TYPE4, instance4.questionType);
        assertEquals(QUESTION_TYPE5, instance5.questionType);
        assertEquals(QUESTION_TYPE6, instance6.questionType);
        assertEquals(QUESTION_TYPE7, instance7.questionType);
        assertEquals(QUESTION_TYPE8, instance8.questionType);
    }

    @Test
    public void testToString() {
        final VerifyQuestionType instance = new VerifyQuestionType(QUESTION_TYPE5);
        String expected = "Scaling Options";

        assertEquals(expected, instance.toString());
    }

}