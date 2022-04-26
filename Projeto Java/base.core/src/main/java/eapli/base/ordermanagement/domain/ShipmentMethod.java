package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class ShipmentMethod implements ValueObject {

    private String shipmentMethod;

    public ShipmentMethod(final String shipmentMethod){

        if (shipmentMethod == null || shipmentMethod.isBlank())
            throw new IllegalArgumentException("Payment Method cannot be null!");


        this.shipmentMethod = shipmentMethod;
    }

    public ShipmentMethod() {

    }

    @Override
    public String toString(){
        return shipmentMethod;
    }
}
