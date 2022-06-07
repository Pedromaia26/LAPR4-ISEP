package eapli.base.surveymanagement.domain;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

@Embeddable
public class ClientUserSurvey {
    private static final long serialVersionUID = 1L;

    @OneToOne
    private final ClientUser clientUser;


    protected ClientUserSurvey() {
        // for ORM only
        clientUser = null;
    }

    public ClientUserSurvey(final ClientUser clientUser) {
        Preconditions.nonNull(clientUser);
        this.clientUser = clientUser;
    }

    public ClientUser clientUser() {
        return clientUser;
    }
}
