package alex.command;

import alex.Storage;
import alex.Ui;
import alex.task.TaskList;

public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.delete(this.index, ui, storage);
    }

    public static Command parseDelete(String inputStr, TaskList tasks) throws Exception {
        String indexStr = inputStr.substring(7);
        int index = Integer.parseInt(indexStr);
        tasks.checkInBound(index);
        return new DeleteCommand(index);
    }
}
