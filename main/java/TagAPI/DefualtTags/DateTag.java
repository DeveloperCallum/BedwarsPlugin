package TagAPI.DefualtTags;

import TagAPI.Handler.Tag.Tag;

import java.util.Date;

public class DateTag extends Tag<Date> {

    public DateTag(String key) {
        super(key);
    }

    public String getValue(java.util.Date date) {
        return date.toString();
    }
}
