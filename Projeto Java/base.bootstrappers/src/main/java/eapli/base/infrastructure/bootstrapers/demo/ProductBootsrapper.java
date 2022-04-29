package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.CategoryCode;
import eapli.base.categorymanagement.domain.CategoryDescription;
import eapli.base.infrastructure.bootstrapers.ProductBootstrapperBase;
import eapli.base.infrastructure.bootstrapers.StatusBootstrapperBase;
import eapli.base.productmanagement.domain.*;
import eapli.framework.actions.Action;

import java.util.ArrayList;
import java.util.List;

public class ProductBootsrapper extends ProductBootstrapperBase implements Action {

    @Override
    public boolean execute() {
        CategoryDescription description = new CategoryDescription("Clothing");
        CategoryCode code = new CategoryCode("cat1");
        Category category = new Category(code,description);
        List<String> setOfPhotos = new ArrayList<>();
        setOfPhotos.add(0, "base.core/src/main/resources/hasbi.jpg");


        addProduct(category, setOfPhotos, "White t-shirt for man",  "Oversized graphic white t-shirt for man",
                "Oversized graphic white t-shirt for man made with soft knit fabric (59% cotton/41% polyester)",
                "Nike", "nikeogwt123", "n.101", "nike.10100", 45, "1234567890987", 500, 500, 500, 500,
                2,4,2);
        return true;
    }
}
