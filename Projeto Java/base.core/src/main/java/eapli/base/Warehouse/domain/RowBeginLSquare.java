package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class RowBeginLSquare implements ValueObject {
    private long beginLSquare;



    public RowBeginLSquare(long beginLSquare) {
        if(beginLSquare<0)throw new IllegalArgumentException("Row beginLSquare < 0!");

        this.beginLSquare = beginLSquare;
    }

    public RowBeginLSquare() {

    }

    public long BeginLSquare() {
        return beginLSquare;
    }
}
