package Util;

import java.util.Random;

public class Randomize {
    private static final Random rand = new Random();

    public static int[] getRandom(int size, int origin, int bound) {
        return rand.ints(size, origin, bound).toArray();
    }
}
