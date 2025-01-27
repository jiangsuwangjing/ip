public class ToDo extends Task {
    public ToDo (String content) {
        super(content);
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
