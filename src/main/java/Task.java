public class Task {
    private String content;
    private boolean isDone;

    public Task(String content) {
        this.content = content;
        this.isDone = false;
    }

    public String setStatus(boolean isSetDone) {
        if (isSetDone) {
            this.isDone = true;
        } else {
            this.isDone = false;
        }
        return ("Nice! I've marked this task as done:\n" + this.toString());

    }

    @Override
    public String toString() {
        String checkBox = "[ ] ";
        if (isDone) {
            checkBox = "[X] ";
        }
        return checkBox + content + "\n";
    }
}
