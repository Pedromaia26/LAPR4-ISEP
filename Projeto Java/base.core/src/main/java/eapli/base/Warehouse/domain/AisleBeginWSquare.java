package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable

public class AisleBeginWSquare implements ValueObject {
    private long beginWSquare;

    public AisleBeginWSquare(long beginWSquare) {
        if(beginWSquare<0)throw new IllegalArgumentException("Aisle BeginWSquare < 0!");

        this.beginWSquare = beginWSquare;
    }

    public AisleBeginWSquare() {

    }

    public long BeginWSquare() {
        return beginWSquare;
    }
}
