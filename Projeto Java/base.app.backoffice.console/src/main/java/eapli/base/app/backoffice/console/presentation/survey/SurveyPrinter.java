package eapli.base.app.backoffice.console.presentation.survey;

import eapli.base.surveymanagement.domain.dto.SurveyDTO;
import eapli.framework.visitor.Visitor;

public class SurveyPrinter implements Visitor<SurveyDTO> {

    @Override
    public void visit(final SurveyDTO visitee) {
        System.out.printf("%-10s | %-10s", visitee.id, visitee.title);
    }
}
