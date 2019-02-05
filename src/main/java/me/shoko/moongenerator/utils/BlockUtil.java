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
    public static Location getHighestBlock(World world, Random random) {
        int x = random.nextInt(world.getMaxHeight()) - world.getMaxHeight() / 2;
        int z = random.nextInt(world.getMaxHeight()) - world.getMaxHeight() / 2;
        return new Location(world, x, world.getHighestBlockYAt(x, z), z);
    }
}
