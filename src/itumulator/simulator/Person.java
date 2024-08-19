package itumulator.simulator;

import itumulator.world.Location;
import itumulator.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Person implements Actor {

    Random rng = new Random();

    @Override
    public void act(World world) {

        if (world.isNight()) {
            world.delete(this);
        } else {
            List<Location> locations = new ArrayList<>(world.getEmptySurroundingTiles());
            var pos = rng.nextInt(locations.size());
            Location target = locations.get(pos);
            world.move(this, target);
        }
    }
}
