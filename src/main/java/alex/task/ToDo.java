package alex.task;

public class ToDo extends Task {
    public ToDo (String content) {
        super(content);
    }

    public ToDo(String content, String status) {
        super(content, status);
    }

    @Override
    public String getSavedDataFormat() {
        return "T | " + super.getSavedDataFormat() + "\n";
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
