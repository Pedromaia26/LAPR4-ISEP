package eapli.base.surveymanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

@Embeddable
public class SurveySection implements ValueObject {
    private static final long serialVersionUID = 1L;

    @OneToOne
    private final SurvSection section;


    protected SurveySection() {
        // for ORM only
        section = null;
    }

    public SurveySection(final SurvSection section) {
        Preconditions.nonNull(section);
        this.section = section;
    }

    public SurvSection section() {
        return section;
    }
}
