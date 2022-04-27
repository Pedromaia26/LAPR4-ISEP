package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable

public class AisleDepthLSquare implements ValueObject {
    private long DepthLSquare;

    public AisleDepthLSquare(long DepthLSquare) {
        this.DepthLSquare = DepthLSquare;
    }

    public AisleDepthLSquare() {

    }
}
