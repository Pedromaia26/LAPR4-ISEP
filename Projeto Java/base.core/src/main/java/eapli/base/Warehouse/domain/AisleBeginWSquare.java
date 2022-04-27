package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable

public class AisleBeginWSquare implements ValueObject {
    private long BeginWSquare;

    public AisleBeginWSquare(long BeginWSquare) {
        this.BeginWSquare = BeginWSquare;
    }

    public AisleBeginWSquare() {

    }
}
