package me.lownzy.magicmayhem.events;

import me.lownzy.magicmayhem.items.ItemManagerWeapons;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import java.util.List;

public class darkStaffT1ShootEvent implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        if (event.getItem() == null) {
            return;
        }
        if (!(event.getItem().getItemMeta().equals(ItemManagerWeapons.darkStaffT1.getItemMeta()))) {
            return;
        }

        double BlocksToShoot = 10; //Number of blocks to shoot for if 10 the beam will be 10 blocks long

        Location end = player.getEyeLocation().clone().add(player.getEyeLocation().getDirection().normalize().multiply(BlocksToShoot));
        Location start = player.getEyeLocation();
        //Change this to change what particle comes out
        Particle particle = Particle.ASH;

        double d = start.distance(end) / 10;
        for (double i = 0; i < 10; i = i + 0.1) {
            Location l = start.clone();
            Vector direction = end.toVector().subtract(start.toVector()).normalize();
            Vector v = direction.multiply(i * d);
            l.add(v.getX(), v.getY(), v.getZ());
            start.getWorld().spawnParticle(particle, l, 0);

            List<Entity> near = l.getWorld().getEntities();

            for (Entity e : near) {
                if (e.getLocation().distance(l) <= 1.5D) {
                    if (e instanceof LivingEntity && !(e instanceof Player)) ((LivingEntity) e).damage(3, player);//player should be assigned to whoever ran the event ;Wink;
                }
            }
        }
    }
}