package eapli.base.surveymanagement.repositories;

import eapli.base.Warehouse.domain.Section;
import eapli.base.surveymanagement.domain.Identifier;
import eapli.base.surveymanagement.domain.SurvSection;
import eapli.base.surveymanagement.domain.Survey;
import eapli.base.surveymanagement.domain.SurveyIdentifier;
import eapli.framework.domain.repositories.DomainRepository;

public interface SectionRepository extends DomainRepository<Identifier, SurvSection> {

    SurvSection findSectionById(String sectionId);
}
