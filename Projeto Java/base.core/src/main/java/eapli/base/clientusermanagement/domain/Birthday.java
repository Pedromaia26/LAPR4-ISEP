package eapli.base.clientusermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.util.regex.Pattern;

@Embeddable

public class Birthday implements ValueObject {
    private LocalDate birthDate;

    public Birthday(String birthDate) {

        if(birthDate.isBlank()){
            this.birthDate= null;
        }else {


            String[] format = birthDate.split(Pattern.quote("/"));

            if (Integer.parseInt(format[1])>12 || Integer.parseInt(format[1])<1)throw new IllegalArgumentException("Invalid month, should be between 1 and 12 !");
            if (Integer.parseInt(format[2])>31 || Integer.parseInt(format[2])<1)throw new IllegalArgumentException("Invalid day, should be between 1 and 31 !");


            LocalDate date1;

            try {

                date1= LocalDate.of(Integer.parseInt(format[0]),Integer.parseInt(format[1]),Integer.parseInt(format[2])+1);


            } catch (Exception e) {
                throw new IllegalArgumentException("Invalid date format, try yyyy/MM/dd!");
            }


            this.birthDate = date1 ;
        }
    }

    public Birthday() {

    }

    public LocalDate birthDate() {
        return birthDate;
    }
}
