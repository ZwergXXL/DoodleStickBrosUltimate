package game;

import game.fighter.BetaBoy;
import game.fighter.Fighter;
import server.Player;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public final class GameEngine implements Runnable {

	private final Map map;
	private final ArrayList<Fighter> fighterList;
	private final ArrayList<Player> playerList;

	public GameEngine(ArrayList<Player> playerList) {
		this.map = new Map();
		this.playerList = playerList;
		fighterList = new ArrayList<>();

		for (Player player: playerList){
			player.setFighter(new BetaBoy(player, map));
			fighterList.add(player.getFighter());
		}
	}

	@Override
	public void run() {
		long tickBeginning = System.currentTimeMillis();
		long secondAhead = tickBeginning + 1000;
		int fpsCounter = 0;
		// every time the map moves down 24 blocks (1/3 of the screen) a new TileSet
		// should be added at the top
		int mapTileSetCounter = 0;
		// randomNumber for mapGenerator a.k.a. map.addTileSet
		int randomNumber;
		long mapUpdateTimer=tickBeginning+(33*5);
		while (true) {

			// 60 FPS every frame the Engine updates itself
			if (tickBeginning + 33 < System.currentTimeMillis()) {
				fpsCounter++;

				// ----------------------------Game.Map-Specific----------------------------BEGIN
				// Every 5 frames do this

				if (mapUpdateTimer < System.currentTimeMillis()) {
					map.moveAllDown();
					mapTileSetCounter++;
					if (mapTileSetCounter == 24) {

						// SHOULD BE UPDATED WITH EACH NEW TILESET
						randomNumber = ThreadLocalRandom.current().nextInt(1, 1 + 1);
						map.addTileSet(randomNumber);
						mapTileSetCounter = 0;
					}
				}

				// ----------------------------Game.Map-Specific----------------------------END

				// -------------------------fighter-Specific-----------------------BEGIN

				// -------------------------fighter-Specific-----------------------END

				tickBeginning += 33;
			}

			// FPS-Counter
			if (secondAhead < System.currentTimeMillis()) {
				System.out.println(fpsCounter);
				secondAhead = tickBeginning + 1000;
				fpsCounter = 0;
			}

			// Maximum of 1000 loops per Second for performance
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}