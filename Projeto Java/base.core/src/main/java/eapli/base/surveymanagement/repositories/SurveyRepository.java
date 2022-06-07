package eapli.base.surveymanagement.repositories;

import eapli.base.shoppingcartmanagement.domain.ShoppingCart;
import eapli.base.surveymanagement.domain.Survey;
import eapli.base.surveymanagement.domain.SurveyIdentifier;
import eapli.framework.domain.repositories.DomainRepository;

public interface SurveyRepository extends DomainRepository<SurveyIdentifier, Survey> {
    Survey findLastCreated();

    Survey findSurveyById(String surveyId);
}
