package eapli.base.agvmanagement.domain;


import eapli.base.Warehouse.domain.AGVDock;
import eapli.base.taskmanagement.domain.Task;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;

@Entity
public class AGV implements AggregateRoot<AGVIdentifier> {

    @Id
    private AGVIdentifier agvIdentifier;
    private AGVShortDescription agvShortDescription;
    private Autonomy autonomy;
    private MaximumWeight maximumWeight;
    private Model model;
    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    private Task task;
    private Volume volume;
    @OneToOne
    private AGVDock agvDock;


    public AGV(AGVIdentifier agvIdentifier, AGVShortDescription agvShortDescription, Autonomy autonomy, MaximumWeight maximumWeight, Model model, Task task, Volume volume, AGVDock agvDock) {

        if (agvIdentifier == null || agvShortDescription == null || autonomy == null || maximumWeight == null || model == null || task == null || volume == null || agvDock == null)
            throw new IllegalArgumentException();

        this.agvIdentifier = agvIdentifier;
        this.agvShortDescription = agvShortDescription;
        this.autonomy = autonomy;
        this.maximumWeight = maximumWeight;
        this.model = model;
        this.task = task;
        this.volume = volume;
        this.agvDock = agvDock;
    }

    public AGV() {

    }

    public AGVIdentifier AgvIdentifier() {
        return agvIdentifier;
    }

    public void modifyAgvIdentifier(AGVIdentifier agvIdentifier) {
        this.agvIdentifier = agvIdentifier;
    }

    public AGVShortDescription AgvShortDescription() {
        return agvShortDescription;
    }

    public void modifyAgvShortDescription(AGVShortDescription agvShortDescription) {
        this.agvShortDescription = agvShortDescription;
    }

    public Autonomy Autonomy() {
        return autonomy;
    }

    public void modifyAutonomy(Autonomy autonomy) {
        this.autonomy = autonomy;
    }

    public MaximumWeight MaximumWeight() {
        return maximumWeight;
    }

    public void modifyMaximumWeight(MaximumWeight maximumWeight) {
        this.maximumWeight = maximumWeight;
    }

    public Model Model() {
        return model;
    }

    public void modifyModel(Model model) {
        this.model = model;
    }

    public Task Task() {
        return task;
    }

    public void modifyTask(Task task) {
        this.task = task;
    }

    public Volume Volume() {
        return volume;
    }

    public void modifyVolume(Volume volume) {
        this.volume = volume;
    }

    public AGVDock AgvDock() {
        return agvDock;
    }

    public void modifyAgvDock(AGVDock agvDock) {
        this.agvDock = agvDock;
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public int compareTo(AGVIdentifier other) {
        return AggregateRoot.super.compareTo(other);
    }

    @Override
    public AGVIdentifier identity() {
        return null;
    }

    @Override
    public boolean hasIdentity(AGVIdentifier id) {
        return AggregateRoot.super.hasIdentity(id);
    }
}
