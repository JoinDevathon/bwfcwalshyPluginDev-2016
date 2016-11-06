package org.devathon.contest2016;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class DevathonPlugin extends JavaPlugin {

    private Handler handler;

    @Override
    public void onEnable() {
        if(!new File(getDataFolder(), "config.yml").exists())
            saveDefaultConfig();

        handler = new Handler();
        handler.registerBlocks();
        handler.registerRecipes();

        getServer().getPluginManager().registerEvents(new Events(this), this);
    }

    @Override
    public void onDisable() {
    }

    public Handler getHandler(){
        return this.handler;
    }
}

