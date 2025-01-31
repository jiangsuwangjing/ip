package alex.command;

import alex.*;
import alex.task.*;
import alex.exceptions.*;

/**
 * The general command class
 */
abstract public class Command {
    /**
     * Executes the command
     * @param tasks the task list to operate on
     * @param ui
     * @param storage
     */
    abstract public void execute(TaskList tasks, Ui ui, Storage storage);

    /**
     * Returns if the command is a exit command
     * @return
     */
    public boolean isExit() {
        return false;
    }
}
