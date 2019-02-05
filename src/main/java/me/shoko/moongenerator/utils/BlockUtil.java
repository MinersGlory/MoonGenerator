package me.shoko.moongenerator.utils;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.util.Random;

public class BlockUtil {

    /**
     * Iteratively determines the highest moon rock block
     *
     * @return Block highest non-air
     */
    public static Block getHighestBlock(Chunk chunk, int x, int z) {
        for(int i=chunk.getWorld().getMaxHeight()-1; i>=0; i--) {
            Block b = chunk.getBlock(x, i, z);
            if(b.getType() != Material.AIR) {
                return b;
            }
        }
        return chunk.getBlock(x, 0, z);
    }
}
