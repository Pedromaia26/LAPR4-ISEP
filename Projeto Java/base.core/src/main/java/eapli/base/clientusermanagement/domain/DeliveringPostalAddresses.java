package eapli.base.clientusermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.regex.Pattern;
@Embeddable

public class DeliveringPostalAddresses implements ValueObject {
    private String deliveringAddress;

    public DeliveringPostalAddresses(String address) {

        String[] format=address.split(Pattern.quote(","));
        if(format.length!=5) throw new IllegalArgumentException("Invalid Address! eg: Street name, door number, postal code, city, country!");

        if (!format[1].matches("[0-9]+"))  throw new IllegalArgumentException("Invalid door number, all the digits must be numeric!");

        if(format[2].length()!=8) throw new IllegalArgumentException("Invalid postal code, xxxx-xxx!");
        if (!format[2].matches("[0-9]+[-][0-9]+"))  throw new IllegalArgumentException("Invalid postal code, xxxx-xxx!");


        this.deliveringAddress = address;
    }

    public DeliveringPostalAddresses() {

    }
}
