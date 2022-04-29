package eapli.base.clientusermanagement.domain;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class VerifyGenderTest {
    private static final String GENDER1 = "male";
    private static final String GENDER2 = "female";
    private static final String GENDER3 = "other";

    @Test(expected = IllegalArgumentException.class)
    public void ensureGenderMustBeNotEmpty() {
        new VerifyGender("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureGenderMustBeOneOfTheOption() {
        new VerifyGender("genero invalido");
    }

    @Test
    public void ensureGenderHasRightValue() {
        final VerifyGender instance1 = new VerifyGender(GENDER1);
        final VerifyGender instance2 = new VerifyGender(GENDER2);
        final VerifyGender instance3 = new VerifyGender(GENDER3);
        assertEquals(GENDER1, instance1.gender);
        assertEquals(GENDER2, instance2.gender);
        assertEquals(GENDER3, instance3.gender);
    }
}