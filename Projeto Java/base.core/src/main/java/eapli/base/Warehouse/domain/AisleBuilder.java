package eapli.base.Warehouse.domain;

import java.util.Set;

public class AisleBuilder {
    private Aisle aisle;

    private AisleIdentifier aisleIdentifier;

    private AisleLocation aisleLocation;

    private String accessibility;

    private Set<Row> rows;

    public AisleBuilder(long aisleIdentifier, long beginLSquare, long beginWSquare, long endLSquare, long endWSquare, long depthLSquare ,long depthWSquare,String accessibility, Set<Row> rows) {
        withAisleIdentifier(aisleIdentifier);
        withAisleLocation(beginLSquare, beginWSquare, endLSquare, endWSquare, depthLSquare , depthWSquare);
        this.rows = rows;
        this.accessibility= accessibility;
    }

    private AisleBuilder withAisleIdentifier(long rowIdentifier){
        this.aisleIdentifier=new AisleIdentifier(rowIdentifier);
        return this;
    }

    private AisleBuilder withAisleLocation(long beginLSquare, long beginWSquare, long endLSquare, long endWSquare,long depthLSquare ,long depthWSquare  ){
        this.aisleLocation=new AisleLocation(beginLSquare, beginWSquare, endLSquare, endWSquare,depthLSquare , depthWSquare);
        return this;
    }

    private Aisle buildOrThrow() {
        if (aisle != null) {
            return aisle;
        } else if (aisleIdentifier != null && aisleLocation != null && accessibility != null && rows!= null ) {
            aisle = new Aisle(aisleIdentifier,aisleLocation,accessibility,rows);
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
