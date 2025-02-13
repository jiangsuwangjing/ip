package alex;

import alex.command.AddCommand;
import alex.command.Command;
import alex.command.DeleteCommand;
import alex.command.DisplayCommand;
import alex.command.ExitCommand;
import alex.command.FindCommand;
import alex.command.MarkCommand;
import alex.exceptions.AlexException;
import alex.exceptions.CommandFormatException;
import alex.exceptions.InvalidCommandException;
import alex.task.Deadline;
import alex.task.Event;
import alex.task.TaskList;
import alex.task.ToDo;

/**
 * Parser parses user input string into Commands
 */
public class Parser {
    private static enum CommandType {
        DISPLAY, MARK, UNMARK, TODO, DEADLINE, EVENT, DELETE, EXIT, FIND
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
        } else if (input.length() > 4 && input.substring(0, 5).equals("find ")) {
            return CommandType.FIND;
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

    public static Command parseMark(String inputStr, TaskList tasks) throws Exception {
        String indexStr = inputStr.substring(5);
        int index = Integer.parseInt(indexStr);
        tasks.checkInBound(index);
        return new MarkCommand(index, true);
    }

    public static Command parseUnmark(String inputStr, TaskList tasks) throws Exception {
        String indexStr = inputStr.substring(7);
        int index = Integer.parseInt(indexStr);
        tasks.checkInBound(index);
        return new MarkCommand(index, false);
    }

    public static Command parseDeadline(String inputStr) {
        int timeIndex = inputStr.indexOf("/by");
        String content = inputStr.substring(9, timeIndex);
        return new AddCommand(new Deadline(content, inputStr.substring(timeIndex + 4)));
    }

    public static Command parseEvent(String inputStr) {
        int startIndex = inputStr.indexOf("/from");
        String content = inputStr.substring(6, startIndex);
        int endIndex = inputStr.indexOf("/to");
        String startTime = inputStr.substring(startIndex + 6, endIndex - 1);
        String endTime = inputStr.substring(endIndex + 4);
        return new AddCommand(new Event(content, startTime, endTime));
    }

    public static Command parseDelete(String inputStr, TaskList tasks) throws Exception {
        String indexStr = inputStr.substring(7);
        int index = Integer.parseInt(indexStr);
        tasks.checkInBound(index);
        return new DeleteCommand(index);
    }

    /**
     * Parses string into commands
     * @param inputStr original user input
     * @param tasks the task list that are used in generating some commands
     * @return the command that can be executed
     * @throws Exception from parsing the string, mostly AlexException
     */
    public static Command parse(String inputStr, TaskList tasks) throws Exception {
        try {
            CommandType commandType;
            commandType = Parser.extractCommand(inputStr);

            switch (commandType) {
            case DISPLAY:
                return new DisplayCommand();
            case MARK:
                return MarkCommand.parseMark(inputStr, tasks);
            case UNMARK:
                return MarkCommand.parseUnmark(inputStr, tasks);
            case TODO:
                return AddCommand.parseTodo(inputStr);
            case FIND:
                return FindCommand.parseFind(inputStr);
            case DEADLINE:
                return AddCommand.parseDeadline(inputStr);
            case EVENT:
                return AddCommand.parseEvent(inputStr);
            case DELETE:
                return DeleteCommand.parseDelete(inputStr, tasks);
            case EXIT:
                return new ExitCommand();
            default:
                throw new InvalidCommandException();
            }
        } catch (AlexException e) {
            throw e;
        } catch (Exception e) {
            throw new CommandFormatException();
        }
    }
}