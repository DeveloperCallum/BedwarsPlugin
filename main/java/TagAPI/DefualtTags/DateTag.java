package TagAPI.DefualtTags;

import TagAPI.Handler.Tag.InstanceTag;
import TagAPI.Handler.Tag.Tag;

import java.util.Date;

public class DateTag extends InstanceTag<Date> {

    public DateTag(String key) {
        super(key);
    }

    public String getValue(java.util.Date date) {
        return date.toString();
    }
}
