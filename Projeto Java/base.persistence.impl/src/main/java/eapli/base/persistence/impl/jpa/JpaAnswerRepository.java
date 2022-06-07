package eapli.base.persistence.impl.jpa;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.CategoryCode;
import eapli.base.categorymanagement.repositories.CategoryRepository;
import eapli.base.surveymanagement.domain.Answer;
import eapli.base.surveymanagement.repositories.AnswerRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class JpaAnswerRepository extends BasepaRepositoryBase<Answer, Long, Long>
        implements AnswerRepository {

    JpaAnswerRepository() {
        super("id");
    }
}
