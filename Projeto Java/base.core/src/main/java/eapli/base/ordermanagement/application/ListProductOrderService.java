package eapli.base.ordermanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.OrderLine;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.repositories.OrderLineRepository;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

@ApplicationService
public class ListProductOrderService {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final OrderRepository productOrderRepository = PersistenceContext.repositories().orders();
    private final OrderLineRepository productOrderLineRepository = PersistenceContext.repositories().orderlines();

    public Iterable<ProductOrder> productOrdersPrepared() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.WAREHOUSE_EMPLOYEE);

        return productOrderRepository.findProductOrdersPrepared();
    }

    public Iterable<ProductOrder> productOrdersDispatched() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_CLERK);

        return productOrderRepository.findProductOrdersDispatched();
    }

    public Iterable<ProductOrder> productOrdersToBePrepared() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.WAREHOUSE_EMPLOYEE);

        return productOrderRepository.findProductOrdersToBePrepared();
    }

    public ProductOrder findByCode(String orderId) {

        return productOrderRepository.findByOrderId(Long.parseLong(orderId));
    }

    public Iterable<ProductOrder> orderList() {
        return productOrderRepository.findAll();
    }

    public ProductOrder findPreparedOrderById(String orderId){
        return productOrderRepository.findPreparedOrderById(Long.parseLong(orderId));
    }

    public ProductOrder findDispatchedOrderById(String orderId){
        return productOrderRepository.findDispatchedOrderById(Long.parseLong(orderId));
    }

    public ProductOrder findRegisteredOrderById(String orderId){
        return productOrderRepository.findRegisteredOrderById(Long.parseLong(orderId));
    }

    public Iterable<ProductOrder> findClientOrders(String clientVat){
        return productOrderRepository.findOrderByClientVat(clientVat);
    }

    public Iterable<OrderLine> findOrderLinesByOrderId(Long orderId){
        return productOrderLineRepository.findOrderLinesByOrderId(orderId);
    }
}
