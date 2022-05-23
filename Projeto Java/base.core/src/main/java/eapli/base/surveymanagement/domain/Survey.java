package eapli.base.surveymanagement.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Survey {

    private SurveyIdentifier id;

    private Title title;

    private Message welcomeMessage;

    private Set<Section> sections = new HashSet<>();

    private Message finalMessage;

    public Survey(SurveyIdentifier identifier, Title title, Message welcomeMessage, Message finalMessage){

        if (identifier == null || title == null || welcomeMessage == null || finalMessage == null)
            throw new IllegalArgumentException();

        this.id = identifier;
        this.title = title;
        this.welcomeMessage = welcomeMessage;
        this.finalMessage = finalMessage;
    }

    public Survey(SurveyIdentifier identifier, Title title, Message finalMessage){

        if (identifier == null || title == null || finalMessage == null)
            throw new IllegalArgumentException();

        this.id = identifier;
        this.title = title;
        this.finalMessage = finalMessage;
    }

    public Survey(){}

    public SurveyIdentifier SurveyIdentifier() {
        return id;
    }

    public void modifyId(SurveyIdentifier surveyIdentifier) {
        this.id = surveyIdentifier;
    }

    public Title Title() {
        return title;
    }

    public void modifyTitle(Title title) {
        this.title = title;
    }

    public Message WelcomeMessage() {
        return welcomeMessage;
    }

    public void modifyWelcomeMessage(Message welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public Message FinalMessage() {
        return finalMessage;
    }

    public void modifyFinalMessage(Message finalMessage) {
        this.finalMessage = finalMessage;
    }

    public boolean addSection(final Section section) {
        return sections.add(section);
    }

    public Set<Section> questions() {
        return Collections.unmodifiableSet(sections);
    }

    @Override
    public String toString() {
        return "--- Survey ---" +
                "\nId: " + id +
                "\nTitle: " + title +
                "\nWelcome Message: " + welcomeMessage + "\n" +
                sections +
                "\nFinal Message: " + finalMessage + "\n";
    }
}
