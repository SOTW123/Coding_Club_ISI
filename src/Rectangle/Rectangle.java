package Rectangle;

public class Rectangle {
    // instance variables + constructor
    private int height;
    private int width;

    Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    // area + perimeter methods
    public int area() {
        return height * width;
    }
    public int perimeter() {
        return (2 * height) + (2 * width);
    }

    // getters and setters
    public void setHeight(int height) {
        this.height = height;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
}
