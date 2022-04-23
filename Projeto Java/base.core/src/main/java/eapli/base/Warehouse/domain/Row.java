package eapli.base.Warehouse.domain;

import java.util.HashSet;
import java.util.Set;

public class Row {

    private RowIdentifier rowIdentifier;

    private RowLocation rowLocation;

    private Set<Shelf> shelves;

    public Row(RowIdentifier rowIdentifier, RowLocation rowLocation, Set<Shelf> shelves) {
        this.rowIdentifier = rowIdentifier;
        this.rowLocation = rowLocation;
        this.shelves = shelves;
    }
}
