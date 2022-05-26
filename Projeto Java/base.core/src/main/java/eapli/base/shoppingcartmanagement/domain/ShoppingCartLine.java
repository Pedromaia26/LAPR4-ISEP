package eapli.base.shoppingcartmanagement.domain;

import eapli.base.ordermanagement.domain.Cost;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.domain.Quantity;
import eapli.base.productmanagement.domain.Price;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;

@Entity
public class ShoppingCartLine implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Product product;

    @Embedded
    private Quantity quantity;

    @Embedded
    private Price unitPrice;

    public ShoppingCartLine(Product product, Quantity quantity, Price unitPrice){

        if (product == null || quantity == null || unitPrice == null) throw new IllegalArgumentException();

        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public ShoppingCartLine() {

    }

    public Quantity Quantity() {
        return quantity;
    }

    public void modifyQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public Price UnitPrice() {
        return unitPrice;
    }

    public void modifyUnitPrice(Price unitPrice) {
        this.unitPrice = unitPrice;
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

    public Product Product() {
        return product;
    }
}
