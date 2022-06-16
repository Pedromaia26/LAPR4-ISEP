package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.infrastructure.bootstrapers.AGVBootsrapperBase;
import eapli.framework.actions.Action;

public class AGVBootstrapper extends AGVBootsrapperBase implements Action {
    @Override
    public boolean execute() {
        addAGV("11223344", "agv description", 60, 200, "model1", 10, "D1");
        addAGV("12345678", "agv description 2", 70, 500, "model2", 15, "D2");
        addAGV("99999999", "agv description 3", 70, 500, "model3", 15, "D3");
        addAGV("99876543", "agv description 4", 80, 270, "model4", 25, "D4");
        return true;
    }
}
