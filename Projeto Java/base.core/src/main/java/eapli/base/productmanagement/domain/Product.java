package eapli.base.productmanagement.domain;

import java.util.List;

public class Product {


    private Barcode barcode;
    private Brand brand;
    private Code code;
    private Description description;
    private Photo photo;
    private Price price;
    private Reference reference;


    private List<Product> listOfProducts;

    public Product(Photo photo, Description description, Brand brand, Reference reference, Code code, Price price){

        if (photo == null || description == null || brand == null || reference == null || code == null || price == price)
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
}
