package eapli.base.surveymanagement.domain;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.ClientUserBuilder;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.domain.model.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class ClientUserSurveyTest {
    private final SystemUser USER = getNewDummyUser();
    private static final String VAT = "123123123";
    private static final String PHONE_NUMBER = "+351912912912";
    private static final String GENDER = "Male";
    private static final String BIRTHDAY = "2022/01/01";

    public static SystemUser dummyUser(final String username, final Role... roles) {
        // should we load from spring context?
        final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        return userBuilder.with(username, "duMMy1", "dummy", "dummy", "a@b.ro").withRoles(roles).build();
    }

    private SystemUser getNewDummyUser() {
        return dummyUser("dummy", BaseRoles.ADMIN);
    }

    private ClientUser ClientUserBuild(){
        ClientUserBuilder b = new ClientUserBuilder();
        b.withSystemUser(USER);
        b.withVAT(VAT);
        b.withPhoneNumber(PHONE_NUMBER);
        b.withGender(GENDER);
        b.withBirthDay(BIRTHDAY);
        Set<String[]> set = new HashSet<>();
        String[] s = new String[5];
        s[0] = "a";
        s[1] = "1";
        s[2] = "4555-423";
        s[3] = "a";
        s[4] = "a";
        set.add(s);
        b.withDelAddress(set);
        b.withBillAddress(set);
        return b.build();
    }

    private ClientUserSurvey ClientUserSurveyBuild() {
        ClientUser clientUser = ClientUserBuild();
        return new ClientUserSurvey(clientUser);
    }


    @Test
    public void clientUser() {
        ClientUserSurvey clientUserSurvey = ClientUserSurveyBuild();
        ClientUser clientUser = ClientUserBuild();

        assertEquals(clientUser, clientUserSurvey.clientUser());
    }
}