package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class Reference implements ValueObject {

    private String reference;

    public Reference (final String reference){
        if (reference == null || reference.isBlank())
            throw new IllegalArgumentException("Reference cannot be null");

        String regex = "[a-zA-Z|0-9]{2,23}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(reference);
        if (!matcher.matches())
            throw new IllegalArgumentException("Reference must be an alphanumeric code with at 23 chars maximum.");

        this.reference = reference;
    }

    public Reference() {

    }
}
