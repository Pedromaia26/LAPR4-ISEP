package eapli.base.Warehouse.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class ShelfIdentifierTest {
    private static final long ID = 1;

    WarehouseBuilder warehouseBuilder= new WarehouseBuilder("warehouse",4,4,1,"cm");

    Warehouse warehouse= warehouseBuilder.build();


    AisleBuilder aisleBuilder = new AisleBuilder(1,1,1,1,1,1,1,"asd",warehouse);
    private Aisle aisle = aisleBuilder.build();

    RowBuilder rowBuilder = new RowBuilder(1,1,1,1,1,aisle);
    Section section= rowBuilder.build();

    @Test(expected = IllegalArgumentException.class)
    public void ensureShelfIdentifierMustNotBenegative() {
        new ShelfIdentifier(-5L,section,aisle);
    }

    @Test
    public void ensureShelfIdentifierHasRightValue() {
        final ShelfIdentifier instance1 = new ShelfIdentifier();
        final ShelfIdentifier instance = new ShelfIdentifier(ID,section,aisle);
        assertEquals(ID, instance.Id());
    }
}