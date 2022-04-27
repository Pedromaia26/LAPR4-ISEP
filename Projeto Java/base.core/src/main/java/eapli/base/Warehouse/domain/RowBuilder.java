package eapli.base.Warehouse.domain;

import java.util.Set;

public class RowBuilder {
    private Section section;

    private RowIdentifier rowIdentifier;

    private RowBeginLSquare rowBeginLSquare;

    private RowBeginWSquare rowBeginWSquare;

    private RowEndLSquare rowEndLSquare;

    private RowEndWSquare rowEndWSquare;

    private Set<Shelf> shelves;

    private Aisle aisle;


    public RowBuilder(long rowIdentifier, long beginLSquare, long beginWSquare, long endLSquare, long endWSquare , Aisle aisle) {
        withRowIdentifier(rowIdentifier, aisle);
        withRowBeginLSquare(beginLSquare);
        withRowBeginWSquare(beginWSquare);
        withRowEndLSquare(endLSquare);
        withRowEndWSquare(endWSquare);

    }

    private RowBuilder withRowIdentifier(long rowIdentifier, Aisle aisle){
        this.rowIdentifier=new RowIdentifier(rowIdentifier, aisle);
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
    private RowBuilder withAisle(Aisle aisle){
        this.aisle= aisle;
        return this;
    }

    private Section buildOrThrow() {
        if (section != null) {
            return section;
        } else if (rowIdentifier != null && rowBeginLSquare != null && rowBeginWSquare!=null && rowEndLSquare!=null && rowEndWSquare !=null ) {
            section = new Section(rowIdentifier,rowBeginLSquare,rowBeginWSquare,rowEndLSquare,rowEndWSquare);
            return section;
        } else {
            throw new IllegalStateException();
        }
    }

    public Section build() {
        final Section ret = buildOrThrow();
        // make sure we will create a new instance if someone reuses this builder and do not change
        // the previously built dish.
        section = null;
        return ret;
    }
}
