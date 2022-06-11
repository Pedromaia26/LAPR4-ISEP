package eapli.base.app.backoffice.console.presentation.survey;

import eapli.base.app.backoffice.console.presentation.category.ListCategoryUI;
import eapli.base.surveymanagement.application.eapli.base.surveymanagement.application.CreateSurveyController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateSurveyUI extends AbstractUI {

    private final CreateSurveyController theController = new CreateSurveyController();
    private boolean invalidData;

    @Override
    protected boolean doShow() {

        do {
            invalidData = false;
            boolean surveyCreated = false;
            String r, surveyId = null;
            final String file = Console.readLine("Choose the file:");
            ListContextUI listContextUI = new ListContextUI();
            listContextUI.show();
            try {
                do{
                    final String context = Console.readLine("Choose one of the options (Id):");
                    if (Long.parseLong(context) == 2){
                        final String minAge = Console.readLine("Minimum age: ");
                        final String maxAge = Console.readLine("Maximum age: ");
                        if (!surveyCreated){
                            surveyId = theController.createSurvey(file, Long.parseLong(context), Integer.parseInt(minAge), Integer.parseInt(maxAge));
                            surveyCreated = true;
                            System.out.println(surveyId);
                        }
                        else{
                            theController.addContext(surveyId, Long.parseLong(context), Integer.parseInt(minAge), Integer.parseInt(maxAge));
                        }
                    }
                    else if (Long.parseLong(context) == 3){
                        final String productInternalCode = Console.readLine("Product internal code: ");
                        if (!surveyCreated){
                            surveyId = theController.createSurvey(file, Long.parseLong(context), productInternalCode);
                            surveyCreated = true;
                        }
                        else{
                            theController.addContext(surveyId, Long.parseLong(context), productInternalCode);
                        }
                    }
                    else{
                        if (!surveyCreated){
                            surveyId = theController.createSurvey(file, Long.parseLong(context));
                            surveyCreated = true;
                        }
                        else{
                            theController.addContext(surveyId, Long.parseLong(context));
                        }
                    }
                    r = Console.readLine("Do you want to add one more context? (Y/N)");
                }while(r.equals("Y"));
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
