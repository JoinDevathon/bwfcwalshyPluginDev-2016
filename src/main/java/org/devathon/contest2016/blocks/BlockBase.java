package org.devathon.contest2016.blocks;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

public interface BlockBase {

    String getName();

    ItemStack getItem();

    Recipe getRecipe();
}
