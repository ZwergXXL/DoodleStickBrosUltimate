package blockType;

public final class Damage extends BlockType {

	int damageNumber;

	Damage(int damageNumber) {
		super(Type.DAMAGE);
		this.damageNumber = damageNumber;
	}
}
