package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Category implements AggregateRoot<CategoryCode> {

    @EmbeddedId
    private CategoryCode categoryCode;
    private CategoryDescription categoryDescription;

    public Category(CategoryCode categoryCode, CategoryDescription categoryDescription){
        if (categoryCode == null || categoryDescription == null)
            throw new IllegalArgumentException();

        this.categoryCode = categoryCode;
        this.categoryDescription = categoryDescription;
    }

    public Category() {

    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public int compareTo(CategoryCode other) {
        return AggregateRoot.super.compareTo(other);
    }


    @Override
    public CategoryCode identity() {
        return categoryCode;
    }

    @Override
    public boolean hasIdentity(CategoryCode id) {
        return AggregateRoot.super.hasIdentity(id);
    }

    public CategoryCode CategoryCode() {
        return categoryCode;
    }

    public void modifyCategoryCode(CategoryCode categoryCode) {
        this.categoryCode = categoryCode;
    }

    public CategoryDescription CategoryDescription() {
        return categoryDescription;
    }

    public void modifyCategoryDescription(CategoryDescription categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}
