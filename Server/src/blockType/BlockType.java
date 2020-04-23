package blockType;

public abstract class BlockType {

	private int width;
	private Type blocktype;

	protected BlockType(Type blocktype, int width) {
		this.blocktype = blocktype;
		this.width = width;
	}

	protected BlockType(Type blocktype) {
		this.blocktype = blocktype;
		width = 1;
	}

	public Type getType() {
		return this.blocktype;
	}

	public int getWidth() {
		return this.width;
	}
}
