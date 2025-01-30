package alex.exceptions;

import alex.exceptions.CorruptDataException;

public class InvalidTaskTypeException extends CorruptDataException {
    public InvalidTaskTypeException() {
        super("The task type does not exists");
    }
}
