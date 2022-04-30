package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Aisle implements AggregateRoot<AisleIdentifier> {
    @EmbeddedId
        private AisleIdentifier aisleIdentifier;
    @Embedded
        private AisleBeginLSquare aisleBeginLSquare;

    @Embedded
        private AisleBeginWSquare aisleBeginWSquare;
    @Embedded
        private AisleDepthLSquare aisleDepthLSquare;
    @Embedded
        private AisleDepthWSquare aisleDepthWSquare;
    @Embedded
        private AisleEndLSquare aisleEndLSquare;
    @Embedded
        private AisleEndWSquare aisleEndWSquare;

        private String accessibility;
   // @OneToMany
   //     private Set<Row> rows;
    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    private Warehouse warehouse;

    public Aisle(AisleIdentifier aisleIdentifier, AisleBeginLSquare aisleBeginLSquare, AisleBeginWSquare aisleBeginWSquare, AisleDepthLSquare aisleDepthLSquare, AisleDepthWSquare aisleDepthWSquare, AisleEndLSquare aisleEndLSquare, AisleEndWSquare aisleEndWSquare, String accessibility, Warehouse warehouse) {
        this.aisleIdentifier = aisleIdentifier;
        this.aisleBeginLSquare = aisleBeginLSquare;
        this.aisleBeginWSquare = aisleBeginWSquare;
        this.aisleDepthLSquare = aisleDepthLSquare;
        this.aisleDepthWSquare = aisleDepthWSquare;
        this.aisleEndLSquare = aisleEndLSquare;
        this.aisleEndWSquare = aisleEndWSquare;
        this.accessibility = accessibility;
        this.warehouse= warehouse;
      //  this.rows = rows;
    }

    public Aisle() {

    }

    public AisleIdentifier AisleIdentifier() {
        return aisleIdentifier;
    }


    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public AisleIdentifier identity() {
        return aisleIdentifier;
    }
    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }


    public AisleIdentifier aisleIdentifier() {
        return identity();
    }
}
