package eapli.base.Warehouse.repositories;

import eapli.base.Warehouse.domain.Shelf;
import eapli.base.Warehouse.domain.ShelfIdentifier;
import eapli.base.Warehouse.domain.Warehouse;
import eapli.framework.domain.repositories.DomainRepository;

public interface WarehouseRepository extends DomainRepository<Long, Warehouse> {

    Warehouse findById(String id);

}
