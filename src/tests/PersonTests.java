package tests;

import itumulator.simulator.Person;
import itumulator.world.Location;
import itumulator.world.World;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class PersonTests {

    World w;

    @BeforeEach
    public void setup() {
        w = new World(2);
    }

    public void personMovesDuringDay() {
        var p = new Person();
        var i = new Location(0, 0);

        w.setDay();
        w.setCurrentLocation(i);
        w.setTile(i, p);

        p.act(w);

        var person_loc = w.getLocation(p);

        assertNull(w.getTile(i));
        assertNotNull(person_loc);
        assertNotEquals(i, person_loc);
    }
}
