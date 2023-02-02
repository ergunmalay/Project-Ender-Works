package me.lownzy.magicmayhem.events;

import me.lownzy.magicmayhem.items.ItemManagerWeapons;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

public class ComboEvent implements Listener {
    private final Map<String, String> playerOrder = new HashMap<>();

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        //Get the player who interacted
        Player player = event.getPlayer();
        //Get the hand the player interacted with
        EquipmentSlot hand = event.getHand();

        //Get the order of clicks for the current player
        String order = playerOrder.getOrDefault(player.getName(), "");

        //Check if the item is not a stick, return if it is not
        if (!(Objects.requireNonNull(event.getItem()).isSimilar(ItemManagerWeapons.darkStaffT1))) {
            return;
        }

        //Check if the player interacted with their offhand, return if they did
        if (hand != null && hand.equals(EquipmentSlot.OFF_HAND)) {
            return;
        }

        //Check if the order is empty and the player performed a left-click, return if they did
        if (order.isEmpty() && event.getAction().name().contains("LEFT")) {
            return;
        }

        //If the player performed a right-click
        if (event.getAction().name().contains("RIGHT")) {
            //Append R to the order
            order += "R";
            //Send the order as a message in the action bar
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(order));

            //If the player performed a left-click
        } else if (event.getAction().name().contains("LEFT")) {
            //Append L to the order
            order += "L";
            //Send the order as a message in the action bar
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(order));
        }

        //Save the updated order for the current player
        playerOrder.put(player.getName(), order);

        //Check if the order is less than 3 clicks, return if it is
        if (order.length() < 3) {
            return;
        }

        //Check the order and send appropriate message to the player
        switch (order) {
            case "RLL":
                player.sendMessage(ChatColor.AQUA + "You have clicked the stick in the order RLL.");
                break;
            case "RLR":
                player.sendMessage(ChatColor.GREEN + "You have clicked the stick in the order RLR.");
                break;
            case "RRR":
                player.sendMessage(ChatColor.RED + "You have clicked the stick in the order RRR.");
                HashSet<Material> transparent = new HashSet<>();
                transparent.add(Material.AIR);
                Block block = player.getTargetBlock(transparent, 200);
                for (int i = 0; i < 5; i++) {
                    player.getWorld().strikeLightning(block.getLocation());
                }
                break;
            case "RRL":
                player.sendMessage(ChatColor.RED + "You have clicked the stick in the order RRL.");
                break;
            default:
                player.sendMessage(ChatColor.GOLD + "Invalid Combo sequence.");
                break;
        }

        //Remove the order for the current player
        playerOrder.remove(player.getName());
    }
}