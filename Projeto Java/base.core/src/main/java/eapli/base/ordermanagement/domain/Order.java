package eapli.base.ordermanagement.domain;

import eapli.base.clientusermanagement.domain.BillingPostalAddresses;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.DeliveringPostalAddresses;
import eapli.base.productmanagement.domain.Price;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Order implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private ClientUser clientUser_id;

    @Temporal(TemporalType.DATE)
    private Calendar createdOn;

    @Embedded
    private DeliveringPostalAddresses deliveringPostalAddress;

    @Embedded
    private BillingPostalAddresses billingPostalAddress;

    @Embedded
    private Cost totalAmountWithTaxes;

    @Embedded
    private Cost totalAmountWithoutTaxes;

    @Embedded
    private ShipmentMethod shipmentMethod;

    @Embedded
    private Cost shipmentCost;

    @Embedded
    private PaymentMethod paymentMethod;

    public Order(ClientUser clientUser_id, Calendar createdOn, DeliveringPostalAddresses deliveringPostalAddress, BillingPostalAddresses billingPostalAddress,
    Cost totalAmountWithTaxes, Cost totalAmountWithoutTaxes, ShipmentMethod shipmentMethod, Cost shipmentCost, PaymentMethod paymentMethod){

        if (clientUser_id == null || createdOn == null || deliveringPostalAddress == null || billingPostalAddress == null || totalAmountWithTaxes == null || totalAmountWithoutTaxes == null || shipmentMethod == null || shipmentCost == null || paymentMethod == null)
            throw new IllegalArgumentException();

        this.clientUser_id = clientUser_id;
        this.createdOn = createdOn;
        this.deliveringPostalAddress = deliveringPostalAddress;
        this.billingPostalAddress = billingPostalAddress;
        this.totalAmountWithTaxes = totalAmountWithTaxes;
        this.totalAmountWithoutTaxes = totalAmountWithoutTaxes;
        this.shipmentMethod = shipmentMethod;
        this.shipmentCost = shipmentCost;
        this.paymentMethod = paymentMethod;
    }

    public Order() {

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

    public Calendar CreatedOn() {
        return createdOn;
    }

    public void modifyCreatedOn(Calendar createdOn) {
        this.createdOn = createdOn;
    }

    public DeliveringPostalAddresses DeliveringPostalAddress() {
        return deliveringPostalAddress;
    }

    public void modifyDeliveringPostalAddress(DeliveringPostalAddresses deliveringPostalAddress) {
        this.deliveringPostalAddress = deliveringPostalAddress;
    }

    public BillingPostalAddresses BillingPostalAddress() {
        return billingPostalAddress;
    }

    public void modifyBillingPostalAddress(BillingPostalAddresses billingPostalAddress) {
        this.billingPostalAddress = billingPostalAddress;
    }

    public Cost TotalAmountWithTaxes() {
        return totalAmountWithTaxes;
    }

    public void modifyTotalAmountWithTaxes(Cost totalAmountWithTaxes) {
        this.totalAmountWithTaxes = totalAmountWithTaxes;
    }

    public Cost TotalAmountWithoutTaxes() {
        return totalAmountWithoutTaxes;
    }

    public void modifyTotalAmountWithoutTaxes(Cost totalAmountWithoutTaxes) {
        this.totalAmountWithoutTaxes = totalAmountWithoutTaxes;
    }

    public ShipmentMethod ShipmentMethod() {
        return shipmentMethod;
    }

    public void modifyShipmentMethod(ShipmentMethod shipmentMethod) {
        this.shipmentMethod = shipmentMethod;
    }

    public Cost ShipmentCost() {
        return shipmentCost;
    }

    public void modifyShipmentCost(Cost shipmentCost) {
        this.shipmentCost = shipmentCost;
    }

    public PaymentMethod PaymentMethod() {
        return paymentMethod;
    }

    public void modifyPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
