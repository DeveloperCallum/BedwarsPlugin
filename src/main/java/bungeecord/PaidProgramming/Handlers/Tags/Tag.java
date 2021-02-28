package bungeecord.PaidProgramming.Handlers.Tags;

public abstract class Tag<t> { //The idea is to create an API that other plugins can hook into to get values, or create tags. it also means that my each time i create a new tag, it is easier for me to impairment or update.
    protected final String key;
    public Tag(String key) {
        this.key = key.toLowerCase();
    }
    public abstract String getValue(t data);
}
