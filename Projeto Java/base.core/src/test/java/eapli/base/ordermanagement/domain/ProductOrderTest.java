package eapli.base.ordermanagement.domain;

import eapli.base.Warehouse.domain.AGVDock;
import eapli.base.agvmanagement.domain.*;
import eapli.base.clientusermanagement.domain.BillingPostalAddresses;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.ClientUserBuilder;
import eapli.base.clientusermanagement.domain.DeliveringPostalAddresses;
import eapli.base.orderstatusmanagement.domain.Status;
import eapli.base.productmanagement.domain.Product;
import eapli.base.taskmanagement.domain.Description;
import eapli.base.taskmanagement.domain.Task;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.domain.model.*;
import eapli.framework.time.util.Calendars;
import org.junit.Test;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ProductOrderTest {
    private static final Calendar CREATEDON = Calendars.now();
    private static final String DELIVERING_POSTAL_ADDRESS = "a,1,4555-423,a,a";
    private static final String BILLING_POSTAL_ADDRESS = "a,1,4555-423,a,a";
    private static final double TOTAL_AMOUNT_WITH_TAXES = 45d;
    private static final double TOTAL_AMOUNT_WITHOUT_TAXES = 50d;
    private static final String SHIPMENT_METHOD = "Blue";
    private static final String PAYMENT_METHOD = "Paypal";
    private static final double SHIPMENT_COST = 1d;
    private final SystemUser USER = getNewDummyUser();
    private static final String VAT = "123123123";
    private static final String PHONE_NUMBER = "+351912912912";
    private static final String GENDER = "Male";
    private static final String BIRTHDAY = "2022/01/01";

    public static SystemUser dummyUser(final String username, final Role... roles) {
        // should we load from spring context?
        final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        return userBuilder.with(username, "duMMy1", "dummy", "dummy", "a@b.ro").withRoles(roles).build();
    }

    private SystemUser getNewDummyUser() {
        return dummyUser("dummy", BaseRoles.ADMIN);
    }

    private ProductOrder ProductOrderBuild() {
        ClientUserBuilder b = new ClientUserBuilder();
        b.withSystemUser(USER);
        b.withVAT(VAT);
        b.withPhoneNumber(PHONE_NUMBER);
        b.withGender(GENDER);
        b.withBirthDay(BIRTHDAY);
        Set<String[]> set = new HashSet<>();
        String[] s = new String[5];
        s[0] = "a";
        s[1] = "1";
        s[2] = "4555-423";
        s[3] = "a";
        s[4] = "a";
        set.add(s);
        b.withDelAddress(set);
        b.withBillAddress(set);
        ClientUser client = b.build();
        Status status = new Status();
        ProductOrderBuilder builder = new ProductOrderBuilder(client, CREATEDON, status);
        return builder.build();
    }

    @Test
    public void ensureProductOrderWithAllAttributes() {
        ClientUserBuilder b = new ClientUserBuilder();
        b.withSystemUser(USER);
        b.withVAT(VAT);
        b.withPhoneNumber(PHONE_NUMBER);
        b.withGender(GENDER);
        b.withBirthDay(BIRTHDAY);
        Set<String[]> set = new HashSet<>();
        String[] s = new String[5];
        s[0] = "a";
        s[1] = "1";
        s[2] = "4555-423";
        s[3] = "a";
        s[4] = "a";
        set.add(s);
        b.withDelAddress(set);
        b.withBillAddress(set);
        ClientUser client = b.build();
        Status status = new Status();
        ProductOrderBuilder builder = new ProductOrderBuilder(client, status, CREATEDON, set,
                set, TOTAL_AMOUNT_WITH_TAXES, TOTAL_AMOUNT_WITHOUT_TAXES, SHIPMENT_METHOD, SHIPMENT_COST, PAYMENT_METHOD);
        builder.build();
        assertTrue(true);
    }

    @Test
    public void ensureCanChangeTotalAmountWithoutTaxes() {
        final ProductOrder subject = ProductOrderBuild();

        final TotalAmountWithoutTaxes newInfo = new TotalAmountWithoutTaxes(2d);

        subject.modifyTotalAmountWithoutTaxes(newInfo);

        assertEquals(newInfo, subject.TotalAmountWithoutTaxes());
    }

    @Test
    public void ensureCanChangeTotalAmountWithTaxes() {
        final ProductOrder subject = ProductOrderBuild();

        final TotalAmountWithTaxes newInfo = new TotalAmountWithTaxes(2d);

        subject.modifyTotalAmountWithTaxes(newInfo);

        assertEquals(newInfo, subject.TotalAmountWithTaxes());
    }

    @Test
    public void ensureCanChangeCreatedOn() {
        final ProductOrder subject = ProductOrderBuild();

        final Calendar newInfo = Calendars.now();

        subject.modifyCreatedOn(newInfo);

        assertEquals(newInfo, subject.CreatedOn());
    }

    @Test
    public void ensureCanChangeShipmentMethod() {
        final ProductOrder subject = ProductOrderBuild();

        final ShipmentMethod newInfo = new ShipmentMethod("Standard");

        subject.modifyShipmentMethod(newInfo);

        assertEquals(newInfo, subject.ShipmentMethod());
    }

    @Test
    public void ensureCanChangeShipmentCost() {
        final ProductOrder subject = ProductOrderBuild();

        final ShipmentCost newInfo = new ShipmentCost(5d);

        subject.modifyShipmentCost(newInfo);

        assertEquals(newInfo, subject.ShipmentCost());
    }

    @Test
    public void ensureCanChangePaymentMethod() {
        final ProductOrder subject = ProductOrderBuild();

        final PaymentMethod newInfo = new PaymentMethod("Paypal");

        subject.modifyPaymentMethod(newInfo);

        assertEquals(newInfo, subject.PaymentMethod());
    }

    @Test
    public void ensureCanChangeDeliveringAddress() {
        final ProductOrder subject = ProductOrderBuild();

        Set<String[]> set = new HashSet<>();
        String[] s = new String[5];
        s[0] = "abc";
        s[1] = "1";
        s[2] = "4555-423";
        s[3] = "abc";
        s[4] = "abc";
        set.add(s);

        final DeliveringPostalAddresses newInfo = new DeliveringPostalAddresses(set);

        subject.modifyDeliveringPostalAddress(newInfo);

        assertEquals(newInfo, subject.DeliveringPostalAddress());
    }

    @Test
    public void ensureCanChangeBillingAddress() {
        final ProductOrder subject = ProductOrderBuild();

        Set<String[]> set = new HashSet<>();
        String[] s = new String[5];
        s[0] = "abc";
        s[1] = "1";
        s[2] = "4555-423";
        s[3] = "abc";
        s[4] = "abc";
        set.add(s);

        final BillingPostalAddresses newInfo = new BillingPostalAddresses(set);

        subject.modifyBillingPostalAddress(newInfo);

        assertEquals(newInfo, subject.BillingPostalAddress());
    }

    @Test
    public void ensureProductOrderEqualsAreTheSameForTheSameInstance() {
        final ProductOrder productOrder = ProductOrderBuild();

        final boolean expected = productOrder.equals(productOrder);

        assertTrue(expected);
    }

    @Test
    public void ensureProductOrderEqualsFailsForDifferenteObjectTypes() {

        final ProductOrder productOrder = ProductOrderBuild();

        final boolean expected = productOrder.equals(new Product());

        assertFalse(expected);
    }

    @Test
    public void ensureProductOrderIsTheSameAsItsInstance() {

        final ProductOrder productOrder = ProductOrderBuild();

        final boolean expected = productOrder.sameAs(productOrder);

        assertTrue(expected);
    }

    @Test
    public void ensureTwoProductOrderWithDifferentAGVIdentifierAreNotTheSame() {
        final ProductOrder productOrder = ProductOrderBuild();

        final ProductOrder productOrder1 = ProductOrderBuild();
        productOrder1.modifyShipmentMethod(new ShipmentMethod("Blue"));
        final boolean expected = productOrder.sameAs(productOrder1);

        assertTrue(expected);
    }

    @Test
    public void ensureModifyAgv() {

        Description description = new Description("task");
        Task task = new Task(description);
        AGVDock agvDock = new AGVDock();
        AGV agv=new AGVBuilder("abc123", "description", 120d, 500d, "model", task, 100d, agvDock).build();


        final ProductOrder productOrder = ProductOrderBuild();




        productOrder.modifyAgv(agv);

        assertEquals(productOrder.Agv(), agv);

    }

    @Test
    public void ensureModifyStatus() {

        Description description = new Description("task");
        Task task = new Task(description);
        AGVDock agvDock = new AGVDock();
        AGV agv=new AGVBuilder("abc123", "description", 120d, 500d, "model", task, 100d, agvDock).build();


        final ProductOrder productOrder = ProductOrderBuild();

        Status status=new Status(new eapli.base.orderstatusmanagement.domain.Description( "description"));

        productOrder.modifyStatus(status);




        assertEquals(productOrder.Status(), status);
    }
}