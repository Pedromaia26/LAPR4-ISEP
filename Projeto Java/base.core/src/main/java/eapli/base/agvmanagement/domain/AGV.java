package eapli.base.agvmanagement.domain;


import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AGV implements AggregateRoot<AGVIdentifier> {

    @EmbeddedId
    private AGVIdentifier agvIdentifier;
    @Embedded
    private AGVShortDescription agvShortDescription;
    @Embedded
    private Autonomy autonomy;
    @Embedded
    private MaximumWeight maximumWeight;
    @Embedded
    private Model model;
    @Embedded
    private Task task;
    @Embedded
    private Volume volume;

    public Volume getVolume() {
        return volume;
    }

    public Task getTask() {
        return task;
    }

    public Model getModel() {
        return model;
    }

    public MaximumWeight getMaximumWeight() {
        return maximumWeight;
    }

    public Autonomy getAutonomy() {
        return autonomy;
    }

    public AGVShortDescription getAgvShortDescription() {
        return agvShortDescription;
    }

    public AGVIdentifier getAgvIdentifier() {
        return agvIdentifier;
    }


    public AGV(AGVIdentifier agvIdentifier, AGVShortDescription agvShortDescription, Autonomy autonomy, MaximumWeight maximumWeight, Model model, Task task, Volume volume) {

        if (agvIdentifier == null || agvShortDescription == null || autonomy == null || maximumWeight == null || model == null || task == null || volume == null)
            throw new IllegalArgumentException();

        this.agvIdentifier = agvIdentifier;
        this.agvShortDescription = agvShortDescription;
        this.autonomy = autonomy;
        this.maximumWeight = maximumWeight;
        this.model = model;
        this.task = task;
        this.volume = volume;
    }

    public AGV() {

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

    @Override
    public boolean sameAs(Object other) {
        return false;
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
