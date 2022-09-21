package me.lownzy.magicmayhem;

import me.lownzy.magicmayhem.commands.ItemCreator;
import me.lownzy.magicmayhem.events.AttackEvent;
import me.lownzy.magicmayhem.events.comboTestEvent;
import me.lownzy.magicmayhem.events.darkStaffT1ShootEvent;
import me.lownzy.magicmayhem.events.darkStaffT2ShootEvent;
import me.lownzy.magicmayhem.items.ItemManagerTestingItems;
import me.lownzy.magicmayhem.items.ItemManagerWeapons;
import org.bukkit.plugin.java.JavaPlugin;

public final class MagicMayhem extends JavaPlugin {

    @Override
    public void onEnable() {
        ItemManagerWeapons.init();
        ItemManagerTestingItems.init();

        //commands

        //darkStaffs
        getCommand("darkStaffT1").setExecutor(new ItemCreator());
        getCommand("darkStaffT2").setExecutor(new ItemCreator());
        getCommand("allStaffs").setExecutor(new ItemCreator());

        getCommand("testStaff").setExecutor(new ItemCreator());


        getCommand("givesword").setExecutor(new ItemCreator());

        //Events
        getServer().getPluginManager().registerEvents(new darkStaffT1ShootEvent(), this);
        getServer().getPluginManager().registerEvents(new darkStaffT2ShootEvent(), this);

        getServer().getPluginManager().registerEvents(new comboTestEvent(), this);

        getServer().getPluginManager().registerEvents(new AttackEvent(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
