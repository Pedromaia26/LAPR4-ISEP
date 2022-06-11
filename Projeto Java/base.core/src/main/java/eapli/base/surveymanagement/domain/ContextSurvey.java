package eapli.base.surveymanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

@Embeddable
public class ContextSurvey implements ValueObject {
    private static final long serialVersionUID = 1L;

    @OneToOne
    private final Context context;


    protected ContextSurvey() {
        // for ORM only
        context = null;
    }

    public ContextSurvey(final Context context) {
        Preconditions.nonNull(context);
        this.context = context;
    }

    public Context context() {
        return context;
    }
}
