package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AGVDockIdentifier implements Comparable<AGVDockIdentifier>, Serializable, ValueObject {
    private static final long serialVersionUID = 7249038453492292448L;
    private String id;

    public AGVDockIdentifier(String id) {
        if(id.isBlank())
            throw new IllegalArgumentException("Invalid dock id!");

        this.id = id;
    }

    public AGVDockIdentifier() {

    }

    @Override
    public int compareTo(AGVDockIdentifier o) {
        return id.compareTo(o.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AGVDockIdentifier that = (AGVDockIdentifier) o;
        return id.equals(that.id);
    }

    public String Id() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
