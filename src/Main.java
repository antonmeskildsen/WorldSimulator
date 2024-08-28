import java.awt.Color;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import itumulator.executable.DisplayInformation;
import itumulator.executable.Program;
import itumulator.init.Initializer;
import itumulator.init.WorldConfiguration;
import itumulator.simulator.Person;
import itumulator.world.Location;
import itumulator.world.World;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        var input = Files.readString(Path.of("data/t1/t1-1c.txt"));
//        var input = "5\ngrass 3\n\n";

        var config = new WorldConfiguration(input);

        var p = Initializer.init(config);

        var person_display = new DisplayInformation(Color.red);
        p.setDisplayInformation(Person.class, person_display);





//        World w = p.getWorld();
//
//        int amount = 10;
//        var rng = new Random();
//
//
//        for (int i = 0; i < amount; i++) {
//            int x = rng.nextInt(size);
//            int y = rng.nextInt(size);
//
//            Location loc = new Location(x, y);
//
//            while (!w.isTileEmpty(loc)) {
//                x = rng.nextInt(size);
//                y = rng.nextInt(size);
//                loc = new Location(x, y);
//            }
//
//            w.setTile(loc, new Person());
//        }



        // w.setTile(new Location(0, 0), new <MyClass>());

        // p.setDisplayInformation(<MyClass>.class, new DisplayInformation(<Color>, "<ImageName>"));

        p.show();

        for (int i=0; i<200; i++) {
            p.simulate();
        }
    }
}