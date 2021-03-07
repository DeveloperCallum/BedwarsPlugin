package TagAPI.Exceptions;

public class TagValueNotSet extends RuntimeException{
    public TagValueNotSet(String message) {
        super(message);
    }

    public TagValueNotSet(String message, Throwable cause) {
        super(message, cause);
    }
}
