package eapli.base.productmanagement.domain;

import java.util.regex.Pattern;

public class Code {

    private String internalCode, productionCode;

    public Code(final String internalCode) {

        if (internalCode.isEmpty())
            throw new IllegalArgumentException("Internal code cannot be empty!");
        if (!internalCode.equals(Pattern.compile("[A-Z]{4}.[A-Z]{0,13}[0-9]{5}", Pattern.CASE_INSENSITIVE)))
            throw new IllegalArgumentException("Internal code must respect the following pattern: 4 letters followed by a dot ('.') and ending with 5 digits (Max 23 chars).");

        this.internalCode = internalCode;
    }

    public Code (final String internalCode, final String productionCode){
        if (internalCode.isEmpty())
            throw new IllegalArgumentException("Internal code cannot be empty!");
        if (!internalCode.equals(Pattern.compile("[A-Z]{4}.[A-Z]{0,13}[0-9]{5}", Pattern.CASE_INSENSITIVE)))
            throw new IllegalArgumentException("Internal code must respect the following pattern: 4 letters followed by a dot ('.') and ending with 5 digits (Max 23 chars).");
        if (productionCode.isEmpty())
            throw new IllegalArgumentException("Production code cannot be empty!");
        if (!productionCode.equals(Pattern.compile("[A-Z|0-9]{2,23}", Pattern.CASE_INSENSITIVE)))
            throw new IllegalArgumentException("Production code must respect the following pattern: to be defined!");

        this.internalCode = internalCode;
        this.productionCode = productionCode;
    }
}
