package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class ShipmentCost implements ValueObject {
    private Double shipmentCost;

    public ShipmentCost(final double shipmentCost){

        if (shipmentCost < 0)
            throw new IllegalArgumentException("Cost cannot be negative!");

        this.shipmentCost = shipmentCost;
    }

    public ShipmentCost() {

    }

    @Override
    public String toString(){

        return String.valueOf(shipmentCost);
    }

    public Double shipmentCost() {
        return shipmentCost;
    }

    public void modifyShipmentCost(Double shipmentCost) {
        this.shipmentCost = shipmentCost;
    }
}
