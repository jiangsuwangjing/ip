package alex.command;

import alex.Storage;
import alex.Ui;
import alex.task.TaskList;

public class MarkCommand extends Command {
    private int index;
    private boolean markDone;

    public MarkCommand(int index, boolean markDone) {
        this.index = index;
        this.markDone = markDone;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.mark(index, markDone, ui, storage);
    }

    public static Command parseMark(String inputStr, TaskList tasks) throws Exception {
        String indexStr = inputStr.substring(5);
        int index = Integer.parseInt(indexStr);
        tasks.checkInBound(index);
        return new MarkCommand(index, true);
    }

    public static Command parseUnmark(String inputStr, TaskList tasks) throws Exception {
        String indexStr = inputStr.substring(7);
        int index = Integer.parseInt(indexStr);
        tasks.checkInBound(index);
        return new MarkCommand(index, false);
    }

}
