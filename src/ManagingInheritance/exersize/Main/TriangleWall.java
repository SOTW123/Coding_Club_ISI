package ManagingInheritance.exersize.Main;

public class TriangleWall extends Wall {

    private int base;
    private int height;

    public TriangleWall(String name, String color, int base, int height) {
        super(name, color);
        this.base = base;
        this.height = height;
    }

    @Override
    public int getArea() {
        return (base * height) / 2;
    }

    public String toString() {
        return this.getName() + " (" + base + "x" + height + ") " + "triangle";
    }
}
