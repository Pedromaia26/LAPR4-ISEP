package eapli.base.surveymanagement.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Section {

    private Identifier id;

    private Title title;

    private SectionDescription sectionDescription;

    private VerifyObligatoriness obligatoriness;

    private Repeatability repeatability;

    private Set<Question> questions = new HashSet<>();

    public Section(Identifier identifier, Title title, SectionDescription sectionDescription, VerifyObligatoriness obligatoriness, Repeatability repeatability, Set<Question> questions){

        if (identifier == null || title == null || sectionDescription == null || obligatoriness == null || repeatability == null)
            throw new IllegalArgumentException();

        this.id = identifier;
        this.title = title;
        this.sectionDescription = sectionDescription;
        this.obligatoriness = obligatoriness;
        this.repeatability = repeatability;
        this.questions = questions;
    }

    public Section(Identifier identifier, Title title, SectionDescription sectionDescription, VerifyObligatoriness obligatoriness, Repeatability repeatability){

        if (identifier == null || title == null || sectionDescription == null || obligatoriness == null || repeatability == null)
            throw new IllegalArgumentException();

        this.id = identifier;
        this.title = title;
        this.sectionDescription = sectionDescription;
        this.obligatoriness = obligatoriness;
        this.repeatability = repeatability;
    }

    public Section(Identifier identifier, Title title, VerifyObligatoriness obligatoriness, Repeatability repeatability, Set<Question> questions){

        if (identifier == null || title == null || obligatoriness == null || repeatability == null)
            throw new IllegalArgumentException();

        this.id = identifier;
        this.title = title;
        this.obligatoriness = obligatoriness;
        this.repeatability = repeatability;
        this.questions = questions;
    }

    public Section(Identifier identifier, Title title, SectionDescription sectionDescription, VerifyObligatoriness obligatoriness, Set<Question> questions){

        if (identifier == null || title == null || sectionDescription == null || obligatoriness == null)
            throw new IllegalArgumentException();

        this.id = identifier;
        this.title = title;
        this.sectionDescription = sectionDescription;
        this.obligatoriness = obligatoriness;
        this.questions = questions;
    }

    public Section(Identifier identifier, Title title, VerifyObligatoriness obligatoriness, Set<Question> questions){

        if (identifier == null || title == null || obligatoriness == null)
            throw new IllegalArgumentException();

        this.id = identifier;
        this.title = title;
        this.obligatoriness = obligatoriness;
        this.questions = questions;
    }

    public Section(){}

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
        return questions.add(question);
    }

    public Set<Question> questions() {
        return Collections.unmodifiableSet(questions);
    }

    public void modifyQuestions(Set<Question> questions){
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
}
