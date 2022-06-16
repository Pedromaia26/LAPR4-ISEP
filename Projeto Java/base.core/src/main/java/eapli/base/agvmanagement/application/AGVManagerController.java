package eapli.base.agvmanagement.application;

public interface AGVManagerController {

    boolean addOrderWithAGV(boolean flag);
    boolean freeAgv(String id);
    boolean rechargingAGV(String id);
    boolean rechargingAGVFinishedOrder(String id);
    boolean AGVinMaintenance(String id);


}
