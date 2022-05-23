package eapli.base.surveymanagement.domain;

import java.util.Objects;

public class QuestionText {

    private String questionText;

    public QuestionText(final String questionText){

        if (questionText.length() > 50)
            throw new IllegalArgumentException("Exceeded question maximum chars (50)!");

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
