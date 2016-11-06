package org.devathon.contest2016;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class Events implements Listener {

    private DevathonPlugin plugin;
    public Events(DevathonPlugin pl){
        this.plugin = pl;
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        if(plugin.getHandler().isBlock(e.getItemInHand())) {
            plugin.getHandler().addBlock(plugin.getHandler().getBlock(e.getItemInHand()), e.getBlockPlaced().getLocation());
        }
    }

    @EventHandler
    public void onRemove(BlockBreakEvent e){
        if(plugin.getHandler().isBlock(e.getBlock().getLocation())){
            plugin.getHandler().removeBlock(e.getBlock().getLocation());
        }
    }
}
