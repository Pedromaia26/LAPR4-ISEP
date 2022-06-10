package eapli.base.surveymanagement.application.eapli.base.surveymanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.surveymanagement.domain.Answer;
import eapli.base.surveymanagement.repositories.AnswerRepository;

import java.util.ArrayList;
import java.util.List;

public class AnsVisitor extends AnswerBaseVisitor<List<Answer>>{
    String aux;
    List<Answer> answers = new ArrayList<>();
    Answer answer = new Answer();

    @Override public List<Answer> visitProg(AnswerParser.ProgContext ctx) {
        System.out.println("Answered questions: ");
        for (int i = 0; i < ctx.answer().size(); i++){
            visit(ctx.otherId(i));
            System.out.print(aux + " ");
            visit(ctx.answer(i));
            Answer a = new Answer(answer.answers());
            answers.add(a);
            answer.resetAnswers();
        }
        System.out.println();

        return answers;
    }

    @Override public List<Answer> visitAnswers(AnswerParser.AnswersContext ctx) {
        visitType(ctx.type());
        return answers;
    }

    @Override public List<Answer> visitAlphanumeric(AnswerParser.AlphanumericContext ctx) {
        if (ctx.INT() != null){
            aux = ctx.INT().getText();
        }
        else{
            aux = ctx.WORD().getText();
        }
        return answers;
    }

    @Override public List<Answer> visitOtherId(AnswerParser.OtherIdContext ctx) {
        aux = ctx.INT().getText();
        return answers;
    }

    @Override public List<Answer> visitPhrase(AnswerParser.PhraseContext ctx) {
        aux = ctx.getText();
        return answers;
    }

    @Override public List<Answer> visitSignal(AnswerParser.SignalContext ctx) {
        aux = ctx.getText();
        return answers;
    }

    @Override public List<Answer> visitOption(AnswerParser.OptionContext ctx) {
        visit(ctx.alphanumeric());
        return answers;
    }

    @Override public List<Answer> visitText(AnswerParser.TextContext ctx) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < ctx.phrase().size(); i++){
            visit(ctx.phrase(i));
            builder.append(aux);
            visit(ctx.signal(i));
            builder.append(aux);
        }
        aux = builder.toString();
        return answers;
    }

    @Override public List<Answer> visitType(AnswerParser.TypeContext ctx) {
        if (ctx.FREE_TEXT() != null){
            visit(ctx.text());
            answer.addAnswers(aux);
        }
        else if (ctx.NUMERIC() != null){
            answer.addAnswers(ctx.INT().getText());
        }
        else{
            for (int i = 0; i < ctx.option().size(); i++){
                visit(ctx.option(i));
                answer.addAnswers(aux);
            }
            if (ctx.phrase() != null){
                visit(ctx.phrase());
                answer.addAnswers(aux);
            }
        }

        return answers;
    }

    @Override public List<Answer> visitEnd(AnswerParser.EndContext ctx) {
        aux = ctx.getText();
        return answers;
    }
}
