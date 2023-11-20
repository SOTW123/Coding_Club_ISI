package ToDoListApp;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MethodLibrary {
    static Application app = new Application();
    static MethodLibrary m = new MethodLibrary();
    public void exportData(ArrayList<Task> e) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("tasklist.txt", true));
        // number of runs
        setNumberOfRuns(app.numRuns);

        for (int i = getNumberOfRuns(); i < e.size(); i++) {
            writer.write("# " + e.get(i).getTaskName() + "\n");
            writer.write("## " + e.get(i).getDueDate() + "\n");
            writer.write("### " + e.get(i).getNote() + "\n");
        }
        // * name
        // ** date
        // *** note
        writer.close();
    }
    public int getNumberOfRuns() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("numberOfRuns.txt"));
        int value = 0;
        String currLine;
        while((currLine = reader.readLine()) != null) {
           value = Integer.parseInt(currLine);
        }
        return value;
    }
    public void setNumberOfRuns(int a) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("numberOfRuns.txt", true));
        int value = getNumberOfRuns();
        a += value;
        writer.write(a + "\n");
        writer.close();
        //writer.write();
    }




}
