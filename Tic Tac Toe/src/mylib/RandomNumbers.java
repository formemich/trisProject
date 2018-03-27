package mylib;

import java.util.Random;

public class RandomNumbers {

	private static Random rand = new Random();

	public static int getIntegerRandom(int min, int max) {
		int range = max + 1 - min;
		int random_int = rand.nextInt(range);
		return random_int + min;
	}

	public static double getDoubleRandom(double min, double max) {
		double range = max - min;
		double random_double = rand.nextDouble();
		double posEstratto = range * random_double;
		return posEstratto + min;
	}

}
