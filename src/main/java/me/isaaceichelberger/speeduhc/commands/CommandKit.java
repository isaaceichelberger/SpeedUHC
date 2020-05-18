package me.isaaceichelberger.speeduhc.commands;

import me.isaaceichelberger.speeduhc.utils.EasyGUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CommandKit implements CommandExecutor {

    private static EasyGUI kitInv = new EasyGUI("Kits").setSlots(9);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (sender instanceof Player){
            Player p = (Player) sender;
            ItemStack archer = new ItemStack(Material.BOW);
            ItemStack scout = new ItemStack(Material.POTION);
            ItemStack gatherer = new ItemStack(Material.STONE_PICKAXE);
            ItemStack enchanter = new ItemStack(Material.ENCHANTED_BOOK);
            ItemMeta archerMeta = archer.getItemMeta();
            ItemMeta scoutMeta = scout.getItemMeta();
            ItemMeta gathererMeta = gatherer.getItemMeta();
            ItemMeta enchanterMeta = enchanter.getItemMeta();
            ArrayList<String> archerLore = new ArrayList<String>();
            ArrayList<String> scoutLore = new ArrayList<String>();
            ArrayList<String> gathererLore = new ArrayList<String>();
            ArrayList<String> enchanterLore = new ArrayList<String>();
            archerMeta.setDisplayName(ChatColor.GOLD + "Archer Kit");
            archerLore.add(ChatColor.GRAY + "1 Bow");
            archerLore.add(ChatColor.GRAY + "64 Arrows");
            archerMeta.setLore(archerLore);
            archer.setItemMeta(archerMeta);
            scoutMeta.setDisplayName(ChatColor.GOLD + "Scout Kit");
            scoutLore.add(ChatColor.GRAY + "Leather Boots, depth strider III");
            scoutLore.add(ChatColor.GRAY + "2 Speed II potions");
            scoutMeta.setLore(scoutLore);
            scout.setItemMeta(scoutMeta);
            gathererMeta.setDisplayName(ChatColor.GOLD + "Gatherer Kit");
            gathererLore.add(ChatColor.GRAY + "1 Stone Pickaxe");
            gathererLore.add(ChatColor.GRAY + "1 Stone Axe");
            gathererLore.add(ChatColor.GRAY + "1 Stone Sword");
            gathererMeta.setLore(gathererLore);
            gatherer.setItemMeta(gathererMeta);
            enchanterMeta.setDisplayName(ChatColor.GOLD + "Enchanter Kit");
            enchanterLore.add(ChatColor.GRAY + "4 Obsidian");
            enchanterLore.add(ChatColor.GRAY + "3 books");
            enchanterLore.add(ChatColor.GRAY + "15 enchanting bottles");
            enchanterMeta.setLore(enchanterLore);
            enchanter.setItemMeta(enchanterMeta);
            kitInv.setItem(0, archer);
            kitInv.setItem(1, scout);
            kitInv.setItem(2, gatherer);
            kitInv.setItem(3, enchanter);
            kitInv.openGUIFor(p);
            return true;
        }
        return false;
    }

    public static EasyGUI getKitInv()
    {
        return kitInv;
    }
}
