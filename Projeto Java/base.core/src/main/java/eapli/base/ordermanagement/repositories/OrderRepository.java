package eapli.base.ordermanagement.repositories;

import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.framework.domain.repositories.DomainRepository;

public interface OrderRepository extends DomainRepository<Long, ProductOrder> {

    /**
     * inserts an entity and commits
     *
     * @param entity
     * @return the persisted entity
     */
    public ProductOrder save(ProductOrder entity);

    ProductOrder findByOrderId(Long id);
}
