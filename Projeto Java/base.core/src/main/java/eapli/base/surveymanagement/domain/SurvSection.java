package eapli.base.surveymanagement.domain;

import eapli.base.surveymanagement.domain.dto.SurvSectionDTO;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.*;

@Entity
public class SurvSection implements AggregateRoot<Identifier> {

    @EmbeddedId
    private Identifier id;

    @Embedded
    private Title title;

    @Embedded
    private SectionDescription sectionDescription;

    @Embedded
    private VerifyObligatoriness obligatoriness;

    @Embedded
    private Repeatability repeatability;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<SectionQuestion> questions = new ArrayList<>();

    @ManyToOne
    private Question dependent;

    private String dependentChoice;

    public SurvSection(Identifier identifier, Title title, SectionDescription sectionDescription, VerifyObligatoriness obligatoriness, Repeatability repeatability, List<SectionQuestion> questions){

        if (identifier == null || title == null || sectionDescription == null || obligatoriness == null || repeatability == null)
            throw new IllegalArgumentException();

        this.id = identifier;
        this.title = title;
        this.sectionDescription = sectionDescription;
        this.obligatoriness = obligatoriness;
        this.repeatability = repeatability;
        this.questions = questions;
    }

    public SurvSection(Identifier identifier, Title title, SectionDescription sectionDescription, VerifyObligatoriness obligatoriness, Repeatability repeatability){

        if (identifier == null || title == null || sectionDescription == null || obligatoriness == null || repeatability == null)
            throw new IllegalArgumentException();

        this.id = identifier;
        this.title = title;
        this.sectionDescription = sectionDescription;
        this.obligatoriness = obligatoriness;
        this.repeatability = repeatability;
    }

    public SurvSection(Identifier identifier, Title title, VerifyObligatoriness obligatoriness, Repeatability repeatability, List<SectionQuestion> questions){

        if (identifier == null || title == null || obligatoriness == null || repeatability == null)
            throw new IllegalArgumentException();

        this.id = identifier;
        this.title = title;
        this.obligatoriness = obligatoriness;
        this.repeatability = repeatability;
        this.questions = questions;
    }

    public SurvSection(Identifier identifier, Title title, SectionDescription sectionDescription, VerifyObligatoriness obligatoriness, List<SectionQuestion> questions){

        if (identifier == null || title == null || sectionDescription == null || obligatoriness == null)
            throw new IllegalArgumentException();

        this.id = identifier;
        this.title = title;
        this.sectionDescription = sectionDescription;
        this.obligatoriness = obligatoriness;
        this.questions = questions;
    }

    public SurvSection(Identifier identifier, Title title, VerifyObligatoriness obligatoriness, List<SectionQuestion> questions){

        if (identifier == null || title == null || obligatoriness == null)
            throw new IllegalArgumentException();

        this.id = identifier;
        this.title = title;
        this.obligatoriness = obligatoriness;
        this.questions = questions;
    }

    public SurvSection(){}

    public Identifier identifier() {
        return id;
    }

    public void modifyId(Identifier identifier) {
        this.id = identifier;
    }

    public Title Title() {
        return title;
    }

    public void modifyTitle(Title title) {
        this.title = title;
    }

    public VerifyObligatoriness Obligatoriness(){
        return obligatoriness;
    }

    public void modifyVerifyObligatoriness(VerifyObligatoriness obligatoriness) {
        this.obligatoriness = obligatoriness;
    }

    public SectionDescription SectionDescription() {
        return sectionDescription;
    }

    public void modifySectionDescription(SectionDescription sectionDescription) {
        this.sectionDescription = sectionDescription;
    }

    public Repeatability Repeatability(){
        return repeatability;
    }

    public void modifyRepeatability(Repeatability repeatability) {
        this.repeatability = repeatability;
    }

    public boolean addQuestion(final Question question) {
        return questions.add(new SectionQuestion(question));
    }

    public List<SectionQuestion> questions() {
        return questions;
    }

    public void modifyQuestions(List<SectionQuestion> questions){
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "--- Section ---" +
                "\nId: " + id +
                "\nTitle: " + title +
                "\nSection Description: " + sectionDescription +
                "\nObligatoriness: " + obligatoriness +
                "\nRepeatability: " + repeatability + "\n" +
                questions + "\n";
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Identifier identity() {
        return null;
    }

    public SurvSectionDTO toDTO(){
        if (sectionDescription == null && repeatability == null && dependent == null){
            return new SurvSectionDTO(id.toString(), title.toString(), obligatoriness.toString());
        }
        else if (sectionDescription == null && repeatability == null && dependent != null){
            return new SurvSectionDTO(id.toString(), title.toString(), obligatoriness.toString(), dependent.identity().toString(), dependentChoice, 0);
        }
        else if (sectionDescription == null && repeatability != null && dependent == null){
            return new SurvSectionDTO(id.toString(), title.toString(), obligatoriness.toString(), repeatability.toString(), 0);
        }
        else if (sectionDescription == null && repeatability != null && dependent != null){
            return new SurvSectionDTO(id.toString(), title.toString(), obligatoriness.toString(), repeatability.toString(), dependent.identity().toString(), dependentChoice, 0);
        }
        else if (sectionDescription != null && repeatability == null && dependent == null){
            return new SurvSectionDTO(id.toString(), title.toString(), obligatoriness.toString(), sectionDescription.toString(), 1);
        }
        else if (sectionDescription != null && repeatability == null && dependent != null){
            return new SurvSectionDTO(id.toString(), title.toString(), obligatoriness.toString(), sectionDescription.toString(), dependent.identity().toString(), dependentChoice, 1);
        }
        else if (sectionDescription != null && repeatability != null && dependent == null){
            return new SurvSectionDTO(id.toString(), title.toString(), obligatoriness.toString(), sectionDescription.toString(), repeatability.toString(), 1);
        }
        else if (sectionDescription != null && repeatability != null && dependent != null){
            return new SurvSectionDTO(id.toString(), title.toString(), sectionDescription.toString(), obligatoriness.toString(), repeatability.toString(), dependent.identity().toString(), dependentChoice);
        }
        return null;
    }

    public Question dependent() {
        return dependent;
    }

    public void modifyDependent(Question dependent) {
        this.dependent = dependent;
    }

    public String dependentChoice() {
        return dependentChoice;
    }

    public void modifyDependentChoice(String dependentChoice) {
        this.dependentChoice = dependentChoice;
    }
}
