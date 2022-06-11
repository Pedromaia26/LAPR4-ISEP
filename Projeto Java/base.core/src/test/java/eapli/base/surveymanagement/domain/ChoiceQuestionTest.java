package eapli.base.surveymanagement.domain;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.ClientUserBuilder;
import eapli.base.productmanagement.domain.Product;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.domain.model.*;
import eapli.framework.time.util.Calendars;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ChoiceQuestionTest {

    private ChoiceQuestion ChoiceQuestionBuild() {
        return new ChoiceQuestion(new Identifier("1"), new QuestionText("Text"), new VerifyQuestionType("numeric"), new VerifyObligatoriness("mandatory"), new Message("extra info"));
    }

    @Test
    public void ensureCanAddOption() {
        final ChoiceQuestion subject = ChoiceQuestionBuild();

        String answer = "A) Yes";

        subject.addOption(answer);

        List<String> expected = new ArrayList<>();
        expected.add(answer);

        assertEquals(expected, subject.options());
    }

    @Test
    public void testToString() {
        final ChoiceQuestion subject = ChoiceQuestionBuild();

        String answer = "A) Yes";

        subject.addOption(answer);

        String expected = "--- Question ---\n" +
                "Id: 1\n" +
                "Question Text: Text\n" +
                "Instruction: null\n" +
                "Question Type: numeric\n" +
                "Obligatoriness: mandatory\n" +
                "Extra Info: extra info\n" +
                "ChoiceQuestion{options=[A) Yes]}";

        assertEquals(expected, subject.toString());
    }
}