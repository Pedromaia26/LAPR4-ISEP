package eapli.base.persistence.impl.inmemory;

import eapli.base.Warehouse.domain.Section;
import eapli.base.surveymanagement.domain.Identifier;
import eapli.base.surveymanagement.domain.SurvSection;
import eapli.base.surveymanagement.domain.Survey;
import eapli.base.surveymanagement.domain.SurveyIdentifier;
import eapli.base.surveymanagement.repositories.SectionRepository;
import eapli.base.surveymanagement.repositories.SurveyRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class InMemorySectionRepository extends JpaAutoTxRepository<SurvSection, Identifier, Identifier>
        implements SectionRepository {

    public InMemorySectionRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    @Override
    public SurvSection findSectionById(String sectionId){
        return null;
    }
}
