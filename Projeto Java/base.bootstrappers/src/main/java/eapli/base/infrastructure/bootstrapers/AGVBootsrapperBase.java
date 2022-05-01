package eapli.base.infrastructure.bootstrapers;

import eapli.base.Warehouse.application.AGVDockListController;
import eapli.base.Warehouse.domain.AGVDock;
import eapli.base.agvmanagement.application.ConfigureAGVController;
import eapli.base.categorymanagement.application.DefineNewCategoryController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class AGVBootsrapperBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersBootstrapperBase.class);

    final ConfigureAGVController configureAGVController = new ConfigureAGVController();
    final AGVDockListController agvDockListController = new AGVDockListController();

    public AGVBootsrapperBase() {
        super();
    }


    protected boolean addAGV(final String agvIdentifier, final String agvDescription, final double autonomy, final double maxWeight, final String model, final double volume) {
        try {
            List<AGVDock> list = (List<AGVDock>)agvDockListController.agvDocks();
            AGVDock agvDock = list.get(0);
            configureAGVController.addAGV(agvIdentifier, agvDescription, autonomy, maxWeight, model, volume, agvDock);
            LOGGER.debug("»»» %s", agvIdentifier);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // assuming it is just a primary key violation due to the tentative
            // of inserting a duplicated user. let's just lookup that user
            System.out.println("Something went wrong.");
        }
        return true;
    }
}
