package mylib;

public class Player {

	private String name, surname;
	private int sign;
	private boolean isIA;
	private int turns;

	public Player(String name, String surname) {
		this.name = name;
		this.surname = surname;
		this.isIA = false;
		this.turns = 0;
	}

	public Player() {
		this.isIA = false;
	}

	public int getTurns() {
		return turns;
	}

	public void setTurns(int turns) {
		this.turns = turns;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getSign() {
		return sign;
	}

	public void setSign(int sign) {
		this.sign = sign;
	}

	public boolean isIA() {
		return isIA;
	}

	public void setIA(boolean isIA) {
		this.isIA = isIA;
	}

}
