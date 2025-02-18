package alex.command;

import alex.Storage;
import alex.Ui;
import alex.task.TaskList;

public class MarkCommand extends Command {
    private int index;
    private boolean markDone;
    private int[] range;

    public MarkCommand(int index, boolean markDone) {
        this.index = index;
        this.markDone = markDone;
    }

    public MarkCommand(int start, int end, boolean markDone) {
        this.range = new int[]{start, end};
        this.markDone = markDone;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        if (range != null) {
            tasks.mark(range, markDone, ui, storage);
            return;
        }
        tasks.mark(index, markDone, ui, storage);
    }

    public static Command parseMark(String inputStr, TaskList tasks) throws Exception {
        String indexStr = inputStr.substring(5);
        if (indexStr.contains("-")) {
            String[] range = indexStr.split("-");
            int start = Integer.parseInt(range[0]);
            int end = Integer.parseInt(range[1]);
            tasks.checkInBound(start);
            tasks.checkInBound(end);

            if (start > end) {
                return new MarkCommand(end, start, true);
            }
            return new MarkCommand(start, end, true);
        }
        int index = Integer.parseInt(indexStr);
        tasks.checkInBound(index);
        return new MarkCommand(index, true);
    }

    public static Command parseUnmark(String inputStr, TaskList tasks) throws Exception {
        String indexStr = inputStr.substring(7);
        if (indexStr.contains("-")) {
            String[] range = indexStr.split("-");
            int start = Integer.parseInt(range[0]);
            int end = Integer.parseInt(range[1]);
            tasks.checkInBound(start);
            tasks.checkInBound(end);
            return new MarkCommand(start, end, false);
        }
        int index = Integer.parseInt(indexStr);
        tasks.checkInBound(index);
        return new MarkCommand(index, false);
    }

}
