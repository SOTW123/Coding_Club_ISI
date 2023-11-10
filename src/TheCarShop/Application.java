package TheCarShop;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static TheCarShop.CarLibrary.isBrandValid;
import static TheCarShop.CarLibrary.isColorValid;

public class Application {
    Car car1 = null;

    ArrayList<Car> carsList = new ArrayList<>();
    ArrayList<String> namesList = new ArrayList<>();
    ArrayList<String> extendedNamesList = new ArrayList<>();
    HashMap<String, Car> dataBase = new HashMap<>();

    BufferedWriter writer;
    BufferedReader reader;
    String input;
    public boolean isNameValid(String name) throws IOException {

        String currLine3;
        while ((currLine3 = reader.readLine()) != null) {
            if (!(currLine3.contains("*")) && !(currLine3.contains("**")) && !(currLine3.contains("***"))) {
                extendedNamesList.add(currLine3);
            }
        }

        for (int i = 0; i < extendedNamesList.size(); i++) {
            if(name.equals(extendedNamesList.get(i))) {
                System.out.println("This name already exists in our database");
                return false;
            }
        }
        return true;
    }
    public void run() throws IOException {
        writer = new BufferedWriter(new FileWriter("database.txt", true));
        reader = new BufferedReader(new FileReader("database.txt"));
        // -------------------------------------------------------------- //
        System.out.println("Options: 'Buy Car', 'Car Info', 'Exit', 'Settings'");
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();

        if (input.equals("Buy Car")) {
            System.out.print("Brand: ");
            String brand = scan.nextLine();
            System.out.print("Color: ");
            String color = scan.nextLine();
            System.out.print("Model Number: ");
            String modelNumber = scan.nextLine();

            System.out.println("Please type the name of your car for our database.");
            String name = scan.nextLine();

            if (isBrandValid(brand) && isColorValid(color) && isNameValid(name)) {
                namesList.add(name);
                car1 = new Car(brand, color, modelNumber);
                carsList.add(new Car(brand, color, modelNumber));
                dataBase.put(name, car1);

                writer.write(name);
                writer.write("\n*" + car1.getBrand());
                writer.write("\n**" + car1.getColor());
                writer.write("\n***" + car1.getModelNumber());
                writer.write("\n");


            } else {
                System.out.println("Invalid Brand/Color/Name");
            }
        } else if (input.equals("Car Info")) {
            boolean isAllowed = false;
            if (!namesList.isEmpty()) {
                System.out.println("Which car would you like to get the info for?");

                for (int i = 0; i < carsList.size(); i++) {
                    System.out.println("    - " + namesList.get(i));
                    //System.out.println("    -" + "(" + (i+1) + ") " + carsList.get(i).getBrand() + ", " + carsList.get(i).getColor() + ", " + carsList.get(i).getModelNumber());
                }
                System.out.println("Note: If you don't find your car on this list, feel free to take a look at our extended database; 'Y' for access.");
                System.out.println("      OR if your car is on the list above, please type the name of your car!");
                String access = scan.nextLine();
                if(access.equals("Y")) {
                    isAllowed = true;
                } else if(!access.equals("Y")) {
                    try{
                        System.out.println(dataBase.get(access).getInfo());
                    } catch(NullPointerException e) {
                        System.out.println("not in current database");
                    }
                } else {
                    System.out.println("error");
                }
            }
            if (namesList.isEmpty() || isAllowed) {
                System.out.println("You haven't bought a car yet ... No worries - you can always check our extended database.");

                String currLine;
                while ((currLine = reader.readLine()) != null) {
                    if (!(currLine.contains("*")) && !(currLine.contains("**")) && !(currLine.contains("***"))) {
                        System.out.println("    - " + currLine);
                    }
                }

                BufferedReader reader2 = new BufferedReader(new FileReader("database.txt"));

                String inp2 = scan.nextLine();
                String currBrand = "";
                String currColor = "";
                String currModelNumber = "";

                int line = 0;
                int maxLines = 0;
                BufferedReader reader3 = new BufferedReader(new FileReader("database.txt"));
                while (reader3.readLine() != null) maxLines++;
                reader3.close();

                String currLine2;
                while ((currLine2 = reader2.readLine()) != null) {
                    for (int i = 0; i < maxLines; i += 4) {
                        if (inp2.equals(Files.readAllLines(Paths.get("database.txt")).get(line))) {
                            currBrand = (Files.readAllLines(Paths.get("database.txt")).get(line + 1)).replaceAll("\\*", "");
                            currColor = (Files.readAllLines(Paths.get("database.txt")).get(line + 2)).replaceAll("\\*", "");
                            currModelNumber = (Files.readAllLines(Path.of("database.txt")).get(line + 3)).replaceAll("\\*", "");
                        }

                    }
                    line++;
                }

                System.out.println("Brand: " + currBrand + "\nColor: " + currColor + "\nModel Number: " + currModelNumber);
            }
        }
        else if(input.equals("Exit")) {
            System.exit(0);
        } else if(input.equals("Settings")) {
            System.out.println("Welcome to administrative settings.");
            System.out.println("    Options: ");
            System.out.println("        - Delete Extended Database");

            String admin = scan.nextLine();
            if(admin.equals("Delete Extended Database")) {
                System.out.println("Note: You are about to delete the entire existing database of all cars created in the history of cars. Are you sure about that? 'Y' or 'N'");
                String destroy = scan.nextLine();
                if(destroy.equals("Y")) {
                    Files.newBufferedWriter(Paths.get("database.txt"), StandardOpenOption.TRUNCATE_EXISTING);
                } else if (destroy.equals("N")) {
                    System.out.println("Good idea.");
                } else {
                    System.out.println("that was NOT 'Y' or 'N'");
                }
            }
        }
        else {
            System.out.println("Remember Java is Case-Sensitive");
        }
        writer.close();
    }

}
