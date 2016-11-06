package org.devathon.contest2016.blocks;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

public interface BlockBase {

    String getSimpleName();

    String getName();

    ItemStack getItem();

    Recipe getRecipe();

    void tick(Location loc);
}
