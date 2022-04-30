package eapli.base.Warehouse.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class RowIdentifierTest {
    private static final long ID = 1;

    WarehouseBuilder warehouseBuilder= new WarehouseBuilder("warehouse",4,4,1,"cm");

    Warehouse warehouse= warehouseBuilder.build();


    AisleBuilder aisleBuilder = new AisleBuilder(1,1,1,1,1,1,1,"asd",warehouse);
    private Aisle aisle = aisleBuilder.build();

    @Test(expected = IllegalArgumentException.class)
    public void ensureRowIdentifierMustNotBenegative() {
        new RowIdentifier(-5L,aisle);
    }

    @Test
    public void ensureRowIdentifierHasRightValue() {
        final RowIdentifier instance1 = new RowIdentifier();

        final RowIdentifier instance = new RowIdentifier(ID,aisle);
        assertEquals(ID, instance.RowId());
    }
}