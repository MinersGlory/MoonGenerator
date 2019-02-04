package me.shoko.moongenerator.utils;

import org.bukkit.Chunk;
import org.bukkit.Material;

public class BlockUtil {

    public static int getHighestBlock(int x, int z, Chunk source) {
        for(int y = 10; y < 256;y++) {
            if(source.getBlock(x, y, z).getRelative(0,1,0).getType() == Material.DEAD_BRAIN_CORAL_BLOCK && source.getBlock(x, y, z).getType() == Material.AIR) {
                return y;
            }
        }
        return 0;
    }
}
