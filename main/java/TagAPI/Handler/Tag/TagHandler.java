package TagAPI.Handler.Tag;

import java.util.HashMap;

public class TagHandler {
    private final HashMap<String, Tag<?>> tags = new HashMap<>();

    public void addTags(Tag... tag){
        for (Tag t : tag) addTag(t);
    }
    public void addTag(Tag tag){ //Does not allow overwriting values.
        if (tags.containsKey(tag.key)) return;
        tags.put(tag.key, tag);
    }

    public boolean tagExists(String key){
        return tags.containsKey(key.toLowerCase());
    }

    public Tag getTag(String key){
        if (tagExists(key)) return tags.get(key);
        else return null;
    }
}
