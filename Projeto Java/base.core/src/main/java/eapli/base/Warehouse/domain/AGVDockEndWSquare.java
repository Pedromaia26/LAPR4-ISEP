package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable

public class AGVDockEndWSquare implements ValueObject {
    private long endWSquare;

    public AGVDockEndWSquare(long endWSquare) {
        if(endWSquare<0)throw new IllegalArgumentException("Dock endWSquare < 0!");

        this.endWSquare = endWSquare;
    }

    public AGVDockEndWSquare() {

    }
}
