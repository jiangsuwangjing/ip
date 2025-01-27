import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private ArrayList<Task> list;
    private Ui ui = new Ui();
    private Storage storage = new Storage();

    public TaskList() {
        this.list = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> list) {
        this.list = list;
    }

    public void addItem(Task task) {
        list.add(task);
        int itemCount = list.size();
        ui.addItemResponse(task.toString(), itemCount);
        storage.saveData(task.getSavedDataFormat());
    }

    public void displayList() {
        System.out.println("Here are the tasks in your list");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d.%s\n", i + 1, list.get(i).toString());
        }
    }

    public void mark(int index, boolean isDone) throws ListOutOfBoundException {
        if (index >= list.size() || index < 0) {
            throw new ListOutOfBoundException();
        }
        String responseMsg = list.get(index - 1).setStatus(isDone);
        System.out.printf(responseMsg);
    }

    public void delete(int index) throws ListOutOfBoundException {
        if (index >= list.size() || index < 0) {
            throw new ListOutOfBoundException();
        }
        try {
            String task = list.remove(index - 1).toString();
            System.out.println("Noted, I've removed this task:");
            System.out.println(task);
            ui.printTaskCount(list.size());
            storage.deleteLineFromFile(index);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Integer i = 1; i <= list.size(); i++) {
            str.append(i.toString() + ". " + list.get(i - 1).toString());
            str.append("\n");
        }
        return str.toString();
    }
}
