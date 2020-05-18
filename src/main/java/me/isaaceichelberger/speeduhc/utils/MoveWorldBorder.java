package me.isaaceichelberger.speeduhc.utils;

import me.isaaceichelberger.speeduhc.SpeedUHC;
import org.bukkit.WorldBorder;


public class MoveWorldBorder  {

    SpeedUHC plugin;
    public MoveWorldBorder(SpeedUHC pl) {
        plugin = pl;
    }

    private static WorldBorder border;

    public static void setWorldBorder(WorldBorder input, double size, long time) {
        border = input;
        border.setSize(size, time);
    }

    public static WorldBorder getWorldBorder() {
        return border;
    }

}