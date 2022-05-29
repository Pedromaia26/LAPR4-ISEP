package eapli.base.surveymanagement.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TitleTest {

    private static final String TITLE = "Product Satisfaction Survey";

    @Test(expected = IllegalArgumentException.class)
    public void ensureTitleMustBeLessThan30() {
        new Title("Product and Product Delivery Satisfaction Survey");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureTitleMustBeNotEmpty() {
        new Title("");
    }

    @Test
    public void ensureTitleHasRightValue() {
        final Title instance = new Title(TITLE);
        assertEquals(TITLE, instance.toString());
    }

    @Test
    public void testEquals() {
        final Title instance = new Title(TITLE);
        String title = "Product Satisfaction Survey";
        Title instance2 = new Title(title);

        assertEquals(instance, instance2);
    }

    @Test
    public void testToString() {
        final Title instance = new Title(TITLE);
        String expected = "Product Satisfaction Survey";

        assertEquals(expected, instance.toString());
    }


}