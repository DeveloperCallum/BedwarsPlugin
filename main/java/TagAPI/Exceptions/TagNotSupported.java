package TagAPI.Exceptions;

public class TagNotSupported extends RuntimeException{
    public TagNotSupported() {
    }

    public TagNotSupported(String message) {
        super(message);
    }

    public TagNotSupported(String message, Throwable cause) {
        super(message, cause);
    }

    public TagNotSupported(Throwable cause) {
        super(cause);
    }

    public TagNotSupported(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
