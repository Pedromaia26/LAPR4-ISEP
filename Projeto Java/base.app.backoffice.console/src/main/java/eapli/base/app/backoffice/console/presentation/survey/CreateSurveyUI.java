package eapli.base.app.backoffice.console.presentation.survey;

import eapli.base.app.backoffice.console.presentation.category.ListCategoryUI;
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
            ListContextUI listContextUI = new ListContextUI();
            listContextUI.show();
            try {
                final String context = Console.readLine("Choose one of the options (Id):");
                if (Long.parseLong(context) == 2){
                    final String minAge = Console.readLine("Minimum age: ");
                    final String maxAge = Console.readLine("Maximum age: ");
                    theController.createSurvey(file, Long.parseLong(context), Integer.parseInt(minAge), Integer.parseInt(maxAge));
                }
                else{
                    theController.createSurvey(file, Long.parseLong(context));
                }
                System.out.println("Survey created with success!");
            } catch (IllegalArgumentException | IOException e) {
                System.out.println(e.getMessage());
                if (Console.readLine("Do you want to try again? (Y/N)").equals("Y")) {
                    System.out.println();
                    invalidData = true;
                }
            }catch (NullPointerException e){
                System.out.println("Invalid Survey");
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
