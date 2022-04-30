package eapli.base.app.backoffice.console.presentation.warehouse;

import eapli.base.Warehouse.application.JsonImporterController;
import eapli.base.usermanagement.application.AddCostumerController;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.HashSet;
import java.util.Set;

public class JsonImporterUI extends AbstractUI {
    private final JsonImporterController theController = new JsonImporterController();
    private boolean flag=true;

    @Override
    protected boolean doShow() {
        do {
            flag=true;
            final String fileName = Console.readLine("File Name");


            try {
                this.theController.jsonImporter(fileName);
            } catch (Exception e) {
                System.out.println("Invalid file name.");
                if(Console.readLine("Want to try another file? Y/N").equalsIgnoreCase("y")) {
                    flag = false;
                }
            }
        }while (!flag);

            return false;

    }

    @Override
    public String headline() {
        return "Import warehouse plant from json file";
    }
}
