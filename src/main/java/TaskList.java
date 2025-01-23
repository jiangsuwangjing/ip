import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Task> list;

    public TaskList() {
        this.list = new ArrayList<>();
    }

    public void addItem(String input) {
        Task task = new Task(input);
        list.add(task);
        System.out.printf("added: %s\n", input);
    }

    public static void displayList() {
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d.%s", i + 1, list.get(i).toString());
        }
    }

    public static void mark(int index, boolean isDone) {
        System.out.println("____________________________________________________________");
        String responseMsg = list.get(index - 1).setStatus(isDone);
        System.out.printf(responseMsg);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Integer i = 1; i <= list.size(); i++) {
            str.append(i.toString() + ". " + list.get(i - 1).toString());
        }
        return str.toString();
    }
}
