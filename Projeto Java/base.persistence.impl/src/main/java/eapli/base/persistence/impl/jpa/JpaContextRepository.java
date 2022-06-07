package eapli.base.persistence.impl.jpa;

import eapli.base.surveymanagement.domain.Context;
import eapli.base.surveymanagement.repositories.ContextRepository;

import javax.persistence.TypedQuery;
import java.util.Optional;

public class JpaContextRepository extends BasepaRepositoryBase<Context, Long, Long>
        implements ContextRepository {

    JpaContextRepository() {
        super("id");
    }

    @Override
    public Context findContextById(final Long id) {
        final TypedQuery<Context> query = super.createQuery(
                "SELECT d FROM Context d WHERE id = " + id,
                Context.class);

        return query.getSingleResult();
    }
}
