package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable

public class AGVDockEndLSquare implements ValueObject {
    private long endLSquare;

    public AGVDockEndLSquare(long endLSquare) {
        this.endLSquare = endLSquare;
    }

    public AGVDockEndLSquare() {

    }
}
