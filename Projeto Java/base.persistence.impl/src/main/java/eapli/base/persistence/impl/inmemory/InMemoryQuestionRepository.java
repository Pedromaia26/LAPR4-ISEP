package eapli.base.persistence.impl.inmemory;

import eapli.base.surveymanagement.domain.Identifier;
import eapli.base.surveymanagement.domain.Question;
import eapli.base.surveymanagement.domain.Survey;
import eapli.base.surveymanagement.domain.SurveyIdentifier;
import eapli.base.surveymanagement.repositories.QuestionRepository;
import eapli.base.surveymanagement.repositories.SurveyRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class InMemoryQuestionRepository extends JpaAutoTxRepository<Question, Identifier, Identifier>
        implements QuestionRepository {

    public InMemoryQuestionRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public Question findQuestionById(String id){
        return null;
    }
}
