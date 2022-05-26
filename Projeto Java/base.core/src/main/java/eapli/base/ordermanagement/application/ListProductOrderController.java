package eapli.base.ordermanagement.application;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.productmanagement.domain.Product;

import java.util.List;

public class ListProductOrderController {

    private final ListProductOrderService svc = new ListProductOrderService();

    public Iterable<ProductOrder> productOrdersPrepared() {
        return svc.productOrdersPrepared();
    }

    public Iterable<ProductOrder> productOrdersToBePrepared() {
        return svc.productOrdersToBePrepared();
    }

    public boolean verifyIfExistsOrdersPrepared(){
        List<ProductOrder> list = (List<ProductOrder>) productOrdersToBePrepared();
        return list.size() > 0;
    }

    public ProductOrder findByCode(String productOrderId) {
        return svc.findByCode(productOrderId);
    }

    public Iterable<ProductOrder> productOrders() {
        return svc.orderList();
    }
}
