package game;


public final class Map {

	// 72*2 = 144 map grows outside of render distance
	private int[][] map = new int[128][144];

	// Tileset filled with Air

	int[][] emptyTileset = new int[128][24];

	public Map() {

		// Starting Platform
		for (int y = 14; y < map[0].length - 14; y++) {
			map[120][y] = 1;
			;
		}
	}

	// loads a preset tileSet from switch case to top Row of Game.Map
	public void addTileSet(int preset) {
		int[][] newTileSet = getTileset(preset);
		for (int x = 0; x < map[0].length; x++) {
			for (int y = 0; y < 23; y++) {
				map[x][y] = newTileSet[x][y];
			}
		}
	}

	public void moveAllDown() {
		for (int x = 0; x < map[0].length; x++) {
			for (int y = 1; y < map.length - 1; y++) {
				map[y][x] = map[y -1][x];
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

	public int[][] getMap(){
		return map;
	}
	
	public boolean isWall (int x, int y) {
		if(map[x][y] == 1) {
			return true;
		}
		return false;
	}
}
