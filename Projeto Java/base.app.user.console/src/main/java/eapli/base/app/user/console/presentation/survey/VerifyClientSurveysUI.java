package eapli.base.app.user.console.presentation.survey;

import eapli.base.surveymanagement.application.VerifyClientSurveysController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class VerifyClientSurveysUI {
    VerifyClientSurveysController theController = new VerifyClientSurveysController();

    public boolean doShow() {
        try {
            int numSurveys = theController.verifyClientSurveys();
            if (numSurveys > 0){
                System.out.println("Notification: You have " + numSurveys + " questionnaire(s) to answer!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Something went wrong!");
        }

        return false;
    }
}
