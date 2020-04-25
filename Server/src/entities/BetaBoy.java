package entities;

import game.Map;
import server.Player;

public class BetaBoy extends Fighter {


    public BetaBoy(int id, int length, int height, int x, int y, int xAcc, int yAcc, int xVel, int yVel, int maxVel, Player player, Map map, int hp) {
        super(id, length, height, x, y, xAcc, yAcc, xVel, yVel, maxVel, player, map, hp);
    }
}
