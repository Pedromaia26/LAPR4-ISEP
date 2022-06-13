package eapli.base.surveymanagement.domain;

import eapli.base.productmanagement.domain.ShortDescription;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Title {

    private String title;

    public Title(final String title){

        if (title == null || title.isBlank())
            throw new IllegalArgumentException("Title cannot be empty!");
        if (title.length() > 50)
            throw new IllegalArgumentException("Exceeded title maximum chars (50)");

        this.title = title;

    }

    public Title() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Title)) return false;
        Title that = (Title) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString(){

        return title;
    }

}
