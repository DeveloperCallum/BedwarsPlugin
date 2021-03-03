package Unit;

import Unit.MockClasses.ProxyServerMock;
import bungeecord.PaidProgramming.Handlers.Messages;
import bungeecord.PaidProgramming.Handlers.Tags.PreDefined.PluginName;
import bungeecord.PaidProgramming.Handlers.Tags.TagHandler;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginDescription;
import org.junit.Test;
import java.lang.reflect.Field;


public class FileTest {

    @Test
    public void TagTest() {
        // Create plugin instance
        Plugin plugin = new Plugin();

        //Create proxy server
        ProxyServer proxyServer = new ProxyServerMock();
        setValue("proxy", plugin, proxyServer);

        //Continue creating plugin instance
        PluginDescription description = new PluginDescription("LobbyCmds", null, null, null, null, null, null, "Fake");
        setValue("description", plugin, description);

        //setup tagHandler TODO: Change the way Config, Messages, and tagHandler work.
        TagHandler tagHandler = new TagHandler();
        tagHandler.addTag(new PluginName("pluginname"));
        Messages.setTagHandler(tagHandler);

        //set the value of LOBBYCMDS_CONSOLE_ENABLED, so we can test against it!
        Messages.setMessage(Messages.COMMAND_MESSAGES.LOBBYCMDS_CONSOLE_ENABLED, new TextComponent("<PluginName> has been enabled!"));

        assert Messages.formatted(Messages.COMMAND_MESSAGES.LOBBYCMDS_CONSOLE_ENABLED, plugin).toLowerCase().equals((plugin.getDescription().getName() + " has been enabled!").toLowerCase());
    }

    public static void setValue(String field, Object instance, Object value) {
        try {
            Field fieldR = instance.getClass().getDeclaredField(field);
            fieldR.setAccessible(true);
            fieldR.set(instance, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

//TODO: Change Message, Config, Tag Handler