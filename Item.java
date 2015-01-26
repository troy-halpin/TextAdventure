public class Item {
	Item() {
	}
	public static void use() {}
	public static String examine() {
		return "";
	}
}

// Each item used to have it's own separate file, but given how small and similar they all are,
// I just put them all into here

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

public class Bow extends Item {
	public static void use() {
		GameMod.setUsedBow(true);
		
	}
	public static String examine() {
		return Text.bowDescription;
	}
}

public class CookedBearMeat extends Item {
	public static void use() {
		GameMod.setUsedCookedBearMeat(true);
		GameMod.setHasCookedBearMeat(false);
	}
	public static String examine() {
		return Text.cookedBearMeatDescription;
	}
}

public class DragonGlassDagger extends Item {
	public static void use() {
		GameMod.setUsedDragonGlassDagger(true);		
	}
	public static String examine() {
		return Text.dragonGlassDaggerDescription;
	}
}

public class FireStarter extends Item {
	public static void use() {
		GameMod.setUsedFireStarter(true);
		//Text.usedFireStarter;
	}
	public static String examine() {
		return Text.fireStarterDescription;
	}
}

public class Lantern extends Item {

	public static void use() {
		GameMod.setUsedLantern(true);

	}
	public static String examine() {
		return Text.lanternDescription;
	}
}

public class Longsword extends Item{

	public static void use() {
		GameMod.setUsedLongsword(true);
		System.out.println(Text.swungLongsword);
	}

	public static String examine() {
		return Text.longswordDescription;
	}
}

public class OldLetter extends Item {
	public static void use() {}

	public static String examine() {
		return Text.oldLetter;
	}
}

public class Pot extends Item {
	
	public static void use() {
		GameMod.setUsedPot(true);
	}
	public static String examine() {
		return Text.potDescription;
	}
}
