package eapli.base.Warehouse.domain;

import eapli.base.productmanagement.domain.Product;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;


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
