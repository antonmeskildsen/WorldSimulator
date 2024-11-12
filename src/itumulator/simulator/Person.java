package itumulator.simulator;

import itumulator.world.Location;
import itumulator.world.World;

import java.util.Random;

public class Person implements Actor {

    private Dog dog;

    Random rng = new Random();

    private final float dogChance;

    public Person(float dogChancePercent) {
        this.dogChance = 1 - dogChancePercent/100;
    }

    @Override
    public void act(World world) {

        if (world.isNight()) {
            if (dog != null) {
                world.delete(dog);
            }
            world.delete(this);
        } else {
            Location target = Actor.getRandomEmptyLocation(this.rng, world);
            Location old = world.getLocation(this);
            world.move(this, target);

            if (rng.nextFloat() > dogChance && dog == null) {
                dog = new Dog(this);
                world.setTile(old, dog);
            }
        }


    }

}
