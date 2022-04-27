package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class AisleBeginLSquare implements ValueObject {
    private long BeginLSquare;

    public AisleBeginLSquare(long BeginLSquare) {
        this.BeginLSquare = BeginLSquare;
    }

    public AisleBeginLSquare() {

    }
}
