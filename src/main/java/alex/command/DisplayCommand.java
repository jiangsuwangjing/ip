package alex.command;

import alex.*;
import alex.task.*;
import alex.exceptions.*;

public class DisplayCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.displayList();
    }
}
