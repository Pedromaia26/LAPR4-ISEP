package eapli.base.surveymanagement.domain;

import eapli.base.clientusermanagement.domain.BillingPostalAddresses;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.DeliveringPostalAddresses;
import eapli.base.ordermanagement.domain.*;
import eapli.base.orderstatusmanagement.domain.Status;

import java.util.Calendar;

public class Question {

    private Identifier id;

    private QuestionText questionText;

    private Message instruction;

    private VerifyQuestionType questionType;

    private VerifyObligatoriness obligatoriness;

    private Message extraInfo;

    public Question(Identifier identifier, QuestionText questionText, Message instruction, VerifyQuestionType questionType, VerifyObligatoriness obligatoriness, Message extraInfo){

        if (identifier == null || questionText == null || instruction == null || questionType == null || obligatoriness == null || extraInfo == null)
            throw new IllegalArgumentException();

        this.id = identifier;
        this.questionText = questionText;
        this.instruction = instruction;
        this.questionType = questionType;
        this.obligatoriness = obligatoriness;
        this.extraInfo = extraInfo;
    }

    public Question(Identifier identifier, QuestionText questionText, VerifyQuestionType questionType, VerifyObligatoriness obligatoriness, Message extraInfo){

        if (identifier == null || questionText == null || questionType == null || obligatoriness == null || extraInfo == null)
            throw new IllegalArgumentException();

        this.id = identifier;
        this.questionText = questionText;
        this.questionType = questionType;
        this.obligatoriness = obligatoriness;
        this.extraInfo = extraInfo;
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
}
