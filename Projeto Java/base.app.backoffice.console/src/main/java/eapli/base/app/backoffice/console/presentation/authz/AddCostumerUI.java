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
    private boolean flag;

    @Override
    protected boolean doShow() {
        // FIXME avoid duplication with SignUpUI. reuse UserDataWidget from
        // UtenteApp
        do {
            flag=true;

            final String username = Console.readLine("Username");
            final String password = Console.readLine("Password(At least one number and one capital letter)");
            final String firstName = Console.readLine("First Name");
            final String lastName = Console.readLine("Last Name");
            final String email = Console.readLine("E-Mail");
            final String vat = Console.readLine("VAT(9 Digits number)");
            final String phoneNumber = Console.readLine("PhoneNumber('+'+12digits phone number. eg:+351912345678)");
            final String gender = Console.readLine("Gender(Optional. If not blank, choose between male, female or other)");
            final String birthDay = Console.readLine("BirthDay(Optional. If not blank, the format is yyyy/MM/dd)");

            String opt = Console.readLine("Do you want to register the Delivering Postal Addresses? 1->Yes/2->No");
            Set<String[]> delAddress = new HashSet<>();
            while (opt.equalsIgnoreCase("1")) {
                String[] delAdd = new String[5];
                final String streetNameDel = Console.readLine("Street name");
                delAdd[0] = streetNameDel;
                final String doorNumberDel = Console.readLine("Door number(Only numbers)");
                delAdd[1] = doorNumberDel;
                final String postalCodeDel = Console.readLine("Postal code(4 number '-' 3 number. eg:4550-123)");
                delAdd[2] = postalCodeDel;
                final String cityDel = Console.readLine("City");
                delAdd[3] = cityDel;
                final String countryDel = Console.readLine("Country");
                delAdd[4] = countryDel;
                delAddress.add(delAdd);
                opt = Console.readLine("Do you want to register another Delivering Postal Addresses? 1->Yes/2->No");
            }


            String opt1 = Console.readLine("Do you want to register the Billing Postal Addresses? 1->Yes/2->No");
            Set<String[]> bilAddress = new HashSet<>();
            while (opt1.equalsIgnoreCase("1")) {
                String[] bilAdd = new String[5];
                final String streetNameBil = Console.readLine("Street name");
                bilAdd[0] = streetNameBil;
                final String doorNumberBil = Console.readLine("Door number(Only numbers)");
                bilAdd[1] = doorNumberBil;
                final String postalCodeBil = Console.readLine("Postal code(4 number '-' 3 number. eg:4550-123)");
                bilAdd[2] = postalCodeBil;
                final String cityBil = Console.readLine("City");
                bilAdd[3] = cityBil;
                final String countryBil = Console.readLine("Country");
                bilAdd[4] = countryBil;
                bilAddress.add(bilAdd);
                opt1 = Console.readLine("Do you want to register another Delivering Postal Addresses? 1->Yes/2->No");
            }


            final Set<Role> roleTypes = new HashSet<>();
            roleTypes.add(BaseRoles.COSTUMER_USER);


            try {
                this.theController.addUser(username, password, firstName, lastName, email, roleTypes, vat, phoneNumber, gender, birthDay, delAddress, bilAddress);
            } catch (Exception e) {
                System.out.println("Invalid data.");

                if(Console.readLine("Want to try to create another customer? Y/N").equalsIgnoreCase("y")) {
                    flag = false;
                }
            }
        }while (!flag);

        return false;
    }

    @Override
    public String headline() {
        return "Add Costumer";
    }
}
