package alex;

import java.util.Scanner;

public class Ui {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Prints the welcome message when launching the program
     */
    public void printWelcomeMsg() {
        printDivider();
        System.out.println("Hello! I'm Alex.\n What can I do for you?");
        printDivider();
        System.out.println("I will keep track of what you said! Say \"list\" to check.\nSay \"bye\" if you are leaving...");
        printDivider();
    }

    /**
     * Reads a line from input
     * @return the command read
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Prints divider that separates input and output
     */
    public void printDivider() {
        System.out.println("____________________________________________________________");
    }

    /**
     * Prints message when user exits program
     */
    public void printExitMsg() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    /**
     * Prints how many tasks there are
     * @param count number of tasks
     */
    public void printTaskCount(int count) {
        System.out.printf("Now you have %d tasks in the list.\n", count);
    }

    /**
     * Prints the response message when a task is added
     * @param task task details
     * @param count the count after adding the task
     */
    public void addItemResponse(String task, int count) {
        System.out.printf("Ok I've added this task:\n%s\n", task);
        printTaskCount(count);
    }

    /**
     * Shows the error message when getting the error
     * @param e
     */
    public void showErrorMsg(Exception e) {
        System.out.println(e.getMessage());
    }

    public void showLoadingError() {
        System.out.println("There is something wrong with loading the data...");
    }
}
