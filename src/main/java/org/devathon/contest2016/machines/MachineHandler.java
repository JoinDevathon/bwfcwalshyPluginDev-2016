package org.devathon.contest2016.machines;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.devathon.contest2016.DevathonPlugin;

import java.util.HashMap;
import java.util.Map;

public class MachineHandler {

    private Map<Location, Machine> machines;

    private DevathonPlugin plugin;
    public MachineHandler(DevathonPlugin pl){
        this.plugin = pl;

        machines = new HashMap<>();
    }

    public boolean isMachine(Block b){
        return machines.containsKey(b.getLocation());
    }

    public boolean isMachine(ItemStack is) {
        for (Machine machine : plugin.getMachines()) {
            if (is.isSimilar(machine.getItem()))
                return true;
        }
        return false;
    }

    public Machine getMachine(Location loc){
        if(machines.containsKey(loc))
            return machines.get(loc);
        return null;
    }

    public boolean isItem(ItemStack is){
        return false;
    }

    public Map<Location,Machine> getMachines() {
        return machines;
    }
}
