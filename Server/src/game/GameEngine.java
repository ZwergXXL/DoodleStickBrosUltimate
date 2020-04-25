package game;

import server.Player;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import entities.BetaBoy;
import entities.Fighter;

public final class GameEngine implements Runnable {

	private final Map map;
	private final ArrayList<Fighter> fighterList;
	private final ArrayList<Player> playerList;

	public GameEngine(ArrayList<Player> playerList) {
		this.map = new Map();
		this.playerList = playerList;
		fighterList = new ArrayList<>();

		for (Player player : playerList) {
			player.setFighter(new Fighter(0, 2, 6, 20, 50, 2, 2, 0, 0, 10, player, this.map, 100));
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

		long mapUpdateTimer = tickBeginning + (33 * 5);
		while (true) {

			// 60 FPS every frame the Engine updates itself
			if (tickBeginning + 33 < System.currentTimeMillis()) {
				fpsCounter++;

				fighterUpdate();
				mapUpdate(mapUpdateTimer);
				sendData();

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

	private void mapUpdate(long mapUpdateTimer) {
		int mapTileSetCounter = 0;
		// randomNumber for mapGenerator a.k.a. map.addTileSet
		int randomNumber;
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
	}

	private void fighterUpdate() {
		for (Fighter fighter : fighterList) {
			fighter.nextFrame();
		}
	}

	private void sendData() {
		String s = "";
		for (Fighter fighter : fighterList) {
			s += fighter.toString() + ';';
		}
		int[][] newMap = new int[128][72];
		int counter = 0;
		for (int i = 0; i < map.getMap().length; i++) {
			for (int j = 71; j < map.getMap()[0].length; j++) {
				newMap[i][counter] = map.getMap()[i][j];
				counter++;
			}
		}
		for (Player player : playerList) {
			player.sendGameData(newMap, s);
		}
	}
}