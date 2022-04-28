package eapli.base.categorymanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class CategoryDescription implements ValueObject {

    private String description;

    public CategoryDescription(final String categoryDescription){

        if (categoryDescription == null || categoryDescription.isBlank())
            throw new IllegalArgumentException("Category description cannot be null!");


        this.description = categoryDescription;
    }

    public CategoryDescription() {

    }

    @Override
    public String toString(){

        return description;
    }

    public String Description() {
        return description;
    }
}
