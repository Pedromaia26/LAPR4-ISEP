package eapli.base.Warehouse.domain;

import java.util.HashSet;
import java.util.Set;

public class Row {

    private RowIdentifier rowIdentifier;

    private RowBeginLSquare rowBeginLSquare;

    private RowBeginWSquare rowBeginWSquare;

    private RowEndLSquare rowEndLSquare;

    private RowEndWSquare rowEndWSquare;

    private Set<Shelf> shelves;

    public Row(RowIdentifier rowIdentifier, RowBeginLSquare rowBeginLSquare, RowBeginWSquare rowBeginWSquare, RowEndLSquare rowEndLSquare, RowEndWSquare rowEndWSquare, Set<Shelf> shelves) {
        this.rowIdentifier = rowIdentifier;
        this.rowBeginLSquare = rowBeginLSquare;
        this.rowBeginWSquare = rowBeginWSquare;
        this.rowEndLSquare = rowEndLSquare;
        this.rowEndWSquare = rowEndWSquare;
        this.shelves = shelves;
    }
}
