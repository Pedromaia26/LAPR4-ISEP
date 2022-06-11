package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;

@Entity
public class Section implements AggregateRoot<RowIdentifier> {

    @EmbeddedId
    private RowIdentifier rowIdentifier;

    @Embedded
    private RowBeginLSquare rowBeginLSquare;
    @Embedded
    private RowBeginWSquare rowBeginWSquare;
    @Embedded
    private RowEndLSquare rowEndLSquare;

    public RowBeginLSquare RowBeginLSquare() {
        return rowBeginLSquare;
    }

    public RowBeginWSquare RowBeginWSquare() {
        return rowBeginWSquare;
    }

    public RowEndLSquare RowEndLSquare() {
        return rowEndLSquare;
    }

    public RowEndWSquare RowEndWSquare() {
        return rowEndWSquare;
    }

    @Embedded
    private RowEndWSquare rowEndWSquare;
   // @OneToMany
   // private Set<Shelf> shelves;


    public Section(RowIdentifier rowIdentifier, RowBeginLSquare rowBeginLSquare, RowBeginWSquare rowBeginWSquare, RowEndLSquare rowEndLSquare, RowEndWSquare rowEndWSquare /*Set<Shelf> shelves*/ ) {
        this.rowIdentifier = rowIdentifier;
        this.rowBeginLSquare = rowBeginLSquare;
        this.rowBeginWSquare = rowBeginWSquare;
        this.rowEndLSquare = rowEndLSquare;
        this.rowEndWSquare = rowEndWSquare;
      //  this.shelves = shelves;

    }

    public Section() {

    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public RowIdentifier identity() {
        return rowIdentifier;
    }
    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    public RowIdentifier rowIdentifier() {
        return identity();
    }

}
