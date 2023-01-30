package me.lownzy.magicmayhem.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ItemManagerWeapons {

    public static ItemStack darkStaffT1;
    public static ItemStack darkStaffT2;
    public static ItemStack sword;

    public static void init() {
        darkStaffT1();
        darkStaffT2();
        createSword();
    }

    //darkStaffs
    private static void darkStaffT1() {
        ItemStack item = new ItemStack(Material.ECHO_SHARD, 1);
        ItemMeta meta = item.getItemMeta();
        Objects.requireNonNull(meta).setDisplayName(ChatColor.DARK_GRAY + "Dark Staff T1");

        List<String> lore = new ArrayList<>();

        //lore
        lore.add(ChatColor.DARK_GRAY + "=========");
        lore.add(ChatColor.DARK_AQUA + "Tier 1");
        lore.add(ChatColor.BLUE + "Damage: 3");
        lore.add(ChatColor.DARK_GRAY + "=========");
        meta.setLore(lore);

        //other stuffs
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        item.setItemMeta(meta);
        darkStaffT1 = item;
    }

    private static void darkStaffT2() {
        ItemStack item = new ItemStack(Material.FLINT, 1);
        ItemMeta meta = item.getItemMeta();
        Objects.requireNonNull(meta).setDisplayName(ChatColor.DARK_GRAY + "Dark Staff T2");

        List<String> lore = new ArrayList<>();

        //lore
        lore.add(ChatColor.DARK_GRAY + "=========");
        lore.add(ChatColor.DARK_AQUA + "Tier 2");
        lore.add(ChatColor.BLUE + "Damage: 5");
        lore.add(ChatColor.DARK_GRAY + "=========");
        meta.setLore(lore);

        //other stuffs
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        item.setItemMeta(meta);
        darkStaffT2 = item;
    }




    //Swords
    private static void createSword() {
        ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        Objects.requireNonNull(meta).setDisplayName(ChatColor.DARK_AQUA + "Sword of Hero's");

        List<String> lore = new ArrayList<>();

        //lore
        lore.add(ChatColor.DARK_GRAY + "=========");
        lore.add(ChatColor.BLUE + "Damage: 3");
        lore.add(ChatColor.DARK_GRAY + "=========");
        meta.setLore(lore);

        //other stuffs
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(),
                "GENERIC_ATTACK_DAMAGE", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND
        ));

        item.setItemMeta(meta);
        sword = item;
    }
}
