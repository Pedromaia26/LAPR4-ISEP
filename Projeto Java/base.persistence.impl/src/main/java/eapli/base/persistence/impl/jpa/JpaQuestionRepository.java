package eapli.base.persistence.impl.jpa;

import eapli.base.surveymanagement.domain.*;
import eapli.base.surveymanagement.repositories.QuestionRepository;
import eapli.base.surveymanagement.repositories.SurveyRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;

public class JpaQuestionRepository extends JpaAutoTxRepository<Question, Identifier, Identifier>
        implements QuestionRepository {

    public JpaQuestionRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    @Override
    public Question findQuestionById(final String id) {
        final TypedQuery<Question> query = super.createQuery(
                "SELECT d FROM Question d WHERE id = '" + id + "'",
                Question.class);

        return query.getSingleResult();
    }
}
