package org.devathon.contest2016;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

public interface Machine {

    // This will be the machine name
    String getName();

    // Get the ItemStack of the machine
    ItemStack getItem();

    // This will be how to craft the machine
    Recipe getRecipe();

    // Handle interactions with the machine.
    // TODO: Make this take params and not just the event.
    void handleInteract();

    // Handle the save if any extra data is needed in there.
    void handleSave();
}
