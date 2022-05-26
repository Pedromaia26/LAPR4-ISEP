package eapli.base.agvmanagement.application;

import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.taskmanagement.application.TasksListService;
import eapli.base.taskmanagement.domain.Task;
import eapli.framework.domain.repositories.TransactionalContext;

public class AGVStatusControllerImpl implements AGVStatusController{

    private AGVListService svcAGV = new AGVListService();
    private TasksListService svcTask = new TasksListService();
    private AGV agv;
    private final AGVRepository agvRepository = PersistenceContext.repositories().agv();


    @Override
    public boolean updateStatus(String id) {

        try {
            Task task = svcTask.findTaskById(3L);
            for (AGV agv: svcAGV.agv()){
                if (agv.identity().AgvIdentifier().equals(id)){
                    agv.modifyTask(task);
                    this.agv = agv;
                    agvRepository.save(agv);
                    return true;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }
}
