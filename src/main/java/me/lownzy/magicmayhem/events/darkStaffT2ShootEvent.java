package me.lownzy.magicmayhem.events;

import me.lownzy.magicmayhem.items.ItemManagerWeapons;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class darkStaffT2ShootEvent implements Listener {
    private static final Particle PARTICLE = Particle.ASH;

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (!(Objects.requireNonNull(event.getItem()).isSimilar(ItemManagerWeapons.darkStaffT2))) {
            return;
        }

        if (event.getAction().name().contains("RIGHT")) {
            return;
        }

        double blocksToShoot = 10;
        int damage = 5;
        double range = 1.5;


        Location start = player.getEyeLocation();
        Location end = start.clone().add(start.getDirection().normalize().multiply(blocksToShoot));
        shootEvent.onShoot(blocksToShoot, start, end, PARTICLE, player, damage, range);
    }
}
