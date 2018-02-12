package simonhaefeli.barhelper;

/**
 * Created by simon on 11.07.17.
 */

public class Tuple<X, Y> {
    private X x;
    private Y y;
    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public X getX() {
        return x;
    }

    public Y getY() {
        return y;
    }

    public void setX(X x){
        this.x=x;
    }
    public void setY(Y y){
        this.y=y;
    }

}