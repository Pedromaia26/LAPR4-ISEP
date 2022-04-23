package eapli.base.productmanagement.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

public class Product implements AggregateRoot<Code> {


    private Barcode barcode;
    private Brand brand;
    private Code code;
    private Description description;
    private Photo photo;
    private Price price;
    private Reference reference;


    private List<Product> listOfProducts;

    public Product(Photo photo, Description description, Brand brand, Reference reference, Code code, Price price, Barcode barcode){

        if (photo == null || description == null || brand == null || reference == null || code == null || price == price || barcode == null)
            throw new IllegalArgumentException();

        this.photo = photo;
        this.description = description;
        this.brand = brand;
        this.reference = reference;
        this.code = code;
        this.price = price;

    }

    public List<Product> getListOfProducts() {
        return listOfProducts;
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public Code identity() {
        return this.code;
    }
}
