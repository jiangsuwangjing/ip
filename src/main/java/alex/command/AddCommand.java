package alex.command;

import alex.Storage;
import alex.Ui;
import alex.task.Deadline;
import alex.task.Event;
import alex.task.Task;
import alex.task.TaskList;

public class AddCommand extends Command {
    private Task task;

    public AddCommand(Task task) {
        this.task = task;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.addItem(task, ui, storage);
    }

    public static Command parseTodo(String inputStr) {
        return new AddCommand(new Task(inputStr.substring(5)));
    }
    public static Command parseEvent(String inputStr) {
        int startIndex = inputStr.indexOf("/from");
        String content = inputStr.substring(6, startIndex);
        int endIndex = inputStr.indexOf("/to");
        String startTime = inputStr.substring(startIndex + 6, endIndex - 1);
        String endTime = inputStr.substring(endIndex + 4);
        return new AddCommand(new Event(content, startTime, endTime));
    }

    public static Command parseDeadline(String inputStr) {
        int timeIndex = inputStr.indexOf("/by");
        String content = inputStr.substring(9, timeIndex);
        return new AddCommand(new Deadline(content, inputStr.substring(timeIndex + 4)));
    }
}
