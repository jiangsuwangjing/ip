import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    private LocalDate time;

    public Deadline (String content, String time) {
        super(content);
        this.time = LocalDate.parse(time);
    }

    public Deadline (String content, String status, String time) {
        super(content, status);
        this.time = LocalDate.parse(time);
    }

    @Override
    public String getSavedDataFormat() {
        return "D | " + super.getSavedDataFormat() + " | " + this.time + "\n";
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + time.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }
}
