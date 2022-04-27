package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class RowEndLSquare implements ValueObject {
    private long endLSquare;

    public RowEndLSquare(long endLSquare) {
        this.endLSquare = endLSquare;
    }

    public RowEndLSquare() {

    }
}
