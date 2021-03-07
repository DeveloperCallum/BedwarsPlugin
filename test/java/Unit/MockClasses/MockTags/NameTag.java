package Unit.MockClasses.MockTags;

import TagAPI.Handler.Tag.InstanceTag;
import TagAPI.Handler.Tag.Tag;

public class NameTag extends InstanceTag<String> {

    public NameTag(String key) {
        super(key);
    }

    @Override
    public String getValue(String data) {
        return data;
    }
}
