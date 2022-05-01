package eapli.base.Warehouse.domain;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.CategoryCode;
import eapli.base.categorymanagement.domain.CategoryDescription;
import eapli.base.productmanagement.domain.InternalCode;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.domain.ProductBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AGVDockTest {

    private AGVDock AGVDockBuild(){
        WarehouseBuilder warehouseBuilder= new WarehouseBuilder("warehouse",4,4,1,"cm");

        Warehouse warehouse= warehouseBuilder.build();

        AGVDockBuilder b = new AGVDockBuilder("1",1,1,1,1,1,1,"accessibility",warehouse);
        return b.build();
    }

    @Test
    public void ensureAGVDockEqualsAreTheSameForTheSameInstance(){

        final AGVDock subject = AGVDockBuild();

        final boolean expected = subject.equals(subject);

        assertTrue(expected);
    }

    @Test
    public void ensureProductEqualsFailsForDifferenteObjectTypes(){

        final AGVDock subject = AGVDockBuild();

        final boolean expected = subject.equals(new Product());

        assertFalse(expected);
    }

    @Test
    public void ensureProductIsTheSameAsItsInstance(){

        final AGVDock subject = AGVDockBuild();

        final boolean expected = subject.sameAs(subject);

        assertTrue(expected);
    }

    @Test
    public void ensureTwoOrderLineWithDifferentAGVIdentifierAreNotTheSame(){
        final AGVDock subject1 = AGVDockBuild();

        final AGVDock subject2 = AGVDockBuild();
        final boolean expected = subject1.sameAs(subject2);

        assertTrue(expected);
    }
}