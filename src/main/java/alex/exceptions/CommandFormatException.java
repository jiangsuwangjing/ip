package alex.exceptions;

public class CommandFormatException extends AlexException {
    public CommandFormatException() {
        super("There is something wrong with the command format");
    }
}
