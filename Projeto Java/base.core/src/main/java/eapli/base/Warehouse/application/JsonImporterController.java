package eapli.base.Warehouse.application;

import eapli.base.Warehouse.domain.Warehouse;
import eapli.base.Warehouse.domain.JsonImporter;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class JsonImporterController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final JsonImporter jsonImporter= new JsonImporter();

    public Warehouse jsonImporter(final String fileName) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.WAREHOUSE_EMPLOYEE, BaseRoles.ADMIN, BaseRoles.POWER_USER);

        return jsonImporter.importer(fileName);
    }

}
