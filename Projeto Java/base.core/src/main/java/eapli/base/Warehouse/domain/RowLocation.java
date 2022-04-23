package eapli.base.Warehouse.domain;

public class RowLocation {

    private long beginLSquare;
    private long beginWSquare;

    private long endLSquare;
    private long endWSquare;



    public RowLocation(long beginLSquare, long beginWSquare, long endLSquare, long endWSquare) {
        this.beginLSquare = beginLSquare;
        this.beginWSquare = beginWSquare;
        this.endLSquare = endLSquare;
        this.endWSquare = endWSquare;

    }
}
