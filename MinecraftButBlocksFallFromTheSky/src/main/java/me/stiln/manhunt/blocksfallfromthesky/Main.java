package me.stiln.manhunt.blocksfallfromthesky;

import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;


public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new playerdisconnect(), this);
        getServer().getPluginManager().registerEvents(new playerjoin(), this);
        getServer().getPluginManager().registerEvents(new blockLand(), this);
        ArrayList<Material> list = new ArrayList<Material>(List.of(Material.values()));
        int num = (int)(Math.random() * list.size());
        list.remove(Material.WATER);
        list.remove(Material.LAVA);
        //System.out.println(list);
        this.getServer().getPluginCommand("fallingblocks").setExecutor(new add());
        SummonBlocks task = new SummonBlocks();
        task.runTaskTimer(this, 0, 1);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
