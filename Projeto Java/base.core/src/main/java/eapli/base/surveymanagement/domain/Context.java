package eapli.base.surveymanagement.domain;

import eapli.base.productmanagement.domain.ExtendedDescription;
import eapli.base.productmanagement.domain.ShortDescription;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;

@Entity
public class Context implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private ExtendedDescription description;

    public Context(ExtendedDescription description){
        if (description == null) throw new IllegalArgumentException();

        this.description = description;
    }

    public Context(){}

    public ExtendedDescription description() {
        return description;
    }

    public void modifyDescription(ExtendedDescription description) {
        this.description = description;
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public Long identity() {
        return id;
    }
}
