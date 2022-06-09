package eapli.base.app.user.console.presentation.survey;

import eapli.base.surveymanagement.application.AddNewAnswerController;
import eapli.base.surveymanagement.application.VerifyClientSurveysController;
import eapli.base.surveymanagement.domain.Answer;
import eapli.base.surveymanagement.domain.Question;
import eapli.base.surveymanagement.domain.dto.QuestionDTO;
import eapli.base.surveymanagement.domain.dto.SurvSectionDTO;
import eapli.base.surveymanagement.domain.dto.SurveyDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.List;

public class ShowSurveyUI  extends AbstractUI {
    VerifyClientSurveysController theController = new VerifyClientSurveysController();
    AddNewAnswerController theAController = new AddNewAnswerController();

    @Override
    protected boolean doShow() {
        boolean invalidAnswer;
        boolean validDependecy;
        List<String> answers;
        String surveyId = Console.readLine("Select the questionnaire (enter the Id)");
        SurveyDTO survey = theController.getSurveyById(surveyId);
        System.out.println(survey.title);
        if (survey.welcomeMessage != null) System.out.println(survey.welcomeMessage);
        List<SurvSectionDTO> sections = theController.getSurveySections(surveyId);
        System.out.println("-----------");
        for (SurvSectionDTO section : sections){
            validDependecy = true;
            if (section.dependent != null && section.dependentChoice != null){
                validDependecy = theAController.isDependencyValid(section.dependent, section.dependentChoice);
            }
            if (validDependecy) {
                System.out.println(section.title);
                System.out.println(section.sectionDescription);
                List<QuestionDTO> questions = theController.getSectionQuestions(section.id);
                System.out.println("-----------");
                for (QuestionDTO question : questions) {
                    validDependecy = true;
                    answers = new ArrayList<>();
                    if (question.dependent != null && question.dependentChoice != null) {
                        validDependecy = theAController.isDependencyValid(question.dependent, question.dependentChoice);
                    }
                    if (validDependecy) {
                        if (question.obligatoriness.equals("optional") && section.obligatoriness.equals("optional")) {
                            System.out.println(question.questionText + " " + "(optional)");
                        } else {
                            System.out.println(question.questionText);
                        }
                        if (question.instruction != null) System.out.println(question.instruction);
                        if (question.options != null) {
                            for (String op : question.options) {
                                System.out.println(op);
                            }
                        }
                        if (question.questions.size() > 0) {
                            for (String q : question.questions) {
                                System.out.println(q);
                                String a;
                                do {
                                    a = Console.readLine("Choose one of the options (identifier): ");
                                    invalidAnswer = verifyAnswer(a, question.options, question.obligatoriness, section.obligatoriness);
                                    if (!invalidAnswer)
                                        System.out.println("The answer is not valid! Please try again!");
                                } while (!invalidAnswer);
                                answers.add(a);
                            }
                        } else {
                            String type = theController.getQuestionById(question.id).type();
                            answers = readAnswer(question, type, question.obligatoriness, section.obligatoriness);
                        }
                        System.out.println("-----------");
                        theAController.addAnswer(answers, question);
                    }
                }
            }
        }
        System.out.println(survey.finalMessage);
        theController.answeredSurvey(survey.id);
        return false;
    }

    private List<String> readAnswer(QuestionDTO question, String type, String qobli, String sobli){
        List<String> as = new ArrayList<>();
        boolean invalidAnswer;
        if (type.equals("Free-text")){
            String a = Console.readLine("Answer: ");
            as.add(a);
        }
        else if (type.equals("Numeric")){
            String a;
            do{
                a = Console.readLine("Answer (numeric): ");
                try{
                    Integer.parseInt(a);
                    invalidAnswer = false;
                } catch (Exception e){
                    System.out.println("The answer is not valid! Please try again!");
                    invalidAnswer = true;
                }
            } while(invalidAnswer);
            as.add(a);
        }
        else if (type.equals("Multiple-Choice")){
            String op, a;
            do{
                do{
                    a = Console.readLine("Choose one of the options (identifier): ");
                    invalidAnswer = verifyAnswer(a, question.options, qobli, sobli);
                    if (!invalidAnswer) System.out.println("The answer is not valid! Please try again!");
                } while (!invalidAnswer);
                as.add(a);
                op = "N";
                if (a.length() > 0)
                    op = Console.readLine("Do you want to add more options? (Y/N)");
            } while (op.equals("Y"));
        }
        else if (type.equals("Single-Choice")){
            String a;
            do{
                a = Console.readLine("Choose one of the options (identifier): ");
                invalidAnswer = verifyAnswer(a, question.options, qobli, sobli);
                if (!invalidAnswer) System.out.println("The answer is not valid! Please try again!");
            } while (!invalidAnswer);
            as.add(a);
        }
        else if (type.equals("Single-Choice with input value")){
            String a;
            do{
                a = Console.readLine("Choose one of the options (identifier) or write one: ");
                invalidAnswer = verifyAnswer(a, question.options, qobli, sobli);
                if (!invalidAnswer && a.length() > 1) invalidAnswer = true;

                if (!invalidAnswer) System.out.println("The answer is not valid! Please try again!");
            } while (!invalidAnswer);
            as.add(a);
        }
        else if (type.equals("Multiple-Choice with input value")){
            String a, op;
            boolean input = false;
            do{
                do{
                    a = Console.readLine("Choose one of the options (identifier) or write one: ");
                    invalidAnswer = verifyAnswer(a, question.options, qobli, sobli);
                    if (!invalidAnswer && a.length() > 1){
                        invalidAnswer = true;
                        input = true;
                    }

                    if (!invalidAnswer) System.out.println("The answer is not valid! Please try again!");
                } while (!invalidAnswer);
                as.add(a);
                op = "N";
                if (a.length() > 0){
                    if (!input) op = Console.readLine("Do you want to add more options? (Y/N)");
                }
            } while (op.equals("Y") && !input);
        }
        else if (type.equals("Sorting Options")){
            String a;
            int num;
            for (int i = 0; i < question.options.size(); i++){
                do{
                    num = i + 1;
                    a = Console.readLine("Choose one of the options for position " + num + ": ");
                    invalidAnswer = verifyAnswer(a, question.options, qobli, sobli);
                    if (!invalidAnswer) System.out.println("The answer is not valid! Please try again!");
                } while (!invalidAnswer);
                as.add(a);
            }
        }
        return as;
    }

    private boolean verifyAnswer(String answer, List<String> options, String qobli, String sobli){
        if (answer.length() == 0 && qobli.equals("optional") && sobli.equals("optional")) return true;
        else if (answer.length() == 0 && qobli.equals("optional")) return true;
        else if (answer.length() == 0) return false;
        for (String op : options){
            if (answer.charAt(0) == op.charAt(0)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String headline() {
        return "Answering the questionnaire";
    }
}
