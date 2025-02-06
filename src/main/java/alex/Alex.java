package alex;

import alex.command.Command;
import alex.task.TaskList;


/**
 * The main program of Alex
 */
public class Alex {
    private TaskList tasks;
    private Storage storage;
    private Ui ui;

    public Alex(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = storage.load();
    }

    /**
     * The main execution logic
     */
    public void run() {
        ui.printWelcomeMsg();
        boolean isExit = false;
        while (!isExit) {
            try {
                String inputStr = ui.readCommand();
                ui.printDivider();
                Command command = Parser.parse(inputStr, tasks);
                command.execute(tasks, ui, storage);
                isExit = command.isExit();
            } catch (Exception e) {
                ui.showErrorMsg(e);
            } finally {
                // Separator under response
                ui.printDivider();
            }
        }
    }

    public static void main(String[] args) {
        new Alex("data/alex.txt").run();
    }
}
