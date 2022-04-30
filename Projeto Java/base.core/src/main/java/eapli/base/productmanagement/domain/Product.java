package eapli.base.productmanagement.domain;

import eapli.base.Warehouse.domain.Aisle;
import eapli.base.Warehouse.domain.AisleIdentifier;
import eapli.base.Warehouse.domain.Section;
import eapli.base.Warehouse.domain.Shelf;
import eapli.base.categorymanagement.domain.Category;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"productionCode"}), @UniqueConstraint(columnNames = {"barcode"}), @UniqueConstraint(columnNames = {"reference"})})
public class Product implements AggregateRoot<InternalCode> {



    @EmbeddedId
    private InternalCode internalCode;
    @Embedded
    private Photo photo;
    @Embedded
    private ShortDescription shortDescription;
    @Embedded
    private ExtendedDescription extendedDescription;
    @Embedded
    private TechnicalDescription technicalDescription;
    @Embedded
    private Brand brand;
    @Embedded
    private Reference reference;
    @Embedded
    private ProductionCode productionCode;
    @Embedded
    private Price price;
    @Embedded
    private Barcode barcode;
    @Embedded
    private Height height;
    @Embedded
    private Length length;
    @Embedded
    private Width width;
    @Embedded
    private Weight weight;
    @OneToOne
    private Shelf shelf;
    @ManyToOne(optional = false)
    private Category category;

    public Product(Category category, Photo photo, ShortDescription shortDescription, ExtendedDescription extendedDescription, TechnicalDescription technicalDescription, Brand brand, Reference reference, InternalCode internalCode, Price price, Barcode barcode, Height height, Length length, Width width, Weight weight, Shelf shelf) {

        if (photo == null || shortDescription == null || extendedDescription == null || technicalDescription == null || brand == null || reference == null || internalCode == null || price == null || barcode == null || height == null || length == null || width == null || weight == null || category == null || shelf == null)
            throw new IllegalArgumentException();

        this.photo = photo;
        this.shortDescription = shortDescription;
        this.extendedDescription = extendedDescription;
        this.technicalDescription = technicalDescription;
        this.brand = brand;
        this.reference = reference;
        this.internalCode = internalCode;
        this.price = price;
        this.barcode = barcode;
        this.height = height;
        this.length = length;
        this.width = width;
        this.weight = weight;
        this.category = category;
        this.shelf = shelf;
    }

    public Product(Category category, Photo photo, ShortDescription shortDescription, ExtendedDescription extendedDescription, TechnicalDescription technicalDescription, Brand brand, Reference reference, InternalCode internalCode, ProductionCode productionCode, Price price, Barcode barcode, Height height, Length length, Width width, Weight weight, Shelf shelf){

        if (photo == null || shortDescription == null || extendedDescription == null || technicalDescription == null || brand == null || reference == null || internalCode == null || productionCode == null || price == null || barcode == null || height == null || length == null || width == null || weight== null || category == null || shelf == null)
            throw new IllegalArgumentException();

        this.photo = photo;
        this.shortDescription = shortDescription;
        this.extendedDescription = extendedDescription;
        this.technicalDescription = technicalDescription;
        this.brand = brand;
        this.reference = reference;
        this.internalCode = internalCode;
        this.productionCode = productionCode;
        this.price = price;
        this.barcode = barcode;
        this.height = height;
        this.length = length;
        this.width = width;
        this.weight = weight;
        this.category = category;
        this.shelf = shelf;
    }

    public Product() {

    }

    public Weight getWeight() {
        return weight;
    }

    public Width getWidth() {
        return width;
    }

    public Length getLength() {
        return length;
    }

    public Height getHeight() {
        return height;
    }

    public Barcode getBarcode() {
        return barcode;
    }

    public Price getPrice() {
        return price;
    }

    public ProductionCode getProductionCode() {
        return productionCode;
    }

    public Reference getReference() {
        return reference;
    }

    public Brand getBrand() {
        return brand;
    }

    public TechnicalDescription getTechnicalDescription() {
        return technicalDescription;
    }

    public ExtendedDescription getExtendedDescription() {
        return extendedDescription;
    }

    public ShortDescription getShortDescription() {
        return shortDescription;
    }

    public Photo getPhoto() {
        return photo;
    }


    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public int compareTo(InternalCode other) {
        return AggregateRoot.super.compareTo(other);
    }


    @Override
    public InternalCode identity() {
        return internalCode;
    }

    @Override
    public boolean hasIdentity(InternalCode id) {
        return AggregateRoot.super.hasIdentity(id);
    }

    public InternalCode InternalCode() {
        return internalCode;
    }

    public void modifyInternalCode(InternalCode internalCode) {
        this.internalCode = internalCode;
    }

    public Photo Photo() {
        return photo;
    }

    public void modifysetPhoto(Photo photo) {
        this.photo = photo;
    }

    public ShortDescription ShortDescription() {
        return shortDescription;
    }

    public void modifysetShortDescription(ShortDescription shortDescription) {
        this.shortDescription = shortDescription;
    }

    public ExtendedDescription ExtendedDescription() {
        return extendedDescription;
    }

    public void modifyExtendedDescription(ExtendedDescription extendedDescription) {
        this.extendedDescription = extendedDescription;
    }

    public TechnicalDescription TechnicalDescription() {
        return technicalDescription;
    }

    public void modifyTechnicalDescription(TechnicalDescription technicalDescription) {
        this.technicalDescription = technicalDescription;
    }

    public Brand Brand() {
        return brand;
    }

    public void modifyBrand(Brand brand) {
        this.brand = brand;
    }

    public Reference Reference() {
        return reference;
    }

    public void modifyReference(Reference reference) {
        this.reference = reference;
    }

    public ProductionCode ProductionCode() {
        return productionCode;
    }

    public void modifyProductionCode(ProductionCode productionCode) {
        this.productionCode = productionCode;
    }

    public Price Price() {
        return price;
    }

    public void modifyPrice(Price price) {
        this.price = price;
    }

    public Barcode Barcode() {
        return barcode;
    }

    public void modifyBarcode(Barcode barcode) {
        this.barcode = barcode;
    }

    public Height Height() {
        return height;
    }

    public void modifyHeight(Height height) {
        this.height = height;
    }

    public Length Length() {
        return length;
    }

    public void modifyLength(Length length) {
        this.length = length;
    }

    public Width Width() {
        return width;
    }

    public void modifyWidth(Width width) {
        this.width = width;
    }

    public Weight Weight() {
        return weight;
    }

    public void modifyWeight(Weight weight) {
        this.weight = weight;
    }

    public Category Category() {
        return category;
    }

    public void modifyCategory(Category category) {
        this.category = category;
    }

    public Shelf Shelf() {
        return shelf;
    }

    public void modifyShelf(Shelf shelf) {
        this.shelf = shelf;
    }
}
