package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable

public class AGVDockBeginLSquare implements ValueObject {
    private long beginLSquare;

    public long BeginLSquare() {
        return beginLSquare;
    }

    public AGVDockBeginLSquare(long beginLSquare) {
        if(beginLSquare<0)throw new IllegalArgumentException("Dock BeginLSQuare < 0!");
        this.beginLSquare = beginLSquare;
    }

    public AGVDockBeginLSquare() {

    }
}
