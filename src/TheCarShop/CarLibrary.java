package TheCarShop;

public class CarLibrary {
    public static boolean isBrandValid(String brand) {
        String[] carBrands = {
                "Toyota",
                "Ford",
                "Honda",
                "Chevrolet",
                "BMW",
                "Mercedes-Benz",
                "Volkswagen",
                "Nissan",
                "Audi",
                "Hyundai"
        };

        for(String validBrand : carBrands) {
            if(brand.equals(validBrand)) {
                return true;
            }
        }
        return false;
    }
    public static String capitalizeInput(String input) {
        return input.toUpperCase();
    }
    public static boolean isColorValid(String color) {
        String[] colors = {
                "Red",
                "Blue",
                "Green",
                "Yellow",
                "Purple",
                "Orange",
                "Pink",
                "Brown",
                "Black",
                "White"
        };
        for (String validColor : colors) {
            if(color.equals(validColor)) {
                return true;
            }
        }
        return false;
    }




}
