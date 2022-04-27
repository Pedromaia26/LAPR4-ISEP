package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class ShipmentMethod implements ValueObject {

    private String shipmentMethod;

    public ShipmentMethod(final String shipmentMethod){

        if (shipmentMethod.length() > 30)
            throw new IllegalArgumentException("Shipment Method invalid!");


        this.shipmentMethod = shipmentMethod;
    }

    public ShipmentMethod() {

    }

    @Override
    public String toString(){
        return shipmentMethod;
    }

    public String getShipmentMethod() {
        return shipmentMethod;
    }

    public void setShipmentMethod(String shipmentMethod) {
        this.shipmentMethod = shipmentMethod;
    }
}
