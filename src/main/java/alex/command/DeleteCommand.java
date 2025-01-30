package alex.command;

import alex.*;
import alex.task.*;
import alex.exceptions.*;

public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.delete(this.index, ui, storage);
    }
}
