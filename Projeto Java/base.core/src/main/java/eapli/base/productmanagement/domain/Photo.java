package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Photo implements ValueObject {

    private String setOfPhotos;

    public Photo(final String setOfPhotos) {
        this.setOfPhotos = setOfPhotos;
    }

    public Photo() {

    }
}
