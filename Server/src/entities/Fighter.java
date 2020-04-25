package entities;

import game.Map;
import server.Player;

public class Fighter extends Entity {

	Player player;
	Map map;

	int hp;
	boolean airborne, isStunned;
	final int basicAttackLenth = 5;
	int basicAttackStatus;

	Fighter(Player player, Map map) {
		this.player = player;
		this.map = map;
	}

	void nextFrame() {
		if (basicAttackStatus > -1) {
			nextFrameBasicAttack();
		}
	}

	/** MOVEMENT **/

	void left() {

	}

	void right() {

	}

	void startBasicAttack() {
		if (basicAttackStatus > -1) {
			return;
		}
		basicAttackStatus = 0;
	}

	void nextFrameBasicAttack() {
		basicAttackStatus++;
		switch (basicAttackStatus) {
		case 1:
		case 2:
			break;
		case 3:
		case 4:
		case 5:
			if (direction == 0) {
				map.createDmgBlock(x, y + 2, 1, 2, 2);
			} else {
				map.createDmgBlock(x + (1 * direction), y, 2 * direction, 1, 2);
			}
			break;
		case 6:
		default:
			basicAttackStatus = -1;
		}
	}
}
