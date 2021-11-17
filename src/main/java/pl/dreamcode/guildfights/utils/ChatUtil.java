package pl.dreamcode.guildfights.utils;

import org.bukkit.ChatColor;

public class ChatUtil {
  public static String fixColor(String s) {
    return ChatColor.translateAlternateColorCodes('&', s.replace(">>", "»").replace("<<", ""));
  }
}
