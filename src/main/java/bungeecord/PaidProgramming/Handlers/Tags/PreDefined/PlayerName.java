package bungeecord.PaidProgramming.Handlers.Tags.PreDefined;

import bungeecord.PaidProgramming.Handlers.Tags.Tag;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class PlayerName extends Tag<ProxiedPlayer> {

    public PlayerName(String key) {
        super(key);
    }

    @Override
    public String getValue(ProxiedPlayer data) {
        return data.getDisplayName();
    }
}
