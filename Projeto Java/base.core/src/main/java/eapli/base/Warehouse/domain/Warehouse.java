package eapli.base.Warehouse.domain;


import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.Set;
@Entity
public class Warehouse implements AggregateRoot<Long> {
    @Id
    @Column(name = "id", nullable = false)
    private Long id=1L;

    private String name;

    private long length;

    private long width;

    private long square;

    private String unit;

   // @OneToMany
   // private Set<Aisle> aisles;
   // @OneToMany
   // private Set<AGVDock> agvDocks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Warehouse(String name, long length, long width, long square, String unit/*, Set<Aisle> aisles, Set<AGVDock> agvDocks*/) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.square = square;
        this.unit = unit;
       // this.aisles= aisles;
      //  this.agvDocks= agvDocks;
    }


    public Warehouse() {

    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public Long identity() {
        return id;
    }
    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }
}
