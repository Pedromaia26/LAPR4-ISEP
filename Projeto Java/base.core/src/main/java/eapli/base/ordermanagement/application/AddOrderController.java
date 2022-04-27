package eapli.base.ordermanagement.application;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.domain.ProductOrderBuilder;
import eapli.base.ordermanagement.repositories.OrderLineRepository;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.orderstatusmanagement.domain.Status;
import eapli.base.orderstatusmanagement.repositories.StatusRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.time.util.Calendars;

@UseCaseController
public class AddOrderController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final OrderRepository orderRepository = PersistenceContext.repositories().orders();
    private final ClientUserRepository userRepository = PersistenceContext.repositories().clientUsers();
    private final StatusRepository statusRepository = PersistenceContext.repositories().status();
    private final OrderLineRepository orderLineRepository = PersistenceContext.repositories().orderlines();

    public ProductOrder addOrder(final String clientvat) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_CLERK);
        ClientUser clientUser = userRepository.findByVAT(clientvat);
        long statusid = 1;
        Status status = statusRepository.findByStatusId(statusid);
        final ProductOrderBuilder newOrder = new ProductOrderBuilder(clientUser, Calendars.now(), status);
        return orderRepository.save(newOrder.build());
    }

    public ProductOrder addOrder(final String clientvat, final Long orderId, final String deliveringPostalAddress, final String billingPostalAddress,
                                 final String shipmentMethod, final double shipmentCost, final String paymentMethod) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_CLERK);

        ClientUser clientUser = userRepository.findByVAT(clientvat);
        long statusid = 1;
        Status status = statusRepository.findByStatusId(statusid);
        double cost = orderLineRepository.getAllCost(orderId);
        final ProductOrderBuilder newOrder = new ProductOrderBuilder(clientUser, status, Calendars.now(), deliveringPostalAddress, billingPostalAddress, cost + cost*0.23, cost, shipmentMethod, shipmentCost, paymentMethod);

        return orderRepository.save(newOrder.build());
    }
}
