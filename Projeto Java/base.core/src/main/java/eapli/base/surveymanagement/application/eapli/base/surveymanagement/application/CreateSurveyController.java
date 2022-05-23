package eapli.base.surveymanagement.application.eapli.base.surveymanagement.application;

import java.io.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import eapli.base.surveymanagement.domain.Survey;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class CreateSurveyController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    public Survey createSurvey(final String file) throws IOException {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_MANAGER, BaseRoles.POWER_USER, BaseRoles.ADMIN);

        FileInputStream fis = new FileInputStream(file);
        SurveyLexer lexer = new SurveyLexer(new ANTLRInputStream(fis));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SurveyParser parser = new SurveyParser(tokens);
        ParseTree tree = parser.prog(); // parse
        SurvVisitor surv = new SurvVisitor();
        Survey survey = surv.visit(tree);

        System.out.println(survey);

        return null;
    }
}
