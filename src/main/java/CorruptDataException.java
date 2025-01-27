public class CorruptDataException extends DataException {
    public CorruptDataException() {
        super("This data entry is corrupt due to incorrect format or missing fields.");
    }

    public CorruptDataException(String msg) {
        super(msg);
    }
}
