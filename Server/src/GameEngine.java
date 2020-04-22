import java.util.concurrent.ThreadLocalRandom;

public final class GameEngine implements Runnable {

	private final Map map;

	GameEngine() {
		map = new Map();
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
		while (true) {

			// 60 FPS every frame the Engine updates itself
			if (tickBeginning + 33 < System.currentTimeMillis()) {
				fpsCounter++;
				tickBeginning = System.currentTimeMillis();

				// ----------------------------Map-Specific----------------------------BEGIN
				if (fpsCounter % 6 == 0) {
					map.moveAllDown();
					mapTileSetCounter++;
					if (mapTileSetCounter == 24) {

						// SHOULD BE UPDATED WITH EACH NEW TILESET
						randomNumber = ThreadLocalRandom.current().nextInt(1, 1 + 1);
						map.addTileSet(randomNumber);
					}
				}

				// ----------------------------Map-Specific----------------------------END

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