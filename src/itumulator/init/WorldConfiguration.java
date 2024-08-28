package itumulator.init;

import java.util.HashMap;

public class WorldConfiguration {
    HashMap<Class<ConfigurableActor>, EntityConfig> instance_spec;
    int world_size;

    public WorldConfiguration(String input) throws ClassNotFoundException {
        var lines = input.lines().toList();
        world_size = Integer.parseInt(lines.get(0));
        instance_spec = new HashMap<>();

        for (int i=1; i<lines.size(); i++) {
            var line = lines.get(i);
            var elems = line.split(" ");

            instance_spec.put(classForString(elems[0]), rangeFromElems(elems));
        }
    }


    private EntityConfig rangeFromElems(String[] elems) {
        int min = Integer.parseInt(elems[1]);
        int max;
        if (elems.length > 2) {
            max = Integer.parseInt(elems[2]);
        } else {
            max = min;
        }

        return new EntityConfig(min, max);
    }

    private Class<ConfigurableActor> classForString(String className) throws ClassNotFoundException {
        var classNameCap = "itumulator.simulator." +  className.substring(0, 1).toUpperCase() + className.substring(1);
        return (Class<ConfigurableActor>) Class.forName(classNameCap);
    }
}
