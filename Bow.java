public class Bow extends Item {
	public static void use() {
		GameMod.setUsedBow(true);
		//Text.usedLantern;
	}
	public static String examine() {
		return Text.bowDescription;
	}
}
