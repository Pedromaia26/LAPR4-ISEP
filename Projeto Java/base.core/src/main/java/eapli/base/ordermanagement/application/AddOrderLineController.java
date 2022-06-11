package eapli.base.ordermanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.domain.OrderLine;
import eapli.base.ordermanagement.domain.OrderLineBuilder;
import eapli.base.ordermanagement.repositories.OrderLineRepository;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class AddOrderLineController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final OrderLineRepository orderLineRepository = PersistenceContext.repositories().orderlines();
    private final OrderRepository orderRepository = PersistenceContext.repositories().orders();
    private final ProductRepository productRepository = PersistenceContext.repositories().products();

    public OrderLine addOrderLine(final String productId, final Long orderId, final int quantity) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_CLERK, BaseRoles.POWER_USER, BaseRoles.ADMIN);

        Product product = productRepository.findByCode(productId);
        ProductOrder productOrder = orderRepository.findByOrderId(orderId);
        final OrderLineBuilder newOrderLine = new OrderLineBuilder(product, productOrder, quantity, product.Price().getPrice());


        return orderLineRepository.save(newOrderLine.build());
    }
}
