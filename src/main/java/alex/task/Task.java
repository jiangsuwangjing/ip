package alex.task;

/**
 * The general class of all tasks
 */
public class Task {
    private String content;
    private boolean status;

    public Task(String content) {
        this.content = content.trim();
        this.status = false;
    }

    public Task(String content, boolean status) {
        this.content = content;
        this.status = status;
    }

    // Constructor with String status, 1 for done and 0 for not done
    public Task(String content, String status) {
        this(content, status.equals("1"));
    }

    public String getContent() {
        return this.content;
    }

    public boolean isDone() {
        return this.status;
    }

    /**
     * Get the incomplete format to be saved in storage for subclasses
     * @return data to be saved
     */
    public String getSavedDataFormat() {
        String statusRep = status ? "1" : "0";
        return statusRep + " | " + this.content;
    }

    /**
     * Change the current status of completion
     * @param isSetDone the target status
     * @return the reponse message to be printed
     */
    public String setStatus(boolean isSetDone) {
        if (isSetDone) {
            this.status = true;
            return ("Nice! I've marked this task as done:\n" + this.toString() + "\n");
        } else {
            this.status = false;
            return ("Ok, I've marked this task as not done yet:\n" + this.toString() + "\n");
        }
    }

    @Override
    public String toString() {
        String checkBox = "[ ] ";
        if (this.isDone()) {
            checkBox = "[X] ";
        }
        return checkBox + getContent();
    }
}
