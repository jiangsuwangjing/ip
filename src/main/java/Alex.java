import java.util.Scanner;

public class Alex {
    private static final String exitCommand = "bye";

    private static void echo(String input) {
        System.out.println("____________________________________________________________");
        System.out.println(input);
        System.out.println("____________________________________________________________");
    }
    public static void main(String[] args) {
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Alex.\nWhat can I do for you?");
        System.out.println("____________________________________________________________");
        System.out.println("Say something and I will echo your words!\nSay \"bye\" if you are leaving...");
        System.out.println("____________________________________________________________");

        // Echo Function
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        while (!inputStr.equals(exitCommand)) {
            echo(inputStr);
            inputStr = scanner.nextLine();
        }

        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}
