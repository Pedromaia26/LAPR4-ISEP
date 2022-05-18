package eapli.base.agvmanagement.application;

import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.taskmanagement.application.TasksListController;
import eapli.base.taskmanagement.application.TasksListService;
import eapli.base.taskmanagement.domain.Task;

public class AssignTaskController {

    private TasksListService svcTask = new TasksListService();
    private AGVListService svcAGV = new AGVListService();
    private final AGVRepository agvRepository = PersistenceContext.repositories().agv();
    private AGV agv;

    public AGV assignTask(){
        Task task = svcTask.findTaskById(3L);
        for (AGV atAgv: svcAGV.agv()){
            if (atAgv.Task().hasIdentity(1L)){
                atAgv.modifyTask(task);
                agv = atAgv;
                break;
            }
        }

        if (agv == null){
            return null;
        }
        return agvRepository.save(agv);
    }
}
