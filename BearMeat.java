public class BearMeat extends Item {
	public static void use() {
		GameMod.setUsedBearMeat(true);
		GameMod.setHasBearMeat(false);
		Inventory.add(Inventory.cookedbearmeat);
		Inventory.drop(Inventory.bearmeat);
	}
	public static String examine() {
		return Text.bearMeatDescription;
	}
}
