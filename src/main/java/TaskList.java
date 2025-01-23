import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private ArrayList<Task> list;

    public TaskList() {
        this.list = new ArrayList<>();
    }

    public void addItem(Task task) {
        list.add(task);
        System.out.printf("Ok I've added this task:\n%s\n", task.toString());
    }

    public void displayList() {
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
        String task = list.remove(index).toString();
        System.out.println("Noted, I've removed this task:");
        System.out.println(task);
        System.out.printf("Now you have %d tasks in the list.\n", list.size());
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
