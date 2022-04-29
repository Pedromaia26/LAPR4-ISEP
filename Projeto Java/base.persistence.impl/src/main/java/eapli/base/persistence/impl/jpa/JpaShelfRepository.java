package eapli.base.persistence.impl.jpa;

import eapli.base.Warehouse.domain.Shelf;
import eapli.base.Warehouse.domain.ShelfIdentifier;
import eapli.base.Warehouse.repositories.ShelfRepository;
import eapli.base.categorymanagement.domain.Category;

import javax.persistence.TypedQuery;

public class JpaShelfRepository extends BasepaRepositoryBase<Shelf, ShelfIdentifier, ShelfIdentifier> implements ShelfRepository {
    JpaShelfRepository() {
        super("shelfIdentifier");
    }


    @Override
    public Shelf findStorageAreaByID(long aisleID, long sectionID, long shelfID) {

        final TypedQuery<Shelf> query = super.createQuery(
                "SELECT d FROM Shelf d WHERE d.shelfIdentifier.aisle.aisleIdentifier.id = " + aisleID + "and d.shelfIdentifier.section.rowIdentifier.rowId = " + sectionID + "and d.shelfIdentifier.id = " + shelfID, Shelf.class);
        return query.getSingleResult();
    }
}
