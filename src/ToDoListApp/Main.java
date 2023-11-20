package ToDoListApp;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

public class Main {



    public static void main(String[] args) throws IOException {
        // 11/18/2023 - remember to do the thingy mabob KD college apps
        // find out why we need numRuns.
        // try calling getList(). the goal is to make it so that it calls from the tasklist and creates an arraylist of all prev tasks
        // unlike before when we had to make an extended and available databse, we are tryna have just one database :tasklist
        // even if its not one from our side we want the user to not know about two databases


        Application app = new Application();
        MethodLibrary ml = new MethodLibrary();

        while(true) {
            app.run();
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            if(app.exit) {
                break;
            }
        }
    }
}
