package itumulator.init;

import itumulator.executable.Program;
import itumulator.simulator.Actor;

import java.util.Random;

public interface ConfigurableActor extends Actor {

    void configureEntity(EntityConfig config, Program program, Random rng);

    void configureStyle(Program program);

}
