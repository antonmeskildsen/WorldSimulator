package itumulator.simulator;

import itumulator.world.Location;
import itumulator.world.World;

import java.util.Random;

public class Helpers {

    public static Location randomFreeLocation(Random rng, World world) {
        var tiles = world.getEmptySurroundingTiles().toArray();
        return (Location) tiles[rng.nextInt(tiles.length)];
    }
}
