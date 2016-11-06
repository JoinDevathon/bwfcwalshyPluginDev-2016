package org.devathon.contest2016;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import org.devathon.contest2016.machines.Generator;
import org.devathon.contest2016.machines.IronFurnace;
import org.devathon.contest2016.machines.Machine;
import org.devathon.contest2016.machines.MachineHandler;

import java.util.HashSet;
import java.util.Set;

public class DevathonPlugin extends JavaPlugin {

    private Set<Machine> registries;

    private MachineHandler machineHandler;

    @Override
    public void onEnable() {
        registries = new HashSet<>();
        registries.add(new IronFurnace());
        registries.add(new Generator());

        // Load from data.yml

        registries.forEach(machine -> {if(machine.getRecipe() != null) getServer().addRecipe(machine.getRecipe());});
    }

    @Override
    public void onDisable() {

    }

    public void registerMachine(Location loc, Machine machine){
        this.machineHandler.getMachines().put(loc, machine);
    }

    public MachineHandler getMachineHandler() {
        return machineHandler;
    }

    public Set<Machine> getMachineInstances() {
        return registries;
    }
}

