package org.devathon.contest2016;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.devathon.contest2016.blocks.BlockBase;
import org.devathon.contest2016.tasks.BlockTickTask;

import java.io.File;

public class DevathonPlugin extends JavaPlugin {

    private Handler handler;
    private BukkitTask tickTask;

    @Override
    public void onEnable() {
        if(!new File(getDataFolder(), "config.yml").exists())
            saveDefaultConfig();

        handler = new Handler();
        handler.registerBlocks();
        handler.registerRecipes();

        getServer().getPluginManager().registerEvents(new Events(this), this);

        tickTask = getServer().getScheduler().runTaskTimer(this, new BlockTickTask(this), 20L, 20L);
    }

    @Override
    public void onDisable() {
        tickTask.cancel();

        // Save data
        for(Location loc : handler.getBlocks().keySet()){
            BlockBase block = handler.getBlocks().get(loc);

            getConfig().set("Blocks." + getLocationString(loc) + ".Block", block.getSimpleName());
        }
    }

    public Handler getHandler(){
        return this.handler;
    }

    private String getLocationString(Location loc){
        return loc.getWorld().getName() + "," + loc.getBlockX() + "," + loc.getBlockY() + "," + loc.getBlockZ();
    }

    private Location getLocationFromString(String s){
        String[] split = s.split(",");
        if(split.length != 4) return null;
        return new Location(Bukkit.getWorld(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]))
    }
}

