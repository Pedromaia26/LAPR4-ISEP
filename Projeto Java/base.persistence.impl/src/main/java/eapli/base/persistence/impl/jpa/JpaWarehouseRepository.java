package eapli.base.persistence.impl.jpa;

import eapli.base.Warehouse.domain.Shelf;
import eapli.base.Warehouse.domain.ShelfIdentifier;
import eapli.base.Warehouse.domain.Warehouse;
import eapli.base.Warehouse.repositories.ShelfRepository;
import eapli.base.Warehouse.repositories.WarehouseRepository;

public class JpaWarehouseRepository extends BasepaRepositoryBase<Warehouse, Long, Long> implements WarehouseRepository {
    JpaWarehouseRepository() {
        super("id");
    }
}
