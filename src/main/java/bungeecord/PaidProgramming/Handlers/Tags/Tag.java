package bungeecord.PaidProgramming.Handlers.Tags;

public abstract class Tag<t> { //Allows me to create as many tags as i want, with no effort.
    protected final String key;
    public Tag(String key) {
        this.key = key.toLowerCase();
    }
    public abstract String getValue(t data);
}
