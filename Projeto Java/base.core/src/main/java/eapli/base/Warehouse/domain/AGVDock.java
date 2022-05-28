package eapli.base.Warehouse.domain;

import eapli.base.clientusermanagement.domain.VAT;
import eapli.base.productmanagement.domain.InternalCode;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;

@Entity
public class AGVDock implements AggregateRoot<AGVDockIdentifier> {
    @EmbeddedId
    private AGVDockIdentifier agvDockIdentifier;
    @Embedded
    private AGVDockBeginLSquare agvDockBeginLSquare;
    @Embedded

    private AGVDockBeginWSquare agvDockBeginWSquare;
    @Embedded

    private AGVDockEndLSquare agvDockEndLSquare;
    @Embedded

    private AGVDockEndWSquare agvDockEndWSquare;
    @Embedded

    private AGVDockDepthLSquare agvDockDepthLSquare;
    @Embedded

    private AGVDockDepthWSquare agvDockDepthWSquare;

    private String accessibility;
    @ManyToOne(optional = false,cascade = CascadeType.ALL)
    private Warehouse warehouse;


    public AGVDock(AGVDockIdentifier agvDockIdentifier, AGVDockBeginLSquare agvDockBeginLSquare, AGVDockBeginWSquare agvDockBeginWSquare, AGVDockEndLSquare agvDockEndLSquare, AGVDockEndWSquare agvDockEndWSquare, AGVDockDepthLSquare agvDockDepthLSquare, AGVDockDepthWSquare agvDockDepthWSquare, String accessibility, Warehouse warehouse) {

        if(accessibility.isBlank())throw new IllegalArgumentException("Accessibility cannot be blank!");


        this.agvDockIdentifier = agvDockIdentifier;
        this.agvDockBeginLSquare = agvDockBeginLSquare;
        this.agvDockBeginWSquare = agvDockBeginWSquare;
        this.agvDockEndLSquare = agvDockEndLSquare;
        this.agvDockEndWSquare = agvDockEndWSquare;
        this.agvDockDepthLSquare = agvDockDepthLSquare;
        this.agvDockDepthWSquare = agvDockDepthWSquare;
        this.accessibility = accessibility;
        this.warehouse=warehouse;
    }

    public AGVDock() {

    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }
    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }
    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public AGVDockIdentifier identity() {
        return agvDockIdentifier;
    }

    public AGVDockIdentifier agvDockIdentifier() {
        return identity();
    }

    public AGVDockBeginLSquare AgvDockBeginLSquare() {
        return agvDockBeginLSquare;
    }

    public AGVDockBeginWSquare AgvDockBeginWSquare() {
        return agvDockBeginWSquare;
    }

    public AGVDockEndLSquare AgvDockEndLSquare() {
        return agvDockEndLSquare;
    }

    public AGVDockEndWSquare AgvDockEndWSquare() {
        return agvDockEndWSquare;
    }

    public AGVDockDepthLSquare AgvDockDepthLSquare() {
        return agvDockDepthLSquare;
    }

    public AGVDockDepthWSquare AgvDockDepthWSquare() {
        return agvDockDepthWSquare;
    }
}
