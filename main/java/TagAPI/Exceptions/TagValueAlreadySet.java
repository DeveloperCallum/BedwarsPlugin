package TagAPI.Exceptions;

public class TagValueAlreadySet extends RuntimeException{
    public TagValueAlreadySet() {
    }

    public TagValueAlreadySet(String message) {
        super(message);
    }

    public TagValueAlreadySet(String message, Throwable cause) {
        super(message, cause);
    }
}
