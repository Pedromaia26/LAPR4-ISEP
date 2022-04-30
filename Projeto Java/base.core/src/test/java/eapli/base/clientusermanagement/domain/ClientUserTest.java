/*
 * Copyright (c) 2013-2019 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.clientusermanagement.domain;

import java.util.HashSet;
import java.util.Set;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.CategoryBuilder;
import org.junit.Test;

import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.domain.model.NilPasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;

import static org.junit.Assert.*;

/**
 * Created by Nuno Bettencourt [NMB] on 03/04/16.
 */
public class ClientUserTest {

    private final SystemUser USER = getNewDummyUser();
    private final String VAT = "123123123";
    private final String PHONE_NUMBER = "+351912912912";
    private final String GENDER = "Male";
    private final String BIRTHDAY = "2022/01/01";
    private final String DELIVERING_POSTAL_ADDRESS = "a,1,4555-423,a,a";
    private final String BILLING_POSTAL_ADDRESS = "a,1,4555-423,a,a";

    public static SystemUser dummyUser(final String username, final Role... roles) {
        // should we load from spring context?
        final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        return userBuilder.with(username, "duMMy1", "dummy", "dummy", "a@b.ro").withRoles(roles).build();
    }

    private SystemUser getNewDummyUser() {
        return dummyUser("dummy", BaseRoles.ADMIN);
    }

    private ClientUser ClientBuild() {
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
        return b.build();
    }

    @Test
    public void ensureClientUserEqualsPassesForTheSameVAT(){

        final ClientUser aClientUser = ClientBuild();

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

        final ClientUser anotherClientUser = b.build();

        final boolean expected = aClientUser.equals(anotherClientUser);

        assertTrue(expected);
    }

    @Test
    public void ensureClientUserEqualsFailsForDifferenteVAT() {
        final ClientUser aClientUser = ClientBuild();

        ClientUserBuilder b = new ClientUserBuilder();
        b.withSystemUser(USER);
        b.withVAT("123456789");
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

        final ClientUser anotherClientUser = b.build();

        final boolean expected = aClientUser.equals(anotherClientUser);

        assertFalse(expected);
    }

    @Test
    public void ensureClientUserEqualsAreTheSameForTheSameInstance() {
        final ClientUser aClientUser = new ClientUser();

        final boolean expected = aClientUser.equals(aClientUser);

        assertTrue(expected);
    }

    @Test
    public void ensureClientUserEqualsFailsForDifferenteObjectTypes() {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.ADMIN);

        final ClientUser aClientUser = ClientBuild();

        final boolean expected = aClientUser.equals(getNewDummyUser());

        assertFalse(expected);
    }

    @Test
    public void ensureClientUserIsTheSameAsItsInstance() {
        final ClientUser aClientUser = ClientBuild();

        final boolean expected = aClientUser.sameAs(aClientUser);

        assertTrue(expected);
    }

    @Test
    public void ensureClientUserIdentity() {
        final ClientUser clientUser = ClientBuild();

        assertEquals(VAT, clientUser.identity().vat());
    }

    @Test
    public void ensureClientUserBillingAddress() {
        final ClientUser clientUser = ClientBuild();
        Set<String> set = new HashSet<>();
        set.add(BILLING_POSTAL_ADDRESS);

        assertEquals(set, clientUser.getBillingPostalAddresses().billingAddress());
    }

    @Test
    public void ensureClientUserDeliveringAddress() {
        final ClientUser clientUser = ClientBuild();
        Set<String> set = new HashSet<>();
        set.add(DELIVERING_POSTAL_ADDRESS);

        assertEquals(set, clientUser.getDeleveringPostalAddresses().deliveringAddress());
    }
}
