package eapli.base.surveymanagement.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class SurveyIdentifierTest {

    private static final String SURVEY_IDENTIFIER = "product_satisfaction1";

    @Test(expected = IllegalArgumentException.class)
    public void ensureSurveyIdentifierMustBeLessThan30() {
        new SurveyIdentifier("product_and_personnel_satisfaction123");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureSurveyIdentifierMustBeNotEmpty() {
        new SurveyIdentifier("");
    }

    @Test
    public void ensureSurveyIdentifierHasRightValue() {
        final SurveyIdentifier instance = new SurveyIdentifier(SURVEY_IDENTIFIER);
        assertEquals(SURVEY_IDENTIFIER, instance.toString());
    }

    @Test
    public void testEquals() {
        final SurveyIdentifier instance = new SurveyIdentifier(SURVEY_IDENTIFIER);
        String surveyIdentifer = "product_satisfaction1";
        SurveyIdentifier instance2 = new SurveyIdentifier(surveyIdentifer);

        assertEquals(instance, instance2);
    }

    @Test
    public void testToString() {
        final SurveyIdentifier instance = new SurveyIdentifier(SURVEY_IDENTIFIER);
        String expected = "product_satisfaction1";

        assertEquals(expected, instance.toString());
    }

}