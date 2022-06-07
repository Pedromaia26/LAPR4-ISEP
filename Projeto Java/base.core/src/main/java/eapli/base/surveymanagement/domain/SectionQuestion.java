package eapli.base.surveymanagement.domain;

import eapli.base.shoppingcartmanagement.domain.ShoppingCartLine;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

@Embeddable
public class SectionQuestion implements ValueObject {
    private static final long serialVersionUID = 1L;

    @OneToOne
    private final Question question;


    protected SectionQuestion() {
        // for ORM only
        question = null;
    }

    public SectionQuestion(final Question question) {
        Preconditions.nonNull(question);
        this.question = question;
    }

    public Question question() {
        return question;
    }
}
