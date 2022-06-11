package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class RowBeginWSquare implements ValueObject {
    private long beginWSquare;

    public RowBeginWSquare(long beginWSquare) {
        if(beginWSquare<0)throw new IllegalArgumentException("Row beginWSquare < 0!");

        this.beginWSquare = beginWSquare;
    }

    public RowBeginWSquare() {

    }

    public long BeginWSquare() {
        return beginWSquare;
    }
}
