package eapli.base.app.user.console.presentation.survey;

import eapli.base.productmanagement.domain.Product;
import eapli.base.surveymanagement.domain.Survey;
import eapli.base.surveymanagement.domain.dto.SurveyDTO;
import eapli.framework.visitor.Visitor;

public class SurveyPrinter implements Visitor<SurveyDTO> {

    @Override
    public void visit(final SurveyDTO visitee) {
        System.out.printf("%-10s | %-10s", visitee.id, visitee.title);
    }
}
