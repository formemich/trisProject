package model;

import mylib.RandomNumbers;

public class ArtificialIntelligence extends Player {

	public ArtificialIntelligence() {
		super("IA", "");
	}

	public int getX() {
		return RandomNumbers.getIntegerRandom(0, 2);
	}

	public int getY() {
		return RandomNumbers.getIntegerRandom(0, 2);
	}
}
