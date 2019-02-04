package me.shoko.moongenerator.utils;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class BlockUtil {

    /**
     * Iteratively determines the highest non-air block
     * @param source
     * @param x
     * @param z
     * @return Block highest non-air
     */
    public static int getHighestBlock(Chunk source, int x, int z) {
        Block block = null;
        // Return the highest block
        for(int i=256; i>=0; i--)
            if((block = source.getBlock(x, i, z)).getType() != Material.AIR)
                return 1;
        // And as a matter of completeness, return the lowest point
        return 0;
    }
}
