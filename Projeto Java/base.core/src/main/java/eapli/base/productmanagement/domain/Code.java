package eapli.base.productmanagement.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Code implements Comparable<Code> {

    private String internalCode, productionCode;

    public Code(final String internalCode) {

        if (internalCode.isEmpty())
            throw new IllegalArgumentException("Internal code cannot be empty!");
        String regex = "[A-Za-z]{4}.[A-Za-z]{0,13}[0-9]{5}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(internalCode);
        if (!matcher.matches())
            throw new IllegalArgumentException("Internal code must respect the following pattern: 4 letters followed by a dot ('.') and ending with 5 digits (Max 23 chars).");

        this.internalCode = internalCode;
    }

    public Code (final String internalCode, final String productionCode){
        if (internalCode.isEmpty())
            throw new IllegalArgumentException("Internal code cannot be empty!");
        String regex = "[A-Za-z]{4}.[A-Za-z]{0,13}[0-9]{5}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(internalCode);
        if (!matcher.matches())
            throw new IllegalArgumentException("Internal code must respect the following pattern: 4 letters followed by a dot ('.') and ending with 5 digits (Max 23 chars).");
        if (productionCode.isEmpty())
            throw new IllegalArgumentException("Production code cannot be empty!");
        regex = "[A-Za-z0-9]{2,23}";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(productionCode);
        if (!matcher.matches())
            throw new IllegalArgumentException("Production code must respect the following pattern: to be defined!");

        this.internalCode = internalCode;
        this.productionCode = productionCode;
    }

    @Override
    public int compareTo(Code o) {
        return internalCode.compareTo(o.internalCode);
    }
}
