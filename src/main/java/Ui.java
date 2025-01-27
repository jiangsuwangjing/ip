public class Ui {
    public void printWelcomeMsg() {
        System.out.println("""
                ____________________________________________________________
                Hello! I'm Alex.
                What can I do for you?
                ____________________________________________________________
                I will keep track of what you said! Say \"list\" to check.
                Say \"bye\" if you are leaving...
                ____________________________________________________________
                """);
    }

    public void printDivider() {
        System.out.println("____________________________________________________________");
    }

    public void printExitMsg() {
        printDivider();
        System.out.println("Bye. Hope to see you again soon!");
        printDivider();
    }

    public void printTaskCount(int count) {
        System.out.printf("Now you have %d tasks in the list.\n", count);
    }

    public void addItemResponse(String task, int count) {
        System.out.printf("Ok I've added this task:\n%s\n", task);
        printTaskCount(count);
    }
}
