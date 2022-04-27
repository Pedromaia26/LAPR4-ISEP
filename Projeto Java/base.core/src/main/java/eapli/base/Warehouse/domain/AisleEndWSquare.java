package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable

public class AisleEndWSquare implements ValueObject {
    private long endWSquare;

    public AisleEndWSquare(long endWSquare) {
        this.endWSquare = endWSquare;
    }

    public AisleEndWSquare() {

    }
}
