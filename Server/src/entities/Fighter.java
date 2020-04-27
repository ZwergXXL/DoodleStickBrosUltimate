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

    public Fighter(int id, int length, int height, int x, int y, double xAcc, double yAcc, double xVel, double yVel, double maxVel, Player player, Map map, int hp) {
        super(id, length, height, x, y, xAcc, yAcc, xVel, yVel, maxVel);
        this.player = player;
        this.map = map;
        this.hp = hp;

        airborne = false;
        isStunned = false;
        activeSpells = new ArrayList<>();
    }

    public String toString() {
        return x + "," + (y - 72) + "," + id + "," + frameID + "," + hp;
    }

    @Override
    public void nextFrame() {
        falling();
        player.getInputData();
        for (Spell spell : activeSpells) {
            spell.nextFrame();
        }
        System.out.println("fighter updated");
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
        if (airborne) {
            return;
        }
        yVel = maxVel * -3;
    }

    public void moveRight() {
        if (xVel < 0) {
            xVel = 0;
        }
        direction = 01;

        if (airborne) {
            xVel += xAcc * 0.5;
        } else {
            xVel += xAcc;
        }
        for (int j = 0; j < Math.min(xVel, maxVel); j++) {
            for (int i = 0; i < height; i++) {
                if (map.isWall(x + length + j, y + i - 1)) {
                    return;
                }
            }
            x += 1;
        }
    }

    public void moveLeft() {
        if (xVel > 0) {
            xVel = 0;
        }
        direction = 10;

        int newVel;
        if (airborne) {
             xVel -= xAcc * 0.5;
        } else {
            xVel  -= xAcc;
        }

        for (int j = 0; j > Math.max(xVel, -maxVel); j--) {
            for (int i = 0; i < height; i++) {
                if (map.isWall(x + j, y + i - 1)) {
                    return;
                }
            }
            x += -1;
        }
    }

    public void lookUp() {
        direction = 11;
    }

    public void lookDown() {
        direction = 00;
        if (!airborne){
            y += 1;
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
