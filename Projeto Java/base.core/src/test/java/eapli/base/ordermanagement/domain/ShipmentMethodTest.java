package eapli.base.ordermanagement.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShipmentMethodTest {
    private static final String SHIPMENT_METHOD = "shipment method";

    @Test(expected = IllegalArgumentException.class)
    public void ensureShipmentMethodMustNotBeEmpty() {
        new ShipmentMethod("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureShipmentMethodMustNotHaveLengthGreater30() {
        new ShipmentMethod("1234567891234567891234567891234");
    }

    @Test
    public void ensureShipmentMethodHasRightValue() {
        final ShipmentMethod instance = new ShipmentMethod(SHIPMENT_METHOD);
        assertEquals(SHIPMENT_METHOD, instance.shipmentMethod());
    }
}