package eapli.base.productmanagement.domain;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;

public class ProductBuilder {

    private Barcode barcode;
    private Brand brand;
    private Code code;
    private Description description;
    private Photo photo;
    private Price price;
    private Reference reference;

    public ProductBuilder(final String setOfPhotos, final String shortDescription, final String extendedDescription,
                   final String technicalDescription,
                   final String brand, final String reference, final String productionCode, final String internalCode, double price){
        withPhoto(setOfPhotos);
        withDescription(shortDescription, extendedDescription, technicalDescription);
        withBrand(brand);
        withReference(reference);
        withCode(productionCode, internalCode);
        withPrice(price);
    }



    public ProductBuilder(final String setOfPhotos, final String shortDescription, final String extendedDescription,
                          final String technicalDescription,
                          final String brand, final String reference, final String internalCode, double price){

        withPhoto(setOfPhotos);
        withDescription(shortDescription, extendedDescription, technicalDescription);
        withBrand(brand);
        withReference(reference);
        withCode(internalCode);
        withPrice(price);

    }

    public ProductBuilder withPhoto(String setOfPhotos) {
        this.photo = new Photo(setOfPhotos);
        return this;
    }

    public ProductBuilder withDescription(final String shortDescription, final String extendedDescription,
                                          final String technicalDescription) {
        this.description = new Description(shortDescription, extendedDescription, technicalDescription);
        return this;
    }

    public ProductBuilder withBrand(final String brand) {
        this.brand = new Brand(brand);
        return this;
    }

    public ProductBuilder withReference(final String reference) {
        this.reference = new Reference(reference);
        return this;
    }

    public ProductBuilder withCode(final String productionCode, final String internalCode) {
        this.code = new Code(productionCode, internalCode);
        return this;
    }

    public ProductBuilder withCode(final String internalCode) {
        this.code = new Code(internalCode);
        return this;
    }

    public ProductBuilder withPrice(final double price) {
        this.price = new Price(price);
        return this;
    }

    public Product build() {
        // since the factory knows that all the parts are needed it could throw
        // an exception. however, we will leave that to the constructor
        return new Product(this.photo, this.description, this.brand, this.reference, this.code, this.price);
    }


}
