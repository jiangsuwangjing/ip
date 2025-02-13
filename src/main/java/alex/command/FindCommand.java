package alex.command;

import java.util.ArrayList;

import alex.Storage;
import alex.Ui;
import alex.task.Task;
import alex.task.TaskList;

public class FindCommand extends Command {
    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ArrayList<Task> result = tasks.findTasks(this.keyword);
        ui.showSearchResult(result);
    }

    public static Command parseFind(String inputStr) {
        String keyword = inputStr.substring(5);
        return new FindCommand(keyword);
    }
}
