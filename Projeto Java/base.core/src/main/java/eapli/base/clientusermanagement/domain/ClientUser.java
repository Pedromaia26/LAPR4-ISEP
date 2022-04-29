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

import javax.persistence.*;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

/**
 * A Client User.
 *
 * This class represents client users. It follows a DDD approach where User
 * is the root entity of the Base User Aggregate and all of its properties
 * are instances of value objects. A Client User references a System User
 *
 * This approach may seem a little more complex than just having String or
 * native type attributes but provides for real semantic of the domain and
 * follows the Single Responsibility Pattern
 *
 * @author Jorge Santos ajs@isep.ipp.pt
 *
 */
@Entity
public class ClientUser implements AggregateRoot<VAT> {

    @Version
    private Long version;

    //private MecanographicNumber mecanographicNumber;
    @EmbeddedId
    private VAT vat;

    @Embedded
    private PhoneNumber phoneNumber;

    @Embedded
    private VerifyGender gender;

    @Embedded
    private Birthday birthday;

    @Embedded
    private DeliveringPostalAddresses deliveringPostalAddresses;

    @Embedded
    private BillingPostalAddresses billingPostalAddresses;



    /**
     * cascade = CascadeType.NONE as the systemUser is part of another aggregate
     */
    @OneToOne()
    private SystemUser systemUser;

    public BillingPostalAddresses getBillingPostalAddresses() {
        return billingPostalAddresses;
    }

    public DeliveringPostalAddresses getDeleveringPostalAddresses() {
        return deliveringPostalAddresses;
    }

    public Birthday getBirthday() {
        return birthday;
    }

