package eapli.base.persistence.impl.inmemory;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.CategoryCode;
import eapli.base.categorymanagement.repositories.CategoryRepository;
import eapli.base.surveymanagement.domain.Answer;
import eapli.base.surveymanagement.repositories.AnswerRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryAnswerRepository extends InMemoryDomainRepository<Answer, Long>
        implements AnswerRepository {

    static {
        InMemoryInitializer.init();
    }
}
