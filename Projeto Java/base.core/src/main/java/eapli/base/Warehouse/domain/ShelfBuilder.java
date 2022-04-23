package eapli.base.Warehouse.domain;

import java.util.Set;

public class ShelfBuilder {
    private Shelf shelf;

    private ShelfIdentifier shelfIdentifier;

    public ShelfBuilder(long shelfIdentifier) {
        withShelfIdentifier(shelfIdentifier);

    }

    private ShelfBuilder withShelfIdentifier(long shelfIdentifier){
        this.shelfIdentifier=new ShelfIdentifier(shelfIdentifier);
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
