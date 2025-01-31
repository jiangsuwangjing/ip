package alex;

import alex.command.*;
import alex.exceptions.*;
import alex.task.*;

public class Parser {
    private static enum CommandType {
        DISPLAY, MARK, UNMARK, TODO, DEADLINE, EVENT, DELETE, EXIT
    }

    private static final String exitCommand = "bye";
    private static final String displayCommand = "list";

    private static CommandType extractCommand(String input) throws InvalidCommandException {
        input = input.trim().toLowerCase();
        if (input.equals(exitCommand)) {
            return CommandType.EXIT;
        } else if (input.equals(displayCommand)) {
            return Parser.CommandType.DISPLAY;
        } else if (input.length() > 4 && input.substring(0, 5).equals("mark ")) {
            return CommandType.MARK;
        } else if (input.length() > 4 && input.substring(0, 5).equals("todo ")) {
            return CommandType.TODO;
        } else if (input.length() > 5 && input.substring(0, 6).equals("event ")) {
            return CommandType.EVENT;
        } else if (input.length() > 6 && input.substring(0, 7).equals("unmark ")) {
            return CommandType.UNMARK;
        } else if (input.length() > 6 && input.substring(0, 7).equals("delete ")) {
            return CommandType.DELETE;
        } else if (input.length() > 8 && input.substring(0, 9).equals("deadline ")) {
            return CommandType.DEADLINE;
        } else {
            throw new InvalidCommandException();
        }
    }

    public static Command parse(String inputStr, TaskList tasks) throws Exception {
        try {
            CommandType commandType;
            commandType = Parser.extractCommand(inputStr);

            switch (commandType) {
            case DISPLAY:
                return new DisplayCommand();
            case MARK:
                String indexStr = inputStr.substring(5);
                int index = Integer.parseInt(indexStr);
                tasks.checkInBound(index);
                return new MarkCommand(index, true);
            case UNMARK:
                indexStr = inputStr.substring(7);
                index = Integer.parseInt(indexStr);
                tasks.checkInBound(index);
                return new MarkCommand(index, false);
            case TODO:
                return new AddCommand(new ToDo(inputStr.substring(5)));
            case DEADLINE:
                int timeIndex = inputStr.indexOf("/by");
                String content = inputStr.substring(9, timeIndex);
                return new AddCommand(new Deadline(content, inputStr.substring(timeIndex + 4)));
            case EVENT:
                int startIndex = inputStr.indexOf("/from");
                content = inputStr.substring(6, startIndex);
                int endIndex = inputStr.indexOf("/to");
                String startTime = inputStr.substring(startIndex + 6, endIndex - 1);
                String endTime = inputStr.substring(endIndex + 4);
                return new AddCommand(new Event(content, startTime, endTime));
            case DELETE:
                indexStr = inputStr.substring(7);
                index = Integer.parseInt(indexStr);
                tasks.checkInBound(index);
                return new DeleteCommand(index);
            case EXIT:
                return new ExitCommand();
            }
        } catch (AlexException e) {
            throw e;
        } catch (Exception e) {
            throw new CommandFormatException();
        }
        return null;
    }
}