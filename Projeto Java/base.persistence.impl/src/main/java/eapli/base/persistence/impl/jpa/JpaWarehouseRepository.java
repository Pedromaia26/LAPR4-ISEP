package eapli.base.persistence.impl.jpa;

import eapli.base.Warehouse.domain.Shelf;
import eapli.base.Warehouse.domain.ShelfIdentifier;
import eapli.base.Warehouse.domain.Warehouse;
import eapli.base.Warehouse.repositories.ShelfRepository;
import eapli.base.Warehouse.repositories.WarehouseRepository;
import eapli.base.agvmanagement.domain.AGV;

import javax.persistence.TypedQuery;

public class JpaWarehouseRepository extends BasepaRepositoryBase<Warehouse, Long, Long> implements WarehouseRepository {
    JpaWarehouseRepository() {
        super("id");
    }

    @Override
    public Warehouse findById(String id){
        final TypedQuery<Warehouse> query = super.createQuery(
                "SELECT d FROM Warehouse d WHERE id = " + id,
                Warehouse.class);

        return query.getSingleResult();
    }
}
