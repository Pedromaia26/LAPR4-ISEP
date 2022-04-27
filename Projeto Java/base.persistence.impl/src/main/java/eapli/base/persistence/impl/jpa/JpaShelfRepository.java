package eapli.base.persistence.impl.jpa;

import eapli.base.Warehouse.domain.Shelf;
import eapli.base.Warehouse.domain.ShelfIdentifier;
import eapli.base.Warehouse.repositories.ShelfRepository;

public class JpaShelfRepository extends BasepaRepositoryBase<Shelf, ShelfIdentifier, ShelfIdentifier> implements ShelfRepository {
    JpaShelfRepository() {
        super("shelfIdentifier");
    }
}
