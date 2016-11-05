package org.devathon.contest2016;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DevathonPlugin extends JavaPlugin {

    private Set<Machine> registries;
    private Map<Location, Machine> machines;

    @Override
    public void onEnable() {
        registries = new HashSet<>();
        registries.add(new IronFurnace());

        machines = new HashMap<>();

        // Load from data.yml

        registries.forEach(machine -> {if(machine.getRecipe() != null) getServer().addRecipe(machine.getRecipe());});
    }

    @Override
    public void onDisable() {

    }

    public void registerMachine(Location loc, Machine machine){
        this.machines.put(loc, machine);
    }
}

