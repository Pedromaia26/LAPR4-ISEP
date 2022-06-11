package eapli.base.surveymanagement.domain;

import eapli.base.productmanagement.domain.ExtendedDescription;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SurveySectionTest {

    private SurvSection SurvSectionBuild() {
        return new SurvSection(new Identifier("1"), new Title("Titulo"), new VerifyObligatoriness("mandatory"), new ArrayList<>());
    }


    @Test
    public void section() {
        SurvSection survSection = SurvSectionBuild();
        SurveySection surveySection = new SurveySection(survSection);


        assertEquals(survSection, surveySection.section());
    }
}