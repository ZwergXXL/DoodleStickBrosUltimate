package blockType;

public abstract class BlockType {
	public Type blocktype;

	BlockType(Type blocktype) {
		this.blocktype = blocktype;
	}

	public Type getType() {
		return this.blocktype;
	}
}
