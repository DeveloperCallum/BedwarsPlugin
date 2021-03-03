package Unit.MockClasses;

import net.md_5.bungee.api.*;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.config.ConfigurationAdapter;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.PluginManager;
import net.md_5.bungee.api.scheduler.TaskScheduler;

import java.io.File;
import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

public class ProxyServerMock extends ProxyServer {

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getVersion() {
        return null;
    }

    @Override
    public String getTranslation(String name, Object... args) {
        return null;
    }

    @Override
    public Logger getLogger() {
        return null;
    }

    @Override
    public Collection<ProxiedPlayer> getPlayers() {
        return null;
    }

    @Override
    public ProxiedPlayer getPlayer(String name) {
        return null;
    }

    @Override
    public ProxiedPlayer getPlayer(UUID uuid) {
        return null;
    }

    @Override
    public Map<String, ServerInfo> getServers() {
        return null;
    }

    @Override
    public ServerInfo getServerInfo(String name) {
        return null;
    }

    @Override
    public PluginManager getPluginManager() {
        return null;
    }

    @Override
    public ConfigurationAdapter getConfigurationAdapter() {
        return null;
    }

    @Override
    public void setConfigurationAdapter(ConfigurationAdapter adapter) {

    }

    @Override
    public ReconnectHandler getReconnectHandler() {
        return null;
    }

    @Override
    public void setReconnectHandler(ReconnectHandler handler) {

    }

    @Override
    public void stop() {

    }

    @Override
    public void stop(String reason) {

    }

    @Override
    public void start() throws Exception {

    }

    @Override
    public void registerChannel(String channel) {

    }

    @Override
    public void unregisterChannel(String channel) {

    }

    @Override
    public Collection<String> getChannels() {
        return null;
    }

    @Override
    public String getGameVersion() {
        return null;
    }

    @Override
    public int getProtocolVersion() {
        return 0;
    }

    @Override
    public ServerInfo constructServerInfo(String name, InetSocketAddress address, String motd, boolean restricted) {
        return null;
    }

    @Override
    public CommandSender getConsole() {
        return null;
    }

    @Override
    public File getPluginsFolder() {
        return new File("C://Users//shane//Documents//Minecraft//Servers//Bedwars//Bungeecord//plugins");
    }

    @Override
    public TaskScheduler getScheduler() {
        return null;
    }

    @Override
    public int getOnlineCount() {
        return 0;
    }

    @Override
    public void broadcast(String message) {

    }

    @Override
    public void broadcast(BaseComponent... message) {

    }

    @Override
    public void broadcast(BaseComponent message) {

    }

    @Override
    public Collection<String> getDisabledCommands() {
        return null;
    }

    @Override
    public ProxyConfig getConfig() {
        return null;
    }

    @Override
    public Collection<ProxiedPlayer> matchPlayer(String match) {
        return null;
    }

    @Override
    public Title createTitle() {
        return null;
    }
}
