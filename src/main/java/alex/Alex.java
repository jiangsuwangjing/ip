package alex;

import alex.command.Command;
import alex.task.TaskList;
import alex.ui.MainWindow;


/**
 * The main program of Alex
 */
public class Alex {
    private TaskList tasks;
    private Storage storage;
    private Ui ui;

    public Alex(String filePath) {
        storage = new Storage(filePath);
        tasks = storage.load();
    }

    public void setUi(Ui ui) {
        this.ui = ui;
    }

    /**
     * The main execution logic
     */
//    public void run() {
//        ui.printWelcomeMsg();
//        boolean isExit = false;
//        while (!isExit) {
//            try {
//                String inputStr = ui.readCommand();
//                Command command = Parser.parse(inputStr, tasks);
//                command.execute(tasks, ui, storage);
//                isExit = command.isExit();
//            } catch (Exception e) {
//                ui.showErrorMsg(e);
//            }
//        }
//    }

    public void run(String inputStr) {
        try {
            Command command = Parser.parse(inputStr, tasks);
            command.execute(tasks, ui, storage);
        } catch (Exception e) {
            ui.showErrorMsg(e);
        }
    }

    public static void main(String[] args) {
        new Alex("data/alex.txt").run("");
    }
}
