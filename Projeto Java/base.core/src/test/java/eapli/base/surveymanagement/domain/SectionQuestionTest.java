package eapli.base.surveymanagement.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class SectionQuestionTest {
    private Question QuestionBuild() {
        return new Question(new Identifier("1"), new QuestionText("Text"), new VerifyQuestionType("numeric"), new VerifyObligatoriness("mandatory"), new Message("extra info"));
    }


    @Test
    public void question() {
        Question question = QuestionBuild();
        SectionQuestion sectionQuestion = new SectionQuestion(question);


        assertEquals(question, sectionQuestion.question());
    }
}