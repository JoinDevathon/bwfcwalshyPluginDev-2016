package org.devathon.contest2016.blocks;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.devathon.contest2016.CustomHead;

import java.util.Arrays;

public class BlockBreaker implements BlockBase {

    @Override
    public String getName() {
        return ChatColor.GRAY + "Block Breaker";
    }

    @Override
    public ItemStack getItem() {
        ItemStack is = CustomHead.getSkull("http://textures.minecraft.net/texture/5e8057b7a7c3b14579b491f1cb3e9c809037181e3cec5e7aa37de8b95241ceb5");
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(getName());
        im.setLore(Arrays.asList(ChatColor.GRAY + "You can use this item to break any block that is in-front of it.", ChatColor.BLUE + "The items will go into a chest below or above, \n" +
                "if neither are there the items will be spat out."));
        is.setItemMeta(im);
        return is;
    }

    @Override
    public Recipe getRecipe() {
        return new ShapedRecipe(getItem()).shape("icc", "drc", "icc").setIngredient('c', Material.COBBLESTONE).setIngredient('d', Material.DIAMOND_PICKAXE)
                .setIngredient('i', Material.IRON_INGOT).setIngredient('r', Material.REDSTONE);
    }

    @Override
    public void tick(Location location) {

    }
}
