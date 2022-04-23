package eapli.base.Warehouse.domain;

public class AisleLocation {

    private long beginLSquare;
    private long beginWSquare;

    private long endLSquare;
    private long endWSquare;

    private long depthLSquare;
    private long depthWSquare;

    public AisleLocation(long beginLSquare, long beginWSquare, long endLSquare, long endWSquare, long depthLSquare, long depthWSquare) {
        this.beginLSquare = beginLSquare;
        this.beginWSquare = beginWSquare;
        this.endLSquare = endLSquare;
        this.endWSquare = endWSquare;
        this.depthLSquare = depthLSquare;
        this.depthWSquare = depthWSquare;
    }
}
