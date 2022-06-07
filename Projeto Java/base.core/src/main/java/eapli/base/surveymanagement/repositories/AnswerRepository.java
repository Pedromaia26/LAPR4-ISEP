package eapli.base.surveymanagement.repositories;

import eapli.base.surveymanagement.domain.Answer;
import eapli.base.surveymanagement.domain.Survey;
import eapli.base.surveymanagement.domain.SurveyIdentifier;
import eapli.framework.domain.repositories.DomainRepository;

public interface AnswerRepository extends DomainRepository<Long, Answer> {
}
