package eapli.base.ordermanagement.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class PaymentMethodTest {
    private static final String PAYMENT_METHOD = "payment method";

    @Test(expected = IllegalArgumentException.class)
    public void ensurePaymentMethodMustNotBeEmpty() {
        new PaymentMethod("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensurePaymentMethodMustNotHaveLengthGreater30() {
        new PaymentMethod("1234567891234567891234567891234");
    }

    @Test
    public void ensurePaymentMethodHasRightValue() {
        final PaymentMethod instance = new PaymentMethod(PAYMENT_METHOD);
        assertEquals(PAYMENT_METHOD, instance.paymentMethod());
    }
}