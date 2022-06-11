package eapli.base.surveymanagement.domain;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.CategoryCode;
import eapli.base.categorymanagement.domain.CategoryDescription;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.ClientUserBuilder;
import eapli.base.ordermanagement.domain.*;
import eapli.base.orderstatusmanagement.domain.Status;
import eapli.base.productmanagement.domain.Product;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.domain.model.*;
import eapli.framework.time.util.Calendars;
import org.junit.Test;
import org.junit.experimental.theories.internal.AllMembersSupplier;

import java.util.*;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AnswerTest {
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

    private ClientUser ClientUserBuild(String vat){
        ClientUserBuilder b = new ClientUserBuilder();
        b.withSystemUser(USER);
        b.withVAT(vat);
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

    private Answer AnswerBuild() {
        ClientUser client = ClientUserBuild(VAT);
        Question question = new Question();
        List<String> list = new ArrayList<>();
        return new Answer(client, list, question);
    }

    @Test
    public void ensureCanChangeQuestion() {
        final Answer subject = AnswerBuild();

        final Question newInfo = new Question(new Identifier("1"), new QuestionText("Text"), new VerifyQuestionType("numeric"), new VerifyObligatoriness("mandatory"), new Message("extra info"));

        subject.modifyQuestion(newInfo);

        assertEquals(newInfo, subject.question());
    }

    @Test
    public void ensureCanChangeClientUser() {
        final Answer subject = AnswerBuild();

        final ClientUser newInfo = ClientUserBuild("111111111");

        subject.modifyClientUser(newInfo);

        assertEquals(newInfo, subject.clientUser());
    }

    @Test
    public void ensureCanAddAnswer() {
        final Answer subject = AnswerBuild();

        String answer = "A";

        subject.addAnswers(answer);

        List<String> expected = new ArrayList<>();
        expected.add(answer);

        assertEquals(expected, subject.answers());
    }

    @Test
    public void ensureCanResetAnswer() {
        final Answer subject = AnswerBuild();

        String answer = "A";

        subject.addAnswers(answer);
        subject.resetAnswers();

        List<String> expected = new ArrayList<>();

        assertEquals(expected, subject.answers());
    }

    @Test
    public void ensureAnswerEqualsAreTheSameForTheSameInstance() {

        final Answer subject = AnswerBuild();

        final boolean expected = subject.equals(subject);

        assertTrue(expected);
    }

    @Test
    public void ensureAnswerEqualsFailsForDifferenteObjectTypes() {

        final Answer subject = AnswerBuild();

        final boolean expected = subject.equals(new Product());

        assertFalse(expected);
    }

    @Test
    public void ensureAnswerIsTheSameAsItsInstance() {

        final Answer subject = AnswerBuild();

        final boolean expected = subject.sameAs(subject);

        assertTrue(expected);
    }

    @Test
    public void ensureTwoOrderLineWithDifferentQuestionAreNotTheSame() {
        final Answer subject1 = AnswerBuild();

        final Answer subject2 = AnswerBuild();
        subject1.modifyQuestion(new Question(new Identifier("1"), new QuestionText("Text"), new VerifyQuestionType("numeric"), new VerifyObligatoriness("mandatory"), new Message("extra info")));
        final boolean expected = subject1.sameAs(subject2);

        assertTrue(expected);
    }

}