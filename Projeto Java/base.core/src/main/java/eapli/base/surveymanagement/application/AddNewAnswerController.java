package eapli.base.surveymanagement.application;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.VAT;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.domain.ExtendedDescription;
import eapli.base.surveymanagement.domain.Answer;
import eapli.base.surveymanagement.domain.Context;
import eapli.base.surveymanagement.domain.Question;
import eapli.base.surveymanagement.domain.dto.QuestionDTO;
import eapli.base.surveymanagement.repositories.AnswerRepository;
import eapli.base.surveymanagement.repositories.ContextRepository;
import eapli.base.surveymanagement.repositories.QuestionRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.List;
import java.util.Optional;

public class AddNewAnswerController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ClientUserRepository clientUserRepository = PersistenceContext.repositories().clientUsers();
    private final AnswerRepository answerRepository = PersistenceContext.repositories().answers();
    private final TransactionalContext txCtx = PersistenceContext.repositories().newTransactionalContext();
    private final QuestionRepository questionRepository = PersistenceContext.repositories().questions(txCtx);

    public Answer addAnswer(final List<String> answers, final QuestionDTO questionDto) {
        Question question = questionRepository.findQuestionById(questionDto.id);
        final var newAnswer = new Answer(getUser(), answers, question);


        return answerRepository.save(newAnswer);
    }

    public boolean isDependencyValid(String questionId, String choice){
        for (Answer answer : answerRepository.findAll()){
            if (answer.clientUser().equals(getUser()) && answer.question().identity().toString().equals(questionId)){
                if (answer.answers().contains(choice)) return true;
                else return false;
            }
        }
        return false;
    }

    public VAT getUserSessionVat(){
        return getUser().identity();
    }

    public ClientUser getUser(){
        Username username = authz.session().get().authenticatedUser().username();
        Optional<ClientUser> client = clientUserRepository.findByUsername(username);
        return client.get();
    }
}
