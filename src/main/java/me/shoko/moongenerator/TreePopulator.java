package me.shoko.moongenerator;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

import java.io.File;
import java.util.Random;

public class TreePopulator extends BlockPopulator {
    private static final int SMALL_TREE_CHANCE = 4; // 4 out of 100 chance


    int amount;

    @Override
    public void populate(World world, Random random, Chunk source) {

        //TODO: Make string dynamic and add all schem files in /schematics/trees to a for each (?)
        String schem = "moon_mushroom";

        if (random.nextBoolean()) {
            amount = random.nextInt(4) + 1; // Amount of trees
            for (int i = 1; i < amount; i++) {
                int X = random.nextInt(15);
                int Z = random.nextInt(15);
                int Y = world.getHighestBlockYAt(X, Z) + 1;;
                for (int j = world.getMaxHeight()-1; source.getBlock(X, j, Z).getType() == Material.AIR; j--); // Find the highest block of the (X,Z) coordinate chosen.
                int chance = random.nextInt(100);
                if (chance > 34) {
                    SchemUtil.loadSchem(source.getBlock(X, Y, Z).getLocation(), schem);

                    // For debugging to see if this even triggers
                    MoonGenerator.getPlugin().getLogger().info("A SCHEM HAS BEEN SPAWNED");
                }
            }
        }

    }
}
