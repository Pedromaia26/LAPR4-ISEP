package eapli.base.surveymanagement.repositories;

import eapli.base.surveymanagement.domain.Context;
import eapli.base.surveymanagement.domain.Identifier;
import eapli.base.surveymanagement.domain.Question;
import eapli.framework.domain.repositories.DomainRepository;

public interface ContextRepository extends DomainRepository<Long, Context> {

    Context findContextById(Long id);
}
