package me.lownzy.magicmayhem.commands;

import me.lownzy.magicmayhem.items.ItemManagerTestingItems;
import me.lownzy.magicmayhem.items.ItemManagerWeapons;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ItemCreator implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("You're not a player!");
            return true;
        }
        Player player = (Player) sender;

        //darkStaffs
        if (command.getName().equalsIgnoreCase("allStaffs")) {
            player.getInventory().addItem(ItemManagerWeapons.darkStaffT1);
            player.getInventory().addItem(ItemManagerWeapons.darkStaffT2);
        }


        if (command.getName().equalsIgnoreCase("darkStaffT1")) {
            player.getInventory().addItem(ItemManagerWeapons.darkStaffT1);
        }

        if (command.getName().equalsIgnoreCase("darkStaffT2")) {
            player.getInventory().addItem(ItemManagerWeapons.darkStaffT2);
        }

        if (command.getName().equalsIgnoreCase("testStaff")) {
            player.getInventory().addItem(ItemManagerTestingItems.testStaff);
        }


        //swords
        if (command.getName().equalsIgnoreCase("givesword")) {
            player.getInventory().addItem(ItemManagerWeapons.sword);
        }
        return true;
    }
}
