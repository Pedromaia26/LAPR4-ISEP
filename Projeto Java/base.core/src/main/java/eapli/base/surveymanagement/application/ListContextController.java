package eapli.base.surveymanagement.application;

import eapli.base.categorymanagement.application.ListCategoryService;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.surveymanagement.domain.Context;
import eapli.framework.application.UseCaseController;

@UseCaseController
public class ListContextController {

    private final ListContextService svc = new ListContextService();

    public Iterable<Context> allContexts() {
        return svc.allContexts();
    }
}
