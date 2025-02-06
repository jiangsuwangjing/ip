package alex.command;

import alex.Storage;
import alex.Ui;
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
}
