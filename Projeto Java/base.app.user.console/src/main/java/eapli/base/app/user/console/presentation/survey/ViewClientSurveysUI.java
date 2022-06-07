package eapli.base.app.user.console.presentation.survey;

import eapli.base.app.user.console.presentation.product.ProductCartPrinter;
import eapli.base.productmanagement.application.SearchProductDescriptionController;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.domain.ShortDescription;
import eapli.base.surveymanagement.application.VerifyClientSurveysController;
import eapli.base.surveymanagement.domain.Survey;
import eapli.base.surveymanagement.domain.dto.SurveyDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class ViewClientSurveysUI extends AbstractListUI<SurveyDTO>
{
    private final VerifyClientSurveysController theController = new VerifyClientSurveysController();

    @Override
    protected Iterable<SurveyDTO> elements() {
        return this.theController.allClientSurveys();
    }

    @Override
    protected Visitor<SurveyDTO> elementPrinter() {
        return new SurveyPrinter();
    }

    @Override
    protected String elementName() {
        return "Survey";
    }

    @Override
    protected String listHeader() {
        return "ID | TITLE";
    }

    @Override
    protected String emptyMessage() {
        return "No ";
    }

    @Override
    public String headline() {
        return "Surveys";
    }
}
