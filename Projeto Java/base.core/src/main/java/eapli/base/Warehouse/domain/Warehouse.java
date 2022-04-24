package eapli.base.Warehouse.domain;


import java.util.Set;

public class Warehouse {

    private String name;

    private long length;

    private long width;

    private long square;

    private String unit;

    private final Set<Aisle> aisles;

    private Set<AGVDock> agvDocks;


    public Warehouse(String name, long length, long width, long square, String unit, Set<Aisle> aisles, Set<AGVDock> agvDocks) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.square = square;
        this.unit = unit;
        this.aisles= aisles;
        this.agvDocks= agvDocks;
    }


}
