package eapli.base.app.backoffice.console.presentation.category;

import eapli.base.categorymanagement.application.DefineNewCategoryController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class DefineNewCategoryUI extends AbstractUI {

    private final DefineNewCategoryController theController = new DefineNewCategoryController();
    private boolean invalidData;

    @Override
    protected boolean doShow() {

        do {
            invalidData = false;
            // FIXME avoid duplication with SignUpUI. reuse UserDataWidget from
            final String code = Console.readLine("Code (Alphanumeric code with at maximum 23 chars)");
            final String description = Console.readLine("Description");

            try {
                this.theController.addCategory(code, description);
            } catch (final IntegrityViolationException | ConcurrencyException e) {
                System.out.println("That code is already associated.");
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + e.getMessage());
                if (Console.readLine("Do you want to try again? (Y/N)").equals("Y")) {
                    System.out.println();
                    invalidData = true;
                }
            }
        } while (invalidData);


        return false;
    }

    @Override
    public String headline() {
        return "Define Category";
    }
}
