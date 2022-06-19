package eapli.base.ordermanagement.domain;

import eapli.base.agvmanagement.domain.AGV;
import eapli.base.clientusermanagement.domain.BillingPostalAddresses;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.DeliveringPostalAddresses;
import eapli.base.orderstatusmanagement.domain.Status;
import eapli.framework.domain.model.DomainFactory;

import java.util.Calendar;
import java.util.Set;

public class ProductOrderBuilder implements DomainFactory<ProductOrder> {

    private ProductOrder productOrder;
    private ClientUser clientUser;
    private Status status;
    private Calendar createdOn;
    private DeliveringPostalAddresses deliveringPostalAddress;
    private BillingPostalAddresses billingPostalAddress;
    private TotalAmountWithTaxes totalAmountWithTaxes;
    private TotalAmountWithoutTaxes totalAmountWithoutTaxes;
    private ShipmentMethod shipmentMethod;
    private ShipmentCost shipmentCost;
    private PaymentMethod paymentMethod;
    private AGV agv;

    public ProductOrderBuilder(final ClientUser clientvat, final Calendar createdOn) {
        withClientVat(clientvat);
        withCreatedOn(createdOn);
        withShipmentCost(0d);
        withTotalAmountWithoutTaxes(0d);
        withTotalAmountWithTaxes(0d);
    }



    public ProductOrderBuilder(final ClientUser clientvat, final Status status, final Calendar createdOn, final Set<String[]> deliveringPostalAddress, final Set<String[]> billingPostalAddress,
                               final double totalAmountWithTaxes, final double totalAmountWithoutTaxes, final String shipmentMethod, final double shipmentCost, final String paymentMethod) {
        withClientVat(clientvat);
        withStatus(status);
        withCreatedOn(createdOn);
        withDeliveringPostalAddresses(deliveringPostalAddress);
        withBillingPostalAddresses(billingPostalAddress);
        withTotalAmountWithTaxes(totalAmountWithTaxes);
        withTotalAmountWithoutTaxes(totalAmountWithoutTaxes);
        withShipmentMethod(shipmentMethod);
        withShipmentCost(shipmentCost);
        withPaymentMethod(paymentMethod);
    }

    public ProductOrderBuilder(final ClientUser clientvat, final Status status, final Calendar createdOn, final Set<String[]> deliveringPostalAddress, final Set<String[]> billingPostalAddress,
                               final double totalAmountWithTaxes, final double totalAmountWithoutTaxes, final String shipmentMethod, final double shipmentCost, final String paymentMethod, final AGV agv) {
        withClientVat(clientvat);
        withStatus(status);
        withCreatedOn(createdOn);
        withDeliveringPostalAddresses(deliveringPostalAddress);
        withBillingPostalAddresses(billingPostalAddress);
        withTotalAmountWithTaxes(totalAmountWithTaxes);
        withTotalAmountWithoutTaxes(totalAmountWithoutTaxes);
        withShipmentMethod(shipmentMethod);
        withShipmentCost(shipmentCost);
        withPaymentMethod(paymentMethod);
        withAGV(agv);
    }

    public ProductOrderBuilder withClientVat(ClientUser client) {
        this.clientUser = client;
        return this;
    }

    public ProductOrderBuilder withStatus(Status status) {
        this.status = status;
        return this;
    }

    public ProductOrderBuilder withCreatedOn(final Calendar createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public ProductOrderBuilder withDeliveringPostalAddresses(final Set<String[]> deliveringPostalAddress) {
        if (deliveringPostalAddress == null) return null;
        this.deliveringPostalAddress = new DeliveringPostalAddresses(deliveringPostalAddress);
        return this;
    }

    public ProductOrderBuilder withBillingPostalAddresses(final Set<String[]> billingPostalAddress) {
        if (billingPostalAddress == null) return null;
        this.billingPostalAddress = new BillingPostalAddresses(billingPostalAddress);
        return this;
    }

    public ProductOrderBuilder withTotalAmountWithTaxes(final Double totalAmountWithTaxes) {
        this.totalAmountWithTaxes = new TotalAmountWithTaxes(totalAmountWithTaxes);
        return this;
    }

    public ProductOrderBuilder withTotalAmountWithoutTaxes(final Double totalAmountWithoutTaxes) {
        this.totalAmountWithoutTaxes = new TotalAmountWithoutTaxes(totalAmountWithoutTaxes);
        return this;
    }

    public ProductOrderBuilder withShipmentMethod(final String shipmentMethod) {
        this.shipmentMethod = new ShipmentMethod(shipmentMethod);
        return this;
    }

    public ProductOrderBuilder withShipmentCost(final Double shipmentCost) {
        this.shipmentCost = new ShipmentCost(shipmentCost);
        return this;
    }

    public ProductOrderBuilder withPaymentMethod(final String paymentMethod) {
        this.paymentMethod = new PaymentMethod(paymentMethod);
        return this;
    }

    public ProductOrderBuilder withAGV(final AGV agv) {
       this.agv = agv;
       return this;
    }

    private ProductOrder buildOrThrow() {
        if (productOrder != null) {
            return productOrder;
        } else if (clientUser != null && status != null && createdOn != null && deliveringPostalAddress != null && billingPostalAddress != null && totalAmountWithTaxes != null && totalAmountWithoutTaxes != null && shipmentMethod != null && shipmentCost != null && paymentMethod != null) {
            productOrder = new ProductOrder(clientUser, status, createdOn, deliveringPostalAddress, billingPostalAddress, totalAmountWithTaxes, totalAmountWithoutTaxes, shipmentMethod, shipmentCost, paymentMethod);
            return productOrder;
        } else if (clientUser != null && createdOn != null && shipmentCost != null && totalAmountWithoutTaxes != null && totalAmountWithTaxes != null) {
            productOrder = new ProductOrder(clientUser, createdOn);
            return productOrder;
        } else if (clientUser != null && status != null && createdOn != null && deliveringPostalAddress != null && billingPostalAddress != null && totalAmountWithTaxes != null && totalAmountWithoutTaxes != null && shipmentMethod != null && shipmentCost != null && paymentMethod != null && agv != null){
            productOrder = new ProductOrder(clientUser, status, createdOn, deliveringPostalAddress, billingPostalAddress, totalAmountWithTaxes, totalAmountWithoutTaxes, shipmentMethod, shipmentCost, paymentMethod, agv);
            return productOrder;
        } else {
            throw new IllegalStateException();
        }
    }

    public ProductOrder build() {
        final ProductOrder ret = buildOrThrow();
        return ret;
    }
}
