package eapli.base.categorymanagement.domain;

import eapli.framework.domain.model.DomainFactory;

public class CategoryBuilder implements DomainFactory<Category> {

    private Category category;
    private CategoryCode code;
    private CategoryDescription description;

    public CategoryBuilder(final String code, final String description){
        withCode(code);
        withDescription(description);
    }

    public CategoryBuilder withCode(String code) {
        this.code = new CategoryCode(code);
        return this;
    }

    public CategoryBuilder withDescription(final String description) {
        this.description = new CategoryDescription(description);
        return this;
    }

    private Category buildOrThrow() {
        if (category != null) {
            return category;
        } else if (code != null && description != null) {
            category = new Category(code, description);
            return category;
        } else {
            throw new IllegalStateException();
        }
    }

    public Category build() {
        final Category ret = buildOrThrow();
        return ret;
    }
}
