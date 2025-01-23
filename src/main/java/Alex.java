import java.util.ArrayList;
import java.util.Scanner;

public class Alex {
    private static final String exitCommand = "bye";
    private static final String displayCommand = "list";

    private static TaskList list = new TaskList();

//    private static ArrayList<Task> list = new ArrayList<>();

//    private static void echo(String input) {
//        System.out.println("____________________________________________________________");
//        System.out.println(input);
//        System.out.println("____________________________________________________________");
//    }
//
//    private static void displayList() {
//        for (int i = 0; i < list.size(); i++) {
//            System.out.printf("%d. %s", i + 1, list.get(i).toString());
//        }
//    }
//
//    private static void addItem(String input) {
//        Task task = new Task(input);
//        list.add(task);
//        System.out.printf("added: %s\n", input);
//    }
//
//    private static void mark(int index, boolean isDone) {
//        System.out.println("____________________________________________________________");
//        String responseMsg = list.get(index - 1).setStatus(isDone);
//        System.out.printf(responseMsg);
//    }

    public static void main(String[] args) {
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Alex.\nWhat can I do for you?");
        System.out.println("____________________________________________________________");
        System.out.println("I will keep track of what you said! Say \"list\" to check.");
        System.out.println("Say \"bye\" if you are leaving...");
        System.out.println("____________________________________________________________");

        // Echo Function
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        while (!inputStr.equals(exitCommand)) {
            // Separator under user's input
            System.out.println("____________________________________________________________");
            if (inputStr.equals(displayCommand)) {
                list.displayList();
            } else if (inputStr.length() > 4 && inputStr.substring(0, 5).equals("mark ")) {
                String indexStr = inputStr.substring(5);
                int index = Integer.parseInt(indexStr);
                list.mark(index, true);
            } else if (inputStr.length() > 6 && inputStr.substring(0, 7).equals("unmark ")) {
                String indexStr = inputStr.substring(7);
                int index = Integer.parseInt(indexStr);
                list.mark(index, false);
            } else {
                list.addItem(inputStr);
            }
            // Separator under response
            System.out.println("____________________________________________________________");
            inputStr = scanner.nextLine();
        }

        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}
