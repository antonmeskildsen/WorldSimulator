package itumulator.init;

import java.util.Random;

public class EntityConfig {
    int min;
    int max;

    public EntityConfig(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getInt(Random rng) {
        if (min == max) return min;

        return rng.nextInt(min, max);
    }
}
