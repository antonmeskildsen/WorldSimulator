import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import itumulator.executable.DisplayInformation;
import itumulator.executable.Program;
import itumulator.simulator.Person;
import itumulator.world.Location;
import itumulator.world.World;

public class Main {

    public static void main(String[] args) {
        int size = 5;
        Program p = new Program(size, 1600, 75);

        var person_display = new DisplayInformation(Color.red);
        p.setDisplayInformation(Person.class, person_display);

        World w = p.getWorld();

        var person = new Person();
        var place = new Location(0, 1);

        w.setTile(place, person);



        // w.setTile(new Location(0, 0), new <MyClass>());

        // p.setDisplayInformation(<MyClass>.class, new DisplayInformation(<Color>, "<ImageName>"));

        p.show();

        for (int i=0; i<200; i++) {
            p.simulate();
        }
    }
}