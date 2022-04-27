package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable

public class AGVDockBeginLSquare implements ValueObject {
    private long beginLSquare;

    public AGVDockBeginLSquare(long beginLSquare) {
        this.beginLSquare = beginLSquare;
    }

    public AGVDockBeginLSquare() {

    }
}
