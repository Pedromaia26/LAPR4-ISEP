package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Embeddable
public class RowIdentifier implements ValueObject, Comparable<RowIdentifier> {

    private long rowId;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Aisle aisle;

    public RowIdentifier(long id,Aisle aisle) {
        if(rowId<0)throw new IllegalArgumentException("Row id < 0!");

        this.rowId = id;
        this.aisle=aisle;
    }

    public RowIdentifier() {

    }

    public long RowId() {
        return rowId;
    }

    @Override
    public int compareTo(RowIdentifier o) {
        if(rowId>o.rowId)return 1;
        else if (rowId<o.rowId)return -1;
        else return 0;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RowIdentifier that = (RowIdentifier) o;
        return rowId == that.rowId && aisle.equals(that.aisle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowId, aisle);
    }
}
