package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable

public class AisleEndWSquare implements ValueObject {
    private long endWSquare;

    public AisleEndWSquare(long endWSquare) {
        if(endWSquare<0)throw new IllegalArgumentException("Aisle endWSquare < 0!");

        this.endWSquare = endWSquare;
    }

    public AisleEndWSquare() {

    }
}
