package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable

public class AGVDockEndWSquare implements ValueObject {
    private long endWSquare;

    public AGVDockEndWSquare(long endWSquare) {
        this.endWSquare = endWSquare;
    }

    public AGVDockEndWSquare() {

    }
}
