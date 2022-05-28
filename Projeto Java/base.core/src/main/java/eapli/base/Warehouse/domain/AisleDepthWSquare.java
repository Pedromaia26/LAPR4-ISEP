package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable

public class AisleDepthWSquare implements ValueObject {
    private long depthWSquare;

    public AisleDepthWSquare(long depthWSquare) {
        if(depthWSquare<0)throw new IllegalArgumentException("Aisle DepthWSquare < 0!");

        this.depthWSquare = depthWSquare;
    }

    public AisleDepthWSquare() {

    }

    public long DepthWSquare() {
        return depthWSquare;
    }
}
