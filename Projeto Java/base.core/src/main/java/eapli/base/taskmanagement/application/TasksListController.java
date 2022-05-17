package eapli.base.taskmanagement.application;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.productmanagement.domain.Product;
import eapli.base.taskmanagement.domain.Task;
import eapli.framework.application.UseCaseController;

@UseCaseController
public class TasksListController {

    private final TasksListService svc = new TasksListService();

    public Iterable<Task> allTasks() {
        return svc.allTasks();
    }

    public Task findTaskById(Long taskID) {
        return svc.findTaskById(taskID);
    }
}
