package me.isaaceichelberger.speeduhc.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatUtils {
    public static void broadcast(String msg){
        for (Player player : Bukkit.getOnlinePlayers()){
            player.sendMessage(starter() + msg);
        }
    }
    private static String starter(){
        return ChatColor.DARK_GRAY + "[" + ChatColor.RED + "SpeedUHC" + ChatColor.DARK_GRAY + "] ";
    }
}
