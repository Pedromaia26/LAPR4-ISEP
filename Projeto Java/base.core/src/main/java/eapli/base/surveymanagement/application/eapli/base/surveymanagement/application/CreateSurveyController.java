package eapli.base.surveymanagement.application.eapli.base.surveymanagement.application;

import java.io.*;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.Quantity;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.base.shoppingcartmanagement.domain.ShoppingCart;
import eapli.base.shoppingcartmanagement.domain.ShoppingCartLine;
import eapli.base.surveymanagement.domain.*;
import eapli.base.surveymanagement.repositories.ContextRepository;
import eapli.base.surveymanagement.repositories.QuestionRepository;
import eapli.base.surveymanagement.repositories.SectionRepository;
import eapli.base.surveymanagement.repositories.SurveyRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.*;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.BitSet;
import java.util.List;

public class CreateSurveyController implements ANTLRErrorListener{
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final TransactionalContext txCtx = PersistenceContext.repositories().newTransactionalContext();
    private final SurveyRepository surveyRepository = PersistenceContext.repositories().surveys(txCtx);
    private final SectionRepository sectionRepository = PersistenceContext.repositories().sections(txCtx);
    private final QuestionRepository questionRepository = PersistenceContext.repositories().questions(txCtx);
    private final ContextRepository contextRepository = PersistenceContext.repositories().contexts();
    private final ProductRepository productRepository = PersistenceContext.repositories().products();

    public String createSurvey(final String file, final Long context) throws IOException {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_MANAGER, BaseRoles.POWER_USER, BaseRoles.ADMIN);

        Survey survey = parseSurvey(file);
        survey.addContext(contextRepository.findContextById(context));
        try{
            txCtx.beginTransaction();
            for (SurveySection s : survey.sections()){
                for (SectionQuestion q : s.section().questions()){
                    questionRepository.save(q.question());
                }
                sectionRepository.save(s.section());
            }
            surveyRepository.save(survey);
            txCtx.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            txCtx.rollback();
            throw new IllegalArgumentException();
        }

        return survey.identity().toString();
    }

    public String createSurvey(final String file, final Long context, int minAge, int maxAge) throws IOException {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_MANAGER, BaseRoles.POWER_USER, BaseRoles.ADMIN);


        Survey survey = parseSurvey(file);
        survey.modifyMinAge(new Age(minAge));
        survey.modifyMaxAge(new Age(maxAge));
        survey.addContext(contextRepository.findContextById(context));
        try{
            txCtx.beginTransaction();
            for (SurveySection s : survey.sections()){
                for (SectionQuestion q : s.section().questions()){
                    questionRepository.save(q.question());
                }
                sectionRepository.save(s.section());
            }
            surveyRepository.save(survey);
            txCtx.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            txCtx.rollback();
            throw new IllegalArgumentException();
        }

        return survey.identity().toString();
    }

    public String createSurvey(final String file, final Long context, final String productCode) throws IOException {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_MANAGER, BaseRoles.POWER_USER, BaseRoles.ADMIN);

        Survey survey = parseSurvey(file);
        survey.modifyProduct(productRepository.findByCode(productCode));
        survey.addContext(contextRepository.findContextById(context));
        try{
            txCtx.beginTransaction();
            for (SurveySection s : survey.sections()){
                for (SectionQuestion q : s.section().questions()){
                    questionRepository.save(q.question());
                }
                sectionRepository.save(s.section());
            }
            surveyRepository.save(survey);
            txCtx.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            txCtx.rollback();
            throw new IllegalArgumentException();
        }

        return survey.identity().toString();
    }

    public String addContext(String surveyId, Long context, int minAge, int maxAge) throws IOException {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_MANAGER, BaseRoles.POWER_USER, BaseRoles.ADMIN);

        txCtx.beginTransaction();
        Survey survey = surveyRepository.findSurveyById(surveyId);
        survey.modifyMinAge(new Age(minAge));
        survey.modifyMaxAge(new Age(maxAge));
        survey.addContext(contextRepository.findContextById(context));
        txCtx.commit();

        return survey.identity().toString();
    }

    public String addContext(String surveyId, Long context, String productCode) throws IOException {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_MANAGER, BaseRoles.POWER_USER, BaseRoles.ADMIN);

        txCtx.beginTransaction();
        Survey survey = surveyRepository.findSurveyById(surveyId);
        survey.modifyProduct(productRepository.findByCode(productCode));
        survey.addContext(contextRepository.findContextById(context));
        txCtx.commit();

        return survey.identity().toString();
    }

    public String addContext(String surveyId, Long context) throws IOException {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_MANAGER, BaseRoles.POWER_USER, BaseRoles.ADMIN);

        txCtx.beginTransaction();
        Survey survey = surveyRepository.findSurveyById(surveyId);
        survey.addContext(contextRepository.findContextById(context));
        txCtx.commit();

        return survey.identity().toString();
    }

    public Survey parseSurvey(final String file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        SurveyLexer lexer = new SurveyLexer(new ANTLRInputStream(fis));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SurveyParser parser = new SurveyParser(tokens);
        ANTLRErrorListener errorListener = new CreateSurveyController();
        parser.addErrorListener(errorListener);
        ParseTree tree = parser.prog(); // parse
        SurvVisitor surv = new SurvVisitor();

       return surv.visit(tree);
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) {
        System.out.println("Syntax Error");
    }

    @Override
    public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {
        System.out.println("Report ambiguity");
    }

    @Override
    public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitSet, ATNConfigSet atnConfigSet) {
        System.out.println("Report attempting full context");
    }

    @Override
    public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atnConfigSet) {
        System.out.println("Report context sensitivity");
    }

    public boolean addPeriodLimit(String surveyId, String days){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_MANAGER, BaseRoles.POWER_USER, BaseRoles.ADMIN);

        LocalDate today = LocalDate.now();

        LocalDate limit = today.plusDays(Integer.parseInt(days));

        txCtx.beginTransaction();
        Survey survey = surveyRepository.findSurveyById(surveyId);
        survey.modifyPeriod(limit);
        surveyRepository.save(survey);
        txCtx.commit();

        return false;
    }
}
