package pl.dreamcode.guildfights;

import static org.bukkit.Bukkit.getConsoleSender;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import pl.dreamcode.guildfights.commands.FightCommand;

public class Main extends JavaPlugin {

    private final static Main plugin;

    public void onEnable() {
        PluginDescriptionFile pluginDescriptionFile = getDescription();
        if (!pluginDescriptionFile.getName().contains("DC_GuildFights")) {
            getConsoleSender().sendMessage(" >");
            getConsoleSender().sendMessage(" > Wykryto zmiane nazwy pluginu!");
            getConsoleSender().sendMessage(" > -> DC_GuildFights v1.0-SNAPSHOT zostal wylaczony!");
            Bukkit.getServer().getPluginManager().disablePlugin((Plugin)this);
            return;
        }
        if (!pluginDescriptionFile.getAuthors().contains("Kamilo")) {
            getConsoleSender().sendMessage(" >");
            getConsoleSender().sendMessage(" > Wykryto zmiane autora pluginu!");
            getConsoleSender().sendMessage(" > -> DC_GuildFights v1.0-SNAPSHOT zostal wylaczony!");
            Bukkit.getServer().getPluginManager().disablePlugin((Plugin)this);
            return;
        }
        if (!pluginDescriptionFile.getVersion().contains("1.0-SNAPSHOT")) {
            getConsoleSender().sendMessage(" >");
            getConsoleSender().sendMessage(" > Wykryto zmiane autora pluginu!");
            getConsoleSender().sendMessage(" > -> DC_GuildFights v1.0-SNAPSHOT zostal wylaczony!");
            Bukkit.getServer().getPluginManager().disablePlugin((Plugin)this);
            return;
        }
        getConsoleSender().sendMessage("[DC_GuildFights] DC_GuildFights v1.0-SNAPSHOT");
        getConsoleSender().sendMessage(" >");
        getConsoleSender().sendMessage(" > Twoj serwer posiada wazna licencje do pluginu");
        getConsoleSender().sendMessage(" > -> DC_GuildFights v1.0-SNAPSHOT");
        (plugin = this).saveDefaultConfig();
        saveConfig();
        registerCommands();
    }

    private void registerCommands() {
        getCommand("walka").setExecutor((CommandExecutor) new FightCommand());
    }

    public static Main getPlugin() {
        return Main.plugin;
    }
}
