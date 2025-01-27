import java.util.Scanner;

public class Alex {
    private static final String exitCommand = "bye";
    private static final String displayCommand = "list";

    private static TaskList list;
    private enum Command {
        DISPLAY, MARK, UNMARK, TODO, DEADLINE, EVENT, DELETE, EXIT
    }

    private static Command parseCommand(String input) throws InvalidCommandException {
        if (input.equals(exitCommand)) {
            return Command.EXIT;
        } else if (input.equals(displayCommand)) {
            return Command.DISPLAY;
        } else if (input.length() > 4 && input.substring(0, 5).equals("mark ")) {
            return Command.MARK;
        } else if (input.length() > 4 && input.substring(0, 5).equals("todo ")) {
            return Command.TODO;
        } else if (input.length() > 5 && input.substring(0, 6).equals("event ")) {
            return Command.EVENT;
        } else if (input.length() > 6 && input.substring(0, 7).equals("unmark ")) {
            return Command.UNMARK;
        } else if (input.length() > 6 && input.substring(0, 7).equals("delete ")) {
            return Command.DELETE;
        } else if (input.length() > 8 && input.substring(0, 9).equals("deadline ")) {
            return Command.DEADLINE;
        } else {
            throw new InvalidCommandException();
        }
    }

    public static void main(String[] args) {
        Ui ui = new Ui();
        ui.printWelcomeMsg();
        Storage storage = new Storage();
        list = storage.loadTaskList();

        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        while (!inputStr.equals(exitCommand)) {
            try {
                ui.printDivider();
                Command command = parseCommand(inputStr);
                switch (command) {
                    case DISPLAY:
                        list.displayList();
                        break;
                    case MARK:
                        String indexStr = inputStr.substring(5);
                        int index = Integer.parseInt(indexStr);
                        list.mark(index, true);
                        break;
                    case UNMARK:
                        indexStr = inputStr.substring(7);
                        index = Integer.parseInt(indexStr);
                        list.mark(index, false);
                        break;
                    case TODO:
                        Task newTask = new ToDo(inputStr.substring(5));
                        list.addItem(newTask);
                        break;
                    case DEADLINE:
                        int timeIndex = inputStr.indexOf("/");
                        String content = inputStr.substring(9, timeIndex);
                        newTask = new Deadline(content, inputStr.substring(timeIndex + 1));
                        list.addItem(newTask);
                        break;
                    case EVENT:
                        int startIndex = inputStr.indexOf("/");
                        content = inputStr.substring(6, startIndex);
                        int endIndex = inputStr.substring(startIndex + 1).indexOf("/") + startIndex + 1;
                        String startTime = inputStr.substring(startIndex + 1, endIndex - 1);
                        String endTime = inputStr.substring(endIndex + 1);
                        newTask = new Event(content, startTime, endTime);
                        list.addItem(newTask);
                        break;
                    case DELETE:
                        indexStr = inputStr.substring(7);
                        index = Integer.parseInt(indexStr);
                        list.delete(index);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                // Separator under response
                ui.printDivider();
                inputStr = scanner.nextLine();
            }
        }

        ui.printExitMsg();
    }
}
