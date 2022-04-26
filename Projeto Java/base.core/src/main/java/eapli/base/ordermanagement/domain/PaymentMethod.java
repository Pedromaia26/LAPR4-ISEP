package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class PaymentMethod implements ValueObject {

    private String paymentMethod;

    public PaymentMethod(final String paymentMethod){

        if (paymentMethod == null || paymentMethod.isBlank())
            throw new IllegalArgumentException("Payment Method cannot be null!");


        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod() {

    }

    @Override
    public String toString(){
        return paymentMethod;
    }
}
