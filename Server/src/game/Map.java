package game;

public final class Map {

	// 72*2 = 144 map grows outside of render distance
	private int[][] map = new int[240][270];

	// Tileset filled with Air

	int[][] emptyTileset = new int[map.length][map[0].length / 6];

	public Map() {

		// Starting Platform
		for (int x = 14; x < map.length - 15; x++) {
			map[x][240] = 1;
		}

		// DELETE- THIS for testing only
		map[14][239] = 1;
		map[14][235] = 1;
		map[14][240] = 1;
		map[14][236] = 1;
		map[225][239] = 1;
		map[225][235] = 1;
		map[225][240] = 1;
		map[225][236] = 1;
	}

	// loads a preset tileSet from switch case to top Row of Game.Map
	public void addTileSet(int preset) {
		int[][] newTileSet = getTileset(preset);
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < emptyTileset[0].length; y++) {
				map[x][y] = newTileSet[x][y];
			}
		}
	}

	public void moveAllDown() {
		for (int x = 0; x < map.length; x++) {
			for (int y = map[0].length - 1; y > 0; y--) {
				map[x][y] = map[x][y - 1];
			}
		}
	}

	// change Blocktype on given coordinates
	public void dynamicBlockChange(int x, int y, int i) {
		map[x][y] = i;
	}

	// WHENEVER CHANGED, ALSO UPDATE MIN & MAX IN GAME ENGINE -> MAP-SPECIFIC ->
	// RANDOMNUMBER
	private int[][] getTileset(int preset) {
		int[][] newTileset = emptyTileset;

		switch (preset) {
		case 1:
			newTileset = insertLineOfGround(12, 0, 100, newTileset);
			newTileset = insertLineOfGround(0, 11, 12, newTileset);
			newTileset = insertLineOfGround(112, 11, 12, newTileset);
			return newTileset;
		}

		return null;
	}

	private int[][] insertLineOfGround(int x, int y, int length, int[][] tileSet) {
		for (int i = 0; i < length; i++) {
			tileSet[x + i][y] = 1;
		}

		return tileSet;
	}

	public int[][] getMap() {
		return map;
	}

	public boolean isWall(int x, int y) {
		if (x >= map.length | y >= map[0].length | x <= 0 | y <= 0) {
			return true;
		}
		
		if (map[x][y] == 1) {
			//System.out.println("no");
			return true;
			
		}
		return false;
	}
}