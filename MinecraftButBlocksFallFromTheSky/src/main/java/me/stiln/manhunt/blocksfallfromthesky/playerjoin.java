package me.stiln.manhunt.blocksfallfromthesky;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.UUID;

public class playerjoin implements Listener {
    @EventHandler
    public void playerJoin(PlayerJoinEvent event) {
        hunters.players.add(event.getPlayer());

    }
}
