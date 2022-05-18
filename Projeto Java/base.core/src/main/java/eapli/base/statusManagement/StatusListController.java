package eapli.base.statusManagement;

import eapli.base.orderstatusmanagement.domain.Status;
import eapli.base.taskmanagement.application.TasksListService;
import eapli.base.taskmanagement.domain.Task;

public class StatusListController {
    private final StatusListService svc = new StatusListService();

    public Iterable<Status> allStatus() {
        return svc.allStatus();
    }

    public Status findStatusById(Long statusid) {
        return svc.findStatusById(statusid);
    }
}
