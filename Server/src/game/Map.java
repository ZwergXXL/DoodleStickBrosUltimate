package game;

import blockType.*;

public final class Map {

	private Air air = new Air();

	// 72*2 = 144 map grows outside of render distance
	BlockType[][] map = new BlockType[128][144];

	// Tileset filled with Air

	BlockType[][] emptyTileset = new BlockType[128][24];

	public Map() {
		// generate empty map
		for (int x = 0; x < map[0].length; x++) {
			for (int y = 0; y < map.length; y++) {
				map[x][y] = air;
			}
		}
		// generate empty Tileset
		for (int x = 0; x < emptyTileset[0].length; x++) {
			for (int y = 0; y < emptyTileset.length; y++) {
				emptyTileset[x][y] = air;
			}
		}

		// Starting Platform
		Ground base = new Ground(100);
		for (int x = 14; x < map[0].length - 14; x++) {
			map[x][120] = base;
			;
		}
	}

	// loads a preset tileSet from switch case to top Row of Game.Map
	public void addTileSet(int preset) {
		BlockType[][] newTileSet = getTileset(preset);
		for (int x = 0; x < map[0].length; x++) {
			for (int y = 0; y < 23; y++) {
				map[x][y] = newTileSet[x][y];
			}
		}
	}

	public void moveAllDown() {
		for (int x = 0; x < map[0].length; x++) {
			for (int y = 1; y < map.length - 1; y++) {
				map[x][y] = map[x][y - 1];
			}
		}
	}

	// change Blocktype on given coordinates
	public void dynamicBlockChange(int x, int y, BlockType block) {

		map[x][y] = block;
	}

	// WHENEVER CHANGED, ALSO UPDATE MIN & MAX IN GAME ENGINE -> MAP-SPECIFIC ->
	// RANDOMNUMBER
	private BlockType[][] getTileset(int preset) {
		BlockType[][] newTileset = emptyTileset;

		switch (preset) {
		case 1:
			newTileset = insertLineOfGround(12, 0, 100, newTileset);
			newTileset = insertLineOfGround(0, 11, 12, newTileset);
			newTileset = insertLineOfGround(112, 11, 12, newTileset);
			return newTileset;
		}

		return null;
	}

	private BlockType[][] insertLineOfGround(int x, int y, int length, BlockType[][] tileSet) {
		Ground newLine = new Ground(length);
		for (int i = 0; i < length; i++) {
			tileSet[x + i][y] = newLine;
		}

		return tileSet;
	}

	public void createDmgBlock(int x, int y, int length, int height, int dmg){
		for (int i=x; i< length;i ++){
			for (int j=y; j< height;j ++){
				dynamicBlockChange(i , j, new Damage(dmg));
			}
		}
	}
}
