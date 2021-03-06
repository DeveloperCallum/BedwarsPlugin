package lobbyplugin.lobby.Tags;

import TagAPI.Handler.Tag.Tag;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginName extends Tag<String> {
    public PluginName(String key) {
        super(key);
    }

    @Override
    public String getValue(String data) {
        return data;
    }
}
