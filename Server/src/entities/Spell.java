package entities;

public class Spell extends Entity {

	int damageNumber;
	boolean isAttached;

	public Spell(int id, int length, int height, int x, int y, int xAcc, int yAcc, int xVel, int yVel, int maxVel) {
		super(id, length, height, x, y, xAcc, yAcc, xVel, yVel, maxVel);
	}

	public String toString(){
		return x + "," + (y - 72) + "," + id + "," + frameID;
	}
}
