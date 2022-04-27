package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable

public class AisleEndLSquare implements ValueObject {
    private long EndLSquare;

    public AisleEndLSquare(long EndLSquare) {
        this.EndLSquare = EndLSquare;
    }

    public AisleEndLSquare() {

    }
}
