package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.CategoryCode;
import eapli.base.categorymanagement.domain.CategoryDescription;
import eapli.base.infrastructure.bootstrapers.CategoryBootstrapperBase;
import eapli.base.infrastructure.bootstrapers.ProductBootstrapperBase;
import eapli.base.infrastructure.bootstrapers.StatusBootstrapperBase;
import eapli.base.productmanagement.domain.*;
import eapli.framework.actions.Action;

import java.util.ArrayList;
import java.util.List;

public class CategoryBootstrapper extends CategoryBootstrapperBase implements Action {

    @Override
    public boolean execute() {
        addCategory("cat1", "Clothing");
        addCategory("cat2", "Drinks");
        return true;
    }
}
