package eapli.base.infrastructure.bootstrapers;

import eapli.base.Warehouse.application.JsonImporterController;
import eapli.base.Warehouse.domain.Warehouse;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WarehouseBootstrapperBase {
    final JsonImporterController warehouseImporter = new JsonImporterController();
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersBootstrapperBase.class);


    public WarehouseBootstrapperBase() {
        super();
    }

    /**
     * @param fileName
     */
    protected Warehouse importWarehouse(final String fileName) {
        Warehouse u = null;
        try {
            u = warehouseImporter.jsonImporter(fileName);
            LOGGER.debug("»»» %s", fileName);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // assuming it is just a primary key violation due to the tentative
            // of inserting a duplicated user. let's just lookup that user
            e.printStackTrace();
        }
        return u;
    }
}
