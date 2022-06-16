package eapli.base.agvmanagement.application;

import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.taskmanagement.application.TasksListService;
import eapli.base.taskmanagement.domain.Task;
import eapli.framework.domain.repositories.TransactionalContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AGVStatusControllerImpl implements AGVStatusController{

    private AGVListService svcAGV = new AGVListService();
    private TasksListService svcTask = new TasksListService();
    private AGV agv;
    private final AGVRepository agvRepository = PersistenceContext.repositories().agv();
    private static final Logger LOGGER = LogManager.getLogger(AGVStatusControllerImpl.class);

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
            LOGGER.debug(e.getMessage());
            return false;
        }
        return false;
    }

    @Override
    public boolean updateStatusFree(String id) {
        try {
            Task task = svcTask.findTaskById(1L);
            for (AGV agv: svcAGV.agv()){
                if (agv.identity().AgvIdentifier().equals(id)){
                    agv.modifyTask(task);
                    this.agv = agv;
                    agvRepository.save(agv);
                    return true;
                }
            }
        }catch (Exception e){
            LOGGER.debug(e.getMessage());
            return false;
        }
        return false;
    }

    @Override
    public boolean updateStatusRecharge(String id) {
        try {
            Task task = svcTask.findTaskById(2L);
            for (AGV agv: svcAGV.agv()){
                if (agv.identity().AgvIdentifier().equals(id)){
                    agv.modifyTask(task);
                    this.agv = agv;
                    agvRepository.save(agv);
                    return true;
                }
            }
        }catch (Exception e){
            LOGGER.debug(e.getMessage());
            return false;
        }
        return false;
    }
}
