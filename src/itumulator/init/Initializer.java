package itumulator.init;

import itumulator.executable.Program;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class Initializer {

    public static Program init(WorldConfiguration configuration) {
        var rng = new Random();

        var program = new Program(configuration.world_size, 800, 75);

        for (var entry : configuration.instance_spec.entrySet()) {
            var cls = entry.getKey();
            var config = entry.getValue();

            var n = config.getInt(rng);

            for (int i=0; i<n; i++) {
                try {
                    var entity = cls.getConstructor().newInstance();

                    entity.configureEntity(config, program, rng);
                    entity.configureStyle(program);

                } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                         InvocationTargetException e) {
                    throw new RuntimeException("Could not instantiate " + cls.getName(), e);
                }


            }
        }

        return program;
    }
}
