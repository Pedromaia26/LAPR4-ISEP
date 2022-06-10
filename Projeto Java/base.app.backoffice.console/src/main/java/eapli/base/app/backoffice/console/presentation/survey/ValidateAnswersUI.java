package eapli.base.app.backoffice.console.presentation.survey;

import eapli.base.surveymanagement.application.ValidateAnswersController;
import eapli.base.surveymanagement.application.eapli.base.surveymanagement.application.CreateSurveyController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;

public class ValidateAnswersUI extends AbstractUI {

    private final ValidateAnswersController theController = new ValidateAnswersController();
    private boolean invalidData;

    @Override
    protected boolean doShow() {

        do {
            invalidData = false;

            final String file = Console.readLine("Choose the file:");
            try {
                theController.validateAnswer(file);
                System.out.println("Answers validated with success!");
            } catch (IllegalArgumentException | IOException e) {
                System.out.println(e.getMessage());
                if (Console.readLine("Do you want to try again? (Y/N)").equals("Y")) {
                    System.out.println();
                    invalidData = true;
                }
            }catch (NullPointerException e){
                System.out.println("Invalid Answers");
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
        return "Validate Answers";
    }
}
