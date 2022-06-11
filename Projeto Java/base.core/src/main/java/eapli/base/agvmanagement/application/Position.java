package eapli.base.agvmanagement.application;

public class Position {

    int l;
    int c;
    int dist;
    Position prev;

    Position(int l, int c, int dist, Position prev){
        this.c = c;
        this.l = l;
        this.dist = dist;
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "(" + l + "," + c + ")";
    }
}
