public class Deadline extends Task {
    private String time;

    public Deadline (String content, String time) {
        super(content);
        this.time = time.trim();
    }

    @Override
    public String getSavedDataFormat() {
        return "D | " + super.getSavedDataFormat() + " | " + this.time + "\n";
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by: " + time + ")";
    }
}
