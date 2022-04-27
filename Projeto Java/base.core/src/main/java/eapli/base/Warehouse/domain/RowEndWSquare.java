package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class RowEndWSquare implements ValueObject {
    private long endWSquare;

    public RowEndWSquare(long endWSquare) {
        this.endWSquare = endWSquare;
    }

    public RowEndWSquare() {

    }
}
