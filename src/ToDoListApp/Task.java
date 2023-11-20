package ToDoListApp;

public class Task {
    private String taskName;
    private String dueDate;
    private String note;
    Task(String taskName, String dueDate, String note) {
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.note = note;
    }

    // Getters

    public String getTaskName() {
        return taskName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getNote() {
        return note;
    }
    public String getAll() { return taskName + ", " + dueDate + ", " + note; }
    // Setters

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    // Adder
    public void addNote(String note) {
        //StringBuilder sb = new StringBuilder(note);
        //sb.append(this.note);
        this.note += note;
    }
}
