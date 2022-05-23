package eapli.base.surveymanagement.application.eapli.base.surveymanagement.application;

import eapli.base.surveymanagement.domain.*;
import org.apache.commons.lang3.ObjectUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SurvVisitor extends SurveyBaseVisitor<Survey> {
    /*** "memory" for our calculator; variable/value pairs go here */
    Survey survey = new Survey();
    Section section = new Section();
    Question question = new Question();
    String aux;
    int op;
    /**
     * ID '=' expr NEWLINE
     */
    @Override
    public Survey visitProg(SurveyParser.ProgContext ctx) {
        return visit(ctx.survey());
    }
    /*** expr NEWLINE */
    @Override
    public Survey visitSurveys(SurveyParser.SurveysContext ctx) {
        visit(ctx.id());
        op = 0;
        visit(ctx.title());
        if (ctx.wMessage().size() == 2){
            op = 0;
            visit(ctx.wMessage(0));
            op = 1;
            visit(ctx.wMessage(1));
        }
        else{
            System.out.println("Survey " + survey.SurveyIdentifier() + " with no welcome message.");
            op = 1;
            visit(ctx.wMessage(0));
        }
        for (int i = 0; i < ctx.section().size(); i++){
            section = new Section();
            visit(ctx.section(i));
            Section s;
            if (section.SectionDescription() != null && section.Repeatability() != null){
                s = new Section(section.identifier(), section.Title(), section.SectionDescription(), section.Obligatoriness(), section.Repeatability(), section.questions());
            }
            else if (section.SectionDescription() == null && section.Repeatability() != null){
                s = new Section(section.identifier(), section.Title(), section.Obligatoriness(), section.Repeatability(), section.questions());
            }
            else if (section.SectionDescription() != null && section.Repeatability() == null){
                s = new Section(section.identifier(), section.Title(), section.SectionDescription(), section.Obligatoriness(), section.questions());
            }
            else{
                s = new Section(section.identifier(), section.Title(), section.Obligatoriness(), section.questions());
            }
            survey.addSection(s);
        }
        return survey;
    }
    /*** INT */
    @Override
    public Survey visitId(SurveyParser.IdContext ctx) {
        StringBuilder id = new StringBuilder();
        int num = ctx.alphanumeric().size();
        if (ctx.HIFFEN() != null) num++;
        for (int i = 0; i < num; i++){
            if (ctx.HIFFEN() != null) {
                if (ctx.getChild(i).equals(ctx.HIFFEN())) {
                    id.append(ctx.HIFFEN().getText());
                }
                else{
                    visit(ctx.getChild(i));
                    id.append(aux);
                }
            }
            else{
                visit(ctx.getChild(i));
                id.append(aux);
            }
        }
        survey.modifyId(new SurveyIdentifier(id.toString()));
        return survey;
    }
    /**
     * ID
     */
    @Override
    public Survey visitAlphanumeric(SurveyParser.AlphanumericContext ctx) {
        aux = ctx.getText();
        return survey;
    }
    /*** expr op=('*'|'/') expr */
    @Override
    public Survey visitTitle(SurveyParser.TitleContext ctx) {
        if (op == 0){
            survey.modifyTitle(new Title(ctx.getText()));
        }
        else if (op == 1){
            section.modifyTitle(new Title(ctx.getText()));
        }
        return survey;
    }
    /*** expr op=('+'|'-') expr */
    @Override
    public Survey visitObli(SurveyParser.ObliContext ctx) {
        if (op == 0){
            section.modifyVerifyObligatoriness(new VerifyObligatoriness(ctx.getText()));
        }
        else if (op == 1){
            question.modifyVerifyObligatoriness(new VerifyObligatoriness(ctx.getText()));
        }
        return survey;
    }
    /**
     * '(' expr ')'
     */
    @Override
    public Survey visitWMessage(SurveyParser.WMessageContext ctx) {
        StringBuilder wMessage = new StringBuilder();
        for (int i = 0; i < ctx.phrase().size(); i++){
            visit(ctx.phrase(i));
            wMessage.append(aux);
            visit(ctx.signal(i));
            wMessage.append(aux);
        }
        if (op == 0){
            survey.modifyWelcomeMessage(new Message(wMessage.toString()));
        }
        else if (op == 1){
            survey.modifyFinalMessage(new Message(wMessage.toString()));
        }
        else if (op == 2){
            section.modifySectionDescription(new SectionDescription(wMessage.toString()));
        }
        else if (op == 3){
            question.modifyInstruction(new Message(wMessage.toString()));
        }
        return survey; // return child expr's value
    }

    @Override
    public Survey visitSection(SurveyParser.SectionContext ctx) {
        op = 0;
        visit(ctx.otherId());
        op = 1;
        visit(ctx.title());
        op = 2;
        try{
            visit(ctx.wMessage());
        } catch (NullPointerException e){
            System.out.println("Section " + section.identifier() + " with no section description.");
        }
        op = 0;
        visit(ctx.obli());
        try{
            visitRep(ctx.rep());
        } catch (NullPointerException e){
            System.out.println("Section " + section.identifier() + " with no repeatability.");
        }
        for (int i = 0; i < ctx.content().size(); i++){
            question = new Question();
            visit(ctx.content(i));
            Question q;
            if (question.Instruction() == null){
                q = new Question(question.identifier(), question.QuestionText(), question.QuestionType(), question.Obligatoriness(), question.ExtraInfo());
            }
            else {
                q = new Question(question.identifier(), question.QuestionText(), question.Instruction(), question.QuestionType(), question.Obligatoriness(), question.ExtraInfo());
            }
            section.addQuestion(q);
        }
        return null;
    }

    @Override
    public Survey visitOtherId(SurveyParser.OtherIdContext ctx) {
        if (op == 0){
            section.modifyId(new Identifier(ctx.getText()));
        }
        else if (op == 1){
            question.modifyId(new Identifier(ctx.getText()));
        }
        return survey; // return child expr's value
    }


    @Override
    public Survey visitContent(SurveyParser.ContentContext ctx) {
        op = 1;
        visit(ctx.otherId());
        visit(ctx.question());
        op = 3;
        try{
            visit(ctx.wMessage());
        } catch (NullPointerException e){
            System.out.println("Question " + question.identifier() + " with no instruction.");
        }

        visit(ctx.type());
        return survey; // return child expr's value
    }

    @Override
    public Survey visitQuestion(SurveyParser.QuestionContext ctx) {
        StringBuilder quest = new StringBuilder();
        visit(ctx.phrase());
        quest.append(aux);
        quest.append(ctx.INTE());
        question.modifyQuestionText(new QuestionText(quest.toString()));
        return survey; // return child expr's value
    }

    @Override
    public Survey visitRep(SurveyParser.RepContext ctx){
        section.modifyRepeatability(new Repeatability(ctx.getText()));
        return survey;
    }

    @Override
    public Survey visitPhrase(SurveyParser.PhraseContext ctx) {
        aux = ctx.getText();
        return survey; // return child expr's value
    }

    @Override
    public Survey visitSignal(SurveyParser.SignalContext ctx) {
        aux = ctx.getText();
        return survey; // return child expr's value
    }

    @Override
    public Survey visitType(SurveyParser.TypeContext ctx) {
        question.modifyVerifyQuestionType(new VerifyQuestionType(ctx.getChild(0).getText()));
        op = 1;
        visit(ctx.obli());
        question.modifyExtraInfo(new Message(ctx.getChild(4).getText()));
        return null;
    }

    @Override
    public Survey visitEnd(SurveyParser.EndContext ctx) {
        return survey; // return child expr's value
    }
}