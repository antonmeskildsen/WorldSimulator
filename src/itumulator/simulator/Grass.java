package itumulator.simulator;

import itumulator.executable.DisplayInformation;
import itumulator.executable.Program;
import itumulator.init.ConfigurableActor;
import itumulator.init.EntityConfig;
import itumulator.world.Location;
import itumulator.world.NonBlocking;
import itumulator.world.World;

import java.awt.*;
import java.util.Random;

public class Grass implements ConfigurableActor, NonBlocking {

    Random rng = new Random();

    @Override
    public void configureEntity(EntityConfig config, Program program, Random rng) {

        Location loc;
        do {
            int x = rng.nextInt(program.getSize());
            int y = rng.nextInt(program.getSize());

            loc = new Location(x, y);
        } while (program.getWorld().getTile(loc) instanceof Grass);

        program.getWorld().setTile(loc, this);
    }

    @Override
    public void configureStyle(Program program) {
        program.setDisplayInformation(Grass.class, new DisplayInformation(Color.green, "grass"));
    }

    @Override
    public void act(World world) {
        if (rng.nextFloat() > 0.9) {
            var tiles = world.getSurroundingTiles().toArray();
            var loc = (Location) tiles[rng.nextInt(tiles.length)];
            if (!world.containsNonBlocking(loc)) {
                world.setTile(loc, new Grass());
            }
        }
    }
}
