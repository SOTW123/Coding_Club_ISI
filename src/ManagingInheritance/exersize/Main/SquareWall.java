package ManagingInheritance.exersize.Main;

public class SquareWall extends RectangleWall {

    private int sideLength;
    public SquareWall(String name, String color, int sideLength) {
        super(name, color, sideLength, sideLength);
        this.sideLength = sideLength;
    }

    public String toString() {
        return this.getName() + " (" + sideLength + "x" + sideLength + ") " + "square";
    }
}
