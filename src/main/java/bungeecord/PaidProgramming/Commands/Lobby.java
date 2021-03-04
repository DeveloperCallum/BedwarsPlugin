package bungeecord.PaidProgramming.Commands;

import bungeecord.PaidProgramming.Handlers.Config;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Lobby extends Command {
    Config config;

    //region Constructors
    public Lobby(String name, Config config) {
        super(name);
        this.config = config;
    }

    public Lobby(String name, String permission, Config config, String... aliases) {
        super(name, permission, aliases);
        this.config = config;
    }
    //endregion

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof ProxiedPlayer){
            ProxiedPlayer player = (ProxiedPlayer) sender;
        }
    }
}
