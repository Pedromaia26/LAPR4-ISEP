package eapli.base.ordermanagement.domain;

import eapli.base.productmanagement.domain.*;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;

@Entity
public class Order_Line implements AggregateRoot<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Product product_id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Order order_id;

    @Embedded
    private Quantity quantity;

    @Embedded
    private Cost unitPrice;

    public Order_Line(Product product, Quantity quantity, Order order, Cost unitPrice){

        if (product == null || quantity == null || order == null || unitPrice == null)
            throw new IllegalArgumentException();

        this.product_id = product;
        this.quantity = quantity;
        this.order_id = order;
        this.unitPrice = unitPrice;
    }

    public Order_Line() {

    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public int compareTo(Long other) {
        return AggregateRoot.super.compareTo(other);
    }


    @Override
    public Long identity() {
        return id;
    }

    @Override
    public boolean hasIdentity(Long id) {
        return AggregateRoot.super.hasIdentity(id);
    }

    public Long Id() {
        return id;
    }

    public void modifyId(Long id) {
        this.id = id;
    }

    public Quantity Quantity() {
        return quantity;
    }

    public void modifyQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public Cost UnitPrice() {
        return unitPrice;
    }

    public void modifyUnitPrice(Cost unitPrice) {
        this.unitPrice = unitPrice;
    }
}
