public class Task {
    private String content;
    private boolean status;

    public Task(String content) {
        this.content = content;
        this.status = false;
    }

    public String getContent() {
        return this.content;
    }

    public boolean isDone() {
        return this.status;
    }

    public String setStatus(boolean isSetDone) {
        if (isSetDone) {
            this.status = true;
            return ("Nice! I've marked this task as done:\n" + this.toString() + "\n");
        } else {
            this.status = false;
            return ("Ok, I've marked this task as not done yet" + this.toString() + "\n");
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
