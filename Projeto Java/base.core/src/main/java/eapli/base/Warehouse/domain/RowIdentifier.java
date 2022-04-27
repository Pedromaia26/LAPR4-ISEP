package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class RowIdentifier implements ValueObject, Comparable<RowIdentifier> {

    private long rowId;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Aisle aisle;

    public RowIdentifier(long id,Aisle aisle) {
        this.rowId = id;
        this.aisle=aisle;
    }

    public RowIdentifier() {

    }

    @Override
    public int compareTo(RowIdentifier o) {
        if(rowId>o.rowId)return 1;
        else if (rowId<o.rowId)return -1;
        else return 0;

    }
}
