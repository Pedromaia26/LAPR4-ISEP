package eapli.base.app.backoffice.console.presentation.agv;

import eapli.base.agvmanagement.application.AGVController;
import eapli.base.app.backoffice.console.presentation.category.ListCategoryUI;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;

public class ConfigureAGVUI extends AbstractUI {

    private AGVController theController = new AGVController();
    private boolean invalidData;

    @Override
    protected boolean doShow() {

        do {
            final String agvIdentifier = Console.readLine("Identifier (Alphanumeric code with at maximum 8 chars)");
            final String agvShortDescription = Console.readLine("Short Description (Max 30 chars)");
            final double autonomy = Double.parseDouble(Console.readLine("Autonomy (Minutes)"));
            final double maximumWeight = Double.parseDouble(Console.readLine("Maximum weight it can carry (kg)"));
            final String model = Console.readLine("Model (Max 50 chars)");
            final double volume = Double.parseDouble(Console.readLine("Maximum volume it can carry (cm3)"));

            try {
                this.theController.addAGV(agvIdentifier, agvShortDescription, autonomy, maximumWeight, model, volume);
            } catch (final IntegrityViolationException | ConcurrencyException e) {
                System.out.println("That code is already associated.");
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + e.getMessage());
                if (Console.readLine("Do you want to try again? (Y/N)").equals("Y")) {
                    System.out.println();
                    invalidData = true;
                }
            }
            return false;
        }while(invalidData);

    }

    @Override
    public String headline() {
        return "Configure AGV";
    }
}
