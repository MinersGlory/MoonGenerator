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
        String moonshroom = "moon_mushroom";
        String moontreelarge = "moon_treelarge";
        String moontreemedium = "moon_treemedium";
        String moontreesmall = "moon_treesmall";

        if (random.nextBoolean()) {
            amount = random.nextInt(4) + 1; // Amount of trees
        for (int i = 1; i < amount; i++)
        {
                int X = random.nextInt(15);
                int Z = random.nextInt(15);
                int Y;


                //int Y = world.getHighestBlockYAt(X, Z) + 1;;
                // TODO: Correctly 0-255 getBlock() scan for highest source block
                for (Y = world.getHighestBlockYAt(X, Z)+1; source.getBlock(X, Y, Z).getType() == Material.DEAD_BRAIN_CORAL_BLOCK;); // Find highest surface block of the (Y) coordinate.
                Y -= 1;


                //for (int j = world.getMaxHeight()-1; source.getBlock(X, j, Z).getType() == Material.AIR; j--); // Find the highest block of the (X,Z) coordinate chosen.


                int chance = random.nextInt(100);
                if (chance > 97) {
                    SchemUtil.loadSchem(source.getBlock(X, Y, Z).getLocation(),moonshroom);

                    // DEBUG
                    //MoonGenerator.getPlugin().getLogger().info("SPAWNED A MOONSHROOM");
                }
                if (chance  > 86) {
                    SchemUtil.loadSchem(source.getBlock(X, Y, Z).getLocation(),moontreelarge);


                    // DEBUG
                    //MoonGenerator.getPlugin().getLogger().info("SPAWNED A LARGE MOON TREE");
                }
                if (chance > 64) {
                    SchemUtil.loadSchem(source.getBlock(X, Y, Z).getLocation(),moontreemedium);


                    // DEBUG
                    //MoonGenerator.getPlugin().getLogger().info("SPAWNED A MEDIUM MOON TREE");
                }
                if (chance > 54) {
                    SchemUtil.loadSchem(source.getBlock(X, Y, Z).getLocation(),moontreesmall);


                    // DEBUG
                    //MoonGenerator.getPlugin().getLogger().info("SPAWNED A SMALL MOON TREE");
                }
            }
        }

    }
}
