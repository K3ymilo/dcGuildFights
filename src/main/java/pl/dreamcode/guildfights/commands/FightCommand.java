package pl.dreamcode.guildfights.commands;

import java.util.HashMap;
import java.util.UUID;
import net.dzikoysk.funnyguilds.basic.guild.Guild;
import net.dzikoysk.funnyguilds.basic.user.User;
import pl.dreamcode.guildfights.Main;
import pl.dreamcode.guildfights.utils.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class FightCommand implements CommandExecutor {
  private static final HashMap<UUID, Long> times = new HashMap<>();

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] strings) {
    Player player = (Player)sender;
    User user = User.get(player);
    Guild guild2 = User.get(player).getGuild();
    Long t1 = times.get(player.getUniqueId());
    if (!(sender instanceof Player))
      return true;
    if (!user.hasGuild()) {
      sender.sendMessage(ChatUtil.fixColor(Main.getPlugin().getConfig().getString("messages.noguild")));
      return true;
    }
    if (!user.isDeputy() && !user.isOwner()) {
      sender.sendMessage(ChatUtil.fixColor(Main.getPlugin().getConfig().getString("messages.nopermission")));
      return true;
    }
    if (t1 != null && System.currentTimeMillis() - t1.longValue() < 240000L) {
      sender.sendMessage(ChatUtil.fixColor(Main.getPlugin().getConfig().getString("messages.cooldown")));
      return true;
    }
    times.put(player.getUniqueId(), Long.valueOf(System.currentTimeMillis()));
    Bukkit.getServer().broadcastMessage(ChatUtil.fixColor(" &7&m------------"));
    Bukkit.getServer().broadcastMessage(ChatUtil.fixColor(" "));
    Bukkit.getServer().broadcastMessage(ChatUtil.fixColor(" &8» &7Gildia &e&l" + guild2.getTag() + " &7wyzywa na walke!"));
    Bukkit.getServer().broadcastMessage(ChatUtil.fixColor(" &8» &7Koordynaty Gildii &e&lX:&f " + guild2.getHome().getBlockX()) + ChatUtil.fixColor(" &e&lZ: &f" + guild2.getHome().getBlockZ()));
    Bukkit.getServer().broadcastMessage(ChatUtil.fixColor(" &8» &7Ranking Gildii: &f&l" + guild2.getRank()));
    Bukkit.getServer().broadcastMessage(ChatUtil.fixColor(" "));
    Bukkit.getServer().broadcastMessage(ChatUtil.fixColor(" &7&m------------"));
    return false;
  }
}
