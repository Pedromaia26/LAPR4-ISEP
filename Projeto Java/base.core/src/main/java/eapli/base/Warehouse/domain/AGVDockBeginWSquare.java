package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable

public class AGVDockBeginWSquare implements ValueObject {
    private long beginWSquare;

    public AGVDockBeginWSquare(long beginWSquare) {
        if(beginWSquare<0)throw new IllegalArgumentException("Dock beginWSquare < 0!");
        this.beginWSquare = beginWSquare;
    }

    public AGVDockBeginWSquare() {

    }
}
