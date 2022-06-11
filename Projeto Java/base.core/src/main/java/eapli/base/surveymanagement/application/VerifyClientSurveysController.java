package eapli.base.surveymanagement.application;

import eapli.base.Warehouse.domain.Section;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.VAT;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.domain.ExtendedDescription;
import eapli.base.surveymanagement.domain.*;
import eapli.base.surveymanagement.domain.dto.QuestionDTO;
import eapli.base.surveymanagement.domain.dto.SurvSectionDTO;
import eapli.base.surveymanagement.domain.dto.SurveyDTO;
import eapli.base.surveymanagement.repositories.ContextRepository;
import eapli.base.surveymanagement.repositories.QuestionRepository;
import eapli.base.surveymanagement.repositories.SectionRepository;
import eapli.base.surveymanagement.repositories.SurveyRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class VerifyClientSurveysController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ClientUserRepository clientUserRepository = PersistenceContext.repositories().clientUsers();
    private final TransactionalContext txCtx = PersistenceContext.repositories().newTransactionalContext();
    private final SurveyRepository surveyRepository = PersistenceContext.repositories().surveys(txCtx);
    private final SectionRepository sectionRepository = PersistenceContext.repositories().sections(txCtx);
    private final QuestionRepository questionRepository = PersistenceContext.repositories().questions(txCtx);

    public int verifyClientSurveys() {
        int numSurveys = 0;
        boolean answered, dis = false;
        ClientUser user = getUser();
        if(user.birthday() != null){
            for (Survey survey : surveyRepository.findAll()){
                answered = false;
                for (ClientUserSurvey c : survey.clientUsersAnswered()){
                    if (c.clientUser().equals(getUser())) answered = true;
                }
                dis = false;
                for (int i = 0; i < survey.contexts().size(); i++){
                    if (survey.contexts().get(i).context().identity() == 2 && !answered){
                        int clientAge = calculateAge(user.birthday().birthDate());
                        if (clientAge >= survey.minAge().age() && clientAge <= survey.maxAge().age() && !dis){
                            if (verifyUserSurveyAgePeriod(user, survey)){
                                survey.addClientUserToAnswer(user);
                            }
                            numSurveys++;
                            dis = true;
                        }
                        txCtx.beginTransaction();
                        surveyRepository.save(survey);
                        txCtx.commit();
                    }
                    else if (survey.contexts().get(i).context().identity() != 2){
                        for (ClientUserSurvey c : survey.clientUsersToAnswer()) {
                            if (c.clientUser().equals(user) && !dis){
                                numSurveys++;
                                dis = true;
                            }
                        }
                    }
                }
            }
        }
        else{
            for (Survey survey : surveyRepository.findAll()){
                dis = false;
                for (int i = 0; i < survey.contexts().size(); i++){
                    if (survey.contexts().get(i).context().identity() != 2) {
                        for (ClientUserSurvey c : survey.clientUsersToAnswer()) {
                            if (c.clientUser().equals(user) && !dis) {
                                numSurveys++;
                                dis = true;
                            }
                        }
                    }
                }
            }
        }
        return numSurveys;
    }

    private VAT getUserSessionVat(){
        return getUser().identity();
    }

    private ClientUser getUser(){
        Username username = authz.session().get().authenticatedUser().username();
        Optional<ClientUser> client = clientUserRepository.findByUsername(username);
        return client.get();
    }

    private int calculateAge(LocalDate birthday) {
        LocalDate curDate = LocalDate.now();
        return Period.between(birthday, curDate).getYears();
    }

    private boolean verifyUserSurveyAgePeriod(ClientUser user, Survey survey) {
        for (ClientUserSurvey c : survey.clientUsersToAnswer()) {
            if (c.clientUser().equals(user)) return false;
        }
        for (ClientUserSurvey c : survey.clientUsersAnswered()) {
            if (c.clientUser().equals(user)) return false;
        }
        return true;
    }

    public Iterable<SurveyDTO> allClientSurveys(){
        List<SurveyDTO> list = new ArrayList<>();
        ClientUser user = getUser();
        for (Survey survey : surveyRepository.findAll()){
            for (ClientUserSurvey c : survey.clientUsersToAnswer()) {
                if (c.clientUser().equals(user)) list.add(survey.toDTO());
            }
        }
        return list;
    }

    public SurveyDTO getSurveyById(String id){
        Survey survey = surveyRepository.findSurveyById(id);
        return survey.toDTO();
    }

    public List<SurvSectionDTO> getSurveySections(String id){
        Survey survey = surveyRepository.findSurveyById(id);
        List<SurvSectionDTO> list = new ArrayList<>();
        for (SurveySection ss : survey.sections()){
            list.add(ss.section().toDTO());
        }
        return list;
    }

    public List<QuestionDTO> getSectionQuestions(String id){
        SurvSection section = sectionRepository.findSectionById(id);
        List<QuestionDTO> list = new ArrayList<>();
        for (SectionQuestion ss : section.questions()){
            list.add(ss.question().toDTO());
        }
        return list;
    }

    public Question getQuestionById(String id){
        return questionRepository.findQuestionById(id);
    }

    public boolean answeredSurvey(String surveyId){
        Survey survey = surveyRepository.findSurveyById(surveyId);
        for (ClientUserSurvey clientUserSurvey : survey.clientUsersToAnswer()){
            if (clientUserSurvey.clientUser().equals(getUser())){
                survey.clientUsersToAnswer().remove(clientUserSurvey);
                survey.addClientUserAnswered(getUser());
                txCtx.beginTransaction();
                surveyRepository.save(survey);
                txCtx.commit();
                return false;
            }
        }
        return false;
    }

    public boolean clientToAnswerSurveyOrder(){
        boolean dis;
        txCtx.beginTransaction();
        ClientUser user = getUser();
        for (Survey survey : surveyRepository.findAll()){
            dis = false;
            for (ContextSurvey contextSurvey : survey.contexts()) {
                if (contextSurvey.context().identity().equals(1L) && !dis) {
                    survey.addClientUserToAnswer(user);
                    surveyRepository.save(survey);
                    dis = true;
                }
            }
        }
        txCtx.commit();
        return true;
    }

    public boolean clientToAnswerSurveyProduct(String productReference){
        boolean dis;
        txCtx.beginTransaction();
        ClientUser user = getUser();
        for (Survey survey : surveyRepository.findAll()){
            dis = false;
            for (ContextSurvey contextSurvey : survey.contexts()) {
                if (contextSurvey.context().identity().equals(3L)) {
                    if (survey.product().Reference().toString().equals(productReference) && !dis) {
                        survey.addClientUserToAnswer(user);
                        surveyRepository.save(survey);
                        dis = true;
                    }
                }
            }
        }
        txCtx.commit();
        return true;
    }
}
