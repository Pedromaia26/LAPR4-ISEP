package eapli.base.surveymanagement.domain;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.ClientUserBuilder;
import eapli.base.productmanagement.domain.ExtendedDescription;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.domain.model.*;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ContextSurveyTest {
    private static final String DESCRIPTION = "description description";

    private Context ContextBuild() {
        return new Context(new ExtendedDescription(DESCRIPTION));
    }


    @Test
    public void context() {
        Context context = ContextBuild();
        ContextSurvey contextSurvey = new ContextSurvey(context);


        assertEquals(context, contextSurvey.context());
    }
}