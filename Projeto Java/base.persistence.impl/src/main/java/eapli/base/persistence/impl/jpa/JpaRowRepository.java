package eapli.base.persistence.impl.jpa;

import eapli.base.Warehouse.domain.Section;
import eapli.base.Warehouse.domain.RowIdentifier;
import eapli.base.Warehouse.repositories.RowRepository;

public class JpaRowRepository extends BasepaRepositoryBase<Section, RowIdentifier, RowIdentifier> implements RowRepository {
    JpaRowRepository() {
        super("rowIdentifier");
    }
}
