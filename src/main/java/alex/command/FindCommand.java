package alex.command;

import alex.*;
import alex.task.*;

import java.util.ArrayList;

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
}
