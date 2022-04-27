package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class RowBeginWSquare implements ValueObject {
    private long beginWSquare;

    public RowBeginWSquare(long beginWSquare) {
        this.beginWSquare = beginWSquare;
    }

    public RowBeginWSquare() {

    }
}
