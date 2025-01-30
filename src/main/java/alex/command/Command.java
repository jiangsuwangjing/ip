package alex.command;

import alex.*;
import alex.task.*;
import alex.exceptions.*;

abstract public class Command {
    abstract public void execute(TaskList tasks, Ui ui, Storage storage);
    public boolean isExit() {
        return false;
    }
}
