package eapli.base.ordermanagement.application;

import eapli.base.agvmanagement.application.AGVListService;
import eapli.base.agvmanagement.domain.AGV;
import eapli.base.ordermanagement.domain.ProductOrder;

public class OrderListController {
    private final OrderListService svc = new OrderListService();

    public Iterable<ProductOrder> productOrders() {
        return svc.orderList();
    }
}
