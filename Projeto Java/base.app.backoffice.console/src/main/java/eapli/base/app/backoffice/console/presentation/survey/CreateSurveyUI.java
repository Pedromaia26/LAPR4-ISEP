package eapli.base.app.backoffice.console.presentation.survey;

import eapli.base.surveymanagement.application.eapli.base.surveymanagement.application.CreateSurveyController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;

public class CreateSurveyUI extends AbstractUI {

    private final CreateSurveyController theController = new CreateSurveyController();
    private boolean invalidData;

    @Override
    protected boolean doShow() {

        do {
            invalidData = false;

            final String file = Console.readLine("Choose the file:");

            try {
                this.theController.createSurvey(file);
            } catch (IllegalArgumentException | IOException e) {
                System.out.println("\n" + e.getMessage());
                if (Console.readLine("Do you want to try again? (Y/N)").equals("Y")) {
                    System.out.println();
                    invalidData = true;
                }
            }
        } while (invalidData);


        return false;
    }

    @Override
    public String headline() {
        return "Create survey";
    }
}
