package eapli.base.surveymanagement.domain;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.productmanagement.domain.Product;
import eapli.base.surveymanagement.domain.dto.SurveyDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.*;

@Entity
public class Survey implements AggregateRoot<SurveyIdentifier> {

    @EmbeddedId
    private SurveyIdentifier id;

    @Embedded
    private Title title;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "message",
                    column = @Column(name = "WelcomeMessage")),
    })
    private Message welcomeMessage;

    @ElementCollection
    private List<SurveySection> sections = new ArrayList<>();

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "message",
                    column = @Column(name = "FinalMessage")),
    })
    private Message finalMessage;

    @ElementCollection
    private List<ClientUserSurvey> clientUsersToAnswer = new ArrayList<>();

    @ElementCollection
    private List<ClientUserSurvey> clientUsersAnswered = new ArrayList<>();

    @ManyToOne
    private Context context;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "age",
                    column = @Column(name = "MinimumAge")),
    })
    private Age minAge;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "age",
                    column = @Column(name = "MaximumAge")),
    })
    private Age maxAge;

    @ManyToOne
    private Product product;

    public Message getWelcomeMessage() {
        return welcomeMessage;
    }

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

    public boolean addSection(final SurvSection section) {
        return sections.add(new SurveySection(section));
    }

    public List<SurveySection> sections() {
        return sections;
    }

    public boolean addClientUserToAnswer(final ClientUser clientUser) {
        return clientUsersToAnswer.add(new ClientUserSurvey(clientUser));
    }

    public List<ClientUserSurvey> clientUsersToAnswer() {
        return clientUsersToAnswer;
    }

    public boolean addClientUserAnswered(final ClientUser clientUser) {
        return clientUsersAnswered.add(new ClientUserSurvey(clientUser));
    }

    public List<ClientUserSurvey> clientUsersAnswered() {
        return clientUsersAnswered;
    }

    @Override
    public String toString() {
        return "--- Survey ---" +
                "\nId: " + id +
                "\nTitle: " + title +
                "\nMinAge: " + minAge +
                "\nMaxAge: " + maxAge +
                "\nWelcome Message: " + welcomeMessage + "\n" +
                sections +
                "\nFinal Message: " + finalMessage + "\n";
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public SurveyIdentifier identity() {
        return id;
    }

    public Context context() {
        return context;
    }

    public void modifyContext(Context context) {
        this.context = context;
    }

    public Age minAge() {
        return minAge;
    }

    public void modifyMinAge(Age minAge) {
        this.minAge = minAge;
    }

    public Age maxAge() {
        return maxAge;
    }

    public void modifyMaxAge(Age maxAge) {
        this.maxAge = maxAge;
    }

    public Product product() {
        return product;
    }

    public void modifyProduct(Product product) {
        this.product = product;
    }

    public SurveyDTO toDTO(){
        if (welcomeMessage == null){
            return new SurveyDTO(id.toString(), title.toString(), finalMessage.toString(), minAge.age(), maxAge.age());
        }
        else{
            return new SurveyDTO(id.toString(), title.toString(), welcomeMessage.toString(), finalMessage.toString(), minAge.age(), maxAge.age());
        }
    }
}
