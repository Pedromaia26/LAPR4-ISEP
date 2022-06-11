package eapli.base.surveymanagement.domain;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Answer implements AggregateRoot<Long> {

    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ClientUser clientUser;

    @ManyToOne
    private Question question;

    @ElementCollection
    private List<String> answers = new ArrayList<>();

    public Answer(ClientUser clientUser, List<String> answers, Question question){
        if (clientUser == null || answers == null || question == null){
            throw new IllegalArgumentException();
        }
        this.clientUser = clientUser;
        this.answers = answers;
        this.question = question;
    }

    public Answer(List<String> answers){
        if (answers == null){
            throw new IllegalArgumentException();
        }
        this.answers = answers;
    }

    public Answer() {
    }

    public ClientUser clientUser() {
        return clientUser;
    }

    public void modifyClientUser(ClientUser clientUser) {
        this.clientUser = clientUser;
    }

    public List<String> answers() {
        return answers;
    }

    public void addAnswers(String answer) {
        answers.add(answer);
    }

    public void resetAnswers() {
        answers = new ArrayList<>();
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public Long identity() {
        return id;
    }

    public Question question() {
        return question;
    }

    public void modifyQuestion(Question question) {
        this.question = question;
    }
}
