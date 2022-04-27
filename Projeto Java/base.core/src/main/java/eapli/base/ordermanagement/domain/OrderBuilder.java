package eapli.base.ordermanagement.domain;

import eapli.base.clientusermanagement.domain.BillingPostalAddresses;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.DeliveringPostalAddresses;
import eapli.base.orderstatusmanagement.domain.Status;
import eapli.framework.domain.model.DomainFactory;

import java.util.Calendar;

public class OrderBuilder implements DomainFactory<ProductOrder> {

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

    public OrderBuilder(final ClientUser clientvat, final Calendar createdOn, final Status status) {
        withClientVat(clientvat);
        withStatus(status);
        withCreatedOn(createdOn);
        withDeliveringPostalAddresses(null);
        withBillingPostalAddresses(null);
        withTotalAmountWithTaxes(null);
        withTotalAmountWithoutTaxes(null);
        withShipmentMethod("null");
        withShipmentCost(null);
        withPaymentMethod("null");
    }



    public OrderBuilder(final ClientUser clientvat, final Status status, final Calendar createdOn, final String deliveringPostalAddress, final String billingPostalAddress,
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

    public OrderBuilder withClientVat(ClientUser client) {
        this.clientUser = client;
        return this;
    }

    public OrderBuilder withStatus(Status status) {
        this.status = status;
        return this;
    }

    public OrderBuilder withCreatedOn(final Calendar createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public OrderBuilder withDeliveringPostalAddresses(final String deliveringPostalAddress) {
        if (deliveringPostalAddress == null) return null;
        this.deliveringPostalAddress = new DeliveringPostalAddresses(deliveringPostalAddress);
        return this;
    }

    public OrderBuilder withBillingPostalAddresses(final String billingPostalAddress) {
        if (billingPostalAddress == null) return null;
        this.billingPostalAddress = new BillingPostalAddresses(billingPostalAddress);
        return this;
    }

    public OrderBuilder withTotalAmountWithTaxes(final Double totalAmountWithTaxes) {
        if (totalAmountWithTaxes == null) return null;
        this.totalAmountWithTaxes = new TotalAmountWithTaxes(totalAmountWithTaxes);
        return this;
    }

    public OrderBuilder withTotalAmountWithoutTaxes(final Double totalAmountWithoutTaxes) {
        if (totalAmountWithoutTaxes == null) return null;
        this.totalAmountWithoutTaxes = new TotalAmountWithoutTaxes(totalAmountWithoutTaxes);
        return this;
    }

    public OrderBuilder withShipmentMethod(final String shipmentMethod) {
        this.shipmentMethod = new ShipmentMethod(shipmentMethod);
        return this;
    }

    public OrderBuilder withShipmentCost(final Double shipmentCost) {
        if (shipmentCost == null) return null;
        this.shipmentCost = new ShipmentCost(shipmentCost);
        return this;
    }

    public OrderBuilder withPaymentMethod(final String paymentMethod) {
        this.paymentMethod = new PaymentMethod(paymentMethod);
        return this;
    }

    private ProductOrder buildOrThrow() {
        if (productOrder != null) {
            return productOrder;
        } else if (clientUser != null && status != null && createdOn != null && deliveringPostalAddress == null && billingPostalAddress == null && totalAmountWithTaxes == null && totalAmountWithoutTaxes == null && shipmentMethod.getShipmentMethod().equals("null") && shipmentCost == null && paymentMethod.getPaymentMethod().equals("null")) {
            productOrder = new ProductOrder(clientUser, status, createdOn);
            return productOrder;
        } else if (clientUser != null && status != null && createdOn != null && deliveringPostalAddress != null && billingPostalAddress != null && totalAmountWithTaxes != null && totalAmountWithoutTaxes != null && !shipmentMethod.getShipmentMethod().equals("null") && shipmentCost != null && !paymentMethod.getPaymentMethod().equals("null")) {
            productOrder = new ProductOrder(clientUser, status, createdOn, deliveringPostalAddress, billingPostalAddress, totalAmountWithTaxes, totalAmountWithoutTaxes, shipmentMethod, shipmentCost, paymentMethod);
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
