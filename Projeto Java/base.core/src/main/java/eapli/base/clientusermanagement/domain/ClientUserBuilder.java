/*
 * Copyright (c) 2013-2021 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.base.clientusermanagement.domain;

import eapli.base.Warehouse.domain.Warehouse;
import eapli.framework.domain.model.DomainFactory;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.Set;

/**
 * A factory for User entities.
 *
 * This class demonstrates the use of the factory (DDD) pattern using a fluent
 * interface. it acts as a Builder (GoF).
 *
 * @author Jorge Santos ajs@isep.ipp.pt 02/04/2016
 */
public class ClientUserBuilder implements DomainFactory<ClientUser> {

    private ClientUser clientUser;

    private SystemUser systemUser;

    private MecanographicNumber mecanographicNumber;

    private VAT vat;
    private PhoneNumber phoneNumber;

    private VerifyGender gender;

    private Birthday birthday;

    private DeliveringPostalAddresses deliveringPostalAddresses;

    private BillingPostalAddresses billingPostalAddresses;

    public ClientUserBuilder withSystemUser(final SystemUser systemUser) {
        this.systemUser = systemUser;
        return this;
    }

    public ClientUserBuilder withMecanographicNumber(final MecanographicNumber mecanographicNumber) {
        this.mecanographicNumber = mecanographicNumber;
        return this;
    }

    public ClientUserBuilder withMecanographicNumber(final String mecanographicNumber) {
        this.mecanographicNumber = new MecanographicNumber(mecanographicNumber);
        return this;
    }

    public ClientUserBuilder withVAT(final String vat) {
        this.vat = new VAT(vat);
        return this;
    }

    public ClientUserBuilder withPhoneNumber(final String phoneNumber) {
        this.phoneNumber = new PhoneNumber(phoneNumber);
        return this;
    }

    public ClientUserBuilder withGender(final String gender) {
        this.gender = new VerifyGender(gender);
        return this;
    }

    public ClientUserBuilder withBirthDay(final String birthday) {
        this.birthday = new Birthday(birthday);
        return this;
    }

    public ClientUserBuilder withDelAddress(final Set<String[]> delAddress) {
        this.deliveringPostalAddresses = new DeliveringPostalAddresses(delAddress);
        return this;
    }

    public ClientUserBuilder withBillAddress(final Set<String[]> billAddress) {
        this.billingPostalAddresses = new BillingPostalAddresses(billAddress);
        return this;
    }


    private ClientUser buildOrThrow() {
        if (clientUser != null) {
            return clientUser;
        } else if (systemUser != null && vat != null && phoneNumber != null /*&& gender != null && birthday != null && deliveringPostalAddresses != null && billingPostalAddresses != null*/) {
            clientUser = new ClientUser(systemUser,vat,phoneNumber,gender,birthday,deliveringPostalAddresses,billingPostalAddresses);
            return clientUser;
        }
         else {
            throw new IllegalStateException();
        }
    }

    public ClientUser build() {
        final ClientUser ret = buildOrThrow();
        // make sure we will create a new instance if someone reuses this builder and do not change
        // the previously built dish.
        clientUser = null;
        return ret;
    }
}
