package me.lownzy.magicmayhem;

import me.lownzy.magicmayhem.commands.ItemCreator;
import me.lownzy.magicmayhem.events.AttackEvent;
import me.lownzy.magicmayhem.events.ComboEvent;
import me.lownzy.magicmayhem.events.darkStaffT1ShootEvent;
import me.lownzy.magicmayhem.events.darkStaffT2ShootEvent;
import me.lownzy.magicmayhem.items.ItemManagerWeapons;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.Objects;

public final class MagicMayhem extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.broadcastMessage("Updated 1.0.0");
        ItemManagerWeapons.init();

        //commands

        //darkStaffs
        for (String s : Arrays.asList("darkStaffT1", "darkStaffT2", "allStaffs", "testStaff", "givesword")) {
            Objects.requireNonNull(getCommand(s)).setExecutor(new ItemCreator());
        }


        //Events
        getServer().getPluginManager().registerEvents(new darkStaffT1ShootEvent(), this);
        getServer().getPluginManager().registerEvents(new darkStaffT2ShootEvent(), this);
        getServer().getPluginManager().registerEvents(new ComboEvent(), this);


        getServer().getPluginManager().registerEvents(new AttackEvent(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
