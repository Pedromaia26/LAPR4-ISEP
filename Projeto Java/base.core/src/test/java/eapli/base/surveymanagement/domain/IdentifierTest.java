package eapli.base.surveymanagement.domain;

import org.junit.Test;

import javax.persistence.Id;

import static org.junit.Assert.assertEquals;

public class IdentifierTest {

    private static final String IDENTIFIER = "abcde12345";

    @Test(expected = IllegalArgumentException.class)
    public void ensureIdentifierMustBeNotEmpty() {
        new Identifier("");
    }

    @Test
    public void ensureIdentifierHasRightValue() {
        final Identifier instance = new Identifier(IDENTIFIER);
        assertEquals(IDENTIFIER, instance.toString());
    }

    @Test
    public void testEquals() {
        final Identifier instance = new Identifier(IDENTIFIER);
        String id = "abcde12345";
        Identifier instance2 = new Identifier(id);

        assertEquals(instance, instance2);
    }

    @Test
    public void testToString() {
        final Identifier instance = new Identifier(IDENTIFIER);
        String expected = "abcde12345";

        assertEquals(expected, instance.toString());
    }
}