package TheCarShop;

public class Car {
    // variables + constructor
    private String brand;
    private String color;
    private String modelNumber;
    Car(String brand, String color, String modelNumber) {
        this.brand = brand;
        this.color = color;
        this.modelNumber = modelNumber;
    }

    // setters
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    // getters
    public int getPrice() {
        int brandFee = 0;
        int colorFee = 10;
        if(color.equals("White") || color.equals("Black")) {
            colorFee = 5;
        }
        switch(brand) {
            case "Toyota":
                brandFee = 10000;
                break;
            case "Honda":
                brandFee = 25000;
                break;
            case "Tesla":
                brandFee = 50000;
                break;
        }
        return brandFee + colorFee;
    }
    public String getInfo() {
        return "Brand: " + brand + "\nColor: " + color + "\nModel Number: " + modelNumber;
    }

}
