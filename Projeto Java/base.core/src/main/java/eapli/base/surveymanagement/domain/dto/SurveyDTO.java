package eapli.base.surveymanagement.domain.dto;

import eapli.base.surveymanagement.domain.*;
import eapli.framework.representations.dto.DTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@DTO
public class SurveyDTO {

    public String id;

    public String title;

    public String welcomeMessage;

    public String finalMessage;

    public int minAge;

    public int maxAge;

    public SurveyDTO(String identifier, String title, String welcomeMessage, String finalMessage, int minAge, int maxAge){
        this.id = identifier;
        this.title = title;
        this.welcomeMessage = welcomeMessage;
        this.finalMessage = finalMessage;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public SurveyDTO(String identifier, String title, String finalMessage, int minAge, int maxAge){
        this.id = identifier;
        this.title = title;
        this.finalMessage = finalMessage;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public SurveyDTO(String identifier, String title, String welcomeMessage, String finalMessage){
        this.id = identifier;
        this.title = title;
        this.welcomeMessage = welcomeMessage;
        this.finalMessage = finalMessage;
    }

    public SurveyDTO(String identifier, String title, String finalMessage){
        this.id = identifier;
        this.title = title;
        this.finalMessage = finalMessage;
    }
}
