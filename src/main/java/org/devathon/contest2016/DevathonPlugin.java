package org.devathon.contest2016;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
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
    }

    public Handler getHandler(){
        return this.handler;
    }
}

