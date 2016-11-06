package org.devathon.contest2016.machines;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

public interface IMachine {

    // This will be the machine name
    String getName();

    // Get the ItemStack of the machine
    ItemStack getItem();

    // This is just so they are easier to identify while looping and doing other actions.
    Machine getMachineEnum();

    // This will be how to craft the machine
    Recipe getRecipe();

    // Handle interactions with the machine.
    void handleInteract(Player player, Block b);

    // Handle the save if any extra data is needed in there.
    void handleSave();
}
