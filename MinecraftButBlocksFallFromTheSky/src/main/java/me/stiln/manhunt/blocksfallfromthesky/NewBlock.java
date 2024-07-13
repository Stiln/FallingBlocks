package me.stiln.manhunt.blocksfallfromthesky;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.FallingBlock;

import java.util.ArrayList;
import java.util.List;


public class NewBlock {
    public static void newblock(Location location) {
        ArrayList<Material> list = new ArrayList<Material>(List.of(Material.values()));
        int num = (int)(Math.random() * list.size());
        list.remove(Material.WATER);
        list.remove(Material.LAVA);
        list.remove(Material.KELP_PLANT);
        list.remove(Material.KELP);
        list.remove(Material.CONDUIT);
        try {


            if (!list.get(num).toString().contains("CORAL")) {
                if (!list.get(num).toString().contains("SEA")) {
                    if (!list.get(num).toString().contains("WATER")) {
                        if (!list.get(num).toString().contains("LAVA")) {
                        }
                        //if (!list.get(num).toString().contains("CANDLE") && !list.get(num).toString().contains("CAKE")) {


                            BlockData data = Bukkit.createBlockData(list.get(num));

                            FallingBlock block = location.getWorld().spawnFallingBlock(location, data);
                        //}
                    }
                }
            }
        }


                //System.out.println("summoned block: " + list.get(num) + ", at coordinates: X: " + location.getX() + ", Y:" + location.getY() + ", Z: " + location.getZ());



        catch (Exception e) {
            //System.out.println("couldn't summon block: " + list.get(num).toString());
            //System.out.println(num);

        }

    }
}
