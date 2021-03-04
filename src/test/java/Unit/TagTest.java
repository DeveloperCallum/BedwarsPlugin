package Unit;

import Unit.MockClasses.ProxyServerMock;
import bungeecord.PaidProgramming.Handlers.Config;
import bungeecord.PaidProgramming.Handlers.Messages;
import bungeecord.PaidProgramming.Handlers.Tags.PreDefined.PluginName;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginDescription;
import org.junit.Test;
import java.lang.reflect.Field;


public class TagTest {

    @Test
    public void test() {
        // Create plugin instance
        Plugin plugin = new Plugin();

        //Create proxy server
        ProxyServer proxyServer = new ProxyServerMock();
        setValue("proxy", plugin, proxyServer);

        //Continue creating plugin instance
        PluginDescription description = new PluginDescription("LobbyCmds", null, null, null, null, null, null, "Fake");
        setValue("description", plugin, description);

        //setup tagHandler TODO: Change the way Config, Messages, and tagHandler work.

        Config config = new Config(plugin);
        config.addTag(new PluginName("PluginName"));

        assert config.getMessages().formatted(Messages.DEFAULT_COMMAND_MESSAGES.LOBBY_CONSOLE_ENABLED, plugin).toLowerCase().equals((plugin.getDescription().getName() + " has been enabled!").toLowerCase());
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