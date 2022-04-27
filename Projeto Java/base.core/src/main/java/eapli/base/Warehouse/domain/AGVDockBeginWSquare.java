package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable

public class AGVDockBeginWSquare implements ValueObject {
    private long beginWSquare;

    public AGVDockBeginWSquare(long beginWSquare) {
        this.beginWSquare = beginWSquare;
    }

    public AGVDockBeginWSquare() {

    }
}
