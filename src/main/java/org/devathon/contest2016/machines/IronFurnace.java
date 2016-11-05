package org.devathon.contest2016.machines;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.devathon.contest2016.CustomHead;

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
        ItemStack furnace = CustomHead.getSkull("http://textures.minecraft.net/texture/8083cfb8c7b58182b93b2166c1a7c1d99887365d0db83e5c69381ebe658fa");
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
