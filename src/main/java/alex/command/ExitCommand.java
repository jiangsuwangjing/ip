package alex.command;

import alex.*;
import alex.task.*;
import alex.exceptions.*;

public class ExitCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.printExitMsg();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
