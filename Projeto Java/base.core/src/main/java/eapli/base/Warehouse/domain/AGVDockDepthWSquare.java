package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable

public class AGVDockDepthWSquare implements ValueObject {
    private long depthWSquare;

    public AGVDockDepthWSquare(long depthWSquare) {
        this.depthWSquare = depthWSquare;
    }

    public AGVDockDepthWSquare() {

    }
}
