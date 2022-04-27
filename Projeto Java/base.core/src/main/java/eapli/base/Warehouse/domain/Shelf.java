package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Shelf implements AggregateRoot<ShelfIdentifier> {
    @EmbeddedId
    private ShelfIdentifier shelfIdentifier;

    public Shelf(ShelfIdentifier shelfIdentifier) {
        this.shelfIdentifier = shelfIdentifier;

    }

    public Shelf() {

    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public ShelfIdentifier identity() {
        return shelfIdentifier;
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }
}
