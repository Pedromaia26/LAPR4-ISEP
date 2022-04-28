package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.infrastructure.bootstrapers.StatusBootstrapperBase;
import eapli.base.infrastructure.bootstrapers.TaskBootstrapperBase;
import eapli.framework.actions.Action;

public class TaskBootstrapper extends TaskBootstrapperBase implements Action {

    @Override
    public boolean execute() {
        addTask("Free");
        addTask("Charging");
        addTask("Occupied serving a given order");
        addTask("In maintenance");
        return true;
    }
}
