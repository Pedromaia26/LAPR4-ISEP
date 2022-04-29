package eapli.base.productmanagement.domain;

import eapli.base.Warehouse.domain.Aisle;
import eapli.base.Warehouse.domain.Section;
import eapli.base.Warehouse.domain.Shelf;
import eapli.base.categorymanagement.domain.Category;
import eapli.framework.domain.model.DomainFactory;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class ProductBuilder implements DomainFactory<Product> {

    private Product product;
    private Barcode barcode;
    private Brand brand;
    private InternalCode internalCode;
    private ProductionCode productionCode;
    private ShortDescription shortDescription;
    private ExtendedDescription extendedDescription;
    private TechnicalDescription technicalDescription;
    private Photo photo;
    private Price price;
    private Reference reference;
    private Height height;
    private Length length;
    private Width width;
    private Weight weight;
    private Category category;
    private Aisle aisle;
    private Section section;
    private Shelf shelf;

    public ProductBuilder(final Category category, final List<String>  setOfPhotos, final String shortDescription, final String extendedDescription,
                          final String technicalDescription,
                          final String brand, final String reference, final String productionCode, final String internalCode,
                          final double price, String barcode, final double height, final double length, final double width, final double weight,
                       final Shelf shelf) throws IOException {
        withPhoto(setOfPhotos);
        withShortDescription(shortDescription);
        withExtendedDescription(extendedDescription);
        withTechnicalDescription(technicalDescription);
        withBrand(brand);
        withReference(reference);
        withInternalCode(internalCode);
        withProductionCode(productionCode);
        withPrice(price);
        withBarcode(barcode);
        withHeight(height);
        withLength(length);
        withWidth(width);
        withWeight(weight);
        withCategory(category);
        withShelf(shelf);

    }




    public ProductBuilder(final Category category, final List<String> setOfPhotos, final String shortDescription, final String extendedDescription,
                          final String technicalDescription,
                          final String brand, final String reference, final String internalCode, final double price, final String barcode,
                          final double height, final double length, final double width, final double weight, final Shelf shelf) throws IOException {

        withPhoto(setOfPhotos);
        withShortDescription(shortDescription);
        withExtendedDescription(extendedDescription);
        withTechnicalDescription(technicalDescription);
        withBrand(brand);
        withReference(reference);
        withInternalCode(internalCode);
        withPrice(price);
        withBarcode(barcode);
        withHeight(height);
        withLength(length);
        withWidth(width);
        withWeight(weight);
        withCategory(category);
        withShelf(shelf);
    }

    public ProductBuilder withPhoto(List<String>  setOfPhotos) throws IOException {
        this.photo = new Photo(setOfPhotos);
        return this;
    }

    public ProductBuilder withShortDescription(final String shortDescription) {
        this.shortDescription = new ShortDescription(shortDescription);
        return this;
    }

    public ProductBuilder withExtendedDescription(final String extendedDescription) {
        this.extendedDescription = new ExtendedDescription(extendedDescription);
        return this;
    }

    public ProductBuilder withTechnicalDescription(final String technicalDescription) {
        this.technicalDescription = new TechnicalDescription(technicalDescription);
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

    public ProductBuilder withInternalCode(final String internalCode) {
        this.internalCode = new InternalCode(internalCode);
        return this;
    }

    public ProductBuilder withProductionCode(final String productionCode) {
        this.productionCode = new ProductionCode(productionCode);
        return this;
    }

    public ProductBuilder withPrice(final double price) {
        this.price = new Price(price);
        return this;
    }

    public ProductBuilder withBarcode(String barcode) {
        this.barcode = new Barcode(barcode);
        return this;
    }

    public ProductBuilder withHeight(double height) {
        this.height = new Height(height);
        return this;
    }

    public ProductBuilder withLength(double length) {
        this.length = new Length(length);
        return this;
    }

    public ProductBuilder withWidth(double width) {
        this.width = new Width(width);
        return this;
    }

    public ProductBuilder withWeight(double weight) {
        this.weight = new Weight(weight);
        return this;
    }

    public ProductBuilder withCategory(Category category) {
        this.category = category;
        return this;
    }

    public ProductBuilder withShelf(Shelf shelf) {
        this.shelf = shelf;
        return this;
    }

    private Product buildOrThrow() {
        if (product != null) {
            return product;
        } else if (barcode != null && brand != null && internalCode != null && shortDescription != null && extendedDescription != null && technicalDescription != null && photo != null && price != null && reference != null && productionCode == null && height != null && length != null && width != null && weight != null && category != null && shelf != null) {
            product = new Product(category, photo, shortDescription, extendedDescription, technicalDescription, brand, reference, internalCode, price, barcode, height, length, width, weight, shelf);
            return product;
        } else if (barcode != null && brand != null && internalCode != null && shortDescription != null && extendedDescription != null && technicalDescription != null && photo != null && price != null && reference != null && productionCode != null && height != null && length != null && width != null && weight != null && category != null && shelf != null) {
            product = new Product(category, photo, shortDescription, extendedDescription, technicalDescription, brand, reference, internalCode, productionCode, price, barcode, height, length, width, weight, shelf);
            return product;
        } else {
            throw new IllegalStateException();
        }
    }

    public Product build() {
        final Product ret = buildOrThrow();
        return ret;
    }


}
