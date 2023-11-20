package ToDoListApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Application {
    Scanner scan = new Scanner(System.in);
    static Application app = new Application();
    static MethodLibrary ml = new MethodLibrary();

    public boolean exit = false;
    ArrayList<Task> taskList = new ArrayList<>();

    int numRuns = 0;
    public void importData(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        // number of runs

        System.out.println("1");
        String currLine;
        String name = "";
        String date = "";
        String note = "";
        int line = 0;
        while((currLine = reader.readLine()) != null) {
            char[] chars = currLine.toCharArray();
            if(chars[0] == '#' && chars[1] == ' ') {
                name = currLine.replaceAll("# ", "");
            } else if(chars[0] == '#' && chars[1] == '#' && chars[2] == ' ') {
                date = currLine.replaceAll("## ", "");
            } else if(chars[0] == '#' && chars[1] == '#' && chars[2] == '#' && chars[3] == ' ') {
                note = currLine.replaceAll("### ", "");
            }
            line++;
            if(line % 3 == 0) {
                taskList.add(new Task(name, date, note));
            }
        }
        reader.close();
    }


    // run 1
        // ran twice
            // numRuns = 2;
    // run 2
        // ran thrice
            // numRuns = 5


    // instead of temporary and extended database how about lets just have one database on txt
        // at the beginning of every run we have to make a new arraylist calling everything from txt file
    // first time use you make hashmap and file new
    // after that you use importData method -> use setters
    public void run() throws IOException {
        System.out.println("Options: 'Add', 'Complete', 'Get List', 'Exit' ");
        String options = scan.nextLine();
        switch(options) {
            case "Add":
                app.add();
                break;
            case "Complete":
                app.complete();
                break;
            case "Get List":
                app.getList();
                break;
            case "Exit":
                exit = true;
                break;
        }
        if(exit) {
            ml.exportData(app.taskList);
        }
        numRuns++;
    }

    public void add() {
        System.out.print("Name: ");
            String name = scan.nextLine();

        System.out.print("Date: ");
            String date = scan.nextLine();

        System.out.print("Note: ");
            String note = scan.nextLine();

        taskList.add(new Task(name, date, note));
    }
    public void complete() throws IOException {
        app.getList();
        System.out.println("Which task did you complete?");
        int taskNumber = scan.nextInt();
        taskList.remove(taskNumber-1);
    }
    int run = 0;
    public void getList() throws IOException {
        if(run == 0) {
            app.importData("tasklist.txt");
            run++;
        }
        if(taskList.isEmpty()) {
            System.out.println("Empty List");
            return;
        }
        for(int i = 0; i < taskList.size(); i++) {
            String sum = taskList.get(i).getTaskName() + ", due on " + taskList.get(i).getDueDate() + "\n       Note: \n            " + taskList.get(i).getNote();
            System.out.println("(" + (i+1) + ") " + sum);
        }
    }

}
