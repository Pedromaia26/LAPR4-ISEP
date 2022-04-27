package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class RowBeginLSquare implements ValueObject {
    private long beginLSquare;

    public RowBeginLSquare(long beginLSquare) {
        this.beginLSquare = beginLSquare;
    }

    public RowBeginLSquare() {

    }
}
