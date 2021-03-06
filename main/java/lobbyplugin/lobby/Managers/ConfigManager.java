package lobbyplugin.lobby.Managers;

import TagAPI.Handler.Tag.TagHandler;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.MemorySection;
import org.bukkit.configuration.file.YamlConfiguration;
import TagAPI.Handler.Message;

import java.io.*;

public class ConfigManager {
    private File parentDir, configLocation;
    private Message message = new Message();

    public Message getMessage() {
        return message;
    }
    public TagHandler getTagHandler() {
        return message.getTagHandler();
    }

    public ConfigManager(File parentDir, Object MainClass) {
        this.parentDir = parentDir;

        if (!parentDir.exists()) parentDir.mkdir();
        configLocation = new File(parentDir, "/Config.yml");

        if (!configLocation.exists()) {
            try {
                configLocation.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    InputStream in = new BufferedInputStream(MainClass.getClass().getResourceAsStream("/Config.yml"));
                    OutputStream out = new BufferedOutputStream(new FileOutputStream(configLocation));

                    byte[] buffer = new byte[1024];
                    int lengthRead;
                    while ((lengthRead = in.read(buffer)) > 0) {
                        out.write(buffer, 0, lengthRead);
                        out.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Config has been generated!");
                    loadMessages();
                }
            }
        } else {
            loadMessages();
        }
    }

    private void loadMessages() {
        try {
            YamlConfiguration configuration = new YamlConfiguration();
            configuration.load(configLocation);
            System.out.println(configuration);

            ((MemorySection) configuration.get("ServerConfiguration.Predefined_Messages")).getValues(false).forEach((s, o) -> {
                if (!(o instanceof String)) return;

                String key = s;
                String value = (String) o;

                message.addMessage(key, value);
                System.out.println("Key: " + key + " Value: " + value);
            });
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
