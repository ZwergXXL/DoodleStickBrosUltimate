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

	Fighter(){
		super();
	}
}
