package eapli.base.surveymanagement.domain;

import eapli.base.productmanagement.domain.Barcode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    private static final String MESSAGE = "abcdefghijklmnopqrstuvwxyz123457890";

    @Test(expected = IllegalArgumentException.class)
    public void ensureMessageMustBeLessThan200() {
        new Message("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz" +
                "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz");
    }

    @Test
    public void ensureMessageHasRightValue() {
        final Message instance = new Message(MESSAGE);
        assertEquals(MESSAGE, instance.toString());
    }

    @Test
    public void testEquals() {
        final Message instance = new Message(MESSAGE);
        String message = "abcdefghijklmnopqrstuvwxyz123457890";
        Message instance2 = new Message(message);

        assertEquals(instance, instance2);
    }

    @Test
    public void testToString() {
        final Message instance = new Message(MESSAGE);
        String expected = "abcdefghijklmnopqrstuvwxyz123457890";

        assertEquals(expected, instance.toString());
    }

}