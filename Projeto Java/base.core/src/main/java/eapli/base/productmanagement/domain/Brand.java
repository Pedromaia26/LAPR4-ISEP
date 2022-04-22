package eapli.base.productmanagement.domain;

public class Brand {

    private String name;

    public Brand(final String name) {

        if (name.isEmpty())
            throw new IllegalArgumentException("Brand name cannot be empty!");
        if (name.length() > 50)
            throw new IllegalArgumentException("Brand name cannot have more than 50 chars!");

        this.name = name;
    }
}
