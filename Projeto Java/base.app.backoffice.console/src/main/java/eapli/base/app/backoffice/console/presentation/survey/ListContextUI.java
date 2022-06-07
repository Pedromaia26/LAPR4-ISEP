package eapli.base.app.backoffice.console.presentation.survey;

import eapli.base.surveymanagement.application.ListContextController;
import eapli.base.surveymanagement.domain.Context;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class ListContextUI extends AbstractListUI<Context>
{
    private final ListContextController theController = new ListContextController();

    @Override
    protected Iterable<Context> elements() {
        return this.theController.allContexts();
    }

    @Override
    protected Visitor<Context> elementPrinter() {
        return new ContextPrinter();
    }

    @Override
    protected String elementName() {
        return "Context";
    }

    @Override
    protected String listHeader() {
        return "ID | DESCRIPTION";
    }

    @Override
    protected String emptyMessage() {
        return "No data.";
    }

    @Override
    public String headline() {
        return "Context list";
    }
}