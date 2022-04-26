package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;



@Entity
public class Product implements AggregateRoot<InternalCode> {

    @Id
    private InternalCode internalCode;
    private Photo photo;
    private ShortDescription shortDescription;
    private ExtendedDescription extendedDescription;
    private TechnicalDescription technicalDescription;
    private Brand brand;
    private Reference reference;
    private ProductionCode productionCode;
    private Price price;
    private Barcode barcode;


    public Product(Photo photo, ShortDescription shortDescription, ExtendedDescription extendedDescription, TechnicalDescription technicalDescription, Brand brand, Reference reference, InternalCode internalCode, Price price, Barcode barcode){

        if (photo == null || shortDescription == null || extendedDescription == null || technicalDescription == null || brand == null || reference == null || internalCode == null || price == null || barcode == null)
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

    }

    public Product(Photo photo, ShortDescription shortDescription, ExtendedDescription extendedDescription, TechnicalDescription technicalDescription, Brand brand, Reference reference, InternalCode internalCode, ProductionCode productionCode, Price price, Barcode barcode){

        if (photo == null || shortDescription == null || extendedDescription == null || technicalDescription == null || brand == null || reference == null || internalCode == null || price == null || barcode == null)
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

    }

    public Product() {

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
}
