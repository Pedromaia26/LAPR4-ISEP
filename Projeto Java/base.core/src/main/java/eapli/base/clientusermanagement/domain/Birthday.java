package eapli.base.clientusermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Date;
import java.text.SimpleDateFormat;
@Embeddable

public class Birthday implements ValueObject {
    private Date birthDate;

    public Birthday(String birthDate) {

        Date date1;
        try {
            date1 = new SimpleDateFormat("dd/MM/yyyy").parse(birthDate);
        }catch (Exception e){
            throw new IllegalArgumentException("Invalid date format, try year/month/day!");
        }


        this.birthDate = date1;
    }

    public Birthday() {

    }

    public Date birthDate() {
        return birthDate;
    }
}
