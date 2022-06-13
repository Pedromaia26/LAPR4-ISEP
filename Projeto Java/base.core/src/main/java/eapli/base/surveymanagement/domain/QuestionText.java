package eapli.base.surveymanagement.domain;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class QuestionText {

    private String questionText;

    public QuestionText(final String questionText){

        if (questionText.length() > 100)
            throw new IllegalArgumentException("Exceeded question maximum chars (100)!");

        this.questionText = questionText;

    }

    public QuestionText() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuestionText)) return false;
        QuestionText that = (QuestionText) o;
        return Objects.equals(questionText, that.questionText);
    }

    @Override
    public String toString(){

        return questionText;
    }
}
