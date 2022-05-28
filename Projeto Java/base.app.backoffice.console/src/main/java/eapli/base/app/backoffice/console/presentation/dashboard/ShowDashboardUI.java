package eapli.base.app.backoffice.console.presentation.dashboard;

import eapli.base.dashboardmanagement.DashboardController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;

public class ShowDashboardUI extends AbstractUI {

    private final DashboardController theController = new DashboardController();
    private boolean invalidData;

    @Override
    protected boolean doShow() {

        try {
            theController.openDashboard();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public String headline() {
        return "Opening dashboard";
    }
}
