package eapli.base.surveymanagement.domain;

import eapli.base.clientusermanagement.domain.BillingPostalAddresses;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.DeliveringPostalAddresses;
import eapli.base.ordermanagement.domain.*;
import eapli.base.orderstatusmanagement.domain.Status;
import eapli.base.surveymanagement.domain.dto.QuestionDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "questionType")
public class Question implements AggregateRoot<Identifier> {

    @EmbeddedId
    private Identifier id;

    @Embedded
    private QuestionText questionText;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "message",
                    column = @Column(name = "instruction")),
    })
    private Message instruction;

    @Embedded
    private VerifyQuestionType questionType;

    @Embedded
    private VerifyObligatoriness obligatoriness;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "message",
                    column = @Column(name = "extraInfo")),
    })
    private Message extraInfo;

    private String type;

    @ManyToOne
    private Question dependent;

    private String dependentChoice;

    public Question(Identifier identifier, QuestionText questionText, Message instruction, VerifyQuestionType questionType, VerifyObligatoriness obligatoriness, Message extraInfo){

        if (identifier == null || questionText == null || instruction == null || questionType == null || obligatoriness == null || extraInfo == null)
            throw new IllegalArgumentException();

        this.id = identifier;
        this.questionText = questionText;
        this.instruction = instruction;
        this.questionType = questionType;
        this.obligatoriness = obligatoriness;
        this.extraInfo = extraInfo;
        type = questionType.toString();
    }

    public Question(Identifier identifier, QuestionText questionText, VerifyQuestionType questionType, VerifyObligatoriness obligatoriness, Message extraInfo){

        if (identifier == null || questionText == null || questionType == null || obligatoriness == null || extraInfo == null)
            throw new IllegalArgumentException();

        this.id = identifier;
        this.questionText = questionText;
        this.questionType = questionType;
        this.obligatoriness = obligatoriness;
        this.extraInfo = extraInfo;
        type = questionType.toString();
    }

    public Question(){}

    public Identifier identifier() {
        return id;
    }

    public void modifyId(Identifier identifier) {
        this.id = identifier;
    }

    public QuestionText QuestionText() {
        return questionText;
    }

    public void modifyQuestionText(QuestionText questionText) {
        this.questionText = questionText;
    }

    public VerifyObligatoriness Obligatoriness(){
        return obligatoriness;
    }

    public void modifyVerifyObligatoriness(VerifyObligatoriness obligatoriness) {
        this.obligatoriness = obligatoriness;
    }

    public Message Instruction() {
        return instruction;
    }

    public void modifyInstruction(Message instruction) {
        this.instruction = instruction;
    }

    public VerifyQuestionType QuestionType(){
        return questionType;
    }

    public void modifyVerifyQuestionType(VerifyQuestionType questionType) {
        this.questionType = questionType;
    }

    public Message ExtraInfo() {
        return extraInfo;
    }

    public void modifyExtraInfo(Message extraInfo) {
        this.extraInfo = extraInfo;
    }

    @Override
    public String toString() {
        return "--- Question ---" +
                "\nId: " + id +
                "\nQuestion Text: " + questionText +
                "\nInstruction: " + instruction +
                "\nQuestion Type: " + questionType +
                "\nObligatoriness: " + obligatoriness +
                "\nExtra Info: " + extraInfo + "\n";
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public Identifier identity() {
        return id;
    }

    public String type() {
        return type;
    }

    public void modifyType(String type) {
        this.type = type;
    }

    public QuestionDTO toDTO(){
        if (instruction == null && dependent == null) return new QuestionDTO(id.toString(), questionText.toString(), questionType.toString(), obligatoriness.toString(), extraInfo.toString());
        if (instruction != null && dependent == null) return new QuestionDTO(id.toString(), questionText.toString(), instruction.toString(), questionType.toString(), obligatoriness.toString(), extraInfo.toString());
        if (instruction == null) return new QuestionDTO(id.toString(), questionText.toString(), questionType.toString(), obligatoriness.toString(), extraInfo.toString(), dependent.identity().toString(), dependentChoice);
        else return new QuestionDTO(id.toString(), questionText.toString(), instruction.toString(), questionType.toString(), obligatoriness.toString(), extraInfo.toString(), dependent.identity().toString(), dependentChoice);
    }

    public Question dependent() {
        return dependent;
    }

    public void modifyDependent(Question dependent) {
        this.dependent = dependent;
    }

    public String dependentChoice() {
        return dependentChoice;
    }

    public void modifyDependentChoice(String dependentChoice) {
        this.dependentChoice = dependentChoice;
    }
}
