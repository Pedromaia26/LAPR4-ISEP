package eapli.base.ordermanagement.domain;

import eapli.base.agvmanagement.domain.AGV;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.clientusermanagement.domain.BillingPostalAddresses;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.DeliveringPostalAddresses;
import eapli.base.orderstatusmanagement.domain.Status;
import eapli.base.productmanagement.domain.Price;
import eapli.base.productmanagement.domain.Product;
import eapli.base.taskmanagement.domain.Task;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class ProductOrder implements AggregateRoot<Long> {

    @Version
    private Long version;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private ClientUser clientUser;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    private Status status;

    @Temporal(TemporalType.DATE)
    private Calendar createdOn;

    @Embedded
    private DeliveringPostalAddresses deliveringPostalAddress;

    @Embedded
    private BillingPostalAddresses billingPostalAddress;

    @Embedded
    private TotalAmountWithTaxes totalAmountWithTaxes;

    @Embedded
    private TotalAmountWithoutTaxes totalAmountWithoutTaxes;

    @Embedded
    private ShipmentMethod shipmentMethod;

    @Embedded
    private ShipmentCost shipmentCost;

    @Embedded
    private PaymentMethod paymentMethod;

    @OneToOne
    private AGV agv;

    public ProductOrder(ClientUser clientUser_id, Status status, Calendar createdOn, DeliveringPostalAddresses deliveringPostalAddress, BillingPostalAddresses billingPostalAddress, TotalAmountWithTaxes totalAmountWithTaxes, TotalAmountWithoutTaxes totalAmountWithoutTaxes, ShipmentMethod shipmentMethod, ShipmentCost shipmentCost, PaymentMethod paymentMethod){

        if (clientUser_id == null || createdOn == null || deliveringPostalAddress == null || billingPostalAddress == null || totalAmountWithTaxes == null || totalAmountWithoutTaxes == null || shipmentMethod == null || shipmentCost == null || paymentMethod == null)
            throw new IllegalArgumentException();

        this.clientUser = clientUser_id;
        this.status = status;
        this.createdOn = createdOn;
        this.deliveringPostalAddress = deliveringPostalAddress;
        this.billingPostalAddress = billingPostalAddress;
        this.totalAmountWithTaxes = totalAmountWithTaxes;
        this.totalAmountWithoutTaxes = totalAmountWithoutTaxes;
        this.shipmentMethod = shipmentMethod;
        this.shipmentCost = shipmentCost;
        this.paymentMethod = paymentMethod;
    }

    public ProductOrder(ClientUser clientUser_id, Status status, Calendar createdOn){

        if (clientUser_id == null || createdOn == null)
            throw new IllegalArgumentException();
        this.clientUser = clientUser_id;
        this.status = status;
        this.createdOn = createdOn;
    }

    public ProductOrder(ClientUser clientUser_id, Status status, Calendar createdOn, DeliveringPostalAddresses deliveringPostalAddress, BillingPostalAddresses billingPostalAddress, TotalAmountWithTaxes totalAmountWithTaxes, TotalAmountWithoutTaxes totalAmountWithoutTaxes, ShipmentMethod shipmentMethod, ShipmentCost shipmentCost, PaymentMethod paymentMethod, AGV agv){

        if (clientUser_id == null || createdOn == null || deliveringPostalAddress == null || billingPostalAddress == null || totalAmountWithTaxes == null || totalAmountWithoutTaxes == null || shipmentMethod == null || shipmentCost == null || paymentMethod == null)
            throw new IllegalArgumentException();

        this.clientUser = clientUser_id;
        this.status = status;
        this.createdOn = createdOn;
        this.deliveringPostalAddress = deliveringPostalAddress;
        this.billingPostalAddress = billingPostalAddress;
        this.totalAmountWithTaxes = totalAmountWithTaxes;
        this.totalAmountWithoutTaxes = totalAmountWithoutTaxes;
        this.shipmentMethod = shipmentMethod;
        this.shipmentCost = shipmentCost;
        this.paymentMethod = paymentMethod;
        this.agv = agv;
    }

    public ProductOrder() {

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

    public TotalAmountWithTaxes TotalAmountWithTaxes() {
        return totalAmountWithTaxes;
    }

    public void modifyTotalAmountWithTaxes(TotalAmountWithTaxes totalAmountWithTaxes) {
        this.totalAmountWithTaxes = totalAmountWithTaxes;
    }

    public TotalAmountWithoutTaxes TotalAmountWithoutTaxes() {
        return totalAmountWithoutTaxes;
    }

    public void modifyTotalAmountWithoutTaxes(TotalAmountWithoutTaxes totalAmountWithoutTaxes) {
        this.totalAmountWithoutTaxes = totalAmountWithoutTaxes;
    }

    public ShipmentMethod ShipmentMethod() {
        return shipmentMethod;
    }

    public void modifyShipmentMethod(ShipmentMethod shipmentMethod) {
        this.shipmentMethod = shipmentMethod;
    }

    public ShipmentCost ShipmentCost() {
        return shipmentCost;
    }

    public void modifyShipmentCost(ShipmentCost shipmentCost) {
        this.shipmentCost = shipmentCost;
    }

    public PaymentMethod PaymentMethod() {
        return paymentMethod;
    }

    public void modifyPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public AGV Agv() {
        return agv;
    }

    public void modifyAgv(AGV agv) {
        this.agv = agv;
    }

    public void modifyStatus(Status status) {
        this.status = status;
    }

    public Status Status() {
        return status;
    }

    public ClientUser clientUser() {
        return clientUser;
    }
}
