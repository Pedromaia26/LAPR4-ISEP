package eapli.base.Warehouse.domain;

import eapli.base.productmanagement.domain.Product;

import java.util.Set;

public class RowBuilder {
    private Row row;

    private RowIdentifier rowIdentifier;

    private RowLocation rowLocation;

    private Set<Shelf> shelves;


    public RowBuilder(long rowIdentifier, long beginLSquare, long beginWSquare, long endLSquare, long endWSquare , Set<Shelf> shelves) {
        withRowIdentifier(rowIdentifier);
        withRowLocation(beginLSquare, beginWSquare, endLSquare, endWSquare);
        this.shelves = shelves;
    }

    private RowBuilder withRowIdentifier(long rowIdentifier){
        this.rowIdentifier=new RowIdentifier(rowIdentifier);
        return this;
    }

    private RowBuilder withRowLocation(long beginLSquare, long beginWSquare, long endLSquare, long endWSquare ){
        this.rowLocation=new RowLocation(beginLSquare, beginWSquare, endLSquare, endWSquare);
        return this;
    }

    private Row buildOrThrow() {
        if (row != null) {
            return row;
        } else if (rowIdentifier != null && rowLocation != null && shelves != null ) {
            row = new Row(rowIdentifier,rowLocation,shelves);
            return row;
        } else {
            throw new IllegalStateException();
        }
    }

    public Row build() {
        final Row ret = buildOrThrow();
        // make sure we will create a new instance if someone reuses this builder and do not change
        // the previously built dish.
        row = null;
        return ret;
    }
}
