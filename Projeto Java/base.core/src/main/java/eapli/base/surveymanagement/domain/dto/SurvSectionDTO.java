package eapli.base.surveymanagement.domain.dto;

import eapli.base.surveymanagement.domain.*;
import eapli.framework.representations.dto.DTO;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import java.util.ArrayList;
import java.util.List;

@DTO
public class SurvSectionDTO {

    public String id;

    public String title;

    public String sectionDescription;

    public String obligatoriness;

    public String repeatability;

    public String dependent;

    public String dependentChoice;

    public SurvSectionDTO(String identifier, String title, String obligatoriness){
        this.id = identifier;
        this.title = title;
        this.obligatoriness = obligatoriness;
    }

    public SurvSectionDTO(String identifier, String title, String obligatoriness, String dependent, String dependentChoice, int op){
        this.id = identifier;
        this.title = title;
        this.obligatoriness = obligatoriness;
        if (op == 0){
            this.dependent = dependent;
            this.dependentChoice = dependentChoice;
        }
        else{
            this.sectionDescription = dependent;
            this.repeatability = dependentChoice;
        }
    }

    public SurvSectionDTO(String identifier, String title, String obligatoriness, String repeatability, int op){
        this.id = identifier;
        this.title = title;
        this.obligatoriness = obligatoriness;
        if (op == 0) this.repeatability = repeatability;
        else this.sectionDescription = repeatability;
    }


    public SurvSectionDTO(String identifier, String title, String obligatoriness, String repeatability, String dependent, String dependentChoice, int op){
        this.id = identifier;
        this.title = title;
        this.obligatoriness = obligatoriness;
        if (op == 0) this.repeatability = repeatability;
        else this.sectionDescription = repeatability;
        this.dependent = dependent;
        this.dependentChoice = dependentChoice;
    }

    public SurvSectionDTO(String identifier, String title, String sectionDescription, String obligatoriness, String repeatability, String dependent, String dependentChoice){
        this.id = identifier;
        this.title = title;
        this.sectionDescription = sectionDescription;
        this.obligatoriness = obligatoriness;
        this.repeatability = repeatability;
        this.dependent = dependent;
        this.dependentChoice = dependentChoice;
    }
}
