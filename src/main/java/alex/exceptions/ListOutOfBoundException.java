package alex.exceptions;

import alex.exceptions.AlexException;

public class ListOutOfBoundException extends AlexException {
    public ListOutOfBoundException() {
        super("Did you key in the correct index?");
    }
}
