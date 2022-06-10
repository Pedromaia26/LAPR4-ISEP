package eapli.base.surveymanagement.application;

import eapli.base.surveymanagement.application.eapli.base.surveymanagement.application.*;
import eapli.base.surveymanagement.domain.Answer;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.BitSet;
import java.util.List;

public class ValidateAnswersController implements ANTLRErrorListener{
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    public void validateAnswer(String file) throws IOException {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_MANAGER, BaseRoles.POWER_USER, BaseRoles.ADMIN);

        List<Answer> list = parseAnswers(file);
    }

    public List<Answer> parseAnswers(final String file) throws IOException {
        FileInputStream fis = new FileInputStream("Answers/" + file);
        AnswerLexer lexer = new AnswerLexer(new ANTLRInputStream(fis));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AnswerParser parser = new AnswerParser(tokens);
        ANTLRErrorListener errorListener = new ValidateAnswersController();
        parser.addErrorListener(errorListener);
        ParseTree tree = parser.prog(); // parse
        AnsVisitor ans = new AnsVisitor();

        return ans.visit(tree);
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
}
