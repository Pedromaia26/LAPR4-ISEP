package eapli.base.ordermanagement.application;

import eapli.base.agvmanagement.domain.AGV;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.VAT;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.OrderLine;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.shoppingcartmanagement.application.ShoppingCartController;
import eapli.base.taskmanagement.domain.Task;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.Optional;

@UseCaseController
public class ViewClientOrdersControllerImpl  implements ViewClientOrdersController {
    private final ListProductOrderService svc = new ListProductOrderService();
    private final ListProductOrderController thePOController = new ListProductOrderController();

    public String viewClientOrders(String clientVat){
        StringBuilder string = new StringBuilder();
        try {
            for (ProductOrder order : svc.findClientOrders(clientVat)){
                string.append(order.identity());
                string.append(",");
                string.append(order.CreatedOn().getTime().toString());
                string.append(",");
                string.append(order.PaymentMethod());
                string.append(",");
                string.append(order.ShipmentMethod());
                string.append(",");
                string.append(order.TotalAmountWithTaxes());
                string.append(",");
                string.append(order.Status().identity());
                string.append(",");
                for (OrderLine orderLine : thePOController.findOrderLinesByOrderId(order.identity())){
                    string.append("_");
                    string.append(orderLine.Product().Reference());
                    string.append(",");
                    string.append(orderLine.Product().ShortDescription());
                    string.append(",");
                    string.append(orderLine.Product().Brand());
                    string.append(",");
                    string.append(orderLine.Product().Price());
                    string.append(",");
                    string.append(orderLine.Quantity());
                    string.append(",");
                }
                string.append("#");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        return string.toString();
    }
}
