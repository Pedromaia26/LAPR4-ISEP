package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class AGVDockIdentifier implements Comparable<AGVDockIdentifier>, Serializable, ValueObject {
    private static final long serialVersionUID = 7249038453492292448L;
    private String id;

    public AGVDockIdentifier(String id) {
        this.id = id;
    }

    public AGVDockIdentifier() {

    }

    @Override
    public int compareTo(AGVDockIdentifier o) {
        return id.compareTo(o.id);
    }
}
