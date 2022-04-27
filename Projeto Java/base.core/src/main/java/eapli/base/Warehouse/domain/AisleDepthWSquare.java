package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable

public class AisleDepthWSquare implements ValueObject {
    private long DepthWSquare;

    public AisleDepthWSquare(long DepthWSquare) {
        this.DepthWSquare = DepthWSquare;
    }

    public AisleDepthWSquare() {

    }
}
