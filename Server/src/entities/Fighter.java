package entities;

import game.Map;
import server.Player;

import java.util.ArrayList;

public class Fighter extends Entity {

	Player player;
	Map map;

	int hp;
	boolean airborne, isStunned;
	ArrayList<Spell> activeSpells;

	public Fighter(int id, int length, int height, int x, int y, int xAcc, int yAcc, int xVel, int yVel, int maxVel, Player player, Map map, int hp) {
		super(id, length, height, x, y, xAcc, yAcc, xVel, yVel, maxVel);
		this.player = player;
		this.map = map;
		this.hp = hp;

		airborne = false;
		isStunned = false;
		activeSpells = new ArrayList<>();
	}

	public String toString(){
		return x + "," + y + "," + id + "," + frameID + "," + hp;
	}

	@Override
	public void nextFrame() {
		falling();
		player.getInputData();
		for (Spell spell: activeSpells){
			spell.nextFrame();
		}
	}

	void falling(){
		if (!map.isWall(x, y + height)){
			airborne = true;
			y += Math.min(yVel + yAcc, maxVel);
		} else {
			airborne = false;
			yVel = 0;
		}
	}

	void moveRight(){
		if (xVel < 0){
			xVel = 0;
		}
		direction = 01;

		int newVel;
		if (airborne) {
			newVel = (int) Math.min(xVel + xAcc * 0.5, maxVel);
		}else{
			newVel = Math.min(xVel + xAcc, maxVel);
		}
		for(int j = 0; j <= newVel; j++) {
			for (int i = 0; i < height; i++) {
				if (map.isWall(x + (length-1) + j, y + i)){
					x += j - 1;
				}
			}
		}
	}

	void moveLeft(){
		if (xVel > 0){
			xVel = 0;
		}
		direction = 10;

		int newVel;
		if (airborne) {
			newVel = (int) Math.max(xVel - xAcc * 0.5, -maxVel);
		}else{
			newVel = Math.max(xVel - xAcc, -maxVel);
		}
		for(int j = 0; j >= newVel; j--) {
			for (int i = 0; i < height; i++) {
				if (map.isWall(x + j, y + i)){
					x += j + 1;
				}
			}
		}
	}

	void lookUp(){
		direction = 11;
	}

	void lookDown(){
		direction = 00;
	}

	void jump(){
		if (airborne){
			return;
		}
		yVel = -maxVel;
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
