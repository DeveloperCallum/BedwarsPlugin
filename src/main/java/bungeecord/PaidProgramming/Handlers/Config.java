package bungeecord.PaidProgramming.Handlers;

import bungeecord.PaidProgramming.Utils.Logger;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.*;

public class Config {
    private final Plugin plugin;
    private File dataFolder;
    private File config;

    public Config(Plugin plugin) {
        this.plugin = plugin;
        this.dataFolder = plugin.getDataFolder();
        if (!dataFolder.exists()) dataFolder.mkdir();

        config = new File(dataFolder, "/Config.yml");

        if (!config.exists()){
            try {
                config.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    InputStream in = new BufferedInputStream(plugin.getClass().getResourceAsStream("/Config.yml"));
                    OutputStream out = null;
                    out = new BufferedOutputStream(new FileOutputStream(config));

                    byte[] buffer = new byte[1024];
                    int lengthRead;
                    while ((lengthRead = in.read(buffer)) > 0) {
                        out.write(buffer, 0, lengthRead);
                        out.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Logger.message("Config has been generated!");
                plugin.getProxy().stop();
            }
        } else{
            try {
                Configuration configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(config);

                for (Messages.COMMAND_MESSAGES value : Messages.COMMAND_MESSAGES.values()){
                    String name =  configuration.getString("ServerConfiguration.Predefined_Messages." + value.name() + ".Text");
                    if (name.toLowerCase().equals("null") || name.isEmpty()) continue;
                    String message = ChatColor.translateAlternateColorCodes('&',name);

                    ChatColor colour = null;
                    try{
                        colour = ChatColor.valueOf(configuration.getString("ServerConfiguration.Predefined_Messages." + value.name() + ".Colour"));
                    }catch (IllegalArgumentException ignored){
                    }finally {
                        TextComponent component = new TextComponent(message);
                        if(colour != null) component.setColor(colour);
                        Messages.setMessage(value, component);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
