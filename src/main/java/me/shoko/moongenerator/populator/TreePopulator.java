package me.shoko.moongenerator.populator;

import me.shoko.moongenerator.MoonGenerator;
import me.shoko.moongenerator.utils.BlockUtil;
import me.shoko.moongenerator.utils.SchemUtil;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;

public class TreePopulator extends BlockPopulator {
    private static final int SMALL_TREE_CHANCE = 96; // 4 out of 100 chance

    public BlockFace[] faces = {BlockFace.NORTH, BlockFace.SOUTH, BlockFace.EAST, BlockFace.WEST};


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

                // Get highest block from chunk using custom method
                Block b = BlockUtil.getHighestBlock(chunk, X, Z);
                // set chance out of 100
                int chance = random.nextInt(100);
                if (b.getType() == Material.DEAD_BRAIN_CORAL_BLOCK) {


                    if (chance > 97) {
                        SchemUtil.loadSchem(chunk.getBlock(X, b.getLocation().getBlockY()+1, Z).getLocation(),moonshroom);

                            // DEBUG
                            //MoonGenerator.getPlugin().getLogger().info("SPAWNED A MOONSHROOM");
                    }
                    if (chance  > 86) {
                        SchemUtil.loadSchem(chunk.getBlock(X, b.getLocation().getBlockY()+1, Z).getLocation(),moontreelarge);


                        // DEBUG
                        //MoonGenerator.getPlugin().getLogger().info("SPAWNED A LARGE MOON TREE");
                    }
                    if (chance > 64) {
                        SchemUtil.loadSchem(chunk.getBlock(X, b.getLocation().getBlockY()+1, Z).getLocation(),moontreemedium);


                        // DEBUG
                        //MoonGenerator.getPlugin().getLogger().info("SPAWNED A MEDIUM MOON TREE");
                    }
                    if (chance > 54) {
                        SchemUtil.loadSchem(chunk.getBlock(X, b.getLocation().getBlockY()+5, Z).getLocation(),moontreesmall);

                        // DEBUG
                        //lets see what we get as Y coords
                        MoonGenerator.getPlugin().getLogger().info(Integer.toString(b.getLocation().getBlockY()+1));

                        //MoonGenerator.getPlugin().getLogger().info("SPAWNED A SMALL MOON TREE");
                    }
                }
            }
        }
    }
}
