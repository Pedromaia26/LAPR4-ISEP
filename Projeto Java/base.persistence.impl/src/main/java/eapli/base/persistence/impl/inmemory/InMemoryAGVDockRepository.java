package eapli.base.persistence.impl.inmemory;

import eapli.base.Warehouse.domain.AGVDock;
import eapli.base.Warehouse.domain.AGVDockIdentifier;
import eapli.base.Warehouse.repositories.AGVDockRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryAGVDockRepository extends InMemoryDomainRepository<AGVDock, AGVDockIdentifier>
        implements AGVDockRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public AGVDock save(AGVDock agvDock) {
        return agvDock;
    }
}
