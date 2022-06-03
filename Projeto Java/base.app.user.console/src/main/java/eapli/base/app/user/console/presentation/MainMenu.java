/*
 * Copyright (c) 2013-2019 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.app.user.console.presentation;

import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.app.user.console.presentation.order.ViewClientOrdersUI;
import eapli.base.app.user.console.presentation.product.*;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

/**
 * @author Paulo Gandra Sousa
 */
class MainMenu extends ClientUserBaseUI {

    private static final String RETURN_LABEL = "Return ";

    private static final String SEPARATOR_LABEL = "--------------";

    private static final String RETURN = "Return ";

    private static final String NOT_IMPLEMENTED_YET = "Not implemented yet";

    private static final int EXIT_OPTION = 0;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int PRODUCT_CATALOG = 2;
    private static final int SHOPPING_CART = 3;
    private static final int ORDER = 4;

    //PRODUCT CATALOG

    private static final int VIEW_PRODUCT_CATALOG = 1;
    private static final int SEARCH_PRODUCT_CATALOG = 2;

    //SEARCH PRODUCTS CATALOG SUB MENU

    private static final int SEARCH_BRAND_PRODUCT = 1;
    private static final int SEARCH_DESCRIPTION_PRODUCT = 2;

    //SHOPPING CART
    private static final int ADD_PRODUCT_SHOPPING_CART = 1;
    private static final int MY_SHOPPING_CART = 2;

    //ORDER
    private static final int VIEW_MY_PRODUCT_ORDER = 1;

    private final AuthorizationService authz =
            AuthzRegistry.authorizationService();

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    /**
     * @return true if the user selected the exit option
     */
    @Override
    public boolean doShow() {
        final Menu menu = buildMainMenu();
        final MenuRenderer renderer =
                new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu();
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        final Menu buildProductsCatalogMenu = buildProductsCatalogMenu();
        mainMenu.addSubMenu(PRODUCT_CATALOG, buildProductsCatalogMenu);

        final Menu buildAddProductsShoppingCartMenu = buildAddProductsShoppingCartMenu();
        mainMenu.addSubMenu(SHOPPING_CART, buildAddProductsShoppingCartMenu);

        final Menu buildViewOrderMenu = buildViewOrderMenu();
        mainMenu.addSubMenu(ORDER, buildViewOrderMenu);

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildProductsCatalogMenu() {
        final Menu menu = new Menu("Product Catalog >");

        menu.addItem(VIEW_PRODUCT_CATALOG, "View Product Catalog", new ViewAddProductCatalog()::show);

        final Menu SearchProduct = SearchProductsMenu();
        menu.addSubMenu(SEARCH_PRODUCT_CATALOG, SearchProduct);

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu SearchProductsMenu(){
        final Menu menu = new Menu("Search Product Catalog");

        menu.addItem(SEARCH_BRAND_PRODUCT, "Search by Product Brand", new SearchAddProductBrand()::show);
        menu.addItem(SEARCH_DESCRIPTION_PRODUCT, "Search by Product Description", new SearchAddProductDescription()::show);

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildAddProductsShoppingCartMenu() {
       final Menu menu = new Menu("Shopping cart >");

        menu.addItem(ADD_PRODUCT_SHOPPING_CART, "Add a product to shopping cart", new AddProductShoppingCartUI()::show);
        menu.addItem(MY_SHOPPING_CART, "View my shopping cart", new ViewShoppingCartUI()::show);

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildViewOrderMenu() {
        final Menu menu = new Menu("Order >");

        menu.addItem(VIEW_MY_PRODUCT_ORDER, "View my open orders", new ViewClientOrdersUI()::show);

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }
}
