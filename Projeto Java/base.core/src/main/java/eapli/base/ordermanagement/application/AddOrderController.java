package eapli.base.ordermanagement.application;

import com.fasterxml.jackson.databind.ser.Serializers;
import eapli.base.agvmanagement.application.AGVListService;
import eapli.base.agvmanagement.application.AssignAGVService;
import eapli.base.agvmanagement.application.ConfigureAGVController;
import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.base.clientusermanagement.domain.BillingPostalAddresses;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.DeliveringPostalAddresses;
import eapli.base.clientusermanagement.domain.VAT;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.*;
import eapli.base.ordermanagement.repositories.OrderLineRepository;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.orderstatusmanagement.domain.Status;
import eapli.base.orderstatusmanagement.repositories.StatusRepository;
import eapli.base.productmanagement.domain.Product;
import eapli.base.shoppingcartmanagement.domain.Line;
import eapli.base.shoppingcartmanagement.domain.ShoppingCart;
import eapli.base.shoppingcartmanagement.domain.ShoppingCartLine;
import eapli.base.shoppingcartmanagement.repositories.ShoppingCartRepository;
import eapli.base.surveymanagement.application.VerifyClientSurveysController;
import eapli.base.taskmanagement.application.TasksListService;
import eapli.base.taskmanagement.domain.Task;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.time.util.Calendars;

import java.util.Optional;
import java.util.Set;

@UseCaseController
public class AddOrderController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final OrderRepository orderRepository = PersistenceContext.repositories().orders();
    private final ClientUserRepository userRepository = PersistenceContext.repositories().clientUsers();
    private final StatusRepository statusRepository = PersistenceContext.repositories().status();
    private final OrderLineRepository orderLineRepository = PersistenceContext.repositories().orderlines();
    private final TransactionalContext txCtx = PersistenceContext.repositories().newTransactionalContext();
    private final ShoppingCartRepository shoppingCartRepository = PersistenceContext.repositories().shoppingCarts(txCtx);
    private TasksListService svcTask = new TasksListService();
    private AGVListService svcAGV = new AGVListService();
    private final AssignAGVService assignAGVService = new AssignAGVService();
    private final VerifyClientSurveysController verifyClientSurveysController = new VerifyClientSurveysController();
    private AGV agv;

    public ProductOrder addOrder(final String clientvat) {
        ClientUser clientUser = userRepository.findByVAT(clientvat);
        long statusid = 1;
        Status status = statusRepository.findByStatusId(statusid);
        final ProductOrderBuilder newOrder = new ProductOrderBuilder(clientUser, Calendars.now(), status);
        return orderRepository.save(newOrder.build());
    }

    public boolean addOrder(final String clientvat, final ProductOrder order, final Set<String[]> deliveringPostalAddress, final Set<String[]> billingPostalAddress,
                                 final String shipmentMethod, final double shipmentCost, final String paymentMethod) {

        ClientUser clientUser = userRepository.findByVAT(clientvat);
        long statusid = 1;
        Status status = statusRepository.findByStatusId(statusid);
        double cost = orderLineRepository.getAllCost(order.identity());
        order.modifyBillingPostalAddress(new BillingPostalAddresses(billingPostalAddress));
        order.modifyDeliveringPostalAddress(new DeliveringPostalAddresses(deliveringPostalAddress));
        order.modifyTotalAmountWithoutTaxes(new TotalAmountWithoutTaxes(cost));
        order.modifyTotalAmountWithTaxes(new TotalAmountWithTaxes(cost + cost*0.23));
        order.modifyShipmentMethod(new ShipmentMethod(shipmentMethod));
        order.modifyShipmentCost(new ShipmentCost(shipmentCost));
        order.modifyPaymentMethod(new PaymentMethod(paymentMethod));

        orderRepository.save(order);

        assignAGVService.assignAGVService();

        //chamar server e enviar id order

        return true;
    }

    public boolean addOrder(final Set<String[]> deliveringPostalAddress, final Set<String[]> billingPostalAddress,
                            final String shipmentMethod, final double shipmentCost, final String paymentMethod) {

        ShoppingCart shoppingCart = shoppingCartRepository.findByVat(getUserSessionVat().vat());
        ProductOrder order = addOrder(getUserSessionVat().vat());
        for (Line shoppingCartLine : shoppingCart.shoppingCartLines()){
            orderLineRepository.save(new OrderLine(shoppingCartLine.shoppingCartLine().Product(), shoppingCartLine.shoppingCartLine().Quantity(), order, new Cost(shoppingCartLine.shoppingCartLine().UnitPrice().getPrice())));
        }

        addOrder(getUserSessionVat().vat(), order, deliveringPostalAddress, billingPostalAddress,
                shipmentMethod, shipmentCost, paymentMethod);

        verifyClientSurveysController.clientToAnswerSurveyOrder();
        for (OrderLine orderLine : orderLineRepository.findOrderLinesByOrderId(order.identity())){
            verifyClientSurveysController.clientToAnswerSurveyProduct(orderLine.Product().Reference().toString());
        }

        return true;
    }

    private VAT getUserSessionVat(){
        return getUser().identity();
    }

    private ClientUser getUser(){
        Username username = authz.session().get().authenticatedUser().username();
        Optional<ClientUser> client = userRepository.findByUsername(username);
        return client.get();
    }

    public boolean verifyOrder(){
        ShoppingCart shoppingCart = shoppingCartRepository.findByVat(getUserSessionVat().vat());
        return shoppingCart.shoppingCartLines().size() > 0;
    }
}
