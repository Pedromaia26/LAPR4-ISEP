package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable

public class AisleDepthLSquare implements ValueObject {
    private long depthLSquare;

    public AisleDepthLSquare(long depthLSquare) {
        if(depthLSquare<0)throw new IllegalArgumentException("Aisle DepthLSquare < 0!");

        this.depthLSquare = depthLSquare;
    }

    public AisleDepthLSquare() {

    }
}
