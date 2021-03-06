package Unit.MockClasses.MockTags;

import TagAPI.Handler.Tag.Tag;

public class NameTag extends Tag<String> {

    public NameTag(String key) {
        super(key);
    }

    @Override
    public String getValue(String data) {
        return data;
    }
}
