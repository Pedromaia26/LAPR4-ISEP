package eapli.base.persistence.impl.inmemory;

import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryOrderRepository  extends InMemoryDomainRepository<ProductOrder, Long>
        implements OrderRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public ProductOrder findByOrderId(Long orderId) {
        return null;
    }

    @Override
    public ProductOrder findOrderByAGVId(String id) {
        return null;
    }

    @Override
    public Iterable<ProductOrder> findProductOrdersPrepared() {
        return null;
    }

    @Override
    public Iterable<ProductOrder> findProductOrdersToBePrepared() {
        return null;
    }

    @Override
    public ProductOrder findPreparedOrderById(Long id) {
        return null;
    }
}
