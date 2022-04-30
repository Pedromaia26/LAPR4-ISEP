package eapli.base.clientusermanagement.domain;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class BirthdayTest {
    private static final String BIRTHDAY = "2001/01/30";

    @Test(expected = IllegalArgumentException.class)
    public void ensureBirthdayMustBeRightPattern() {
        new Birthday("2022/10/32");
    }

    @Test
    public void ensureBirthdayHasRightValue() {
        final Birthday instance = new Birthday(BIRTHDAY);
        String expected = "2001-01-31";
        assertEquals(expected, String.valueOf(instance.birthDate()));
    }
}