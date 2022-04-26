package eapli.base.categorymanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class CategoryCode implements ValueObject, Comparable<CategoryCode> {
    private String code;

    public CategoryCode(final String code) {

        if (code == null || code.isBlank())
            throw new IllegalArgumentException("Category code cannot be empty!");
        String regex = "[a-zA-Z|0-9]{2,23}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(code);
        if (!matcher.matches())
            throw new IllegalArgumentException("Category code must be an alphanumeric code.");

        this.code = code;
    }

    public CategoryCode() {

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString(){

        return code;
    }

    @Override
    public int compareTo(CategoryCode o) {
        return code.compareTo(o.code);
    }
}
