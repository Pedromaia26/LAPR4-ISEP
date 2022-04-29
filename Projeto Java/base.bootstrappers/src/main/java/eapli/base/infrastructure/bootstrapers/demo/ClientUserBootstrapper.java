/*
 * Copyright (c) 2013-2021 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.clientusermanagement.domain.*;
import eapli.base.usermanagement.application.AddCostumerController;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.domain.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eapli.base.clientusermanagement.application.AcceptRefuseSignupFactory;
import eapli.base.clientusermanagement.application.AcceptRefuseSignupRequestController;
import eapli.base.infrastructure.bootstrapers.TestDataConstants;
import eapli.base.myclientuser.application.SignupController;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Paulo Sousa
 */
public class ClientUserBootstrapper implements Action {
    private static final Logger LOGGER = LoggerFactory.getLogger(
            ClientUserBootstrapper.class);

    private final AddCostumerController addCostumerController = new AddCostumerController();


    @Override
    public boolean execute() {
        signupAndApprove(TestDataConstants.USER_TEST1, "Password1", "John", "Smith",
                "john@smith.com","123123123","+351935184013","Male","","a","1","4550-321","a","a","a","1","4550-321","a","a");
        signupAndApprove("isep959", "Password1", "Mary", "Smith", "mary@smith.com","123123124","+351935184014","Male","2002/08/25","a","1","4550-321","a","a","a","1","4550-321","a","a");
        return true;
    }

    private ClientUser signupAndApprove(final String username, final String password,
                                           final String firstName, final String lastName, final String email,
                                           final String vat, final String phoneNumber, final String gender, final String birthday, final String delStreetName,final String delDoor,final String delPost,final String delCity,final String delCountry, final String bilStreetName,final String bilDoor,final String bilPost,final String bilCity,final String bilCountry) {
        ClientUser request = null;
        try {
            final Set<Role> roleTypes=new HashSet<>();
            roleTypes.add(BaseRoles.COSTUMER_USER);
            final Set<String[]> delAddress=new HashSet<>();
            final Set<String[]> bilAddress=new HashSet<>();
            String[] strings = new String[5];

            strings[0]=delStreetName;
            strings[1]=delDoor;
            strings[2]=delPost;
            strings[3]=delCity;
            strings[4]=delCountry;

            delAddress.add(strings);

            strings[0]=bilStreetName;
            strings[1]=bilDoor;
            strings[2]=bilPost;
            strings[3]=bilCity;
            strings[4]=bilCountry;

            bilAddress.add(strings);

            request = addCostumerController.addUser(username, password, firstName, lastName, email, roleTypes,vat,phoneNumber,gender,birthday,delAddress,bilAddress);

        } catch (final ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", username);
            LOGGER.trace("Assuming existing record", e);
        }
        return request;
    }
}
