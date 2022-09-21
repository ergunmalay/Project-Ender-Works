package me.lownzy.magicmayhem.events;

import me.lownzy.magicmayhem.items.ItemManagerTestingItems;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import static org.bukkit.event.block.Action.LEFT_CLICK_AIR;
import static org.bukkit.event.block.Action.RIGHT_CLICK_AIR;


public class comboTestEvent implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        if (event.getItem() == null) {
            return;
        }
        if (!(event.getItem().getItemMeta().equals(ItemManagerTestingItems.testStaff.getItemMeta()))) {
            return;
        }
        if (!(event.getAction().equals(RIGHT_CLICK_AIR))) {
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText( ChatColor.BLUE +"Pew"));
        }

        if (event.getAction().equals(RIGHT_CLICK_AIR)) {
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText( ChatColor.BLUE +"You have Started a combo! _ + _ + _"));
        }






    }
}