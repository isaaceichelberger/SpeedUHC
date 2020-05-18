package me.isaaceichelberger.speeduhc;

import me.isaaceichelberger.speeduhc.commands.CommandKit;
import me.isaaceichelberger.speeduhc.handlers.Game;
import me.isaaceichelberger.speeduhc.listeners.InventoryClick;
import me.isaaceichelberger.speeduhc.listeners.MGListener;
import me.isaaceichelberger.speeduhc.listeners.PlayerJoin;
import me.isaaceichelberger.speeduhc.listeners.PlayerQuit;
import me.isaaceichelberger.speeduhc.utils.MoveWorldBorder;
import me.isaaceichelberger.speeduhc.threads.StartCountdown;
import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Location;

public final class SpeedUHC extends JavaPlugin {

    private static int startCountdownId;

    @Override
    public void onEnable() {
        getCommand("kit").setExecutor(new CommandKit());
        GameState.setState(GameState.IN_LOBBY);
        Game.setCanStart(false);
        startCountdown();
        registerListeners();
        WorldCreator wc = new WorldCreator("lobby");
        getServer().createWorld(wc);
        WorldCreator wc1 = new WorldCreator("gameWorld");
        getServer().createWorld(wc1);
        MoveWorldBorder.setWorldBorder(Bukkit.getWorld("gameWorld").getWorldBorder(), 1500, 10);
        MoveWorldBorder.getWorldBorder().setCenter(new Location(Bukkit.getWorld("gameWorld"), 0, 0, 0));
        MoveWorldBorder.getWorldBorder().setWarningDistance(10);
        MoveWorldBorder.getWorldBorder().setSize(1500);
        MoveWorldBorder.getWorldBorder().setWarningTime(5);
        MoveWorldBorder.getWorldBorder().setDamageAmount(5.0);
    }

    @Override
    public void onDisable() {

    }

    private void registerListeners(){
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerJoin(this), this);
        pm.registerEvents(new PlayerQuit(this), this);
        pm.registerEvents(new InventoryClick(this), this);
    }

    private void startCountdown(){
        StartCountdown.timeUntilStart = 10; // for testing
        startCountdownId = getServer().getScheduler().scheduleSyncRepeatingTask(this, new StartCountdown(this), 20L, 20L);
    }
    public void stopCountdown() {
        getServer().getScheduler().cancelTask(startCountdownId);
    }

    public void restartCountdown(){
        stopCountdown();
        startCountdown();
    }
}
