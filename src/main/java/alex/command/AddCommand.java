package alex.command;

import alex.*;
import alex.task.*;
import alex.exceptions.*;

public class AddCommand extends Command {
    Task task;

    public AddCommand(Task task) {
        this.task = task;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.addItem(task, ui, storage);
    }
}
