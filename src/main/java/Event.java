public class Event extends Task {
    private String startTime;
    private String endTime;

    public Event(String content, String start, String end) {
        super(content);
        this.startTime = start;
        this.endTime = end;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + startTime + " to " + endTime + ")";
    }
}
