package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.File;
import java.sql.Blob;
import java.util.List;
import java.util.Set;

@Embeddable
public class Photo implements ValueObject {

    private String setOfPhotos = "";

    public Photo(final List<String> setOfPhotos) {

        for (int i = 0; i < setOfPhotos.size(); i++){
            File file = new File(setOfPhotos.get(i));
            if (!file.exists())
                throw new IllegalArgumentException("File does not exist!");

            this.setOfPhotos += setOfPhotos.get(i) + "\n";
        }

    }

    public Photo() {

    }
}
