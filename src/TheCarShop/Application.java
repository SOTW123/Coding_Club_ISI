package TheCarShop;

import java.util.Scanner;

public class Application {
    Car car1 = null;

    public void run() {
        System.out.println("Options: 'Buy Car', 'Car Info', 'Exit'");

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        if(input.equals("Buy Car")) {
            System.out.print("Brand: "); String brand = scan.nextLine();
            System.out.print("Color: "); String color = scan.nextLine();
            System.out.print("Model Number: "); String modelNumber = scan.nextLine();
            car1 = new Car(brand, color, modelNumber);
        } else if(input.equals("Car Info")) {
            if(car1 == null) {
                System.out.println("no car purchased");
            } else {
                System.out.println(car1.getInfo());
            }

        } else if(input.equals("Exit")) {
            System.exit(0);
        } else {
            System.out.println("Remember Java is Case-Sensitive");
        }

    }
}
