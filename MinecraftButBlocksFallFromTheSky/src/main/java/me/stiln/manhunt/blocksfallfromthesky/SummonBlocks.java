package me.stiln.manhunt.blocksfallfromthesky;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.management.PlatformLoggingMXBean;

public class SummonBlocks extends BukkitRunnable {
    @Override
    public void run() {
        if (hunters.started == false) {
            return;
        } else {
            for (int a = 0; a < hunters.players.size(); a++) {
                Player player = hunters.players.get(a);
                double BlockX = player.getLocation().getX() - player.getClientViewDistance();
                BlockX += Math.random() * player.getClientViewDistance()*2;

                double BlockZ = player.getLocation().getZ() - player.getClientViewDistance();
                BlockZ += Math.random() * player.getClientViewDistance()*2;
                //System.out.println(player.getLocation());
                for (double i = (player.getLocation().getY() + 10); i < (player.getLocation().getY() + 100); i++) {
                    if (!player.getLocation().getWorld().getBlockAt(new Location(player.getWorld(), BlockX, i, BlockZ)).getType().equals(Material.AIR)) { //sees if location is air, if not, it goes to the block beneath it
                        if (player.getLocation().getWorld().getBlockAt(new Location(player.getWorld(), BlockX, i - 1, BlockZ)).getType().equals(Material.AIR)) { //if block underneath is air, summons block there
                            NewBlock.newblock(new Location(player.getWorld(), BlockX, i - 1, BlockZ));
                        }
                        break;
                    } else if (i == (player.getLocation().getY() + 99)) { //summons block anyway - incase there are no blocks above the player

                        NewBlock.newblock(new Location(player.getWorld(), BlockX, i, BlockZ));
                        break;

                    }
                }
            }
        }
    }
}
