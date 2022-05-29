package eapli.base.surveymanagement.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class SectionDescriptionTest {

    private static final String SECTION_DESCRIPTION_TEXT = "Section 1";

    @Test(expected = IllegalArgumentException.class)
    public void ensureSectionDescriptionTextMustBeLessThan50() {
        new SectionDescription("Section 1 - Service Quality Review (Personnel and Products Quality)\nSection 2 - Service Quality Review (Personnel and Products Quality)");
    }

    @Test
    public void ensureSectionDescriptionTextHasRightValue() {
        final SectionDescription instance = new SectionDescription(SECTION_DESCRIPTION_TEXT);
        assertEquals(SECTION_DESCRIPTION_TEXT, instance.toString());
    }

    @Test
    public void testEquals() {
        final SectionDescription instance = new SectionDescription(SECTION_DESCRIPTION_TEXT);
        String sectionDescription = "Section 1";
        SectionDescription instance2 = new SectionDescription(sectionDescription);

        assertEquals(instance, instance2);
    }

    @Test
    public void testToString() {
        final SectionDescription instance = new SectionDescription(SECTION_DESCRIPTION_TEXT);
        String expected = "Section 1";

        assertEquals(expected, instance.toString());
    }

}