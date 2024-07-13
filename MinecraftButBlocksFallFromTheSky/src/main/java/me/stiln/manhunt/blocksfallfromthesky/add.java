package me.stiln.manhunt.blocksfallfromthesky;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class add implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args[0].equals("start")) {
            hunters.started = true;
        }
        else if (args[0].equals("stop")) {
            hunters.started = false;
        }


        return false;
    }
}
