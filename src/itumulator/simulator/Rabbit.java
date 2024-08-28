package itumulator.simulator;

import itumulator.world.World;

import java.util.Random;

public class Rabbit implements Actor {
    Random rng = new Random();
    int age_days = 0;
    int food = 100;

    @Override
    public void act(World world) {
        food -= 1;


        if (food <= 0) {
            // death
            world.delete(this);
        } else if (food <= 80) {
            // search
            var nonblock = world.getNonBlocking(world.getCurrentLocation());
            if (nonblock instanceof Grass) {
                world.remove(nonblock);
                food += 20;
            }
        }

        var new_loc = Helpers.randomFreeLocation(rng, world);
        world.move(this, new_loc);
    }
}
