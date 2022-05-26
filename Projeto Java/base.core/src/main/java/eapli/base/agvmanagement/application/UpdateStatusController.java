package eapli.base.agvmanagement.application;

public class UpdateStatusController {

    FreeAGVService freeAGVService = new FreeAGVService();

    public boolean updateStatusWhenAGVTaskIsDone(String agvID){
        freeAGVService.freeAgvService(agvID);
        return true;
    }
}
