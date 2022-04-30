package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable

public class AGVDockDepthWSquare implements ValueObject {
    private long depthWSquare;

    public AGVDockDepthWSquare(long depthWSquare) {
        if(depthWSquare<0)throw new IllegalArgumentException("Dock depthWSquare < 0!");

        this.depthWSquare = depthWSquare;
    }

    public AGVDockDepthWSquare() {

    }
    public long DepthWSquare() {
        return depthWSquare;
    }

}
