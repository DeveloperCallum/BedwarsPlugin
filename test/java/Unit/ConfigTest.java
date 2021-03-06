package Unit;

import TagAPI.DefualtTags.DateTag;
import TagAPI.Handler.Tag.TagData;
import lobbyplugin.lobby.Managers.ConfigManager;
import lobbyplugin.lobby.Tags.PluginName;
import org.junit.Test;

import java.io.File;

public class ConfigTest {

    @Test
    public void test() {
        File datafolder = new File("C:\\Users\\shane\\Documents\\Minecraft\\Servers\\Bedwars\\Lobby\\plugins"); // Folder where the file is saved.

        ConfigManager configManager = new ConfigManager(datafolder, this);
        configManager.getTagHandler().addTag(new PluginName("PluginName"));
        configManager.getTagHandler().addTag(new DateTag("Date"));
        System.out.println(configManager.getMessage().formatMessage("LobbyCmdsConsoleEnabledMessage", this));
    }

    @TagData
    public String getPluginName() {
        return "Lobby";
    }

    @TagData
    public String geDatTage() {
        return "Lobby";
    }
}