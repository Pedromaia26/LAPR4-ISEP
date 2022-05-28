package eapli.base.persistence.impl.inmemory;

import eapli.base.Warehouse.domain.Shelf;
import eapli.base.Warehouse.domain.ShelfIdentifier;
import eapli.base.Warehouse.domain.Warehouse;
import eapli.base.Warehouse.repositories.ShelfRepository;
import eapli.base.Warehouse.repositories.WarehouseRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryWarehouseRepository extends InMemoryDomainRepository<Warehouse, Long>
        implements WarehouseRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Warehouse save(Warehouse warehouse) {
        return warehouse;
    }

    @Override
    public Warehouse findById(String id){return null;}
}
