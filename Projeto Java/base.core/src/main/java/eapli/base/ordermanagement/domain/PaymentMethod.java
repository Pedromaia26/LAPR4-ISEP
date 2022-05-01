package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class PaymentMethod implements ValueObject {

    private String paymentMethod;

    public PaymentMethod(final String paymentMethod){

        if (paymentMethod.isBlank() || paymentMethod == null)
            throw new IllegalArgumentException("Payment Method cannot be empty!");
        if (paymentMethod.length() > 30)
            throw new IllegalArgumentException("Payment Method invalid!");


        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod() {

    }

    @Override
    public String toString(){
        return paymentMethod;
    }

    public String paymentMethod() {
        return paymentMethod;
    }

    public void modifyPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
