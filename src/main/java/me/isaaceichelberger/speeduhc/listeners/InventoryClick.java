package me.isaaceichelberger.speeduhc.listeners;

import me.isaaceichelberger.speeduhc.SpeedUHC;
import me.isaaceichelberger.speeduhc.commands.CommandKit;
import me.isaaceichelberger.speeduhc.utils.EasyGUI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import java.util.HashMap;

public class InventoryClick extends MGListener {

    public InventoryClick(SpeedUHC pl) {
        super(pl);
    }
    private static HashMap<Player, Integer> selection;

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getWhoClicked() instanceof Player) {
            Player p = (Player) e.getWhoClicked();
                if (e.getInventory().getName() == "Kits") {
                    if (e.getCurrentItem() != null) {
                        if (e.getCurrentItem().equals(new ItemStack(Material.BOW))) {
                            selection.put(p, 0);
                            p.getInventory().addItem(new ItemStack(Material.BOW));
                            p.getInventory().addItem(new ItemStack(Material.ARROW, 64));
                        }
                        if (e.getCurrentItem().getType().equals(Material.POTION)) {
                            selection.put(p, 1);
                            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
                            ItemMeta bootsMeta = boots.getItemMeta();
                            boots.setItemMeta(bootsMeta);
                            boots.addEnchantment(Enchantment.DEPTH_STRIDER, 3);
                            Potion splash = new Potion(PotionType.SPEED, 2);
                            splash.setSplash(true);
                            p.getInventory().addItem(new ItemStack(splash.toItemStack(2)));
                            p.getInventory().addItem(new ItemStack(boots));
                        }
                        if (e.getCurrentItem().getType().equals(Material.STONE_PICKAXE)) {
                            selection.put(p, 2);
                            p.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
                            p.getInventory().addItem(new ItemStack(Material.STONE_PICKAXE));
                            p.getInventory().addItem(new ItemStack(Material.STONE_AXE));
                        }
                        if (e.getCurrentItem().getType().equals(Material.BOOK)) {
                            selection.put(p, 3);
                            p.getInventory().addItem(new ItemStack(Material.OBSIDIAN, 4));
                            p.getInventory().addItem(new ItemStack(Material.BOOK, 3));
                            p.getInventory().addItem(new ItemStack(Material.EXP_BOTTLE, 15));
                        }
                    }
                    e.setCancelled(true);
            }
        }
    }

    public static HashMap<Player, Integer> getSelection(){
        return selection;
    }

    public static void setHasSelected(Player player, Integer intt)
    {
        selection.put(player, intt);
    }

}