package eapli.base.app.backoffice.console.presentation.survey;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.surveymanagement.domain.Context;
import eapli.framework.visitor.Visitor;

public class ContextPrinter implements Visitor<Context> {

    @Override
    public void visit(final Context visitee) {
        System.out.printf("%-10s|%-10s", visitee.identity(), visitee.description());
    }
}
