package bungeecord.PaidProgramming;

import bungeecord.PaidProgramming.Commands.Lobby;
import bungeecord.PaidProgramming.Handlers.Config;
import bungeecord.PaidProgramming.Handlers.Messages;
import bungeecord.PaidProgramming.Handlers.Tags.PreDefined.PluginName;
import bungeecord.PaidProgramming.Handlers.Tags.TagHandler;
import bungeecord.PaidProgramming.Utils.Logger;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Plugin;

public final class LobbyCmds extends Plugin {
    private Config config;
    public LobbyCmds() {
        TagHandler tagHandler = new TagHandler();
        tagHandler.addTag(new PluginName("PluginName"));
        Messages.setTagHandler(tagHandler);
    }

    @Override
    public void onLoad() { // This would allow custom messages to be declared in a file instead of reading the file when the message is needed. The message is cached, then an instance of the value is modified.
        config = new Config(this);
    }

    @Override
    public void onEnable() {
        Logger.message(Messages.formatted(Messages.COMMAND_MESSAGES.LOBBYCMDS_CONSOLE_ENABLED, this));
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new Lobby("lobby", "LobbyCmds.lobby", "hub"));
    }

    @Override
    public void onDisable() {
        Logger.message(Messages.getMessage(Messages.COMMAND_MESSAGES.LOBBYCMDS_CONSOLE_DISABLED));
    }
}
