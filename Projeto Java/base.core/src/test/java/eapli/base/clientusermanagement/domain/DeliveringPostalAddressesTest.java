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

public class DeliveringPostalAddressesTest {

    private static final String STREET = "Street1";
    private static final String DOOR = "30";
    private static final String POSTAL_CODE = "4000-600";
    private static final String CITY = "City";
    private static final String COUNTRY = "Country";

    private Set<String[]> SetStringBuild(String street, String door, String postal_code, String city, String country) {
        Set<String[]> deliveringPostalAddress = new HashSet<>();
        String[] lista = new String[5];
        lista[0] = street;
        lista[1] = door;
        lista[2] = postal_code;
        lista[3] = city;
        lista[4] = country;
        deliveringPostalAddress.add(lista);
        return deliveringPostalAddress;
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveStreetNotEmpty() {
        Set<String[]> set = SetStringBuild("", DOOR, POSTAL_CODE, CITY, COUNTRY);
        new DeliveringPostalAddresses(set);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveDoorNotEmpty() {
        Set<String[]> set = SetStringBuild(STREET, "", POSTAL_CODE, CITY, COUNTRY);
        new DeliveringPostalAddresses(set);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHavePostalCodeNotEmpty() {
        Set<String[]> set = SetStringBuild(STREET, DOOR, "", CITY, COUNTRY);
        new DeliveringPostalAddresses(set);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveCityNotEmpty() {
        Set<String[]> set = SetStringBuild(STREET, DOOR, POSTAL_CODE, "", COUNTRY);
        new DeliveringPostalAddresses(set);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveCountryNotEmpty() {
        Set<String[]> set = SetStringBuild(STREET, DOOR, POSTAL_CODE, CITY, "");
        new DeliveringPostalAddresses(set);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureDoorIsANumber() {
        Set<String[]> set = SetStringBuild(STREET, "a", POSTAL_CODE, CITY, COUNTRY);
        new DeliveringPostalAddresses(set);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHavePostalCodeRigthLenght() {
        Set<String[]> set = SetStringBuild(STREET, DOOR, "abc-123", CITY, COUNTRY);
        new DeliveringPostalAddresses(set);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHavePostalCodeRigthPattern() {
        Set<String[]> set = SetStringBuild(STREET, DOOR, "452-1123", CITY, COUNTRY);
        new DeliveringPostalAddresses(set);
    }

    @Test
    public void ensureAllAttributesAreValid(){
        Set<String[]> set = SetStringBuild(STREET, DOOR, POSTAL_CODE, CITY, COUNTRY);
        new DeliveringPostalAddresses(set);
        assertTrue(true);
    }

    @Test
    public void ensureModifyChangeValue(){
        DeliveringPostalAddresses a = new DeliveringPostalAddresses();
        Set<String> set = new HashSet<>();
        set.add(STREET + "," + DOOR + "," + POSTAL_CODE + "," + CITY + "," + COUNTRY);
        a.modifyDeliveringAddress(set);
        assertEquals(a.deliveringAddress(), set);
    }

    @Test
    public void ensureCanBeNull(){
        Set<String[]> set = new HashSet<>();
        DeliveringPostalAddresses a = new DeliveringPostalAddresses(set);
        assertNull(a.deliveringAddress());
    }
}