    public VerifyGender getGender() {
        return gender;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public ClientUser(final SystemUser user, final VAT vat, final PhoneNumber phoneNumber, final VerifyGender gender, final Birthday birthday, final DeliveringPostalAddresses deliveringPostalAddresses, final BillingPostalAddresses billingPostalAddresses) {
        if (vat == null || user == null || phoneNumber == null || gender == null || birthday == null || deliveringPostalAddresses == null || billingPostalAddresses == null) {
            throw new IllegalArgumentException();
        }
        this.systemUser = user;
        this.vat = vat;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.birthday = birthday;
        this.deliveringPostalAddresses = deliveringPostalAddresses;
        this.billingPostalAddresses = billingPostalAddresses;

    }
    public ClientUser(final SystemUser user, final VAT vat, final PhoneNumber phoneNumber, final VerifyGender gender, final Birthday birthday, final DeliveringPostalAddresses deliveringPostalAddresses) {
        if (vat == null || user == null || phoneNumber == null || gender == null || birthday == null || deliveringPostalAddresses == null) {
            throw new IllegalArgumentException();
        }
        this.systemUser = user;
        this.vat = vat;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.birthday = birthday;
        this.deliveringPostalAddresses = deliveringPostalAddresses;


    }
    public ClientUser(final SystemUser user, final VAT vat, final PhoneNumber phoneNumber, final VerifyGender gender, final Birthday birthday, final BillingPostalAddresses billingPostalAddresses) {
        if (vat == null || user == null || phoneNumber == null || gender == null || birthday == null || billingPostalAddresses == null) {
            throw new IllegalArgumentException();
        }
        this.systemUser = user;
        this.vat = vat;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.birthday = birthday;
        this.billingPostalAddresses = billingPostalAddresses;

    }
    public ClientUser(final SystemUser user, final VAT vat, final PhoneNumber phoneNumber, final VerifyGender gender, final DeliveringPostalAddresses deliveringPostalAddresses, final BillingPostalAddresses billingPostalAddresses) {
        if (vat == null || user == null || phoneNumber == null || gender == null || deliveringPostalAddresses == null || billingPostalAddresses == null) {
            throw new IllegalArgumentException();
        }
        this.systemUser = user;
        this.vat = vat;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.deliveringPostalAddresses = deliveringPostalAddresses;
        this.billingPostalAddresses = billingPostalAddresses;

    }
    public ClientUser(final SystemUser user, final VAT vat, final PhoneNumber phoneNumber, final Birthday birthday, final DeliveringPostalAddresses deliveringPostalAddresses, final BillingPostalAddresses billingPostalAddresses) {
        if (vat == null || user == null || phoneNumber == null || birthday == null || deliveringPostalAddresses == null || billingPostalAddresses == null) {
            throw new IllegalArgumentException();
        }
        this.systemUser = user;
        this.vat = vat;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.deliveringPostalAddresses = deliveringPostalAddresses;
        this.billingPostalAddresses = billingPostalAddresses;

    }
    public ClientUser(final SystemUser user, final VAT vat, final PhoneNumber phoneNumber, final VerifyGender gender, final Birthday birthday) {
        if (vat == null || user == null || phoneNumber == null || gender == null || birthday == null ) {
            throw new IllegalArgumentException();
        }
        this.systemUser = user;
        this.vat = vat;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.birthday = birthday;


    }
    public ClientUser(final SystemUser user, final VAT vat, final PhoneNumber phoneNumber, final VerifyGender gender, final DeliveringPostalAddresses deliveringPostalAddresses) {
        if (vat == null || user == null || phoneNumber == null || gender == null || deliveringPostalAddresses == null ) {
            throw new IllegalArgumentException();
        }
        this.systemUser = user;
        this.vat = vat;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.deliveringPostalAddresses = deliveringPostalAddresses;

    }
    public ClientUser(final SystemUser user, final VAT vat, final PhoneNumber phoneNumber, final Birthday birthday, final DeliveringPostalAddresses deliveringPostalAddresses) {
        if (vat == null || user == null || phoneNumber == null ||  birthday == null || deliveringPostalAddresses == null ) {
            throw new IllegalArgumentException();
        }
        this.systemUser = user;
        this.vat = vat;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.deliveringPostalAddresses = deliveringPostalAddresses;

    }
    public ClientUser(final SystemUser user, final VAT vat, final PhoneNumber phoneNumber, final VerifyGender gender, final BillingPostalAddresses billingPostalAddresses) {
        if (vat == null || user == null || phoneNumber == null || gender == null || billingPostalAddresses == null) {
            throw new IllegalArgumentException();
        }
        this.systemUser = user;
        this.vat = vat;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.billingPostalAddresses = billingPostalAddresses;

    }
    public ClientUser(final SystemUser user, final VAT vat, final PhoneNumber phoneNumber, final Birthday birthday, final BillingPostalAddresses billingPostalAddresses) {
        if (vat == null || user == null || phoneNumber == null ||birthday == null || billingPostalAddresses == null) {
            throw new IllegalArgumentException();
        }
        this.systemUser = user;
        this.vat = vat;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.billingPostalAddresses = billingPostalAddresses;

    }
    public ClientUser(final SystemUser user, final VAT vat, final PhoneNumber phoneNumber, final DeliveringPostalAddresses deliveringPostalAddresses, final BillingPostalAddresses billingPostalAddresses) {
        if (vat == null || user == null || phoneNumber == null || deliveringPostalAddresses == null || billingPostalAddresses == null) {
            throw new IllegalArgumentException();
        }
        this.systemUser = user;
        this.vat = vat;
        this.phoneNumber = phoneNumber;

        this.deliveringPostalAddresses = deliveringPostalAddresses;
        this.billingPostalAddresses = billingPostalAddresses;

    }
    public ClientUser(final SystemUser user, final VAT vat, final PhoneNumber phoneNumber, final VerifyGender gender) {
        if (vat == null || user == null || phoneNumber == null || gender == null ) {
            throw new IllegalArgumentException();
        }
        this.systemUser = user;
        this.vat = vat;
        this.phoneNumber = phoneNumber;
        this.gender = gender;

    }
    public ClientUser(final SystemUser user, final VAT vat, final PhoneNumber phoneNumber, final Birthday birthday) {
        if (vat == null || user == null || phoneNumber == null || birthday == null ) {
            throw new IllegalArgumentException();
        }
        this.systemUser = user;
        this.vat = vat;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;

    }
    public ClientUser(final SystemUser user, final VAT vat, final PhoneNumber phoneNumber, final BillingPostalAddresses billingPostalAddresses) {
        if (vat == null || user == null || phoneNumber == null || billingPostalAddresses == null) {
            throw new IllegalArgumentException();
        }
        this.systemUser = user;
        this.vat = vat;
        this.phoneNumber = phoneNumber;

        this.billingPostalAddresses = billingPostalAddresses;

    }
    public ClientUser(final SystemUser user, final VAT vat, final PhoneNumber phoneNumber) {
        if (vat == null || user == null || phoneNumber == null) {
            throw new IllegalArgumentException();
        }
        this.systemUser = user;
        this.vat = vat;
        this.phoneNumber = phoneNumber;

    }

    protected ClientUser() {
        // for ORM only
    }

    public SystemUser user() {
        return this.systemUser;
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(final Object other) {
        return DomainEntities.areEqual(this, other);
    }

    public VAT vat() {
        return identity();
    }

    @Override
    public VAT identity() {
        return this.vat;
    }
}
