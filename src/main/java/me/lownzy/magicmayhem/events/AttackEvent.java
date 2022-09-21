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

    public AttackEvent(MagicMayhem plugin) {

        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDamaged(EntityDamageByEntityEvent event) {

        if (!(event.getDamager() instanceof Player)) {
            return;
        }

        if (event.getDamage() == 0) {
            return;
        }

        Player player = (Player) event.getDamager();

        double damage = Math.round(event.getDamage());

        Entity EventEntity = event.getEntity();

        int entityHealth = 0;

        if (EventEntity instanceof LivingEntity && entityHealth == 0) {
            entityHealth = (int) ((LivingEntity) EventEntity).getHealth();
        }

        if ((entityHealth - damage) > 0) {
            entityHealth = (int) (entityHealth - damage);
        } else {
            entityHealth = 0;
        }


        Bukkit.broadcastMessage(String.valueOf(entityHealth));

        EventEntity.setCustomName(ChatColor.RED +""+ entityHealth + "❤");


        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            EventEntity.setCustomName(null);
        }, 2 * 20L);


        ChatColor ActionBarTextColor = ChatColor.DARK_GRAY;
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ActionBarTextColor + "You have dealt " + ChatColor.RED + "❈" + damage + ActionBarTextColor + " to " + event.getEntityType()));
    }
}
