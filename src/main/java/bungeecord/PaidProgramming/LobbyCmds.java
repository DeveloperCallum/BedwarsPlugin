package bungeecord.PaidProgramming;

import bungeecord.PaidProgramming.Commands.Lobby;
import bungeecord.PaidProgramming.Handlers.Config;
import bungeecord.PaidProgramming.Handlers.Messages;
import bungeecord.PaidProgramming.Handlers.Tags.PreDefined.PluginName;
import bungeecord.PaidProgramming.Utils.Logger;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public final class LobbyCmds extends Plugin {
    private Config config;
    public LobbyCmds() {
        config = new Config(this);
        config.addTag(new PluginName("PluginName"));
    }

    @Override
    public void onLoad() { // This would allow custom messages to be declared in a file instead of reading the file when the message is needed. The message is cached, then an instance of the value is modified.
        config = new Config(this);
    }

    @Override
    public void onEnable() {
        Logger.message(config.getMessages().formatted(Messages.DEFAULT_COMMAND_MESSAGES.LOBBY_CONSOLE_ENABLED, this));
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new Lobby("lobby", "LobbyCmds.lobby", config,"hub"));
    }

    @Override
    public void onDisable() {
        Logger.message(config.getMessages().formatted(Messages.DEFAULT_COMMAND_MESSAGES.LOBBY_CONSOLE_DENIED, this));
    }
}
