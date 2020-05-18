package me.isaaceichelberger.speeduhc.threads;

import me.isaaceichelberger.speeduhc.SpeedUHC;
import me.isaaceichelberger.speeduhc.handlers.Game;
import me.isaaceichelberger.speeduhc.utils.ChatUtils;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

public class StartCountdown extends BukkitRunnable {

    SpeedUHC plugin;

    public StartCountdown(SpeedUHC pl) {
        plugin = pl;
    }

    public static int timeUntilStart;

    public void run() {
        if (timeUntilStart == 0) {
            if (!Game.canStart()) {
                plugin.restartCountdown();
                ChatUtils.broadcast("Cannot start game, restarting countdown!");
                return;
            }
            Game.start();
            plugin.stopCountdown();
        }

        if ((timeUntilStart % 15 == 0 || (timeUntilStart <= 10 && timeUntilStart > 0)) && Game.canStart()) {
            ChatUtils.broadcast(ChatColor.YELLOW + String.valueOf(timeUntilStart) + ChatColor.DARK_GRAY + " seconds until the game starts!");
            timeUntilStart -= 1;
        }
    }
}

