package eapli.base.persistence.impl.inmemory;

import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.domain.AGVIdentifier;
import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryAGVRepository extends InMemoryDomainRepository<AGV, AGVIdentifier>
        implements AGVRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<AGV> findFreeAGV() {
        return null;
    }

    @Override
    public AGV findById(String id) {
        return null;
    }

    @Override
    public Iterable<AGV> findAGVServingOrder() {
        return null;
    }

    @Override
    public Iterable<AGV> findAGVInMaintenance() {
        return null;
    }

    @Override
    public AGV findAGVInMaintenanceById(String id) {
        return null;
    }
}
