package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class AisleBeginLSquare implements ValueObject {
    private long beginLSquare;

    public AisleBeginLSquare(long beginLSquare) {
        if(beginLSquare<0)throw new IllegalArgumentException("Aisle BeginLSquare < 0!");
        this.beginLSquare = beginLSquare;
    }

    public AisleBeginLSquare() {

    }
}
