package eapli.base.Warehouse.domain;

import eapli.base.productmanagement.domain.Product;

import java.util.Set;

public class RowBuilder {
    private Row row;

    private RowIdentifier rowIdentifier;

    private RowBeginLSquare rowBeginLSquare;

    private RowBeginWSquare rowBeginWSquare;

    private RowEndLSquare rowEndLSquare;

    private RowEndWSquare rowEndWSquare;

    private Set<Shelf> shelves;


    public RowBuilder(long rowIdentifier, long beginLSquare, long beginWSquare, long endLSquare, long endWSquare , Set<Shelf> shelves) {
        withRowIdentifier(rowIdentifier);
        withRowBeginLSquare(beginLSquare);
        withRowBeginWSquare(beginWSquare);
        withRowEndLSquare(endLSquare);
        withRowEndWSquare(endWSquare);
        this.shelves = shelves;
    }

    private RowBuilder withRowIdentifier(long rowIdentifier){
        this.rowIdentifier=new RowIdentifier(rowIdentifier);
        return this;
    }


    private RowBuilder withRowBeginLSquare(long beginWSquare){
        this.rowBeginLSquare= new RowBeginLSquare(beginWSquare);
        return this;
    }

    private RowBuilder withRowBeginWSquare(long beginWSquare){
        this.rowBeginWSquare= new RowBeginWSquare(beginWSquare);
        return this;
    }



    private RowBuilder withRowEndLSquare(long EndWSquare){
        this.rowEndLSquare= new RowEndLSquare(EndWSquare);
        return this;
    }

    private RowBuilder withRowEndWSquare(long EndWSquare){
        this.rowEndWSquare= new RowEndWSquare(EndWSquare);
        return this;
    }

    private Row buildOrThrow() {
        if (row != null) {
            return row;
        } else if (rowIdentifier != null && rowBeginLSquare != null && shelves != null && rowBeginWSquare!=null && rowEndLSquare!=null && rowEndWSquare !=null ) {
            row = new Row(rowIdentifier,rowBeginLSquare,rowBeginWSquare,rowEndLSquare,rowEndWSquare,shelves);
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
