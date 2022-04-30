package eapli.base.infrastructure.bootstrapers;

import eapli.framework.actions.Action;

public class WarehouseBootstrapper extends WarehouseBootstrapperBase implements Action {
    @Override
    public boolean execute() {
        importWarehouseBootStrap("warehouse1");
        return true;
    }
    private void importWarehouseBootStrap(final String fileName) {

        importWarehouse(fileName);
    }
}
