package TagAPI.Handler.Tag;

import TagAPI.Exceptions.TagValueAlreadySet;

public class FinalTag extends Tag {
    protected String finalData = null;
    public void setFinalData(String data) {
        if (data != null) this.finalData = data;
        throw new TagValueAlreadySet("Tag is final, value has already been set.");
    }
    public String getValue() { return finalData; }
    public boolean isDataSet() {return finalData != null; }

    public FinalTag(String key) {
        super(key, true);
    }

    public FinalTag(String key, String finalData) {
        super(key, true);
        this.finalData = finalData;
    }
}
