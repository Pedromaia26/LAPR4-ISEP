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
package eapli.base.app.backoffice.console.presentation;

import eapli.base.app.backoffice.console.presentation.agv.ConfigureAGVUI;
import eapli.base.app.backoffice.console.presentation.agv.UpdateAGVStatusUI;
import eapli.base.app.backoffice.console.presentation.authz.*;
import eapli.base.app.backoffice.console.presentation.category.DefineNewCategoryUI;
import eapli.base.app.backoffice.console.presentation.category.ListCategoryUI;
import eapli.base.app.backoffice.console.presentation.dashboard.ShowDashboardUI;
import eapli.base.app.backoffice.console.presentation.forceOrder.ForceOrderUI;
import eapli.base.app.backoffice.console.presentation.order.AddOrderUI;
import eapli.base.app.backoffice.console.presentation.order.UpdateOrderDeliveredUI;
import eapli.base.app.backoffice.console.presentation.order.UpdateOrderDispatchedUI;
import eapli.base.app.backoffice.console.presentation.product.*;
import eapli.base.app.backoffice.console.presentation.survey.CreateSurveyUI;
import eapli.base.app.backoffice.console.presentation.survey.SeeReportStatisticUI;
import eapli.base.app.backoffice.console.presentation.warehouse.JsonImporterUI;
import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.Application;
import eapli.base.app.backoffice.console.presentation.clientuser.AcceptRefuseSignupRequestAction;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.ShowMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

/**
 * TODO split this class in more specialized classes for each menu
 *
 * @author Paulo Gandra Sousa
 */
public class MainMenu extends AbstractUI {

    private static final String RETURN_LABEL = "Return ";

    private static final int EXIT_OPTION = 0;

    // USERS
    private static final int ADD_USER_OPTION = 1;
    private static final int LIST_USERS_OPTION = 2;
    private static final int DEACTIVATE_USER_OPTION = 3;
    private static final int ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION = 4;

    // PRODUCTS MAIN MENU
    private static final int PRODUCT_MENU = 3;

    //PRODUCTS SUB MENU
    private static final int LIST_ALL_PRODUCT = 1;
    private static final int SEARCH_BRAND_PRODUCT = 2;
    private static final int SEARCH_DESCRIPTION_PRODUCT = 3;
    private static final int SEARCH_CATEGORY_PRODUCT = 4;

    //PRODUCTS
    private static final int SPECIFY_NEW_PRODUCT = 1;
    private static final int SEARCH_LIST_PRODUCT_SUBMENU = 2;

    // CATEGORY MAIN MENU
    private static final int CATEGORY_MENU = 4;

    //CATEGORY
    private static final int DEFINE_NEW_CATEGORY = 1;
    private static final int SHOW_CATEGORY_LIST = 2;

    // ORDER MAIN MENU
    private static final int ORDER_MENU = 5;

    // ORDER
    private static final int CREATE_NEW_ORDER = 1;
    private static final int UPDATING_ORDER_DELIVERED = 2;

    // SETTINGS
    private static final int SET_KITCHEN_ALERT_LIMIT_OPTION = 1;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int USERS_OPTION = 2;
    private static final int SETTINGS_OPTION = 4;

    //WareHouse MAIN MENU
    private static final int JSON_WAREHOUSE_PLANT_IMPORTER_MENU = 2;
    private static final int AGV = 3;

    //WareHouse
    private static final int JSON_WAREHOUSE_PLANT_IMPORTER = 1;

    // AGV
    private static final int CONFIGURE_AGV = 1;
    private static final int AGV_TASK_FINISHED = 2;

    //Force order
    private static final int FORCING_ORDER=1;
    private static final int FORCE_ORDER=4;

    //Update order
    private static final int UPDATING_ORDER=1;
    private static final int UPDATE_ORDER = 5;

    //Survey Main Menu
    private static final int SURVEY_MENU = 2;

    //Survey
    private static final int CREATE_SURVEY = 1;
    private static final int STATISTIC_SURVEY = 2;

    //Dashboard
    private static final int DASHBOARD = 6;
    private static final int OPEN_DASHBOARD = 1;


