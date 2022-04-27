package eapli.base.Warehouse.repositories;

import eapli.base.Warehouse.domain.Shelf;
import eapli.base.Warehouse.domain.ShelfIdentifier;
import eapli.framework.domain.repositories.DomainRepository;

public interface ShelfRepository extends DomainRepository<ShelfIdentifier, Shelf> {
}
