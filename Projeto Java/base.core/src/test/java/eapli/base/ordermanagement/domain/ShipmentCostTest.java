package eapli.base.ordermanagement.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShipmentCostTest {
    private static final Double SHIPMENT_COST = 5d;

    @Test(expected = IllegalArgumentException.class)
    public void ensureShipmentCostMustBeGreater0() {
        new ShipmentCost(-1d);
    }

    @Test
    public void ensureShipmentCostHasRightValue() {
        final ShipmentCost instance = new ShipmentCost(SHIPMENT_COST);
        assertEquals(SHIPMENT_COST, instance.shipmentCost());
    }
}