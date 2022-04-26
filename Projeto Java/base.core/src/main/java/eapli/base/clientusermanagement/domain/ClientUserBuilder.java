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

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

/**
 * A factory for User entities.
 *
 * This class demonstrates the use of the factory (DDD) pattern using a fluent
 * interface. it acts as a Builder (GoF).
 *
 * @author Jorge Santos ajs@isep.ipp.pt 02/04/2016
 */
public class ClientUserBuilder implements DomainFactory<ClientUser> {

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

    public ClientUserBuilder withVAT(final VAT vat) {
        this.vat = vat;
        return this;
    }

    public ClientUserBuilder withVAT(final String vat) {
        this.vat = new VAT(vat);
        return this;
    }

    public ClientUserBuilder withPhoneNumber(final PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public ClientUserBuilder withPhoneNumber(final String phoneNumber) {
        this.phoneNumber = new PhoneNumber(phoneNumber);
        return this;
    }

    public ClientUserBuilder withGender(final VerifyGender gender) {
        this.gender = gender;
        return this;
    }

    public ClientUserBuilder withGender(final String gender) {
        this.gender = new VerifyGender(gender);
        return this;
    }

    public ClientUserBuilder withBirthDay(final Birthday birthday) {
        this.birthday = birthday;
        return this;
    }

    public ClientUserBuilder withBirthDay(final String birthday) {
        this.birthday = new Birthday(birthday);
        return this;
    }
    public ClientUserBuilder withDelAddress(final DeliveringPostalAddresses delAddress) {
        this.deliveringPostalAddresses = delAddress;
        return this;
    }

    public ClientUserBuilder withDelAddress(final String delAddress) {
        this.deliveringPostalAddresses = new DeliveringPostalAddresses(delAddress);
        return this;
    }
    public ClientUserBuilder withBillAddress(final BillingPostalAddresses billAddress) {
        this.billingPostalAddresses = billAddress;
        return this;
    }

    public ClientUserBuilder withBillAddress(final String billAddress) {
        this.billingPostalAddresses = new BillingPostalAddresses(billAddress);
        return this;
    }


    @Override
    public ClientUser build() {
        // since the factory knows that all the parts are needed it could throw
        // an exception. however, we will leave that to the constructor
        return new ClientUser(this.systemUser, this.vat,this.phoneNumber, this.gender, this.birthday, this.deliveringPostalAddresses, this.billingPostalAddresses);
    }
}
