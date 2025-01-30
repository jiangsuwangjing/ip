package alex.exceptions;

import alex.exceptions.AlexException;

public class InvalidCommandException extends AlexException {
    public InvalidCommandException () {
        super("I don't really understand this command...");
    }
}
