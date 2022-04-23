package eapli.base.Warehouse.domain;

import eapli.framework.strings.util.Strings;

import java.util.Set;

public class WarehouseBuilder {

    private Warehouse warehouse;

    private String name;

    private long length;

    private long width;

    private long square;

    private String unit;

    private Set<Aisle> aisles;

    public WarehouseBuilder(String name, long length, long width, long square, String unit, Set<Aisle> aisles) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.square = square;
        this.unit = unit;
        this.aisles = aisles;
    }

    private Warehouse buildOrThrow() {
        if (warehouse != null) {
            return warehouse;
        } else if (name != null && length != 0 && width != 0 && square != 0 && unit != null && aisles != null ) {
            warehouse = new Warehouse(name,length,width,square,unit,aisles);
            return warehouse;
        } else {
            throw new IllegalStateException();
        }
    }

    public Warehouse build() {
        final Warehouse ret = buildOrThrow();
        // make sure we will create a new instance if someone reuses this builder and do not change
        // the previously built dish.
        warehouse = null;
        return ret;
    }
}
