package eapli.base.clientusermanagement.domain;

import eapli.base.agvmanagement.domain.MaximumWeight;
import org.junit.Test;

import static org.junit.Assert.*;

public class PhoneNumberTest {
    private static final String PHONE_NUMBER = "+351912912912";

    @Test(expected = IllegalArgumentException.class)
    public void ensurePhoneNumberIsNumeric() {
        new PhoneNumber("a351912912912");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensurePhoneNumberIs12() {
        new PhoneNumber("+3519129129121");
    }

    @Test
    public void ensurePhoneNumberHasRightValue() {
        final PhoneNumber instance = new PhoneNumber(PHONE_NUMBER);
        assertEquals(PHONE_NUMBER, String.valueOf(instance.phoneNumber()));
    }
}