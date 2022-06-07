package eapli.base.surveymanagement.domain.dto;

import eapli.base.surveymanagement.domain.*;
import eapli.framework.representations.dto.DTO;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@DTO
public class QuestionDTO {

    public String id;

    public String questionText;

    public String instruction;

    public String questionType;

    public String obligatoriness;

    public String extraInfo;

    public List<String> questions = new ArrayList<>();

    public List<String> options = new ArrayList<>();

    public String dependent;

    public String dependentChoice;

    public QuestionDTO(String identifier, String questionText, String instruction, String questionType, String obligatoriness, String extraInfo){
        this.id = identifier;
        this.questionText = questionText;
        this.instruction = instruction;
        this.questionType = questionType;
        this.obligatoriness = obligatoriness;
        this.extraInfo = extraInfo;
    }

    public QuestionDTO(String identifier, String questionText, String questionType, String obligatoriness, String extraInfo){
        this.id = identifier;
        this.questionText = questionText;
        this.questionType = questionType;
        this.obligatoriness = obligatoriness;
        this.extraInfo = extraInfo;
    }

    public QuestionDTO(String identifier, String questionText, String instruction, String questionType, String obligatoriness, String extraInfo, String dependent, String dependentChoice){
        this.id = identifier;
        this.questionText = questionText;
        this.instruction = instruction;
        this.questionType = questionType;
        this.obligatoriness = obligatoriness;
        this.extraInfo = extraInfo;
        this.dependent = dependent;
        this.dependentChoice = dependentChoice;
    }

    public QuestionDTO(String identifier, String questionText, String questionType, String obligatoriness, String extraInfo, String dependent, String dependentChoice){
        this.id = identifier;
        this.questionText = questionText;
        this.questionType = questionType;
        this.obligatoriness = obligatoriness;
        this.extraInfo = extraInfo;
        this.dependent = dependent;
        this.dependentChoice = dependentChoice;
    }
}
