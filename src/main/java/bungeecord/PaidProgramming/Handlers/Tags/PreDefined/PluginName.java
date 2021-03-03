package bungeecord.PaidProgramming.Handlers.Tags.PreDefined;

import bungeecord.PaidProgramming.Handlers.Tags.Tag;
import net.md_5.bungee.api.plugin.Plugin;

public class PluginName extends Tag<Plugin> {
    public PluginName(String key) {
        super(key);
    }

    @Override
    public String getValue(Plugin data) {
        return data.getDescription().getName();
    }
}
