package bungeecord.PaidProgramming.Handlers.Tags;

public class TagNotClosedException extends RuntimeException {
    public TagNotClosedException() {
    }

    public TagNotClosedException(String message) {
        super(message);
    }

    public TagNotClosedException(String message, Throwable cause) {
        super(message, cause);
    }

    public TagNotClosedException(Throwable cause) {
        super(cause);
    }

    public TagNotClosedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
