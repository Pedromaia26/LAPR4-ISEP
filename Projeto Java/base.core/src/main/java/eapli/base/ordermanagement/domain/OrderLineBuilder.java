package eapli.base.ordermanagement.domain;

import eapli.base.productmanagement.domain.Product;
import eapli.framework.domain.model.DomainFactory;

public class OrderLineBuilder implements DomainFactory<OrderLine> {

    private OrderLine orderLine;
    private Product productId;
    private ProductOrder productOrderId;
    private Quantity quantity;
    private Cost unitPrice;

    public OrderLineBuilder(final Product productId, final ProductOrder productOrderId, final int quantity, final double unitPrice) {
        withProduct(productId);
        withOrder(productOrderId);
        withQuantity(quantity);
        withUnitPrice(unitPrice);
    }

    public OrderLineBuilder withProduct(final Product product) {
        this.productId = product;
        return this;
    }

    public OrderLineBuilder withOrder(final ProductOrder productOrder) {
        this.productOrderId = productOrder;
        return this;
    }

    public OrderLineBuilder withQuantity(final int quantity) {
        this.quantity = new Quantity(quantity);
        return this;
    }

    public OrderLineBuilder withUnitPrice(final double unitPrice) {
        this.unitPrice = new Cost(unitPrice);
        return this;
    }

    private OrderLine buildOrThrow() {
        if (orderLine != null) {
            return orderLine;
        } else if (productId != null && productOrderId != null && quantity != null && unitPrice != null) {
            orderLine = new OrderLine(productId, quantity, productOrderId, unitPrice);
            return orderLine;
        } else {
            throw new IllegalStateException();
        }
    }

    public OrderLine build() {
        final OrderLine ret = buildOrThrow();
        return ret;
    }
}
