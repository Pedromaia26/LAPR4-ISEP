package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class InternalCode implements Comparable<InternalCode>, ValueObject {


    private String internalCode;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public InternalCode(final String internalCode) {

        if (internalCode == null || internalCode.isBlank())
            throw new IllegalArgumentException("Internal code cannot be empty!");
        String regex = "[A-Za-z]{4}.[A-Za-z]{0,13}[0-9]{5}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(internalCode);
        if (!matcher.matches())
            throw new IllegalArgumentException("Internal code must respect the following pattern: 4 letters followed by a dot ('.') and ending with 5 digits (Max 23 chars).");

        this.internalCode = internalCode;
    }

    public InternalCode() {

    }

    @Override
    public int compareTo(InternalCode o) {
        return internalCode.compareTo(o.internalCode);
    }

    @Override
    public String toString(){

        return internalCode;
    }
}
