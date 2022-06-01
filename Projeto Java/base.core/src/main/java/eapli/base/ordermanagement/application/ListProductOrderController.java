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

    public Iterable<ProductOrder> productOrdersDispatched() {
        return svc.productOrdersDispatched();
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

    public ProductOrder findPreparedOrderById(String orderId){
        return svc.findPreparedOrderById(orderId);
    }

    public ProductOrder findDispacthedOrderById(String orderId){
        return svc.findDispatchedOrderById(orderId);
    }

    public ProductOrder findRegisteredOrderById(String orderId){
        return svc.findRegisteredOrderById(orderId);
    }
}
