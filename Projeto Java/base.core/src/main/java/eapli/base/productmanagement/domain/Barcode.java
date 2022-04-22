package eapli.base.productmanagement.domain;

public class Barcode {

    private String barcode;

    public Barcode (final String barcode){
        if (barcode.isEmpty())
            throw new IllegalArgumentException("Barcode cannot be empty");
        if (barcode.length() != 13)
            throw new IllegalArgumentException("Barcode must have 13 chars!");

        this.barcode = barcode;
    }
}
