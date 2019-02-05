package me.shoko.moongenerator.utils;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class BlockUtil {

    /**
     * Iteratively determines the highest moon rock block
     *
     * @return Block highest non-air
     */
    public static Integer getHighestBlock(Location loc, Chunk source) {
        // Return the highest block and get Y
        for (int i = source.getWorld().getMaxHeight(); i >= 0; i--) {

            Location nloc = new Location(loc.getWorld(), loc.getX(), i, loc.getZ());

            if(nloc.getBlock().getType() != Material.AIR && nloc.getBlock().getType() != Material.BARRIER) {
                return i + 1;
            }

            /* find highest moon rock block
            if ((block = source.getBlock(x, i, z)).getType() == Material.DEAD_BRAIN_CORAL_BLOCK) {
                return block;
            }*/
        }
        return 1;
    }
}
