package eapli.base.surveymanagement.domain;

import eapli.base.productmanagement.domain.ShortDescription;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Message implements ValueObject, Serializable {

    @Column(insertable = false, updatable = false)
    private String message;

    public Message(final String message){

        if (message.length() > 200)
            throw new IllegalArgumentException("Exceeded message maximum chars (200)!");

        this.message = message;

    }

    public Message() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message that = (Message) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public String toString(){

        return message;
    }
}
