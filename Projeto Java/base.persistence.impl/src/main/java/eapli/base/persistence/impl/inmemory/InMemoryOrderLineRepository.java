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
    public Double getAllCost(Long orderId){
        return 0d;
    }

    @Override
    public Iterable<OrderLine> findOrderLinesByOrderId(Long orderId){return null;}

    @Override
    public Iterable<OrderLine> findOrderLinesByOrderIdNotPickedUp(Long orderId) {
        return null;
    }
}
