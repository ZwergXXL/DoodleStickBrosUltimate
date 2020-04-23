package blockType;

public final class Damage extends BlockType {

	private int damageNumber;

	public Damage(int damageNumber) {
		super(Type.DAMAGE);
		this.damageNumber = damageNumber;
	}

	public Damage(int damageNumber, int width) {
		super(Type.DAMAGE, width);
		this.damageNumber = damageNumber;
	}

	public int getDamageNumber() {
		return this.damageNumber;
	}
}
