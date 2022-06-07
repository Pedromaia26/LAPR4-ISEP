package eapli.base.persistence.impl.inmemory;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.CategoryCode;
import eapli.base.categorymanagement.repositories.CategoryRepository;
import eapli.base.surveymanagement.domain.Context;
import eapli.base.surveymanagement.repositories.ContextRepository;
import eapli.base.taskmanagement.domain.Task;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import javax.persistence.TypedQuery;

public class InMemoryContextRepository  extends InMemoryDomainRepository<Context, Long>
        implements ContextRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Context findContextById(final Long id) {
        return null;
    }
}
