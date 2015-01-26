import java.util.*;
import java.io.*;

public class Inventory {
	public static Item longsword = new Longsword();
	public static Item lantern = new Lantern();
	public static Item oldletter = new OldLetter();
	public static Item firestarter = new FireStarter();
	public static Item pot = new Pot();
	public static Item bow = new Bow();
	public static Item dragonGlassDagger = new DragonGlassDagger();
	public static Item bearmeat = new BearMeat();
	public static Item cookedbearmeat = new CookedBearMeat();
	
	Inventory() {	
	}

	public static void add(Item item) {
		GameMod.inventory.add(item);

	}
	public static void drop(Item item) {
		GameMod.inventory.remove(item);
	}
	public static void examine(Item item) {
		if (item.equals(longsword)) {
			if (GameMod.getHasLongsword() == true) {
				System.out.println(Text.longswordDescription);
			}
		}
		if (item.equals(lantern)) {
			if (GameMod.getHasLantern() == true) {
				System.out.println(Text.lanternDescription);
			}
		}
		if (item.equals(oldletter)) {
			if (GameMod.getHasOldLetter() == true) {
				System.out.println(Text.oldLetter);
			}
		}
		if (item.equals(firestarter)) {
			if (GameMod.getHasFireStarter() == true) {
				System.out.println(Text.fireStarterDescription);
			}
		}
		if (item.equals(pot)) {
			if (GameMod.getHasPot() == true) {
				System.out.println(Text.potDescription);
			}
		}
		if (item.equals(bow)) {
			if (GameMod.getHasBow() == true) {
				System.out.println(Text.bowDescription);
			}
		}
		if (item.equals(dragonGlassDagger)) {
			if (GameMod.getHasDragonGlassDagger() == true) {
				System.out.println(Text.dragonGlassDaggerDescription);
			}
		}
		if (item.equals(bearmeat)) {
			if (GameMod.getHasBearMeat() == true) {
				System.out.println(Text.bearMeatDescription);
			}
		}
		if (item.equals(cookedbearmeat)) {
			if (GameMod.getHasCookedBearMeat() == true) {
				System.out.println(Text.cookedBearMeatDescription);
			}
		}
	}

	public static String currentInventory() {
		return GameMod.inventory.toString();
	}

}
