package eapli.base.surveymanagement.domain;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class SectionDescription {

    private String sectionDescription;

    public SectionDescription(final String sectionDescription){

        if (sectionDescription.length() > 100)
            throw new IllegalArgumentException("Exceeded section description maximum chars (100)!");

        this.sectionDescription = sectionDescription;

    }

    public SectionDescription() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SectionDescription)) return false;
        SectionDescription that = (SectionDescription) o;
        return Objects.equals(sectionDescription, that.sectionDescription);
    }

    @Override
    public String toString(){

        return sectionDescription;
    }

}
