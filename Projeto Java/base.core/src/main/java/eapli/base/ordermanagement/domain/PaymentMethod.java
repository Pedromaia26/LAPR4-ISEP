package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class PaymentMethod implements ValueObject {

    private String paymentMethod;

    public PaymentMethod(final String paymentMethod){

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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
