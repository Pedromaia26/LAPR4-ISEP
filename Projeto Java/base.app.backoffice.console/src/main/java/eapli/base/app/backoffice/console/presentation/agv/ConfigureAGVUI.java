package eapli.base.app.backoffice.console.presentation.agv;

import eapli.base.Warehouse.application.AGVDockListController;
import eapli.base.Warehouse.domain.AGVDock;
import eapli.base.agvmanagement.application.AGVListController;
import eapli.base.agvmanagement.application.ConfigureAGVController;
import eapli.base.agvmanagement.domain.AGV;
import eapli.base.productmanagement.domain.Product;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.List;

public class ConfigureAGVUI extends AbstractUI {

    private ConfigureAGVController theController = new ConfigureAGVController();
    private AGVDockListController agvDockListController = new AGVDockListController();
    private AGVListController agvListController = new AGVListController();
    private boolean invalidData;
    private int index;
    private boolean free, more;
    private AGVDock agvDockSelected;

    @Override
    protected boolean doShow() {

        do {

            for (AGVDock agvDock: agvDockListController.agvDocks()){
                free = true;
                index++;
                for (AGV agv: agvListController.agv()) {
                    if (agv.AgvDock().equals(agvDock)) {
                        free = false;
                        System.out.println(index + ". " + agvDock.identity().Id() + " (Occupied)");
                        break;
                    }
                }
                if (free)
                    System.out.println(index + ". " + agvDock.identity().Id() + " (Free)");
            }

            do {
                more = false;
                final String agvDock = Console.readLine("Select one AGV Dock from the list (Identifier)");

                for (AGV agv : agvListController.agv()) {
                    if (agv.AgvDock().identity().Id().equals(agvDock)) {
                        more = true;
                        System.out.println("AGV Dock already belongs to an AGV. Please, try another AGV Dock!");
                    }
                }

                if (!more){
                    for (AGVDock agvDock1 : agvDockListController.agvDocks()) {
                        if (agvDock1.agvDockIdentifier().Id().equals(agvDock)) {
                            agvDockSelected = agvDock1;
                        }
                    }
                }

            }while(more);

            final String agvIdentifier = Console.readLine("Identifier (Alphanumeric code with at maximum 8 chars)");
            final String agvShortDescription = Console.readLine("Short Description (Max 30 chars)");
            final double autonomy = Double.parseDouble(Console.readLine("Autonomy (Minutes)"));
            final double maximumWeight = Double.parseDouble(Console.readLine("Maximum weight it can carry (kg)"));
            final String model = Console.readLine("Model (Max 50 chars)");
            final double volume = Double.parseDouble(Console.readLine("Maximum volume it can carry (cm3)"));




            try {
                this.theController.addAGV(agvIdentifier, agvShortDescription, autonomy, maximumWeight, model, volume, agvDockSelected);
            } catch (final IntegrityViolationException | ConcurrencyException e) {
                System.out.println("That code is already associated.");
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + e.getMessage());
                if (Console.readLine("Do you want to try again? (Y/N)").equals("Y")) {
                    System.out.println();
                    invalidData = true;
                }
            }


        }while(invalidData);

        return false;

    }

    @Override
    public String headline() {
        return "Configure AGV";
    }
}
