package eapli.base.orderstatusmanagement.domain;

import eapli.base.productmanagement.domain.*;
import eapli.framework.domain.model.DomainFactory;

public class StatusBuilder implements DomainFactory<Status> {

    private Status status;
    private Description description;

    public StatusBuilder(final String description){
        withDescription(description);
    }

    public StatusBuilder withDescription(final String description) {
        this.description = new Description(description);
        return this;
    }

    private Status buildOrThrow() {
        if (status != null) {
            return status;
        } else if (description != null) {
            status = new Status(description);
            return status;
        } else {
            throw new IllegalStateException();
        }
    }

    public Status build() {
        final Status ret = buildOrThrow();
        return ret;
    }
}
