package alex.exceptions;

import alex.exceptions.AlexException;

/**
 * The exception when the command keyword is not valid
 */
public class InvalidCommandException extends AlexException {
    public InvalidCommandException () {
        super("I don't really understand this command...");
    }
}
