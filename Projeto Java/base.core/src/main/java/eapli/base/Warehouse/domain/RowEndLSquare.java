package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class RowEndLSquare implements ValueObject {
    private long endLSquare;

    public long EndLSquare() {
        return endLSquare;
    }

    public RowEndLSquare(long endLSquare) {
        if(endLSquare<0)throw new IllegalArgumentException("Row endLSquare < 0!");

        this.endLSquare = endLSquare;
    }

    public RowEndLSquare() {

    }
}
