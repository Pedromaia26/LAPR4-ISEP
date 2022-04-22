package eapli.base.productmanagement.domain;

public class Price {

    private double price;

    public Price(final double price){

        if (price < 0)
            throw new IllegalArgumentException("Price cannot be negative!");

        this.price = price;
    }
}
