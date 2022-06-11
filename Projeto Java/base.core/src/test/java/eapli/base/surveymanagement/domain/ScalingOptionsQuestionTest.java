package eapli.base.surveymanagement.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScalingOptionsQuestionTest {
    private ScalingOptionsQuestion ScalingOptionsQuestionBuild() {
        return new ScalingOptionsQuestion(new Identifier("1"), new QuestionText("Text"), new VerifyQuestionType("numeric"), new VerifyObligatoriness("mandatory"), new Message("extra info"));
    }

    @Test
    public void ensureCanAddOption() {
        final ScalingOptionsQuestion subject = ScalingOptionsQuestionBuild();

        String answer = "A) Yes";

        subject.addOption(answer);

        List<String> expected = new ArrayList<>();
        expected.add(answer);

        assertEquals(expected, subject.options());
    }

    @Test
    public void ensureCanAddQuestion() {
        final ScalingOptionsQuestion subject = ScalingOptionsQuestionBuild();

        String answer = "Are you male?";

        subject.addQuestion(answer);

        List<String> expected = new ArrayList<>();
        expected.add(answer);

        assertEquals(expected, subject.questions());
    }

    @Test
    public void testToString() {
        final ScalingOptionsQuestion subject = ScalingOptionsQuestionBuild();

        String answer = "A) Yes";

        subject.addOption(answer);

        answer = "Are you male?";

        subject.addQuestion(answer);

        String expected = "--- Question ---\n" +
                "Id: 1\n" +
                "Question Text: Text\n" +
                "Instruction: null\n" +
                "Question Type: numeric\n" +
                "Obligatoriness: mandatory\n" +
                "Extra Info: extra info\n" +
                "ScalingOptionsQuestion{questions=[Are you male?], options=[A) Yes]}";

        assertEquals(expected, subject.toString());
    }
}