package eapli.base.surveymanagement.repositories;

import eapli.base.surveymanagement.domain.Identifier;
import eapli.base.surveymanagement.domain.Question;
import eapli.base.surveymanagement.domain.Survey;
import eapli.base.surveymanagement.domain.SurveyIdentifier;
import eapli.framework.domain.repositories.DomainRepository;

public interface QuestionRepository extends DomainRepository<Identifier, Question> {
    Question findQuestionById(String id);
}
