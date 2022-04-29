package eapli.base.clientusermanagement.domain;

import eapli.base.agvmanagement.domain.Autonomy;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class BirthdayTest {
    private static final String BIRTHDAY = "01/01/2001";

    @Test(expected = IllegalArgumentException.class)
    public void ensureBirthdayMustBeRightPattern() {
        new Birthday("10");
    }

    @Test
    public void ensureBirthdayHasRightValue() {
        final Birthday instance = new Birthday(BIRTHDAY);
        Date data = new Date(BIRTHDAY);
        assertEquals(data.toString(), String.valueOf(instance.birthDate()));
    }
}