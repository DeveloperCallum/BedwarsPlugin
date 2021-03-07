package TagAPI.Handler.Tag;

public abstract class Tag<Type> {
    protected final String key;
    protected final boolean isFinal;
    public String getKey() {
        return key;
    }
    public boolean isFinal() { return isFinal; }

    protected Tag(String key, boolean isFinalTag) {
        if (key.trim().isEmpty()) throw new IllegalArgumentException("Key cannot be empty!");
        this.key = key.toLowerCase().trim();
        this.isFinal = isFinalTag;
    }
}

/*Problem:
 * Tags aren't inter-changeable for instance data.
 *
 * The tag handler needs to know the output of other tags, so if <tag1> bla bla changes to <tag2> bla bla it can handle it, without relying on the data being given to it through arguments.
 *
 * Static Tags: Same as Instance except one value has been set it cannot be changed.
 * Instance Tags: &Instance object has the data, with the methods marked with @TagData
 *
 * Tags cant be used everywhere, limit what tags can be used where.
 *
 * TODO: Solution Create a Annotation that requires the class to provide the data. <tag1> uses integer so find getInteger which should be marked using @TagData
 *       if it is not present throw runtime error that the tag is not supported within the class!
 *
 *   The class that called the formatter should have tag data, which would be get<Tag.Key> which would give the formatter the data
 * */