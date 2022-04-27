package eapli.base.persistence.impl.inmemory;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.orderstatusmanagement.domain.Status;
import eapli.base.orderstatusmanagement.repositories.StatusRepository;
import eapli.base.productmanagement.domain.InternalCode;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryStatusRepository extends InMemoryDomainRepository<Status, Long>
        implements StatusRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Status findByStatusId(final Long id) {
        return null;
    }

    @Override
    public Status save(Status status) {
        return status;
    }
}
