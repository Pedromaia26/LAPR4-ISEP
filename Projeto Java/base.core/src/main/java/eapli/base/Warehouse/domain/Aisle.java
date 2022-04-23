package eapli.base.Warehouse.domain;

import java.util.HashSet;
import java.util.Set;

public class Aisle {

        private AisleIdentifier aisleIdentifier;

        private AisleLocation aisleLocation;

        private String accessibility;

        private Set<Row> rows;


    public Aisle(AisleIdentifier aisleIdentifier, AisleLocation aisleLocation, String accessibility, Set<Row> rows) {
        this.aisleIdentifier = aisleIdentifier;
        this.aisleLocation = aisleLocation;
        this.accessibility = accessibility;
        this.rows = rows;
    }
}
