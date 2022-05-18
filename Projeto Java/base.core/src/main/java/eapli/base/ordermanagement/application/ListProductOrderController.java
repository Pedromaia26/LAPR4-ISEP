package eapli.base.ordermanagement.application;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.productmanagement.domain.Product;

public class ListProductOrderController {

    private final ListProductOrderService svc = new ListProductOrderService();

    public Iterable<ProductOrder> productOrdersPrepared() {
        return svc.productOrdersPrepared();
    }

    public ProductOrder findByCode(String productOrderId) {
        return svc.findByCode(productOrderId);
    }

    public Iterable<ProductOrder> productOrders() {
        return svc.orderList();
    }
}
