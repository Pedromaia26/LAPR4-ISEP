package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.shoppingcartmanagement.domain.ShoppingCart;
import eapli.base.shoppingcartmanagement.repositories.ShoppingCartRepository;
import eapli.base.surveymanagement.domain.Survey;
import eapli.base.surveymanagement.domain.SurveyIdentifier;
import eapli.base.surveymanagement.repositories.SurveyRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;

public class JpaSurveyRepository extends JpaAutoTxRepository<Survey, SurveyIdentifier, SurveyIdentifier>
        implements SurveyRepository {

    public JpaSurveyRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    @Override
    public Survey findLastCreated(){
        final TypedQuery<Survey> query = super.createQuery(
                "SELECT d FROM Survey d WHERE id = (SELECT max(e.id) FROM Survey e)",
                Survey.class);


        return query.getSingleResult();
    }

    @Override
    public Survey findSurveyById(String surveyId){
        final TypedQuery<Survey> query = super.createQuery(
                "SELECT d FROM Survey d WHERE id = '" + surveyId + "'",
                Survey.class);


        return query.getSingleResult();
    }
}
