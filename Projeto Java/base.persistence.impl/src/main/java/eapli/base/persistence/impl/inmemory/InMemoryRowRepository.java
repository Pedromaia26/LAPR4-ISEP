package eapli.base.persistence.impl.inmemory;

import eapli.base.Warehouse.domain.Section;
import eapli.base.Warehouse.domain.RowIdentifier;
import eapli.base.Warehouse.repositories.RowRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryRowRepository extends InMemoryDomainRepository<Section, RowIdentifier>
        implements RowRepository {


    static {
        InMemoryInitializer.init();
    }

    @Override
    public Section save(Section section) {
        return section;
    }
}
