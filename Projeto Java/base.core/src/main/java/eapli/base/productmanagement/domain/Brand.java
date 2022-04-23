package eapli.base.productmanagement.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Brand {

    private String name;
    @Id
    private Long id;

    public Brand(final String name) {

        if (name.isEmpty())
            throw new IllegalArgumentException("Brand name cannot be empty!");
        if (name.length() > 50)
            throw new IllegalArgumentException("Brand name cannot have more than 50 chars!");

        this.name = name;
    }

    public Brand() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
