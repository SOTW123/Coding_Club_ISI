package TheCarShop;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static TheCarShop.CarLibrary.isBrandValid;
import static TheCarShop.CarLibrary.isColorValid;

public class Application {
    Car car1 = null;

    ArrayList<Car> carsList = new ArrayList<>();
    ArrayList<String> namesList = new ArrayList<>();
    HashMap<String, Car> dataBase = new HashMap<>();

    public void run() {
        System.out.println("Options: 'Buy Car', 'Car Info', 'Exit'");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        if(input.equals("Buy Car")) {
            System.out.print("Brand: "); String brand = scan.nextLine();
            System.out.print("Color: "); String color = scan.nextLine();
            System.out.print("Model Number: "); String modelNumber = scan.nextLine();
                if(isBrandValid(brand) && isColorValid(color)) {
                    System.out.println("Please type the name of your car for our database.");
                    String name = scan.nextLine();
                    namesList.add(name);
                    car1 = new Car(brand, color, modelNumber);
                    carsList.add(new Car(brand, color, modelNumber));
                    dataBase.put(name, car1);
                } else {
                    System.out.println("Invalid Brand/Color");
                }
        } else if(input.equals("Car Info")) {
            if(car1 == null) {
                System.out.println("no car purchased");
            } else {
                System.out.println("Which car would you like to get the info for?");
                for(int i = 0; i < carsList.size(); i++) {
                    System.out.println("    - " + namesList.get(i));
                    //System.out.println("    -" + "(" + (i+1) + ") " + carsList.get(i).getBrand() + ", " + carsList.get(i).getColor() + ", " + carsList.get(i).getModelNumber());
                }
                String inp = scan.nextLine();
                System.out.println(dataBase.get(inp).getInfo());
            }

        } else if(input.equals("Exit")) {
            System.exit(0);
        } else {
            System.out.println("Remember Java is Case-Sensitive");
        }

    }
}
