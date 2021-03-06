package lobbyplugin.lobby;

import TagAPI.Handler.Message;
import TagAPI.Handler.Tag.TagData;
import lobbyplugin.lobby.Tags.PluginName;
import org.bukkit.plugin.java.JavaPlugin;

public final class Lobby extends JavaPlugin {
    private final Message message = new Message();

    public Lobby() {
        message.getTagHandler().addTag(new PluginName("PluginName"));
        message.addMessage("PluginName", "<PluginName> was enabled!");
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        message.formatMessage("PluginName", this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @TagData
    public JavaPlugin getPluginName(){
        return this;
    }
}
