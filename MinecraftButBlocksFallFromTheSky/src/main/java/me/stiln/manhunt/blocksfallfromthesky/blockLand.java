package me.stiln.manhunt.blocksfallfromthesky;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.loot.LootContext;
import org.bukkit.loot.LootTable;
import org.bukkit.loot.LootTables;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class blockLand implements Listener {
    @EventHandler
    public void blockchangestate(EntityChangeBlockEvent event) {

        FallingBlock fb = (FallingBlock) event.getEntity();
        if (fb.getBlockData().getMaterial().equals(Material.CHEST) || fb.getBlockData().getMaterial().equals(Material.SHULKER_BOX) || fb.getBlockData().getMaterial().equals(Material.ORANGE_SHULKER_BOX) || fb.getBlockData().getMaterial().equals(Material.BLUE_SHULKER_BOX) || fb.getBlockData().getMaterial().equals(Material.BLACK_SHULKER_BOX)  || fb.getBlockData().getMaterial().equals(Material.BROWN_SHULKER_BOX) || fb.getBlockData().getMaterial().equals(Material.CYAN_SHULKER_BOX)  || fb.getBlockData().getMaterial().equals(Material.GREEN_SHULKER_BOX) || fb.getBlockData().getMaterial().equals(Material.MAGENTA_SHULKER_BOX)  || fb.getBlockData().getMaterial().equals(Material.WHITE_SHULKER_BOX) || fb.getBlockData().getMaterial().equals(Material.RED_SHULKER_BOX)) {
            System.out.println("Chest Positioned At " + event.getBlock().getLocation().getX() + ", " + event.getBlock().getLocation().getY() + ", " + event.getBlock().getLocation().getZ());
            fb.setDropItem(false);
            event.setCancelled(true);
            Block highestblock = event.getBlock().getLocation().getWorld().getHighestBlockAt((int) event.getBlock().getLocation().getX(), (int) event.getBlock().getLocation().getZ());
            Block block = highestblock.getLocation().getWorld().getBlockAt(highestblock.getLocation().add(0, 1, 0));
            block.setType(Material.CHEST);
            Chest chest = (Chest) block.getState();

            ArrayList<Material> list = new ArrayList<Material>(List.of(Material.values()));
            for (int i = 0; i < 26; i++) {
                int num = (int) (Math.random() * list.size());

                //chest.setLootTable(list.get(num).getLootTable());
                chest.getInventory().setItem(i, new ItemStack(list.get(num)));
            }
        }
        if (fb.getBlockData().getMaterial().equals(Material.BLUE_TERRACOTTA)) {
            fb.setDropItem(false);
            event.setCancelled(true);
            event.getBlock().setType(Material.WATER);
        }
        if (fb.getBlockData().getMaterial().equals(Material.ORANGE_TERRACOTTA)) {
            fb.setDropItem(false);
            event.setCancelled(true);
            event.getBlock().setType(Material.LAVA);
        }
    }
}
