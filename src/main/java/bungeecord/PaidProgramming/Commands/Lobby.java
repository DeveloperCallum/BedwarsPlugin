package bungeecord.PaidProgramming.Commands;

import bungeecord.PaidProgramming.Handlers.Messages;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Lobby extends Command {

    //region Constructors
    public Lobby(String name) {
        super(name);
    }

    public Lobby(String name, String permission, String... aliases) {
        super(name, permission, aliases);
    }
    //endregion

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof ProxiedPlayer){
            ProxiedPlayer player = (ProxiedPlayer) sender;
            player.sendMessage(Messages.getMessage(Messages.COMMAND_MESSAGES.LOBBY_PLAYER_PROCESSING));
        } else sender.sendMessage(Messages.getMessage(Messages.COMMAND_MESSAGES.LOBBY_CONSOLE_DENIED));
    }
}
