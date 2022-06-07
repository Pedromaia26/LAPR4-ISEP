package eapli.base.persistence.impl.jpa;

import eapli.base.Warehouse.domain.Section;
import eapli.base.surveymanagement.domain.Identifier;
import eapli.base.surveymanagement.domain.SurvSection;
import eapli.base.surveymanagement.domain.Survey;
import eapli.base.surveymanagement.domain.SurveyIdentifier;
import eapli.base.surveymanagement.repositories.SectionRepository;
import eapli.base.surveymanagement.repositories.SurveyRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;

public class JpaSectionRepository extends JpaAutoTxRepository<SurvSection, Identifier, Identifier>
        implements SectionRepository {

    public JpaSectionRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    @Override
    public SurvSection findSectionById(String sectionId){
        final TypedQuery<SurvSection> query = super.createQuery(
                "SELECT d FROM SurvSection d WHERE id = '" + sectionId + "'",
                SurvSection.class);


        return query.getSingleResult();
    }
}
