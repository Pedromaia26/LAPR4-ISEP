package eapli.base.persistence.impl.inmemory;

import eapli.base.Warehouse.domain.Shelf;
import eapli.base.Warehouse.domain.ShelfIdentifier;
import eapli.base.Warehouse.repositories.ShelfRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryShelfRepository extends InMemoryDomainRepository<Shelf, ShelfIdentifier>
        implements ShelfRepository {


    static {
        InMemoryInitializer.init();
    }

    @Override
    public Shelf save(Shelf shelf) {
        return shelf;
    }
}
