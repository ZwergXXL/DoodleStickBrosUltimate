package entities;

import game.Map;
import server.Player;

import java.util.ArrayList;

public class Fighter extends Entity {

	Player player;
	Map map;

	int hp, duckedHeight;
	boolean airborne, isStunned, isCrouched;
	ArrayList<Spell> activeSpells;

	public Fighter(int id, int length, int height, int x, int y, double xAcc, double yAcc, double xVel, double yVel,
			double maxVel, Player player, Map map, int hp) {
		super(id, length, height, x, y, xAcc, yAcc, xVel, yVel, maxVel);
		this.player = player;
		this.map = map;
		this.hp = hp;

		airborne = false;
		isStunned = false;
		isCrouched = false;
		duckedHeight = height / 2;
		activeSpells = new ArrayList<>();
	}

	public String toString() {
		return x + "," + (y - map.getMap()[0].length / 2) + "," + id + "," + frameID + "," + hp;
	}

	@Override
	public void nextFrame() {
		boolean wasCrouched = false;
		if (isCrouched) {
			wasCrouched = true;
		}

		falling();
		player.getInputData();
		for (Spell spell : activeSpells) {
			spell.nextFrame();
		}

		// if the fighter takes cover his vertical hitbox is getting halved, if he
		// returns form cover his hitbox doubles to its former value
		if (isCrouched && !wasCrouched) {
			height = duckedHeight;
			y = y + duckedHeight;
		} else if (!isCrouched && wasCrouched) {
			height = height * 2;
			y = y - duckedHeight;
		}
		// System.out.println("fighter updated");
	}

	private void falling() {
		airborne = true;
		yVel += yAcc;

		if (yVel < 0) {
			y += yVel;
			return;
		}

		for (int j = 0; j < Math.min(yVel, maxVel); j++) {
			for (int i = 0; i < length; i++) {
				if (map.isWall(x + i, y + height - 1)) {
					airborne = false;
					yVel = 0;
					return;
				}
			}
			y += 1;
		}
	}

	public void jump() {
		if (isCrouched) {
			isCrouched = false;
		}
		if (airborne) {
			return;
		}
		yVel = maxVel * -3;
	}

	/*
	 * public void moveRight() { if (isCrouched) { isCrouched = false; } if (xVel <
	 * 0) { xVel = 0; } direction = 01;
	 * 
	 * if (airborne) { xVel += xAcc * 0.5; } else { xVel += xAcc; }
	 * 
	 * for (int j = 0; j < Math.min(xVel, maxVel); j++) {
	 * System.out.println("RIGHT	J:    "+j); for (int i = 0; i < height; i++) {
	 * if (map.isWall(x + length + j+1, y + i - 1)) {
	 * System.out.println("RIGHT NOT WORKING REEE!"); return; } } x += 1; } }
	 */

	/*
	 * public void moveLeft() { if (isCrouched) { isCrouched = false; } if (xVel >
	 * 0) { xVel = 0; } direction = 10;
	 * 
	 * if (airborne) { xVel -= xAcc * 0.5; } else { xVel -= xAcc; }
	 * 
	 * for (int j = 0; j > Math.max(xVel, -maxVel); j--) {
	 * System.out.println("LEFT	J:    "+j); for (int i = -1; i < height; i++) {
	 * //System.out.println(x+j); if (map.isWall(x + j-1, y + i - 1)) { return; } }
	 * x += -1; } }
	 */

	public void moveLeft() {
		if (isCrouched) {
			isCrouched = false;
		}
		if (xVel > 0) {
			xVel = 0;
		}
		direction = 10;
		if (airborne) {
			for (int j = 0; j > -2; j--) {
				System.out.println("LEFT	J:    " + j);
				for (int i = -1; i < height; i++) {
					// System.out.println(x+j);
					if (map.isWall(x + j - 1, y + i - 1)) {
						return;
					}
				}
				x += -1;
			}
		} else {
			for (int j = 0; j > -3; j--) {
				System.out.println("LEFT	J:    " + j);
				for (int i = -1; i < height; i++) {
					// System.out.println(x+j);
					if (map.isWall(x + j - 1, y + i - 1)) {
						return;
					}
				}
				x += -1;
			}
		}

	}

	public void moveRight() {
		if (isCrouched) {
			isCrouched = false;
		}
		if (xVel < 0) {
			xVel = 0;
		}
		direction = 01;
		if (airborne) {
			for (int j = 0; j < 2; j++) {
				System.out.println("RIGHT	J:    " + j);
				for (int i = 0; i < height; i++) {
					if (map.isWall(x + length + j + 1, y + i - 1)) {
						System.out.println("RIGHT NOT WORKING REEE!");
						return;
					}
				}
				x += 1;
			}
		} else {
			for (int j = 0; j < 3; j++) {
				System.out.println("RIGHT	J:    " + j);
				for (int i = 0; i < height; i++) {
					if (map.isWall(x + length + j + 1, y + i - 1)) {
						System.out.println("RIGHT NOT WORKING REEE!");
						return;
					}
				}
				x += 1;
			}
		}

	}

	public void lookUp() {
		if (isCrouched) {
			isCrouched = false;
		}
		direction = 11;
	}

	public void lookDown() {
		if (direction == 00) {
			return;
		}

		if (!airborne) {
			isCrouched = true;
			direction = 00;
		}
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public boolean isAirborne() {
		return airborne;
	}

	public void setAirborne(boolean airborne) {
		this.airborne = airborne;
	}

	public boolean isStunned() {
		return isStunned;
	}

	public void setStunned(boolean stunned) {
		isStunned = stunned;
	}

	public ArrayList<Spell> getActiveSpells() {
		return activeSpells;
	}
}
