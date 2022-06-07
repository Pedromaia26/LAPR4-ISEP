package eapli.base.app.user.console.presentation.survey;

import eapli.base.app.user.console.presentation.product.AddProductShoppingCartUI;
import eapli.base.app.user.console.presentation.product.SearchProductBrandUI;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class ClientSurveys extends AbstractUI {
    @Override
    protected boolean doShow() {
        ViewClientSurveysUI viewClientSurveysUI = new ViewClientSurveysUI();
        viewClientSurveysUI.show();
        String s = Console.readLine("Do you want to answer one of these questionnaires? (Y/N)");
        while (s.equals("Y")){
            ShowSurveyUI showSurveyUI = new ShowSurveyUI();
            showSurveyUI.show();
            s = Console.readLine("Do you want to answer one more of these questionnaires? (Y/N)");
        }

        return false;
    }

    @Override
    public String headline() {
        return "My questionnaires";
    }
}
