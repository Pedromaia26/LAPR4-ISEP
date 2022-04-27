package eapli.base.Warehouse.domain;

public class ShelfBuilder {
    private Shelf shelf;
    private Section section;
    private Aisle aisle;

    private ShelfIdentifier shelfIdentifier;

    public ShelfBuilder(long shelfIdentifier, Section section, Aisle aisle) {
        withShelfIdentifier(shelfIdentifier,section,aisle);


    }

    private ShelfBuilder withShelfIdentifier(long shelfIdentifier,Section section, Aisle aisle){
        this.shelfIdentifier=new ShelfIdentifier(shelfIdentifier,section,aisle);
        return this;
    }
    private ShelfBuilder withAisle(Aisle aisle){
        this.aisle=aisle;
        return this;
    }
    private ShelfBuilder withRow(Section section){
        this.section = section;
        return this;
    }

    private Shelf buildOrThrow() {
        if (shelf != null) {
            return shelf;
        } else if (shelfIdentifier != null) {
            shelf = new Shelf(shelfIdentifier);
            return shelf;
        } else {
            throw new IllegalStateException();
        }
    }

    public Shelf build() {
        final Shelf ret = buildOrThrow();
        // make sure we will create a new instance if someone reuses this builder and do not change
        // the previously built dish.
        shelf = null;
        return ret;
    }
}
