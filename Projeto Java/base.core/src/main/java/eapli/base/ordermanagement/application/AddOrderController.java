package eapli.base.ordermanagement.application;

import eapli.base.clientusermanagement.domain.BillingPostalAddresses;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.DeliveringPostalAddresses;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.*;
import eapli.base.ordermanagement.repositories.OrderLineRepository;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.orderstatusmanagement.domain.Status;
import eapli.base.orderstatusmanagement.repositories.StatusRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.time.util.Calendars;

import java.util.Set;

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

    public boolean addOrder(final String clientvat, final ProductOrder order, final Set<String[]> deliveringPostalAddress, final Set<String[]> billingPostalAddress,
                                 final String shipmentMethod, final double shipmentCost, final String paymentMethod) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_CLERK);

        ClientUser clientUser = userRepository.findByVAT(clientvat);
        long statusid = 1;
        Status status = statusRepository.findByStatusId(statusid);
        double cost = orderLineRepository.getAllCost(order.identity());
        int flag=0, flag1=0;
        if (deliveringPostalAddress.equals("default")) {
            order.modifyDeliveringPostalAddress(clientUser.getDeleveringPostalAddresses());
            flag=1;
        }
        if (billingPostalAddress.equals("default")) {
            order.modifyBillingPostalAddress(clientUser.getBillingPostalAddresses());
            flag1=1;
        }

        if(flag1==0)order.modifyBillingPostalAddress(new BillingPostalAddresses(billingPostalAddress));
        if(flag==0)order.modifyDeliveringPostalAddress(new DeliveringPostalAddresses(deliveringPostalAddress));
        order.modifyTotalAmountWithoutTaxes(new TotalAmountWithoutTaxes(cost));
        order.modifyTotalAmountWithTaxes(new TotalAmountWithTaxes(cost + cost*0.23));
        order.modifyShipmentMethod(new ShipmentMethod(shipmentMethod));
        order.modifyShipmentCost(new ShipmentCost(shipmentCost));
        order.modifyPaymentMethod(new PaymentMethod(paymentMethod));

        orderRepository.update(order);

        return true;
    }
}
