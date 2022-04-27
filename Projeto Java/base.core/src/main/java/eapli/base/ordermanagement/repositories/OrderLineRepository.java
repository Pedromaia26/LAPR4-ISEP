package eapli.base.ordermanagement.repositories;

import eapli.base.ordermanagement.domain.OrderLine;
import eapli.framework.domain.repositories.DomainRepository;

public interface OrderLineRepository extends DomainRepository<Long, OrderLine> {

    /**
     * inserts an entity and commits
     *
     * @param entity
     * @return the persisted entity
     */
    public OrderLine save(OrderLine entity);

    int getAllCost(Long orderId);
}
