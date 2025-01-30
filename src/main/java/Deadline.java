import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    private String timeStr;
    private LocalDate time;


    public Deadline (String content, String time) {
            super(content);
            this.timeStr = time;
    }

    public Deadline (String content, String status, String time) {
        super(content, status);
        this.timeStr = time;
    }

    public boolean isValidDateFormat() {
        try {
            time = LocalDate.parse(timeStr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String getSavedDataFormat() {
        return "D | " + super.getSavedDataFormat() + " | " + this.timeStr + "\n";
    }

    @Override
    public String toString() {
        if (isValidDateFormat()) {
            return "[D]" + super.toString() + " (by: " + time.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
        }
        return "[D]" + super.toString() + " (by: " + timeStr + ")";

    }
}
