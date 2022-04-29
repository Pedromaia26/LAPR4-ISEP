package eapli.base.clientusermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.SimpleDateFormat;
@Embeddable

public class Birthday implements ValueObject {
    private LocalDate birthDate;

    public Birthday(String birthDate) {

        if(birthDate.isBlank()){
            this.birthDate= null;
        }else {

            LocalDate date1;
            try {
                date1 = YearMonth.parse(birthDate, DateTimeFormatter.ofPattern("yyyy/MM/dd")).atDay(1);
                ;
            } catch (Exception e) {
                throw new IllegalArgumentException("Invalid date format, try yyyy/MM/dd!");
            }


            this.birthDate = date1;
        }
    }

    public Birthday() {

    }

    public Date birthDate() {
        return birthDate;
    }
}
