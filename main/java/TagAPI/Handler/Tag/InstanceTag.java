package TagAPI.Handler.Tag;

public abstract class InstanceTag<Type> extends Tag{

    public InstanceTag(String key) {
        super(key, false);
    }

    public abstract String getValue(Type data);
}
