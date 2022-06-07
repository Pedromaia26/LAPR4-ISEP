package eapli.base.surveymanagement.domain;

import eapli.base.surveymanagement.domain.dto.QuestionDTO;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.*;

@Entity
@DiscriminatorValue("Scaling")
public class ScalingOptionsQuestion extends Question{

    @ElementCollection
    List<String> questions = new ArrayList<>();

    @ElementCollection
    List<String> options = new ArrayList<>();

    public ScalingOptionsQuestion(Identifier identifier, QuestionText questionText, Message instruction, VerifyQuestionType questionType, VerifyObligatoriness obligatoriness, Message extraInfo){
        super(identifier, questionText, instruction, questionType, obligatoriness, extraInfo);
    }

    public ScalingOptionsQuestion(Identifier identifier, QuestionText questionText, VerifyQuestionType questionType, VerifyObligatoriness obligatoriness, Message extraInfo){
        super(identifier, questionText, questionType, obligatoriness, extraInfo);
    }

    public ScalingOptionsQuestion(){}

    public boolean addOption(final String option) {
        return options.add(option);
    }

    public List<String> options() {
        return options;
    }

    public boolean addQuestion(final String question) {
        return questions.add(question);
    }

    public List<String> questions() {
        return questions;
    }

    @Override
    public String toString() {
        return super.toString() + "ScalingOptionsQuestion{" +
                "questions=" + questions +
                ", options=" + options +
                '}';
    }

    public QuestionDTO toDTO(){
        QuestionDTO q = super.toDTO();
        q.options.addAll(options);
        q.questions.addAll(questions);
        return q;
    }
}
