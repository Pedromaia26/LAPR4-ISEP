package eapli.base.surveymanagement.application.eapli.base.surveymanagement.application;

import eapli.base.surveymanagement.domain.*;

import java.util.*;

public class SurvVisitor extends SurveyBaseVisitor<Survey> {
    /*** "memory" for our calculator; variable/value pairs go here */
    Survey survey = new Survey();
    SurvSection section = new SurvSection();
    Question question = new Question();
    ChoiceQuestion cquestion = new ChoiceQuestion();
    ScalingOptionsQuestion soquestion = new ScalingOptionsQuestion();
    String aux;
    int op;
    int tq = 0;
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
            section = new SurvSection();
            visit(ctx.section(i));
            SurvSection s;
            if (section.SectionDescription() != null && section.Repeatability() != null){
                s = new SurvSection(section.identifier(), section.Title(), section.SectionDescription(), section.Obligatoriness(), section.Repeatability(), section.questions());
                s.modifyDependent(section.dependent());
                s.modifyDependentChoice(section.dependentChoice());
            }
            else if (section.SectionDescription() == null && section.Repeatability() != null){
                List<SurveySection> list = new ArrayList<>();
                s = new SurvSection(section.identifier(), section.Title(), section.Obligatoriness(), section.Repeatability(), section.questions());
                s.modifyDependent(section.dependent());
                s.modifyDependentChoice(section.dependentChoice());
            }
            else if (section.SectionDescription() != null && section.Repeatability() == null){
                s = new SurvSection(section.identifier(), section.Title(), section.SectionDescription(), section.Obligatoriness(), section.questions());
                s.modifyDependent(section.dependent());
                s.modifyDependentChoice(section.dependentChoice());
            }
            else{
                s = new SurvSection(section.identifier(), section.Title(), section.Obligatoriness(), section.questions());
                s.modifyDependent(section.dependent());
                s.modifyDependentChoice(section.dependentChoice());
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
            if (ctx.OPTIONAL() != null || ctx.MANDATORY() != null) section.modifyVerifyObligatoriness(new VerifyObligatoriness(ctx.getText()));
            else {
                section.modifyVerifyObligatoriness(new VerifyObligatoriness(ctx.CONDITION_DEPENDENT().getText()));
                op = 3;
                visit(ctx.otherId());
                visit(ctx.alphanumeric());
                section.modifyDependentChoice(aux);
            }
        }
        else if (op == 1){
            if (tq == 0 && (ctx.OPTIONAL() != null || ctx.MANDATORY() != null)) question.modifyVerifyObligatoriness(new VerifyObligatoriness(ctx.getText()));
            else if (tq == 0) question.modifyVerifyObligatoriness(new VerifyObligatoriness(ctx.CONDITION_DEPENDENT().getText()));
            else if (tq == 1 && (ctx.OPTIONAL() != null || ctx.MANDATORY() != null)) soquestion.modifyVerifyObligatoriness(new VerifyObligatoriness(ctx.getText()));
            else if (tq == 1) soquestion.modifyVerifyObligatoriness(new VerifyObligatoriness(ctx.CONDITION_DEPENDENT().getText()));
            else if (tq == 2 && (ctx.OPTIONAL() != null || ctx.MANDATORY() != null)) cquestion.modifyVerifyObligatoriness(new VerifyObligatoriness(ctx.getText()));
            else cquestion.modifyVerifyObligatoriness(new VerifyObligatoriness(ctx.CONDITION_DEPENDENT().getText()));

            if (ctx.CONDITION_DEPENDENT() != null){
                op = 2;
                visit(ctx.otherId());
                visit(ctx.alphanumeric());
                if (tq == 0) question.modifyDependentChoice(aux);
                else if (tq == 1) soquestion.modifyDependentChoice(aux);
                else cquestion.modifyDependentChoice(aux);
            }
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
            if (tq == 0) question.modifyInstruction(new Message(wMessage.toString()));
            else if (tq == 1) soquestion.modifyInstruction(new Message(wMessage.toString()));
            else cquestion.modifyInstruction(new Message(wMessage.toString()));
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
            soquestion = new ScalingOptionsQuestion();
            cquestion = new ChoiceQuestion();
            visit(ctx.content(i));
            if (tq == 0){
                Question q;
                if (question.Instruction() == null){
                    q = new Question(question.identifier(), question.QuestionText(), question.QuestionType(), question.Obligatoriness(), question.ExtraInfo());
                    q.modifyDependent(question.dependent());
                    q.modifyDependentChoice(question.dependentChoice());
                }
                else {
                    q = new Question(question.identifier(), question.QuestionText(), question.Instruction(), question.QuestionType(), question.Obligatoriness(), question.ExtraInfo());
                    q.modifyDependent(question.dependent());
                    q.modifyDependentChoice(question.dependentChoice());
                }
                section.addQuestion(q);
            }
            else if (tq == 1){
                ScalingOptionsQuestion q;
                if (soquestion.Instruction() == null){
                    q = new ScalingOptionsQuestion(soquestion.identifier(), soquestion.QuestionText(), soquestion.QuestionType(), soquestion.Obligatoriness(), soquestion.ExtraInfo());
                    q.modifyDependent(question.dependent());
                    q.modifyDependentChoice(question.dependentChoice());
                }
                else {
                    q = new ScalingOptionsQuestion(soquestion.identifier(), soquestion.QuestionText(), soquestion.Instruction(), soquestion.QuestionType(), soquestion.Obligatoriness(), soquestion.ExtraInfo());
                    q.modifyDependent(question.dependent());
                    q.modifyDependentChoice(question.dependentChoice());
                }
                for (String quest : soquestion.questions()){
                    q.addQuestion(quest);
                }
                for (String op : soquestion.options()){
                    q.addOption(op);
                }
                section.addQuestion(q);
            }
            else{
                ChoiceQuestion q;
                if (cquestion.Instruction() == null){
                    q = new ChoiceQuestion(cquestion.identifier(), cquestion.QuestionText(), cquestion.QuestionType(), cquestion.Obligatoriness(), cquestion.ExtraInfo());
                    q.modifyDependent(question.dependent());
                    q.modifyDependentChoice(question.dependentChoice());
                }
                else {
                    q = new ChoiceQuestion(cquestion.identifier(), cquestion.QuestionText(), cquestion.Instruction(), cquestion.QuestionType(), cquestion.Obligatoriness(), cquestion.ExtraInfo());
                    q.modifyDependent(question.dependent());
                    q.modifyDependentChoice(question.dependentChoice());
                }
                for (String op : cquestion.options()){
                    q.addOption(op);
                }
                section.addQuestion(q);
            }
        }
        return null;
    }

    @Override
    public Survey visitOtherId(SurveyParser.OtherIdContext ctx) {
        if (op == 0){
            section.modifyId(new Identifier(ctx.getText()));
        }
        else if (op == 1){
            if (tq == 0) question.modifyId(new Identifier(ctx.getText()));
            else if (tq == 1) soquestion.modifyId(new Identifier(ctx.getText()));
            else cquestion.modifyId(new Identifier(ctx.getText()));
        }
        else{
            for (SurveySection survey : survey.sections()){
                SurvSection s = survey.section();
                for (SectionQuestion q : s.questions()){
                    if (ctx.getText().equals(q.question().identity().toString())){
                        if (op == 2){
                            if (tq == 0) question.modifyDependent(q.question());
                            else if (tq == 1) soquestion.modifyDependent(q.question());
                            else cquestion.modifyDependent(q.question());
                        }
                        else if (op == 3){
                            section.modifyDependent(q.question());
                        }
                    }
                }
            }
            for (SectionQuestion q : section.questions()){
                if (ctx.getText().equals(q.question().identity().toString())){
                    if (op == 2) {
                        if (tq == 0) question.modifyDependent(q.question());
                        else if (tq == 1) soquestion.modifyDependent(q.question());
                        else cquestion.modifyDependent(q.question());
                    }
                    else if (op == 3){
                        section.modifyDependent(q.question());
                    }
                }
            }
        }
        return survey; // return child expr's value
    }


    @Override
    public Survey visitContent(SurveyParser.ContentContext ctx) {
        visit(ctx.type());
        op = 1;
        visit(ctx.otherId());
        visit(ctx.question());
        op = 3;
        try{
            visit(ctx.wMessage());
        } catch (NullPointerException e){
            System.out.println("Question " + question.identifier() + " with no instruction.");
        }
        op = 1;
        visit(ctx.obli());
        return survey; // return child expr's value
    }

    @Override
    public Survey visitQuestion(SurveyParser.QuestionContext ctx) {
        StringBuilder quest = new StringBuilder();
        visit(ctx.phrase());
        quest.append(aux);
        quest.append(ctx.INTE());
        if (tq == 0) question.modifyQuestionText(new QuestionText(quest.toString()));
        else if (tq == 1) soquestion.modifyQuestionText(new QuestionText(quest.toString()));
        else cquestion.modifyQuestionText(new QuestionText(quest.toString()));
        return survey;
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
    public Survey visitOption(SurveyParser.OptionContext ctx) {
        StringBuilder option = new StringBuilder();
        visit(ctx.alphanumeric());
        option.append(aux);
        try{
            option.append(ctx.RIGHT_PARENTHESES().getText());
        } catch (NullPointerException e){
            System.out.println("Option " + aux + " with invalid format.");
        }
        if (ctx.SPACE() != null) {
            option.append(ctx.SPACE().getText());
        }
        visit(ctx.phrase());
        option.append(aux);
        aux = option.toString();
        return survey;
    }

    @Override
    public Survey visitType(SurveyParser.TypeContext ctx) {
        System.out.println(ctx.getChild(0).getText());
        if (ctx.getChild(0).getText().equals("Free-text") || ctx.getChild(0).getText().equals("Numeric")){
            tq = 0;
            question.modifyVerifyQuestionType(new VerifyQuestionType(ctx.getChild(0).getText()));
            question.modifyExtraInfo(new Message(ctx.getChild(ctx.children.size()-1).getText()));
        }
        else if (ctx.getChild(0).getText().equals("Scaling Options")){
            tq = 1;
            soquestion.modifyVerifyQuestionType(new VerifyQuestionType(ctx.getChild(0).getText()));
            soquestion.modifyExtraInfo(new Message(ctx.getChild(ctx.children.size()-1).getText()));
        }
        else{
            tq = 2;
            cquestion.modifyVerifyQuestionType(new VerifyQuestionType(ctx.getChild(0).getText()));
            cquestion.modifyExtraInfo(new Message(ctx.getChild(ctx.children.size()-1).getText()));
        }

        for (int i = 0; i < ctx.phrase().size(); i++){
            visit(ctx.phrase(i));
            aux += ctx.INTE(i).getText();
            soquestion.addQuestion(aux);
        }
        for (int i = 0; i < ctx.option().size(); i++){
            visit(ctx.option(i));
            if (tq == 1) soquestion.addOption(aux);
            else if (tq == 2) cquestion.addOption(aux);
        }
        return null;
    }

    @Override
    public Survey visitEnd(SurveyParser.EndContext ctx) {
        return survey; // return child expr's value
    }
}