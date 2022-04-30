package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable

public class AGVDockEndLSquare implements ValueObject {
    private long endLSquare;

    public AGVDockEndLSquare(long endLSquare) {
        if(endLSquare<0)throw new IllegalArgumentException("Dock endLSquare < 0!");
        this.endLSquare = endLSquare;
    }

    public AGVDockEndLSquare() {

    }
    public long EndLSquare() {
        return endLSquare;
    }
}
