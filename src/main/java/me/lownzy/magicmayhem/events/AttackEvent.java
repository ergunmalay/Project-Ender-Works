package me.lownzy.magicmayhem.events;

import me.lownzy.magicmayhem.MagicMayhem;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class AttackEvent implements Listener {

    private final MagicMayhem plugin;

    // constructor to initialize the plugin variable
    public AttackEvent(MagicMayhem plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDamaged(EntityDamageByEntityEvent event) {

        // check if damager is a player
        if (!(event.getDamager() instanceof Player)) {
            return;
        }

        // check if the damage dealt is greater than 0
        if (event.getDamage() == 0) {
            return;
        }

        Player player = (Player) event.getDamager();

        double damage = Math.round(event.getDamage());

        Entity EventEntity = event.getEntity();

        int entityHealth = 0;

        // check if the damaged entity is a living entity and its health is 0
        if (EventEntity instanceof LivingEntity) {
            entityHealth = (int) ((LivingEntity) EventEntity).getHealth();
        }

        // update the entity's health after taking damage
        if ((entityHealth - damage) > 0) {
            entityHealth = (int) (entityHealth - damage);
        } else {
            entityHealth = 0;
        }

        // broadcast the entity's new health
        Bukkit.broadcastMessage(String.valueOf(entityHealth));

        // set the entity's custom name to its health
        EventEntity.setCustomName(ChatColor.RED +""+ entityHealth + "❤");

        // schedule a task to remove the entity's custom name after 2 seconds
        Bukkit.getScheduler().runTaskLater(plugin, () -> EventEntity.setCustomName(null), 2 * 20L);

        // send the player a message in the action bar displaying the damage dealt
        ChatColor ActionBarTextColor = ChatColor.DARK_GRAY;
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ActionBarTextColor + "You have dealt " + ChatColor.RED + "❈" + damage + ActionBarTextColor + " to " + event.getEntityType()));

    }
}