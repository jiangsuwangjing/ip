package alex.command;

import alex.*;
import alex.task.*;
import alex.exceptions.*;

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
}
