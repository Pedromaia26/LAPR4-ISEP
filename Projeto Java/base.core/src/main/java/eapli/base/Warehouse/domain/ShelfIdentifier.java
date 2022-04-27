package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ShelfIdentifier implements ValueObject, Comparable<ShelfIdentifier> {
    private long id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Section section;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Aisle aisle;

    public ShelfIdentifier(long id, Section section, Aisle aisle) {
        this.id = id;
        this.aisle=aisle;
        this.section=section;
    }

    public ShelfIdentifier() {

    }

    @Override
    public int compareTo(ShelfIdentifier o) {
        if(id>o.id)return 1;
        else if (id<o.id)return -1;
        else return 0;

    }
}
