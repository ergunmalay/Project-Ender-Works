package me.lownzy.magicmayhem.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemManagerTestingItems {

    public static ItemStack testStaff;

    public static void init() {
        testStaff();
    }

    //darkStaffs
    private static void testStaff() {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        Objects.requireNonNull(meta).setDisplayName(ChatColor.WHITE + "Test Item");

        List<String> lore = new ArrayList<>();

        //lore
        lore.add(ChatColor.DARK_GRAY + "=========");
        lore.add(ChatColor.DARK_AQUA + "Tier 1");
        lore.add(ChatColor.BLUE + "Damage: 0");
        lore.add(ChatColor.DARK_GRAY + "=========");
        meta.setLore(lore);

        //other stuffs
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        item.setItemMeta(meta);
        testStaff = item;
    }
}
