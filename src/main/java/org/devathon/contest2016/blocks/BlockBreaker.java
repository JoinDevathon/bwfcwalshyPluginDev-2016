package org.devathon.contest2016.blocks;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.block.Skull;
import org.bukkit.entity.Item;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;
import org.devathon.contest2016.CustomHead;

import java.util.Arrays;
import java.util.Random;

public class BlockBreaker implements BlockBase {

    private Random rand = new Random();

    @Override
    public String getSimpleName() {
        return "BlockBrealer";
    }

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
        Block b = location.getBlock();
        Skull skull = (Skull) b.getState();
        // If powered it will stop.
        if(b.isBlockPowered())
            return;

        Block b2 = b.getRelative(skull.getRotation());
        if(b2.getType() != Material.AIR && b2.getType() != Material.BEDROCK){
            // Now to check if there's a chest
            if(b.getRelative(BlockFace.UP).getType() == Material.CHEST || b.getRelative(BlockFace.UP).getType() == Material.TRAPPED_CHEST ||
                    b.getRelative(BlockFace.DOWN).getType() == Material.CHEST || b.getRelative(BlockFace.DOWN).getType() == Material.TRAPPED_CHEST){
                Block chestBlock = (b.getRelative(BlockFace.UP).getType() == Material.CHEST ? b.getRelative(BlockFace.UP) : b.getRelative(BlockFace.DOWN));
                Chest chest = (Chest) chestBlock.getState();
                // Check if inv is full
                ItemStack is = new ItemStack(b2.getType(), 1, (short) b2.getState().getData().getData());
                if(canFit(chest.getInventory(), is))
                    chest.getInventory().addItem(is);
                else{
                    Item item = b.getLocation().getWorld().dropItemNaturally(b.getLocation().add(0, 1, 0), new ItemStack(b2.getType(), 1, (short) b2.getState().getData().getData()));
                    item.setVelocity(new Vector(rand.nextDouble()/4, 0.5, rand.nextDouble()/4));
                }
            }else{
                // Spit it out
                Item item = b.getLocation().getWorld().dropItemNaturally(b.getLocation().add(0, 1, 0), new ItemStack(b2.getType(), 1, (short) b2.getState().getData().getData()));
                item.setVelocity(new Vector(rand.nextDouble()/2, 0.5, rand.nextDouble()/2));
            }

            b2.setType(Material.AIR);
        }
    }

    private boolean canFit(Inventory inv, ItemStack is){
        for(ItemStack stack : inv.getContents()){
            if(stack != null && stack.getType() != Material.AIR){
                if(stack.getAmount() < stack.getMaxStackSize()) {
                    if (stack.getType() == is.getType() && stack.getData().getData() == is.getData().getData())
                        return true;
                }
            }else {
                // Empty slot
                return true;
            }
        }
        return false;
    }
}
