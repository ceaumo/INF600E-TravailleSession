package projet;

public class Pointeur {

    Point position;

    public Pointeur(){

        position = new Point(100,100);
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
}
