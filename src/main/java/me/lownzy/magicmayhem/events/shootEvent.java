package me.lownzy.magicmayhem.events;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.Objects;

public class shootEvent {
    /**
     * This method creates particles and damages nearby entities, including players
     *
     * @param blocksToShoot number of blocks to shoot
     * @param start start location
     * @param end end location
     * @param particle particle to spawn
     * @param damager entity responsible for the damage
     * @param DAMAGE amount of damage to deal
     * @param RANGE range of damage
     */
    public static void onShoot(double blocksToShoot, Location start, Location end, Particle particle, Player damager, int DAMAGE, double RANGE) {
        // step size for spawning particles
        double d = start.distance(end) / blocksToShoot;

        for (double i = 0; i < blocksToShoot; i = i + 0.1) {
            Location l = start.clone();
            Vector direction = end.toVector().subtract(start.toVector()).normalize();
            Vector v = direction.multiply(i * d);
            l.add(v.getX(), v.getY(), v.getZ());
            // spawn particle at location 'l'
            Objects.requireNonNull(start.getWorld()).spawnParticle(particle, l, 0);
            // get nearby entities
            List<Entity> entities = (List<Entity>) Objects.requireNonNull(l.getWorld()).getNearbyEntities(l, RANGE, RANGE, RANGE);
            for (Entity entity : entities) {
                // check if entity is a living entity and within range
                if (entity instanceof LivingEntity && entity.getLocation().distance(l) <= RANGE) {
                    // damage nearby entities, including players
                    ((LivingEntity) entity).damage(DAMAGE, damager);
                }
            }
        }
    }
}
