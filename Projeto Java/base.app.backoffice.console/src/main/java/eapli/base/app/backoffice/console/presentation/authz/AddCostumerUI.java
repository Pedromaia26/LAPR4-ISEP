package eapli.base.app.backoffice.console.presentation.authz;

import eapli.base.usermanagement.application.AddCostumerController;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        final String gender = Console.readLine("Gender(Optional)");
        final String birthDay = Console.readLine("BirthDay(Optional)");

        String opt =Console.readLine("Do you want to register the Delivering Postal Addresses? 1->Yes/2->No");
        Set<String[]> delAddress = new HashSet<>();
        while (opt.equalsIgnoreCase("1")) {
            String[] delAdd = new String[5];
            final String streetNameDel = Console.readLine("Street name");
            delAdd[0]=streetNameDel;
            final String doorNumberDel = Console.readLine("Door number");
            delAdd[1]=doorNumberDel;
            final String postalCodeDel = Console.readLine("Postal code");
            delAdd[2]=postalCodeDel;
            final String cityDel = Console.readLine("City");
            delAdd[3]=cityDel;
            final String countryDel = Console.readLine("Country");
            delAdd[4]=countryDel;
            delAddress.add(delAdd);
            opt =Console.readLine("Do you want to register another Delivering Postal Addresses? 1->Yes/2->No");
        }


        String opt1 =Console.readLine("Do you want to register the Billing Postal Addresses? 1->Yes/2->No");
        Set<String[]> bilAddress= new HashSet<>();
        while (opt1.equalsIgnoreCase("1")) {
            String[] bilAdd = new String[5];
            final String streetNameBil = Console.readLine("Street name");
            bilAdd[0]=streetNameBil;
            final String doorNumberBil = Console.readLine("Door number");
            bilAdd[1]=doorNumberBil;
            final String postalCodeBil = Console.readLine("Postal code");
            bilAdd[2]=postalCodeBil;
            final String cityBil = Console.readLine("City");
            bilAdd[3]=cityBil;
            final String countryBil = Console.readLine("Country");
            bilAdd[4]=countryBil;
            bilAddress.add(bilAdd);
            opt1 =Console.readLine("Do you want to register another Delivering Postal Addresses? 1->Yes/2->No");
        }


        final Set<Role> roleTypes=new HashSet<>();
        roleTypes.add(BaseRoles.COSTUMER_USER);


        try {
            this.theController.addUser(username, password, firstName, lastName, email, roleTypes, vat, phoneNumber, gender, birthDay, delAddress,bilAddress);
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
