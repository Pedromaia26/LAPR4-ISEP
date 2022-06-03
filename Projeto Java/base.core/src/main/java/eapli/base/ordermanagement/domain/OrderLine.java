package eapli.base.ordermanagement.domain;

import eapli.base.productmanagement.domain.*;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;

@Entity
public class OrderLine implements AggregateRoot<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Product product;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    private ProductOrder productOrder;

    @Embedded
    private Quantity quantity;

    @Embedded
    private Cost unitPrice;

    public OrderLine(Product product, Quantity quantity, ProductOrder productOrder, Cost unitPrice){

        if (product == null || quantity == null || productOrder == null || unitPrice == null)
            throw new IllegalArgumentException();

        this.product = product;
        this.quantity = quantity;
        this.productOrder = productOrder;
        this.unitPrice = unitPrice;
    }

    public OrderLine() {

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

    public Product Product() {
        return product;
    }
}
