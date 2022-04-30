package eapli.base.clientusermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.*;
import java.util.regex.Pattern;
@Embeddable

public class DeliveringPostalAddresses implements ValueObject {
    @ElementCollection
    private Set<String> deliveringAddress= new HashSet<>();

    public DeliveringPostalAddresses(Set<String[]> address) {


        if(address.isEmpty()) {
            this.deliveringAddress=null;
        }else {

            Set<String> set = new HashSet<>();

            List<String[]> lists = new ArrayList<>();

            address.iterator().forEachRemaining(lists::add);


            for (int i = 0; i < address.size(); i++) {

                String[] format = lists.get(i);

                if (format.length != 5)
                    throw new IllegalArgumentException("Invalid Address! eg: Street name, door number, postal code, city, country!");
                if(format[0].isBlank())throw new IllegalArgumentException("Street name cannot be blank!");
                if(format[3].isBlank())throw new IllegalArgumentException("City cannot be blank!");
                if(format[4].isBlank())throw new IllegalArgumentException("Country cannot be blank!");


                if (!format[1].matches("[0-9]+"))
                    throw new IllegalArgumentException("Invalid door number, all the digits must be numeric!");

                if (format[2].length() != 8) throw new IllegalArgumentException("Invalid postal code, xxxx-xxx!");
                if (!format[2].matches("[0-9]{4}[-][0-9]{3}"))
                    throw new IllegalArgumentException("Invalid postal code, xxxx-xxx!");

                String add = format[0];
                add=add.concat(",").concat(format[1]).concat(",").concat(format[2]).concat(",").concat(format[3]).concat(",").concat(format[4]);
                set.add(add);
            }

            this.deliveringAddress = set;
        }
    }


    public DeliveringPostalAddresses() {

    }

    public Set<String> getDeliveringAddress() {

        return deliveringAddress;
    }

    public void setDeliveringAddress(Set<String> deliveringAddress) {
        this.deliveringAddress = deliveringAddress;
    }
}