    private static final String SEPARATOR_LABEL = "--------------";

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

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
        final MenuRenderer renderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            renderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return renderer.render();
    }

    @Override
    public String headline() {

        return authz.session().map(s -> "Base [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("Base [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu();
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER, BaseRoles.ADMIN)) {
            final Menu usersMenu = buildUsersMenu();
            mainMenu.addSubMenu(USERS_OPTION, usersMenu);
            final Menu settingsMenu = buildAdminSettingsMenu();
            mainMenu.addSubMenu(SETTINGS_OPTION, settingsMenu);
        }

        if(authz.isAuthenticatedUserAuthorizedTo(BaseRoles.SALES_CLERK)){
            final Menu registerCostumer = buildRegisterCostumerMenu();
            mainMenu.addSubMenu(USERS_OPTION, registerCostumer);
            final Menu Product = buildProductMenu();
            mainMenu.addSubMenu(PRODUCT_MENU, Product);
            final Menu Category = buildCategoryMenu();
            mainMenu.addSubMenu(CATEGORY_MENU, Category);
            final Menu Order = buildOrderMenu();
            mainMenu.addSubMenu(ORDER_MENU, Order);
        }

        if(authz.isAuthenticatedUserAuthorizedTo(BaseRoles.WAREHOUSE_EMPLOYEE)){
            final Menu importJson = buildImportJson();
            mainMenu.addSubMenu(JSON_WAREHOUSE_PLANT_IMPORTER_MENU, importJson);
            final Menu configureAGV = buildConfigureAGV();
            mainMenu.addSubMenu(AGV, configureAGV);
            final Menu forceOrder = buildForceOrder();
            mainMenu.addSubMenu(FORCE_ORDER, forceOrder);
            final Menu updateOrder = buildUpdateOrderMenu();
            mainMenu.addSubMenu(UPDATE_ORDER, updateOrder);
            final Menu dashboard = buildDashboardMenu();
            mainMenu.addSubMenu(DASHBOARD, dashboard);
        }

        if(authz.isAuthenticatedUserAuthorizedTo(BaseRoles.SALES_MANAGER)){
            final Menu createSurvey = buildCreateSurvey();
            mainMenu.addSubMenu(SURVEY_MENU, createSurvey);
        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildAdminSettingsMenu() {
        final Menu menu = new Menu("Settings >");

        menu.addItem(SET_KITCHEN_ALERT_LIMIT_OPTION, "Set kitchen alert limit",
                new ShowMessageAction("Not implemented yet"));
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildUsersMenu() {
        final Menu menu = new Menu("Users >");

        menu.addItem(ADD_USER_OPTION, "Add User", new AddUserUI()::show);
        menu.addItem(LIST_USERS_OPTION, "List all Users", new ListUsersAction());
        menu.addItem(DEACTIVATE_USER_OPTION, "Deactivate User", new DeactivateUserAction());
        menu.addItem(ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION, "Accept/Refuse Signup Request",
                new AcceptRefuseSignupRequestAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildRegisterCostumerMenu() {
        final Menu menu = new Menu("Register Costumer >");

        menu.addItem(ADD_USER_OPTION, "Add Costumer", new AddCostumerUI()::show);

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildImportJson(){
        final Menu menu = new Menu("Import Json >");

        menu.addItem(JSON_WAREHOUSE_PLANT_IMPORTER, "Import Warehouse plant from Json", new JsonImporterUI()::show);

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildProductMenu() {
        final Menu menu = new Menu("Product >");

        menu.addItem(SPECIFY_NEW_PRODUCT, "Specify Product", new SpecifyNewProductUI()::show);
        final Menu SearchProduct = buildSearchViewProductMenu();
        menu.addSubMenu(SEARCH_LIST_PRODUCT_SUBMENU, SearchProduct);

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildSearchViewProductMenu(){
        final Menu menu = new Menu("Search/View Product Catalog");

        menu.addItem(LIST_ALL_PRODUCT, "View Products Catalog", new ListProductUI()::show);
        menu.addItem(SEARCH_BRAND_PRODUCT, "Search Products Catalog by Brand", new SearchProductBrandUI()::show);
        menu.addItem(SEARCH_DESCRIPTION_PRODUCT, "Search Products Catalog by Description", new SearchProductDescriptionUI()::show);
        menu.addItem(SEARCH_CATEGORY_PRODUCT, "Search Products Catalog by Category Code", new SearchProductCategoryUI()::show);

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildCategoryMenu() {
        final Menu menu = new Menu("Category >");

        menu.addItem(DEFINE_NEW_CATEGORY, "Define Category", new DefineNewCategoryUI()::show);
        menu.addItem(SHOW_CATEGORY_LIST, "Show Category List", new ListCategoryUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildOrderMenu() {
        final Menu menu = new Menu("Order >");

        menu.addItem(CREATE_NEW_ORDER, "Create products order", new AddOrderUI()::show);
        menu.addItem(UPDATING_ORDER_DELIVERED, "Update dispatched orders to being delivered", new UpdateOrderDeliveredUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildConfigureAGV(){
        final Menu menu = new Menu("AGV >");

        menu.addItem(CONFIGURE_AGV, "Configure AGV", new ConfigureAGVUI()::show);
        menu.addItem(AGV_TASK_FINISHED, "Update AGV status", new UpdateAGVStatusUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }
    private Menu buildForceOrder(){
        final Menu menu = new Menu("Force Order >");

        menu.addItem(FORCING_ORDER, "Force Order", new ForceOrderUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildUpdateOrderMenu(){
        final Menu menu = new Menu("Update Order >");

        menu.addItem(UPDATING_ORDER, "Update Order", new UpdateOrderDispatchedUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildCreateSurvey() {
        final Menu menu = new Menu("Survey >");

        menu.addItem(CREATE_SURVEY, "Create Survey", new CreateSurveyUI()::show);
        menu.addItem(STATISTIC_SURVEY, "Statistical report of a survey", new SeeReportStatisticUI()::show);

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildDashboardMenu(){
        final Menu menu = new Menu("Dashboard >");

        menu.addItem(OPEN_DASHBOARD, "Open Dashboard", new ShowDashboardUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

}
