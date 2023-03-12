package e2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int size = 5;
        int numMines = 10;
        final int seed = 123;
        // Useful to set the seed to a constant value for testing purpose
        final Random random = new Random(seed);
        new GUI(size, numMines, random);
    }
}
