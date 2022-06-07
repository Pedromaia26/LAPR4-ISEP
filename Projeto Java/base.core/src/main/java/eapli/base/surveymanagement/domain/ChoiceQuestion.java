package eapli.base.surveymanagement.domain;

import eapli.base.surveymanagement.domain.dto.QuestionDTO;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.*;

@Entity
@DiscriminatorValue("Choice")
public class ChoiceQuestion extends Question{

    @ElementCollection
    List<String> options = new ArrayList<>();

    public ChoiceQuestion(Identifier identifier, QuestionText questionText, Message instruction, VerifyQuestionType questionType, VerifyObligatoriness obligatoriness, Message extraInfo){
        super(identifier, questionText, instruction, questionType, obligatoriness, extraInfo);
    }

    public ChoiceQuestion(Identifier identifier, QuestionText questionText, VerifyQuestionType questionType, VerifyObligatoriness obligatoriness, Message extraInfo){
        super(identifier, questionText, questionType, obligatoriness, extraInfo);
    }

    public ChoiceQuestion(){}

    public boolean addOption(final String option) {
        return options.add(option);
    }

    public List<String> options() {
        return options;
    }

    @Override
    public String toString() {
        return super.toString() + "ChoiceQuestion{" +
                "options=" + options +
                '}';
    }

    public QuestionDTO toDTO(){
        QuestionDTO q =  super.toDTO();
        q.options.addAll(options);
        return q;
    }
}
