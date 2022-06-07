package eapli.base.surveymanagement.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SurveyIdentifier implements Serializable, Comparable<SurveyIdentifier> {

    private String surveyIdentifier;

    public SurveyIdentifier(String surveyIdentifier) {

        if(surveyIdentifier.length() > 30) throw new IllegalArgumentException("Exceeded Survey identifier maximum chars (30)!");
        if(surveyIdentifier.length() == 0) throw new IllegalArgumentException("Invalid Survey identifier, should not be empty!");

        this.surveyIdentifier = surveyIdentifier;
    }

    public SurveyIdentifier() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SurveyIdentifier identifier1 = (SurveyIdentifier) o;
        return surveyIdentifier.equals(identifier1.surveyIdentifier);
    }

    @Override
    public String toString() {
        return surveyIdentifier;
    }

    @Override
    public int compareTo(SurveyIdentifier o) {
        return 0;
    }
}
