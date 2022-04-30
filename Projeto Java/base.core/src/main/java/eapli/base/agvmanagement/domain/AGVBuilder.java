package eapli.base.agvmanagement.domain;

import eapli.base.Warehouse.domain.AGVDock;
import eapli.base.productmanagement.domain.Product;
import eapli.base.taskmanagement.domain.Description;
import eapli.base.taskmanagement.domain.Task;

public class AGVBuilder {


    private AGV agv;
    private AGVIdentifier agvIdentifier;
    private AGVShortDescription agvShortDescription;
    private Autonomy autonomy;
    private MaximumWeight maximumWeight;
    private Model model;
    private Task task;
    private Volume volume;
    private AGVDock agvDock;

    public AGVBuilder(final String agvIdentifier, final String agvShortDescription, final double autonomy, final double maximumWeight, final String model, final Task task, final double volume, final AGVDock agvDock) {

        withAGVIdentifier(agvIdentifier);
        withAGVDescription(agvShortDescription);
        withAutonomy(autonomy);
        withMaximumWeight(maximumWeight);
        withModel(model);
        withTask(task);
        withVolume(volume);
        withAGVDock(agvDock);
    }


    public AGVBuilder withAGVIdentifier (String agvIdentifier){
        this.agvIdentifier = new AGVIdentifier(agvIdentifier);
        return this;
    }

    public AGVBuilder withAGVDescription (String agvShortDescription){
        this.agvShortDescription = new AGVShortDescription(agvShortDescription);
        return this;
    }

    public AGVBuilder withAutonomy (double autonomy){
        this.autonomy = new Autonomy(autonomy);
        return this;
    }

    public AGVBuilder withMaximumWeight (double maximumWeight){
        this.maximumWeight = new MaximumWeight(maximumWeight);
        return this;
    }

    public AGVBuilder withModel (String model){
        this.model = new Model(model);
        return this;
    }

    public AGVBuilder withTask (Task task){
        this.task = task;
        return this;
    }

    public AGVBuilder withVolume (double volume){
        this.volume = new Volume(volume);
        return this;
    }

    public AGVBuilder withAGVDock (AGVDock agvDock){
        this.agvDock = agvDock;
        return this;
    }


    private AGV buildOrThrow() {
        if (agv != null) {
            return agv;
        } else if (agvIdentifier != null && agvShortDescription != null && autonomy != null && maximumWeight != null && model != null && task != null && volume != null && agvDock != null) {
            agv = new AGV(agvIdentifier, agvShortDescription, autonomy, maximumWeight, model, task, volume, agvDock);
            return agv;
        } else {
            throw new IllegalStateException();
        }
    }

    public AGV build() {
        final AGV ret = buildOrThrow();
        return ret;
    }



}
