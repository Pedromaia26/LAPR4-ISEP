package eapli.base.Warehouse.domain;

import java.util.HashSet;
import java.util.Set;

public class Aisle {

        private AisleIdentifier aisleIdentifier;

        private AisleBeginLSquare aisleBeginLSquare;

        private AisleBeginWSquare aisleBeginWSquare;

        private AisleDepthLSquare aisleDepthLSquare;

        private AisleDepthWSquare aisleDepthWSquare;

        private AisleEndLSquare aisleEndLSquare;

        private AisleEndWSquare aisleEndWSquare;

        private String accessibility;

        private Set<Row> rows;

    public Aisle(AisleIdentifier aisleIdentifier, AisleBeginLSquare aisleBeginLSquare, AisleBeginWSquare aisleBeginWSquare, AisleDepthLSquare aisleDepthLSquare, AisleDepthWSquare aisleDepthWSquare, AisleEndLSquare aisleEndLSquare, AisleEndWSquare aisleEndWSquare, String accessibility, Set<Row> rows) {
        this.aisleIdentifier = aisleIdentifier;
        this.aisleBeginLSquare = aisleBeginLSquare;
        this.aisleBeginWSquare = aisleBeginWSquare;
        this.aisleDepthLSquare = aisleDepthLSquare;
        this.aisleDepthWSquare = aisleDepthWSquare;
        this.aisleEndLSquare = aisleEndLSquare;
        this.aisleEndWSquare = aisleEndWSquare;
        this.accessibility = accessibility;
        this.rows = rows;
    }
}
