package eapli.base.Warehouse.domain;

import java.util.Set;

public class AisleBuilder {
    private Aisle aisle;

    private AisleIdentifier aisleIdentifier;

    private AisleBeginLSquare aisleBeginLSquare;

    private AisleBeginWSquare aisleBeginWSquare;

    private AisleDepthLSquare aisleDepthLSquare;

    private AisleDepthWSquare aisleDepthWSquare;

    private AisleEndLSquare aisleEndLSquare;

    private AisleEndWSquare aisleEndWSquare;

    private String accessibility;

    private Set<Section> sections;

    private Warehouse warehouse;

    public AisleBuilder(long aisleIdentifier, long beginLSquare, long beginWSquare, long endLSquare, long endWSquare, long depthLSquare ,long depthWSquare,String accessibility/*, Set<Row> rows*/, Warehouse warehouse) {
        withAisleIdentifier(aisleIdentifier);
        withAileBeginLSquare(beginLSquare);
        withAileBeginWSquare(beginWSquare);
        withAileEndLSquare(endLSquare);
        withAileEndWSquare(endWSquare);
        withAileDepthLSquare(depthLSquare);
        withAileDepthWSquare(depthWSquare);
        withWarehouse(warehouse);

      //  this.rows = rows;
        this.accessibility= accessibility;
    }

    private AisleBuilder withAisleIdentifier(long rowIdentifier){
        this.aisleIdentifier=new AisleIdentifier(rowIdentifier);
        return this;
    }
    private AisleBuilder withWarehouse(Warehouse warehouse){
        this.warehouse=warehouse;
        return this;
    }

    private AisleBuilder withAileBeginLSquare(long beginWSquare){
        this.aisleBeginLSquare= new AisleBeginLSquare(beginWSquare);
        return this;
    }

    private AisleBuilder withAileBeginWSquare(long beginWSquare){
        this.aisleBeginWSquare= new AisleBeginWSquare(beginWSquare);
        return this;
    }



    private AisleBuilder withAileEndLSquare(long EndWSquare){
        this.aisleEndLSquare= new AisleEndLSquare(EndWSquare);
        return this;
    }

    private AisleBuilder withAileEndWSquare(long EndWSquare){
        this.aisleEndWSquare= new AisleEndWSquare(EndWSquare);
        return this;
    }

    private AisleBuilder withAileDepthLSquare(long DepthWSquare){
        this.aisleDepthLSquare= new AisleDepthLSquare(DepthWSquare);
        return this;
    }

    private AisleBuilder withAileDepthWSquare(long DepthWSquare){
        this.aisleDepthWSquare= new AisleDepthWSquare(DepthWSquare);
        return this;
    }

    private Aisle buildOrThrow() {
        if (aisle != null) {
            return aisle;
        } else if (warehouse!= null && aisleIdentifier != null && aisleBeginWSquare != null && accessibility != null && aisleBeginLSquare != null && aisleEndLSquare != null && aisleEndWSquare != null && aisleDepthLSquare != null && aisleDepthWSquare != null ) {
            aisle = new Aisle(aisleIdentifier,aisleBeginLSquare,aisleBeginWSquare,aisleDepthLSquare,aisleDepthWSquare,aisleEndLSquare,aisleEndWSquare,accessibility/*,rows*/,warehouse);
            return aisle;
        } else {
            throw new IllegalStateException();
        }
    }

    public Aisle build() {
        final Aisle ret = buildOrThrow();
        // make sure we will create a new instance if someone reuses this builder and do not change
        // the previously built dish.
        aisle = null;
        return ret;
    }
}
