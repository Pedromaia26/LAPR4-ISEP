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
        Category category = new Category(code, description);
        CategoryDescription descriptionn = new CategoryDescription("Drinks");
        CategoryCode codee = new CategoryCode("cat2");
        Category categoryy = new Category(codee, descriptionn);
        List<String> setOfPhotos = new ArrayList<>();
        setOfPhotos.add(0, "base.core/src/main/resources/hasbi.jpg");


        addProduct(category, setOfPhotos, "White t-shirt for man", "Oversized graphic white t-shirt for man",
                "Oversized graphic white t-shirt for man made with soft knit fabric (59% cotton/41% polyester)",
                "Nike", "nikeogwt123", "n.101", "nike.10101", 45, "1234567890987", 500, 500, 500, 500,
                2, 4, 2);
        addProduct(categoryy, setOfPhotos, "Bombay Sapphire Gin", "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
                "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy",
                "Bombay", "bombay123", "a.101", "bomb.10100", 98, "0983210830123", 500, 500, 500, 500,
                1, 1, 1);
        addProduct(category, setOfPhotos, "FC Porto t-shirt for woman", "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
                "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy",
                "New Balance", "nbb5123", "b.101", "nbbb.10109", 45, "1430249012374", 500, 500, 500, 500,
                1, 2, 1);
        addProduct(category, setOfPhotos, "FC Porto t-shirt for man", "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
                "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy",
                "New Balance", "nbb1234", "c.101", "nbbb.10103", 40, "4012344132244", 500, 500, 500, 500,
                1, 3, 1);
        addProduct(categoryy, setOfPhotos, "Beefeater Gin", "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
                "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy",
                "Beefeater", "beefeater123", "d.101", "beef.10100", 32, "0192355051255", 500, 500, 500, 500,
                2, 1, 1);
        addProduct(category, setOfPhotos, "Blue jeans for man", "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
                "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy",
                "Nike", "nike123123", "e.101", "nike.10100", 19, "6234092643663", 500, 500, 500, 500,
                2, 2, 1);
        addProduct(category, setOfPhotos, "Black FC Porto shorts for man", "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
                "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy",
                "New Balance", "nbb123", "f.101", "nbbb.10100", 34, "1235634554355", 500, 500, 500, 500,
                2, 3, 1);
        return true;
    }
}