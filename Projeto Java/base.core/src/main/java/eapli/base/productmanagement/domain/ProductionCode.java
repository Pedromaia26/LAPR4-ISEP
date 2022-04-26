package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class ProductionCode implements Comparable<InternalCode>, ValueObject {

    private String productionCode;

    public ProductionCode(final String productionCode) {

        if (productionCode == null || productionCode.isBlank())
            throw new IllegalArgumentException("Internal code cannot be empty!");
        String regex = "[A-Za-z].[A-Za-z]{0,19}[0-9]{3}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(productionCode);
        if (!matcher.matches())
            throw new IllegalArgumentException("Production code must respect the following pattern: 1 letter followed by a dot ('.') and ending with 3 digits (Max 23 chars).");

        this.productionCode = productionCode;
    }

    public ProductionCode() {

    }

    @Override
    public int compareTo(InternalCode o) {
        return 0;
    }

    @Override
    public String toString(){

        return productionCode;
    }
}
