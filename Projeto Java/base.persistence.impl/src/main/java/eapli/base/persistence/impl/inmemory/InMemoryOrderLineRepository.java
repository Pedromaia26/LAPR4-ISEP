package eapli.base.persistence.impl.inmemory;

import eapli.base.ordermanagement.domain.OrderLine;
import eapli.base.ordermanagement.repositories.OrderLineRepository;
import eapli.base.productmanagement.domain.InternalCode;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryOrderLineRepository extends InMemoryDomainRepository<OrderLine, Long>
        implements OrderLineRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public OrderLine save(OrderLine orderLine) {
        return orderLine;
    }

    @Override
    public int getAllCost(Long orderId){
        return 0;
    }
}
