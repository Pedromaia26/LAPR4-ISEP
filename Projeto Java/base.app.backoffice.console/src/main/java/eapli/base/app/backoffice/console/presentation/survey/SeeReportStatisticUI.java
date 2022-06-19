package eapli.base.app.backoffice.console.presentation.survey;

import eapli.base.surveymanagement.application.SeeReportStatisticController;
import eapli.base.surveymanagement.application.eapli.base.surveymanagement.application.CreateSurveyController;
import eapli.base.surveymanagement.domain.dto.SurveyDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;
import java.util.*;

public class SeeReportStatisticUI  extends AbstractUI {

    private final SeeReportStatisticController theController = new SeeReportStatisticController();
    private boolean invalidData;
    private String surveyId;

    @Override
    protected boolean doShow() {

        ViewSurveysUI viewSurveysUI = new ViewSurveysUI();
        viewSurveysUI.show();


        List<SurveyDTO> list = (List<SurveyDTO>) theController.allSurveys();
        if (list.size() > 0){
            do {
                invalidData = false;
                try {
                    surveyId = Console.readLine("Select the questionnaire (enter the Id)");
                    theController.getNumberClientsRequested(surveyId);
                }catch (Exception e){
                    System.out.println("Invalid id, please try again!");
                    invalidData = true;
                }
            }while (invalidData);

            System.out.println("-------------");
            System.out.println("Survey: " + surveyId);
            int num = theController.getNumberClientsRequested(surveyId);
            System.out.println("Number of clients requested to answer: " + num);
            num = theController.getNumberClientsAnswered(surveyId);
            System.out.println("Number of responses obtained: " + num);
            num = theController.getPerNumberClientsAnswered(surveyId);
            System.out.println("Percentage of responses obtained: " + num + "%");
            System.out.println("-------------");
            for (String question : theController.getQuestions(surveyId)){
                String type = theController.getQuestionType(question);
                System.out.println("Question " + question);
                System.out.println("Type: " + type);
                if (type.contains("Multiple-Choice") || type.contains("Single-Choice")){
                    List<String> ops = new ArrayList<>();
                    StringBuilder s;
                    for (String op : theController.getQuestionOptions(question)){
                        s = new StringBuilder();
                        num = theController.getPerChoiceOption(question, op);
                        System.out.println("Option " + op.charAt(0) + ": " + num + "%");
                        s.append(op.charAt(0));
                        ops.add(s.toString());
                    }
                    num = theController.getOtherOption(question);
                    System.out.println("Others: " + num + "%");
                    if (type.contains("Multiple-Choice")){
                        for (int i = 1; i < ops.size(); i++){
                            String[] data = new String[i+1];
                            Map<String, Integer> map = new HashMap<>();
                            map = theController.combinations(ops, data, 0, ops.size()-1, 0, i+1, map, question);
                            for (String combination : map.keySet()){
                                System.out.println("Option " + combination + ": " + map.get(combination) + "%");
                            }
                        }
                    }
                }
                else if (type.equals("Sorting Options")){
                    for (int lugar = 0; lugar < theController.getQuestionOptions(question).size(); lugar++){
                        num = lugar + 1;
                        System.out.println("--- Place " + num + " ---");
                        for (String op : theController.getQuestionOptions(question)){
                            num = theController.getPerPlacedOptions(lugar, question, op);
                            System.out.println("Option " + op.charAt(0) + ": " + num + "%");
                        }
                    }
                }
                else if (type.equals("Scaling Options")){
                    int index = 0;
                    for (String op : theController.getQuestionQuestions(question)){
                        System.out.println("--- " + op + " ---");
                        for (String scale : theController.getQuestionSOOptions(question)){
                            num = theController.getNumberScaleOption(question, scale, index);
                            System.out.println("Scale " + scale.charAt(0) + ": " + num);
                        }
                        index++;
                    }
                }
                else if (type.equals("Free-text") || type.equals("Numeric")){
                    num = theController.getNumberClientsRequestedQuestion(question);
                    System.out.println("Number of clients requested to answer: " + num + "%");
                }
                System.out.println("-------------");
            }
        }
        return false;
    }

    @Override
    public String headline() {
        return "Survey statistic";
    }
}
