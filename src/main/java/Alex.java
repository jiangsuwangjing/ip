import java.util.ArrayList;
import java.util.Scanner;

public class Alex {
    private static final String exitCommand = "bye";
    private static final String displayCommand = "list";
    private static ArrayList<String> list = new ArrayList<>();

    private static void echo(String input) {
        System.out.println("____________________________________________________________");
        System.out.println(input);
        System.out.println("____________________________________________________________");
    }

    private static void displayList() {
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, list.get(i));
        }
    }

    private static void addItem(String input) {
        list.add(input);
        System.out.printf("added: %s\n", input);
    }
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
            System.out.println("____________________________________________________________");
            if (inputStr.equals(displayCommand)) {
                displayList();
            } else {
                addItem(inputStr);
            }
            System.out.println("____________________________________________________________");
            inputStr = scanner.nextLine();
        }

        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}
