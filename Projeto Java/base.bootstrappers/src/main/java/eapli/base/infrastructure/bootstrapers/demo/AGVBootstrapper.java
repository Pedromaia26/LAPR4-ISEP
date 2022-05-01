package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.infrastructure.bootstrapers.AGVBootsrapperBase;
import eapli.framework.actions.Action;

public class AGVBootstrapper extends AGVBootsrapperBase implements Action {
    @Override
    public boolean execute() {
        addAGV("11223344", "agv description", 60, 200, "model1", 10);
        return true;
    }
}
