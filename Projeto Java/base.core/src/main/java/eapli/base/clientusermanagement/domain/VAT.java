package eapli.base.clientusermanagement.domain;

import eapli.base.productmanagement.domain.InternalCode;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable

public class VAT implements ValueObject, Comparable<VAT> {
    private String vat;

    public VAT(String vat) {

        final int max=9;
        //check if is numeric and has 9 numbers
        if (!vat.matches("[0-9]+"))  throw new IllegalArgumentException("Invalid VAT, not numeric!");

        if(vat.length()!=max)throw new IllegalArgumentException("Invalid VAT, wrong size!");

        this.vat = vat;
    }

    public VAT() {

    }

    @Override
    public int compareTo(VAT o) {

        return vat.compareTo(o.vat);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VAT vat1 = (VAT) o;
        return vat.equals(vat1.vat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vat);
    }

    public String vat() {
        return vat;
    }
}
