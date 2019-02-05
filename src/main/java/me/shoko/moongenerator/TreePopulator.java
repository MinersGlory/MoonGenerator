package me.shoko.moongenerator;

import me.shoko.moongenerator.utils.BlockUtil;
import me.shoko.moongenerator.utils.SchemUtil;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;

public class TreePopulator extends BlockPopulator {
    private static final int SMALL_TREE_CHANCE = 4; // 4 out of 100 chance


    int amount;

    @Override
    public void populate(World world, Random random, Chunk chunk) {
        //TODO: Block face rotations at random for placement.
        //TODO: Make string dynamic and add all schem files in /schematics/trees to a for each (?)
        String moonshroom = "moon_mushroom";
        String moontreelarge = "moon_treelarge";
        String moontreemedium = "moon_treemedium";
        String moontreesmall = "moon_treesmall";

        if (random.nextBoolean()) {
            amount = random.nextInt(4) + 1; // Amount of trees

            for (int i = 1; i < amount; i++) {
                int X = random.nextInt(15);
                int Z = random.nextInt(15);
                int Y = 1;
                //int Y = world.getHighestBlockYAt(X,Z);
                for(int i2 = world.getMaxHeight()-1; chunk.getBlock(X, i2, Z).getType() == Material.DEAD_BRAIN_CORAL_BLOCK; i2--){

                    // set chance out of 100
                    int chance = random.nextInt(100);
                    if (chunk.getBlock(X, Y, Z).getType() == Material.DEAD_BRAIN_CORAL_BLOCK) {


                        if (chance > 97) {
                            SchemUtil.loadSchem(chunk.getBlock(X, Y, Z).getLocation(),moonshroom);

                            // DEBUG
                            //MoonGenerator.getPlugin().getLogger().info("SPAWNED A MOONSHROOM");
                        }
                    }

                    if (chunk.getBlock(X, Y, Z).getType() == Material.DEAD_BRAIN_CORAL_BLOCK) {
                        if (chance  > 86) {
                            SchemUtil.loadSchem(chunk.getBlock(X, Y, Z).getLocation(),moontreelarge);


                            // DEBUG
                            //MoonGenerator.getPlugin().getLogger().info("SPAWNED A LARGE MOON TREE");
                        }
                    }

                    if (chance > 64 && chunk.getBlock(X, Y, Z).getType() == Material.DEAD_BRAIN_CORAL_BLOCK) {
                        if (chance > 64) {
                            SchemUtil.loadSchem(chunk.getBlock(X, Y, Z).getLocation(),moontreemedium);


                            // DEBUG
                            //MoonGenerator.getPlugin().getLogger().info("SPAWNED A MEDIUM MOON TREE");
                        }
                    }

                    if (chunk.getBlock(X, Y, Z).getType() == Material.DEAD_BRAIN_CORAL_BLOCK) {

                        if (chance > 54) {
                            SchemUtil.loadSchem(chunk.getBlock(X, Y, Z).getLocation(),moontreesmall);


                            // DEBUG

                            //lets see what we get as Y coords
                            //MoonGenerator.getPlugin().getLogger().info(Integer.toString(Y));
                            //MoonGenerator.getPlugin().getLogger().info("SPAWNED A SMALL MOON TREE");
                        }
                    }

                }

                // TODO: Correctly 0-255 getBlock() scan for highest source block
                //for (Y = world.getHighestBlock(X, Z)-1; chunk.getBlock(X, Y, Z).getType() == Material.DEAD_BRAIN_CORAL_BLOCK; Y++); // Find highest surface block of the (Y) coordinate.
                //for (int j = world.getMaxHeight() - 1; chunk.getBlock(X, j, Z).getType() == Material.DEAD_BRAIN_CORAL_BLOCK; j--) Y = j; // Find the highest block of the (X,Z) coordinate chosen.
                //for (int j = world.getHighestBlockYAt(X, Z) - 1; chunk.getBlock(X, j, Z).getType() == Material.DEAD_BRAIN_CORAL_BLOCK; j--) Y = j; // Find the highest block of the (X,Z) coordinate chosen.


            }
        }
    }
}
