package eapli.base.persistence.impl.inmemory;

import eapli.base.surveymanagement.domain.Survey;
import eapli.base.surveymanagement.domain.SurveyIdentifier;
import eapli.base.surveymanagement.repositories.SurveyRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;

public class InMemorySurveyRepository extends JpaAutoTxRepository<Survey, SurveyIdentifier, SurveyIdentifier>
        implements SurveyRepository {

    public InMemorySurveyRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    @Override
    public Survey findLastCreated(){
        return null;
    }

    @Override
    public Survey findSurveyById(String surveyId){
        return null;
    }
}
