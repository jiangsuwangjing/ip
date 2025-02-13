package alex.task;

public class Event extends Task {
    private String startTime;
    private String endTime;

    /**
     * Constructor for new event
     * @param content task details
     * @param start start time
     * @param end end time
     */
    public Event(String content, String start, String end) {
        super(content);

        assert content != null : "Content should not be null";
        assert start != null : "Start time should not be null";
        assert end != null : "End time should not be null";

        this.startTime = start.trim();
        this.endTime = end.trim();
    }

    /**
     * Constructor for loading existing event
     * @param content task details
     * @param status if the status is done
     * @param start start time
     * @param end end time
     */
    public Event(String content, String status, String start, String end) {
        super(content, status);

        assert content != null : "Content should not be null";
        assert start != null : "Start time should not be null";
        assert end != null : "End time should not be null";

        this.startTime = start.trim();
        this.endTime = end.trim();
    }

    @Override
    public String getSavedDataFormat() {
        return "E | " + super.getSavedDataFormat() + " | " + startTime + " | " + endTime + "\n";
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + startTime + " to: " + endTime + ")";
    }
}
