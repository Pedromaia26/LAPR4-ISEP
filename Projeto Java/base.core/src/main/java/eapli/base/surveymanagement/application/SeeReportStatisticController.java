package eapli.base.surveymanagement.application;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.surveymanagement.domain.*;
import eapli.base.surveymanagement.domain.dto.SurveyDTO;
import eapli.base.surveymanagement.repositories.AnswerRepository;
import eapli.base.surveymanagement.repositories.QuestionRepository;
import eapli.base.surveymanagement.repositories.SurveyRepository;
import eapli.framework.application.UseCaseController;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@UseCaseController
public class SeeReportStatisticController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ClientUserRepository clientUserRepository = PersistenceContext.repositories().clientUsers();
    private final AnswerRepository answerRepository = PersistenceContext.repositories().answers();
    private final TransactionalContext txCtx = PersistenceContext.repositories().newTransactionalContext();
    private final QuestionRepository questionRepository = PersistenceContext.repositories().questions(txCtx);
    private final SurveyRepository surveyRepository = PersistenceContext.repositories().surveys(txCtx);

    public Survey getSurveyById(String id){
        return surveyRepository.findSurveyById(id);
    }

    public Iterable<SurveyDTO> allSurveys(){
        List<SurveyDTO> list = new ArrayList<>();
        for (Survey survey : surveyRepository.findAll()){
            list.add(survey.toDTO());
        }
        return list;
    }

    public int getNumberClientsRequested(String id){
        Survey survey = getSurveyById(id);
        return survey.clientUsersToAnswer().size() + survey.clientUsersAnswered().size();
    }

    public int getNumberClientsRequestedQuestion(String id){
        double num = 0;
        for (Answer answer : answerRepository.findAll()){
            if (answer.question().identity().toString().equals(id)){
                for (String as : answer.answers()){
                    if (!as.isBlank()){
                        num++;
                    }
                }
            }
        }
        double x = num / getNumberAnswersQuestion(id);
        return (int)(x * 100);
    }

    public int getNumberClientsAnswered(String id){
        Survey survey = getSurveyById(id);
        return survey.clientUsersAnswered().size();
    }

    public int getPerNumberClientsAnswered(String id){
        Survey survey = getSurveyById(id);
        double x = survey.clientUsersAnswered().size() / (double)getNumberClientsRequested(id);

        return (int)(x * 100);
    }

    public List<String> getQuestions(String id){
        List<String> questionIds = new ArrayList<>();
        Survey survey = getSurveyById(id);
        for (SurveySection ss : survey.sections()){
            for (SectionQuestion sq : ss.section().questions()){
                questionIds.add(sq.question().identity().toString());
            }
        }
        return questionIds;
    }

    public String getQuestionType(String id){
        Question question = questionRepository.findQuestionById(id);
        return question.type();
    }

    public List<String> getQuestionOptions(String id){
        ChoiceQuestion question = (ChoiceQuestion) questionRepository.findQuestionById(id);
        return question.options();
    }

    public List<String> getQuestionQuestions(String id){
        ScalingOptionsQuestion question = (ScalingOptionsQuestion) questionRepository.findQuestionById(id);
        return question.questions();
    }

    public List<String> getQuestionSOOptions(String id){
        ScalingOptionsQuestion question = (ScalingOptionsQuestion) questionRepository.findQuestionById(id);
        return question.options();
    }

    public int getNumberAnswersQuestionSO(String questionId){
        int num = 0;
        for (Answer answer : answerRepository.findAll()){
            if (answer.question().identity().toString().equals(questionId)) num++;
        }
        return num;
    }

    public int getNumberAnswersQuestion(String questionId){
        int num = 0;
        for (Answer answer : answerRepository.findAll()){
            if (answer.question().identity().toString().equals(questionId)) {
                for (int i = 0; i < answer.answers().size(); i++) {
                    num++;
                }
            }
        }
        return num;
    }

    public int getNumberAnswerClientQuestion(String questionId){
        int num = 0;
        for (Answer answer : answerRepository.findAll()){
            if (answer.question().identity().toString().equals(questionId)) {
                num++;
            }
        }
        return num;
    }

    public int getPerChoiceOption(String questionId, String op){
        double num = 0;
        for (Answer answer : answerRepository.findAll()){
            if (answer.question().identity().toString().equals(questionId)){
                for (String as : answer.answers()){
                    if (!as.isBlank()){
                        if (op.charAt(0) == as.charAt(0)){
                            num++;
                        }
                    }
                }
            }
        }
        double x = num / getNumberAnswersQuestion(questionId);
        return (int)(x * 100);
    }

    public int getPerChoiceCombinationOption(String questionId, List<String> op){
        double num = 0;
        int aux;
        for (Answer answer : answerRepository.findAll()){
            if (answer.question().identity().toString().equals(questionId)){
                aux = 0;
                for (String as : answer.answers()){
                    if (!as.isBlank()){
                        for (String s : op){
                            if (s.charAt(0) == as.charAt(0)){
                                aux++;
                            }
                        }

                    }
                }
                if (aux == op.size()) num++;
            }
        }
        double x = num / getNumberAnswerClientQuestion(questionId);
        return (int)(x * 100);
    }

    public int getOtherOption(String questionId){
        double num = 0;
        for (Answer answer : answerRepository.findAll()){
            if (answer.question().identity().toString().equals(questionId)){
                for (String as : answer.answers()){
                    if (as.length() > 1){
                        num++;
                    }
                    else if (as.isBlank()){
                        num++;
                    }
                }
            }
        }
        double x = num / getNumberAnswersQuestion(questionId);
        return (int)(x * 100);
    }

    public int getPerPlacedOptions(int place, String questionId, String op){
        double num = 0;
        for (Answer answer : answerRepository.findAll()) {
            if (answer.question().identity().toString().equals(questionId)) {
                if (!answer.answers().get(place).isBlank()){
                    if (op.charAt(0) == answer.answers().get(place).charAt(0)){
                        num++;
                    }
                }
            }
        }
        double x = num / getNumberAnswersQuestionSO(questionId);
        return (int)(x * 100);
    }

    public int getNumberScaleOption(String questionId, String scale, int index){
        int num = 0;
        StringBuilder s = new StringBuilder();
        s.append(scale.charAt(0));
        for (Answer answer : answerRepository.findAll()) {
            if (answer.question().identity().toString().equals(questionId)) {
                if (answer.answers().get(index).equals(s.toString())){
                    num++;
                }
            }
        }
        return num;
    }



    public Map<String, Integer> combinations(List<String> arr, String[] data, int start, int end, int index, int r, Map<String, Integer> map, String questionId)
    {
        if (index == r)
        {
            List<String> ops = new ArrayList<>();
            StringBuilder s;
            int num;
            s = new StringBuilder();
            for (int j=0; j<r; j++) {
                s.append(data[j]);
                ops.add(data[j]);
                if (j < (r-1)){
                    s.append(" + ");
                }
            }
            num = getPerChoiceCombinationOption(questionId, ops);
            map.put(s.toString(), num);
            return map;
        }

        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr.get(i);
            combinations(arr, data, i+1, end, index+1, r, map, questionId);
        }
        return map;
    }

}
