import blockType.*;

public final class Map {

	// 72*2 = 144 map grows outside of render distance
	BlockType[][] map = new BlockType[128][144];

	// loads a preset tileSet from switch case to top Row of Map
	public void addTileSet(int preset) {
		BlockType[][] newTileSet = getTileSet(preset);
		// TO-DO
	}

	public void moveAllDown() {
		// TO-DO
	}

	// change Blocktype on given coordinates
	public void dynamicBlockChange(int x, int y, Type blocktype) {
		// TO-DO
	}

	// WHENEVER CHANGED, ALSO UPDATE MIN & MAX IN GAME ENGINE -> MAP-SPECIFIC ->
	// RANDOMNUMBER
	private BlockType[][] getTileSet(int preset) {
		switch (preset) {
		case 1:
			return null;
		}

		return null;
	}
}
