package eapli.base.ordermanagement.domain;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.CategoryCode;
import eapli.base.categorymanagement.domain.CategoryDescription;
import eapli.base.clientusermanagement.domain.BillingPostalAddresses;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.ClientUserBuilder;
import eapli.base.clientusermanagement.domain.DeliveringPostalAddresses;
import eapli.base.orderstatusmanagement.domain.Status;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.domain.ProductBuilder;
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

public class OrderLineTest {
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
        ProductOrderBuilder builder = new ProductOrderBuilder(client, CREATEDON);
        return builder.build();
    }

    private OrderLine OrderLineBuild() {
        ProductOrder porder = ProductOrderBuild();
        Category cat = new Category(new CategoryCode("abc123"), new CategoryDescription("Description"));
        Product product = new Product();
        OrderLineBuilder obuilder = new OrderLineBuilder(product, porder, 2, 15.0);
        return obuilder.build();
    }

    @Test
    public void ensureCanChangeQuantity() {
        final OrderLine subject = OrderLineBuild();

        final Quantity newInfo = new Quantity(2);

        subject.modifyQuantity(newInfo);

        assertEquals(newInfo, subject.Quantity());
    }

    @Test
    public void ensureCanChangeUnitPrice() {
        final OrderLine subject = OrderLineBuild();

        final Cost newInfo = new Cost(2);

        subject.modifyUnitPrice(newInfo);

        assertEquals(newInfo, subject.UnitPrice());
    }

    @Test
    public void ensureOrderLineEqualsAreTheSameForTheSameInstance() {

        final OrderLine subject = OrderLineBuild();

        final boolean expected = subject.equals(subject);

        assertTrue(expected);
    }

    @Test
    public void ensureOrderLineEqualsFailsForDifferenteObjectTypes() {

        final OrderLine subject = OrderLineBuild();

        final boolean expected = subject.equals(new Product());

        assertFalse(expected);
    }

    @Test
    public void ensureOrderLineIsTheSameAsItsInstance() {

        final OrderLine subject = OrderLineBuild();

        final boolean expected = subject.sameAs(subject);

        assertTrue(expected);
    }

    @Test
    public void ensureTwoOrderLineWithDifferentAGVIdentifierAreNotTheSame() {
        final OrderLine subject1 = OrderLineBuild();

        final OrderLine subject2 = OrderLineBuild();
        subject1.modifyQuantity(new Quantity(2));
        final boolean expected = subject1.sameAs(subject2);

        assertTrue(expected);
    }
}