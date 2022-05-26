package eapli.base.app.user.console.presentation.product;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class SearchAddProductBrand extends AbstractUI{
        @Override
        protected boolean doShow() {
            SearchProductBrandUI searchProductBrandUI = new SearchProductBrandUI();
            searchProductBrandUI.show();
            String s = Console.readLine("Do you want to add one of these products to your shopping cart? (Y/N)");
            while (s.equals("Y")){
                AddProductShoppingCartUI addProductShoppingCartUI = new AddProductShoppingCartUI();
                addProductShoppingCartUI.show();
                s = Console.readLine("Do you want to add more products to your shopping cart? (Y/N)");
            }

            return false;
        }

        @Override
        public String headline() {
            return "Search product";
        }
}
