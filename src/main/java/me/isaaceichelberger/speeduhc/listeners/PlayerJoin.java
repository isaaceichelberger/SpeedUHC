package me.isaaceichelberger.speeduhc.listeners;

import me.isaaceichelberger.speeduhc.SpeedUHC;
import me.isaaceichelberger.speeduhc.handlers.Game;
import me.isaaceichelberger.speeduhc.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin extends MGListener {
    public PlayerJoin(SpeedUHC pl) {
        super(pl);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Game.setCanStart(Bukkit.getOnlinePlayers().size() >= 2); // 2 for test purposes
        Player player = e.getPlayer();
        e.setJoinMessage(ChatColor.BOLD + "" + ChatColor.GREEN + player.getDisplayName() + ChatColor.DARK_GRAY + " has joined the game!");
        Location loc = new Location(Bukkit.getWorld("lobby"), 0, 70, 0);
        player.teleport(loc);
        if (!Game.canStart()){
            ChatUtils.broadcast("Waiting on " + ChatColor.YELLOW + String.valueOf(2 -Bukkit.getOnlinePlayers().size()) + ChatColor.DARK_GRAY +
                    " player before the game begins!");
        }
    }
}
