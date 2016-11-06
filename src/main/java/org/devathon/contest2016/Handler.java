package org.devathon.contest2016;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.devathon.contest2016.blocks.BlockBase;
import org.devathon.contest2016.blocks.BlockBreaker;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Handler {

    private Set<BlockBase> registry;
    private Map<Location, BlockBase> blocks;

    public Handler(){
        blocks = new HashMap<>();
        registry = new HashSet<>();
    }

    public void addBlock(BlockBase block, Location loc){
        this.blocks.put(loc, block);
    }

    public void removeBlock(Location location) {
        if(this.blocks.containsKey(location))
            this.blocks.remove(location);
    }

    private void registerBlock(BlockBase block){
        this.registry.add(block);
    }

    public boolean isBlock(ItemStack is){
        for(BlockBase block : registry){
            if(block.getItem().isSimilar(is))
                return true;
        }
        return false;
    }

    public boolean isBlock(Location loc){
        return blocks.containsKey(loc);
    }

    public BlockBase getBlock(ItemStack is){
        for(BlockBase block : registry){
            if(block.getItem().isSimilar(is))
                return block;
        }
        return null;
    }

    public void registerBlocks() {
        registerBlock(new BlockBreaker());
    }

    // This is best to call after the register blocks since this uses the registry.
    public void registerRecipes(){
        registry.forEach(block -> { if(block.getRecipe() != null) Bukkit.addRecipe(block.getRecipe()); });
    }

    public Map<Location, BlockBase> getBlocks() {
        return blocks;
    }
}
