package eapli.base.clientusermanagement.domain;

import eapli.base.Warehouse.domain.AGVDock;
import eapli.base.agvmanagement.domain.*;
import eapli.base.taskmanagement.domain.Description;
import eapli.base.taskmanagement.domain.Task;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class BillingPostalAddressesTest {

    private static final String STREET = "Street1";
    private static final String DOOR = "30";
    private static final String POSTAL_CODE = "4000-600";
    private static final String CITY = "City";
    private static final String COUNTRY = "Country";

    private Set<String[]> SetStringBuild(String street, String door, String postal_code, String city, String country) {
        Set<String[]> billingPostalAddress = new HashSet<>();
        String[] lista = new String[5];
        lista[0] = street;
        lista[1] = door;
        lista[2] = postal_code;
        lista[3] = city;
        lista[4] = country;
        billingPostalAddress.add(lista);
        return billingPostalAddress;
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveStreetNotEmpty() {
        Set<String[]> set = SetStringBuild("", DOOR, POSTAL_CODE, CITY, COUNTRY);
        new BillingPostalAddresses(set);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveDoorNotEmpty() {
        Set<String[]> set = SetStringBuild(STREET, "", POSTAL_CODE, CITY, COUNTRY);
        new BillingPostalAddresses(set);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHavePostalCodeNotEmpty() {
        Set<String[]> set = SetStringBuild(STREET, DOOR, "", CITY, COUNTRY);
        new BillingPostalAddresses(set);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveCityNotEmpty() {
        Set<String[]> set = SetStringBuild(STREET, DOOR, POSTAL_CODE, "", COUNTRY);
        new BillingPostalAddresses(set);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveCountryNotEmpty() {
        Set<String[]> set = SetStringBuild(STREET, DOOR, POSTAL_CODE, CITY, "");
        new BillingPostalAddresses(set);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDoorIsANumber() {
        Set<String[]> set = SetStringBuild(STREET, "a", POSTAL_CODE, CITY, COUNTRY);
        new BillingPostalAddresses(set);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHavePostalCodeRigthLenght() {
        Set<String[]> set = SetStringBuild(STREET, DOOR, "abc-123", CITY, COUNTRY);
        new BillingPostalAddresses(set);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHavePostalCodeRigthPattern() {
        Set<String[]> set = SetStringBuild(STREET, DOOR, "452-1123", CITY, COUNTRY);
        new BillingPostalAddresses(set);
    }

    @Test
    public void ensureAllAttributesAreValid(){
        Set<String[]> set = SetStringBuild(STREET, DOOR, POSTAL_CODE, CITY, COUNTRY);
        new BillingPostalAddresses(set);
        assertTrue(true);
    }

    @Test
    public void ensureModifyChangeValue(){
        BillingPostalAddresses a = new BillingPostalAddresses();
        Set<String> set = new HashSet<>();
        set.add(STREET + "," + DOOR + "," + POSTAL_CODE + "," + CITY + "," + COUNTRY);
        a.modifyBillingAddress(set);
        assertEquals(a.billingAddress(), set);
    }

    @Test
    public void ensureCanBeEmpty(){
        Set<String[]> set = new HashSet<>();
        BillingPostalAddresses a = new BillingPostalAddresses(set);
        assertNull(a.billingAddress());
    }
}