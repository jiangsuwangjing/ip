package alex;

import alex.task.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    private Scanner scanner = new Scanner(System.in);

    public void printWelcomeMsg() {
        printDivider();
        System.out.println("Hello! I'm Alex.\n What can I do for you?");
        printDivider();
        System.out.println("I will keep track of what you said! Say \"list\" to check.\nSay \"bye\" if you are leaving...");
        printDivider();
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void printDivider() {
        System.out.println("____________________________________________________________");
    }

    public void printExitMsg() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public void printTaskCount(int count) {
        System.out.printf("Now you have %d tasks in the list.\n", count);
    }

    public void addItemResponse(String task, int count) {
        System.out.printf("Ok I've added this task:\n%s\n", task);
        printTaskCount(count);
    }

    public void showErrorMsg(Exception e) {
        System.out.println(e.getMessage());
    }

    public void showSearchResult(ArrayList<Task> result) {
        if (result.size() == 0) {
            System.out.println("Sorry, there are no matching results.");
        } else {
            System.out.println("Here are the matching tasks in your list:");
            int count = 1;
            for (Task task: result) {
                System.out.println(count + "." + task);
            }
        }
    }
    public void showLoadingError() {
        System.out.println("There is something wrong with loading the data...");
    }
}
