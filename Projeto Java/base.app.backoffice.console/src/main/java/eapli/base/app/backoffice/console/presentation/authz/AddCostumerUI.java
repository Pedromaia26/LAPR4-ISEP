package eapli.base.app.backoffice.console.presentation.authz;

import eapli.base.usermanagement.application.AddCostumerController;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.HashSet;
import java.util.Set;

public class AddCostumerUI extends AbstractUI {

    private final AddCostumerController theController = new AddCostumerController();

    @Override
    protected boolean doShow() {
        // FIXME avoid duplication with SignUpUI. reuse UserDataWidget from
        // UtenteApp
        final String username = Console.readLine("Username");
        final String password = Console.readLine("Password");
        final String firstName = Console.readLine("First Name");
        final String lastName = Console.readLine("Last Name");
        final String email = Console.readLine("E-Mail");
        final String vat = Console.readLine("VAT");
        final String phoneNumber = Console.readLine("PhoneNumber");
        final String gender = Console.readLine("Gender");
        final String birthDay = Console.readLine("BirthDay");
        final String delAddress = Console.readLine("Delivering Postal Addresses");
        final String billAddress = Console.readLine("Billing Postal Addresses");


        final Set<Role> roleTypes=new HashSet<>();
        roleTypes.add(BaseRoles.COSTUMER_USER);


        try {
            this.theController.addUser(username, password, firstName, lastName, email, roleTypes, vat, phoneNumber, gender, birthDay, delAddress,billAddress);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println("That username is already in use.");
        }

        return false;
    }

    @Override
    public String headline() {
        return "Add Costumer";
    }
}
