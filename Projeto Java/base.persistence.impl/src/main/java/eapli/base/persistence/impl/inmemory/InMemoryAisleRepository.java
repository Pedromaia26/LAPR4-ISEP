package eapli.base.persistence.impl.inmemory;

import eapli.base.Warehouse.domain.AGVDock;
import eapli.base.Warehouse.domain.AGVDockIdentifier;
import eapli.base.Warehouse.domain.Aisle;
import eapli.base.Warehouse.domain.AisleIdentifier;
import eapli.base.Warehouse.repositories.AGVDockRepository;
import eapli.base.Warehouse.repositories.AisleRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryAisleRepository extends InMemoryDomainRepository<Aisle, AisleIdentifier>
        implements AisleRepository {


    static {
        InMemoryInitializer.init();
    }

    @Override
    public Aisle save(Aisle aisle) {
        return aisle;
    }
}
