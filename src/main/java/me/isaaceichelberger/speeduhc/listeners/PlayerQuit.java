package me.isaaceichelberger.speeduhc.listeners;

import me.isaaceichelberger.speeduhc.GameState;
import me.isaaceichelberger.speeduhc.SpeedUHC;
import me.isaaceichelberger.speeduhc.handlers.Game;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit extends MGListener {
    public PlayerQuit(SpeedUHC pl) {
        super(pl);
    }
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        e.setQuitMessage(ChatColor.BOLD + "" + ChatColor.GREEN + player.getDisplayName() + ChatColor.DARK_GRAY + " has quit the game!");
        if (GameState.isState(GameState.IN_LOBBY)) {
            Game.setCanStart(Bukkit.getOnlinePlayers().size() - 1 >= 2); // 2 for test purposes
        }
    }
}
