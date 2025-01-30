import java.util.Scanner;

public class Ui {
    private Scanner scanner = new Scanner(System.in);

    public void printWelcomeMsg() {
        System.out.print("""
                ____________________________________________________________
                Hello! I'm Alex.
                What can I do for you?
                ____________________________________________________________
                I will keep track of what you said! Say \"list\" to check.
                Say \"bye\" if you are leaving...
                ____________________________________________________________
                """);
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

    public void showErrorMsg(String msg) {
        System.out.println(msg);
    }

    public void showLoadingError() {
        System.out.println("There is something wrong with loading the data...");
    }
}
