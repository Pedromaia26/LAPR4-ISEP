package eapli.base.ordermanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.ProductOrder;
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

    public Iterable<ProductOrder> productOrdersPrepared() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.WAREHOUSE_EMPLOYEE);

        return productOrderRepository.findProductOrdersPrepared();
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

}
