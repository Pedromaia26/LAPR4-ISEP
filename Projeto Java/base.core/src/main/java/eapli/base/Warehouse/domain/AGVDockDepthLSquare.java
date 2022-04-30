package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable

public class AGVDockDepthLSquare implements ValueObject {
    private long depthLSquare;

    public AGVDockDepthLSquare(long depthLSquare) {
        if(depthLSquare<0)throw new IllegalArgumentException("Dock depthLSquare < 0!");
        this.depthLSquare = depthLSquare;
    }

    public AGVDockDepthLSquare() {

    }
    public long DepthLSquare() {
        return depthLSquare;
    }
}
