package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.infrastructure.bootstrapers.StatusBootstrapperBase;
import eapli.framework.actions.Action;

public class StatusBootstrapper extends StatusBootstrapperBase implements Action {

    @Override
    public boolean execute() {
        addStatus("Registered");
        addStatus("Payment pending");
        addStatus("To be prepared");
        //edu add
        addStatus("Being prepared by agv");
        addStatus("Prepared on the warehouse");
        addStatus("Ready for packaging");
        addStatus("Ready for carrier dispatching");
        addStatus("Dispatched");
        addStatus("Delivered");
        addStatus("Received");


        return true;
    }
}
