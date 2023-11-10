package TheCarShop;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Application app = new Application();
        while(true) {
            app.run();
            System.out.println("----------------------------------------------------------------------------");
        }
    }
}
