package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class ShipmentMethod implements ValueObject {

    private String shipmentMethod;

    public ShipmentMethod(final String shipmentMethod){

        if (shipmentMethod.isBlank() || shipmentMethod == null)
            throw new IllegalArgumentException("Shipment Method cannot be empty!");
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

    public String shipmentMethod() {
        return shipmentMethod;
    }

    public void modifyShipmentMethod(String shipmentMethod) {
        this.shipmentMethod = shipmentMethod;
    }
}
