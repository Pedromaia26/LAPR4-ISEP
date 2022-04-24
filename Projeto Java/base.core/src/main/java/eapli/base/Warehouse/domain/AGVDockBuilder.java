package eapli.base.Warehouse.domain;

import java.util.Set;

public class AGVDockBuilder {
    private AGVDock agvDock;

    private AGVDockIdentifier agvDockIdentifier;

    private AGVDockBeginLSquare agvDockBeginLSquare;

    private AGVDockBeginWSquare agvDockBeginWSquare;

    private AGVDockEndLSquare agvDockEndLSquare;

    private AGVDockEndWSquare agvDockEndWSquare;

    private AGVDockDepthLSquare agvDockDepthLSquare;

    private AGVDockDepthWSquare agvDockDepthWSquare;

    private String accessibility;


    public AGVDockBuilder(String rowIdentifier, long beginLSquare, long beginWSquare, long endLSquare, long endWSquare , long depthLSquare, long depthWSquare, String accessibility) {
        withRowIdentifier(rowIdentifier);
        withAGVDockBeginLSquare(beginLSquare);
        withAGVDockBeginWSquare(beginWSquare);
        withAGVDockEndLSquare(endLSquare);
        withAGVDockEndWSquare(endWSquare);
        withAGVDockDepthLSquare(depthLSquare);
        withAGVDockDepthWSquare(depthWSquare);
        this.accessibility = accessibility;

    }

    private AGVDockBuilder withRowIdentifier(String rowIdentifier){
        this.agvDockIdentifier=new AGVDockIdentifier(rowIdentifier);
        return this;
    }


    private AGVDockBuilder withAGVDockBeginLSquare(long beginWSquare){
        this.agvDockBeginLSquare= new AGVDockBeginLSquare(beginWSquare);
        return this;
    }

    private AGVDockBuilder withAGVDockBeginWSquare(long beginWSquare){
        this.agvDockBeginWSquare= new AGVDockBeginWSquare(beginWSquare);
        return this;
    }



    private AGVDockBuilder withAGVDockEndLSquare(long EndWSquare){
        this.agvDockEndLSquare= new AGVDockEndLSquare(EndWSquare);
        return this;
    }

    private AGVDockBuilder withAGVDockEndWSquare(long EndWSquare){
        this.agvDockEndWSquare= new AGVDockEndWSquare(EndWSquare);
        return this;
    }


    private AGVDockBuilder withAGVDockDepthLSquare(long depthWSquare){
        this.agvDockDepthLSquare= new AGVDockDepthLSquare(depthWSquare);
        return this;
    }

    private AGVDockBuilder withAGVDockDepthWSquare(long depthWSquare){
        this.agvDockDepthWSquare= new AGVDockDepthWSquare(depthWSquare);
        return this;
    }
    private AGVDock buildOrThrow() {
        if (agvDock != null) {
            return agvDock;
        } else if (accessibility != null && agvDockIdentifier != null && agvDockBeginLSquare != null && agvDockBeginWSquare!=null && agvDockEndLSquare!=null && agvDockEndWSquare !=null && agvDockDepthLSquare != null && agvDockDepthWSquare!=null ) {
            agvDock = new AGVDock(agvDockIdentifier,agvDockBeginLSquare,agvDockBeginWSquare,agvDockEndLSquare,agvDockEndWSquare,agvDockDepthLSquare,agvDockDepthWSquare,accessibility);
            return agvDock;
        } else {
            throw new IllegalStateException();
        }
    }

    public AGVDock build() {
        final AGVDock ret = buildOrThrow();
        // make sure we will create a new instance if someone reuses this builder and do not change
        // the previously built dish.
        agvDock = null;
        return ret;
    }
}
