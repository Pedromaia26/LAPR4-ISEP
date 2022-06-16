package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class RowEndWSquare implements ValueObject {
    private long endWSquare;

    public RowEndWSquare(long endWSquare) {
        if(endWSquare<0)throw new IllegalArgumentException("Row endWSquare < 0!");

        this.endWSquare = endWSquare;
    }

    public RowEndWSquare() {

    }

    public long EndWSquare() {
        return endWSquare;
    }
}
