package eapli.base.Warehouse.repositories;

import eapli.base.Warehouse.domain.Shelf;
import eapli.base.Warehouse.domain.ShelfIdentifier;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.domain.repositories.DomainRepository;

public interface ShelfRepository extends DomainRepository<ShelfIdentifier, Shelf> {

    Shelf findStorageAreaByID(long aisleID, long sectionID, long shelfID);

}
