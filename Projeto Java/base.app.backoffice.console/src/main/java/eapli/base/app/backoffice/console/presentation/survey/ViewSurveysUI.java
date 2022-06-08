package eapli.base.app.backoffice.console.presentation.survey;

import eapli.base.surveymanagement.application.SeeReportStatisticController;
import eapli.base.surveymanagement.application.VerifyClientSurveysController;
import eapli.base.surveymanagement.domain.dto.SurveyDTO;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class ViewSurveysUI extends AbstractListUI<SurveyDTO>
{
    private final SeeReportStatisticController theController = new SeeReportStatisticController();

    @Override
    protected Iterable<SurveyDTO> elements() {
        return this.theController.allSurveys();
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
