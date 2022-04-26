package eapli.base.orderstatusmanagement.repositories;

import eapli.base.orderstatusmanagement.domain.Status;
import eapli.base.productmanagement.domain.InternalCode;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.domain.repositories.DomainRepository;

public interface StatusRepository extends DomainRepository<Long, Status> {

    /**
     * inserts an entity and commits
     *
     * @param entity
     * @return the persisted entity
     */
    public Status save(Status entity);
}
