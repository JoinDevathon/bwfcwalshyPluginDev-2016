package org.devathon.contest2016;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class IronFurnace implements Machine {

    @Override
    public String getName() {
        return ChatColor.GRAY + "Iron Furnace";
    }

    @Override
    public Recipe getRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(getItem());
        recipe.shape("iii", "i i", "iii");
        recipe.setIngredient('i', Material.IRON_INGOT);
        return recipe;
    }

    @Override
    public ItemStack getItem() {
        ItemStack furnace = new ItemStack(Material.SKULL_ITEM);
        ItemMeta im = furnace.getItemMeta();
        im.setDisplayName(getName());
        furnace.setItemMeta(im);
        return furnace;
    }

    @Override
    public void handleInteract() {

    }

    @Override
    public void handleSave() {

    }
}
