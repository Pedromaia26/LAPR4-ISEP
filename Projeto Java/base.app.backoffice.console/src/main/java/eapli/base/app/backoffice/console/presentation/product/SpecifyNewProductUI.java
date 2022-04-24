package eapli.base.app.backoffice.console.presentation.product;

import eapli.base.productmanagement.application.SpecifyNewProductController;
import eapli.base.usermanagement.application.AddCostumerController;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.HashSet;
import java.util.Set;

public class SpecifyNewProductUI extends AbstractUI {

    private final SpecifyNewProductController theController = new SpecifyNewProductController();
    private boolean invalidData;

    @Override
    protected boolean doShow() {

        do{
            invalidData = false;
            boolean op = false;
            // FIXME avoid duplication with SignUpUI. reuse UserDataWidget from
            final String setOfPhotos = Console.readLine("Set of Photos");
            final String shortDescription = Console.readLine("Short Description (Max 30 chars)");
            final String extendedDescription = Console.readLine("Extended Description (Between 20 and 100 chars)");
            final String technicalDescription = Console.readLine("Technical Description");
            final String brand = Console.readLine("Brand (Max 50 chars)");
            final String reference = Console.readLine("Reference (Alphanumeric code with at maximum 23 chars)");
            String productionCode = null;
            if (Console.readLine("Do you want to add the production code? (Y/N)").equals("Y")){
                productionCode = Console.readLine("Production Code (Please respect the following pattern: " +
                        "4 letters followed by a dot ('.') and ending with 5 digits (Max 23 chars)");
                op = true;
            }
            final String internalCode = Console.readLine("Internal Code (Please respect the following pattern: " +
                    "4 letters followed by a dot ('.') and ending with 5 digits (Max 23 chars)");
            final double price = Double.parseDouble(Console.readLine("Price"));
            final String barcode = Console.readLine("Barcode (Must have 13 chars)");

                try {
                    if (op)
                        this.theController.addProduct(setOfPhotos, shortDescription, extendedDescription, technicalDescription, brand, reference, productionCode, internalCode, price, barcode);
                    else
                        this.theController.addProduct(setOfPhotos, shortDescription, extendedDescription, technicalDescription, brand, reference, internalCode, price, barcode);
                } catch (final IntegrityViolationException | ConcurrencyException e) {
                    System.out.println("That code is already associated.");
                } catch (IllegalArgumentException e) {
                    System.out.println("\n"+ e.getMessage());
                    if (Console.readLine("Do you want to try again? (Y/N)").equals("Y")){
                        System.out.println();
                        invalidData = true;
                    }
                }
        }while(invalidData);


        return false;
    }

    @Override
    public String headline() {
        return "Specify product";
    }
}
