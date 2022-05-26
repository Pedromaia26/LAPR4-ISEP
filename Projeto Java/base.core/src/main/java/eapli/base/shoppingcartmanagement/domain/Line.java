package eapli.base.shoppingcartmanagement.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.util.Optional;

@Embeddable
public class Line implements ValueObject {
    private static final long serialVersionUID = 1L;

    @OneToOne
    private final ShoppingCartLine shoppingCartLine;


    protected Line() {
        // for ORM only
        shoppingCartLine = null;
    }

    public Line(final ShoppingCartLine shoppingCartLine) {
        Preconditions.nonNull(shoppingCartLine);
        this.shoppingCartLine = shoppingCartLine;
    }

    public ShoppingCartLine shoppingCartLine() {
        return shoppingCartLine;
    }
}
