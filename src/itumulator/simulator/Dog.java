package itumulator.simulator;

import itumulator.world.Location;
import itumulator.world.World;

import java.util.Random;

public class Dog implements Actor {

    private Person person;

    private Random rng = new Random();

    public Dog(Person person) {
        this.person = person;
    }

    @Override
    public void act(World world) {
        if (person != null) {
            var p = world.getLocation(person);
            var d = world.getLocation(this);

            var dx = p.getX() - d.getX();
            var dy = p.getY() - d.getY();

            if (Math.abs(dx) > 1 || Math.abs(dy) > 1) {
                var dir_x = (int) Math.signum(dx);
                var dir_y = (int) Math.signum(dy);
                var newloc = new Location(d.getX() + dir_x, d.getY() + dir_y);
                world.move(this, newloc);
            }

//            var loc = Actor.getRandomEmptyLocation(world.getLocation(person), rng, world);
//
//            world.move(this, loc);
        }
    }
}
