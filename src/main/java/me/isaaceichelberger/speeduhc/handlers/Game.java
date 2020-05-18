package me.isaaceichelberger.speeduhc.handlers;

import me.isaaceichelberger.speeduhc.GameState;
import me.isaaceichelberger.speeduhc.listeners.InventoryClick;
import me.isaaceichelberger.speeduhc.utils.MoveWorldBorder;
import me.isaaceichelberger.speeduhc.utils.ChatUtils;
import org.bukkit.*;
import org.bukkit.entity.Player;

public class Game {

    private static boolean canStart = false;

    public static boolean canStart() {

        return canStart;
    }

    public static void setCanStart(boolean b) {

        canStart = b;
    }

    public static void start() {
        GameState.setState(GameState.IN_GAME);
        int X = -450;
        int Z = -450;
        ChatUtils.broadcast(ChatColor.DARK_GRAY + "Teleporting players!");
        for (Player player : Bukkit.getServer().getOnlinePlayers()) { // TODO improve for multiple players obviously
            Location loc = new Location(Bukkit.getWorld("gameWorld"), X,
                    Bukkit.getWorld("gameWorld").getHighestBlockYAt(X, Z), Z);
            player.teleport(loc);
            if (X <= Z)
                X += 100;
            else
                Z += 100;
            }
        MoveWorldBorder.setWorldBorder(Bukkit.getWorld("gameWorld").getWorldBorder(), 150, 900L);
    }

    public static void stop() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            InventoryClick.setHasSelected(p, null);
        }

    }
}