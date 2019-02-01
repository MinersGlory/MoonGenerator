package me.shoko.moongenerator;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

import java.io.File;
import java.util.Random;

public class TreePopulator extends BlockPopulator {

    @Override
    public void populate(World world, Random random, Chunk chunk) {

        //TODO: Make string dynamic and add all schem files in /schematics/trees to a for each (?)
        String schem = "moon_mushroom";
        File file = new File(MoonGenerator.getPlugin().getDataFolder() + File.separator + "/schematics/" + schem);

        if (random.nextBoolean()) {
            int amount = random.nextInt(4)+1; // Amount of trees
            for (int i = 1; i < amount; i++) {
                int X = random.nextInt(15);
                int Z = random.nextInt(15);
                int Y = 1;
                for (int j = world.getMaxHeight()-1; chunk.getBlock(X, j, Z).getType() == Material.AIR; j--); // Find the highest block of the (X,Z) coordinate chosen.
                SchemUtil.loadSchem(chunk.getBlock(X, Y, Z).getLocation(), schem);
            }
        }

    }
}
