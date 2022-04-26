package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.File;
import java.sql.Blob;

@Embeddable
public class Photo implements ValueObject {

    private String setOfPhotos;

    public Photo(final String setOfPhotos) {
        File file = new File(setOfPhotos);
        if (!file.exists())
            throw new IllegalArgumentException("File does not exist!");

        this.setOfPhotos = setOfPhotos;
    }

    public Photo() {

    }
}
