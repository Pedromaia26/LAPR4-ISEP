package eapli.base.surveymanagement.domain;

public class Repeatability {

    private String repeatability;

    public Repeatability(String repeatability) {

        if(repeatability.length() == 0) throw new IllegalArgumentException("Invalid Repeatability, should not be empty!");

        this.repeatability = repeatability;
    }

    public Repeatability() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repeatability repeatability1 = (Repeatability) o;
        return repeatability.equals(repeatability1.repeatability);
    }

    @Override
    public String toString() {
        return repeatability;
    }
}
