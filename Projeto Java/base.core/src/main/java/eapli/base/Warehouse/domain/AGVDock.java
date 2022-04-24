package eapli.base.Warehouse.domain;

public class AGVDock {

    private AGVDockIdentifier agvDockIdentifier;

    private AGVDockBeginLSquare agvDockBeginLSquare;

    private AGVDockBeginWSquare agvDockBeginWSquare;

    private AGVDockEndLSquare agvDockEndLSquare;

    private AGVDockEndWSquare agvDockEndWSquare;

    private AGVDockDepthLSquare agvDockDepthLSquare;

    private AGVDockDepthWSquare agvDockDepthWSquare;

    private String accessibility;


    public AGVDock(AGVDockIdentifier agvDockIdentifier, AGVDockBeginLSquare agvDockBeginLSquare, AGVDockBeginWSquare agvDockBeginWSquare, AGVDockEndLSquare agvDockEndLSquare, AGVDockEndWSquare agvDockEndWSquare, AGVDockDepthLSquare agvDockDepthLSquare, AGVDockDepthWSquare agvDockDepthWSquare, String accessibility) {
        this.agvDockIdentifier = agvDockIdentifier;
        this.agvDockBeginLSquare = agvDockBeginLSquare;
        this.agvDockBeginWSquare = agvDockBeginWSquare;
        this.agvDockEndLSquare = agvDockEndLSquare;
        this.agvDockEndWSquare = agvDockEndWSquare;
        this.agvDockDepthLSquare = agvDockDepthLSquare;
        this.agvDockDepthWSquare = agvDockDepthWSquare;
        this.accessibility = accessibility;
    }
}
