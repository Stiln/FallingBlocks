package me.stiln.manhunt.blocksfallfromthesky;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class playerdisconnect implements Listener {
    @EventHandler
    public void playerleave(PlayerQuitEvent event) {
        hunters.players.remove(event.getPlayer());
    }
}
