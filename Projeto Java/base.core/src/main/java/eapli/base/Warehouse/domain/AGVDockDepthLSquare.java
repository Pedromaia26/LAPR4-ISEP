package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable

public class AGVDockDepthLSquare implements ValueObject {
    private long depthLSquare;

    public AGVDockDepthLSquare(long depthLSquare) {
        this.depthLSquare = depthLSquare;
    }

    public AGVDockDepthLSquare() {

    }
}
