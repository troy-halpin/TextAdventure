public class Action {
	private int xPos;
	private int yPos;
	public static Action left = new Action();
	public static Action right = new Action();
	public static Action north = new Action();
	public static Action south = new Action();
	public static Action east = new Action();
	public static Action west = new Action();


	/*The action class modifies the gamestate by manipulating booleans, the player's location, as well as inventory*/

	public Action() {

	}

	public static void go(String command) {

		if (command.equals("left")) {
			Location.changeXPos(left);
		}
		if (command.equals("right")) {
			Location.changeXPos(right);
		}
		if (command.equals("north")) {
			Location.changeYPos(north);
		}
		if (command.equals("south")) {
			Location.changeYPos(south);
		}
		if (command.equals("east")) {
			Location.changeXPos(east);
		}
		if (command.equals("west")) {
			Location.changeXPos(west);
		}
	}

	public static void use(String item) {
		
		if (item.equals("longsword")) {
			Longsword.use();
			System.out.println(Text.swungLongsword);
			GameMod.setUsedLongsword(false);
		}
		if (item.equals("lantern")) {
			Lantern.use();
			System.out.println(Text.usedLantern);
		}

		if (item.equals("firestarter")) {
			FireStarter.use();
			System.out.println(Text.usedFireStarter);
		}
		if (item.equals("pot")) {
			if (GameMod.getUsedFireStarter() == true) {
			Pot.use();
			System.out.println(Text.correctlyUsedPot);
			}
		}
		if (item.equals("bow")) {
			Bow.use();
			System.out.println(Text.shotBow);
		}
		if (item.equals("dragonglass")) {
			DragonGlassDagger.use();
			System.out.println(Text.usedDragonGlassDagger);
		}
		if (item.equals("bearmeat")) {
			System.out.println(">Don't you want to eat or cook this?");
		}
		if (item.equals("cookedbearmeat")) {
			System.out.println(">Don't you want to eat this?");
		}
	}

	public static void examine(String thing) {
		if (thing.equals("body")) {
			GameMod.setFightTheWight(true);
		}

		if (thing.equals("longsword")) {
			if (GameMod.getHasLongsword() == true) {
			Inventory.examine(Inventory.longsword);
			}
		}
		if (thing.equals("lantern")) {
			if (GameMod.getHasLantern() == true) {
			Inventory.examine(Inventory.lantern);
			}
		}
		if (thing.equals("oldletter")) {
			if (GameMod.getHasOldLetter() == true) {
			Inventory.examine(Inventory.oldletter);
			}
		}
		if (thing.equals("firestarter")) {
			if (GameMod.getHasFireStarter() == true) {
			Inventory.examine(Inventory.firestarter);
			}
		}
		if (thing.equals("pot")) {
			if (GameMod.getHasPot() == true) {
			Inventory.examine(Inventory.pot);
			}
		}
		if (thing.equals("bow")) {
			if (GameMod.getHasBow() == true) {
			Inventory.examine(Inventory.bow);
			}
		}
		if (thing.equals("dragonglass")) {
			if (GameMod.getHasDragonGlassDagger() == true) {
			Inventory.examine(Inventory.dragonGlassDagger);
			}
		}
		if (thing.equals("bearmeat")) {
			if (GameMod.getHasBearMeat() == true) {
			Inventory.examine(Inventory.bearmeat);
			}
		}
		if (thing.equals("cookedbearmeat")) {
			if (GameMod.getHasCookedBearMeat() == true) {
			Inventory.examine(Inventory.cookedbearmeat);
			}
		}
	}

	//this was mainly used for testing the map, but I'm leaving it in just for fun. Type the name of the location you would like to go and you travel there
	public static void fastTravel(String place) {
		if (place.equals("behind")) {
			Location.setPlace(Location.behindCastleBlack);
			GameMod.setPlayerXCoor(0);
			GameMod.setPlayerYCoor(-1);

		}

		if (place.equals("castle")) {
			Location.setPlace(Location.castleBlack);
			GameMod.setPlayerXCoor(0);
			GameMod.setPlayerYCoor(0);			
		}

		if (place.equals("western")) {
			Location.setPlace(Location.westernWallPath);
			GameMod.setPlayerXCoor(-4);
			GameMod.setPlayerYCoor(0);
		}

		if (place.equals("eastern")) {
			Location.setPlace(Location.easternWallPath);
			GameMod.setPlayerXCoor(4);
			GameMod.setPlayerYCoor(0);		
		}

		if (place.equals("shadow")) {
			Location.setPlace(Location.shadowKeep);
			GameMod.setPlayerXCoor(-13);
			GameMod.setPlayerYCoor(5);
		}

		if (place.equals("eastwatch")) {
			Location.setPlace(Location.eastWatch);
			GameMod.setPlayerXCoor(11);
			GameMod.setPlayerYCoor(5);
		}

		if (place.equals("davy")) {
			Location.setPlace(Location.davyJonesLocker);
			GameMod.setPlayerXCoor(-15);
			GameMod.setPlayerYCoor(10);
		}

		if (place.equals("east")) {
			Location.setPlace(Location.eastForestTrail);
			GameMod.setPlayerXCoor(13);
			GameMod.setPlayerYCoor(7);
		}

		if (place.equals("haunted")) {
			Location.setPlace(Location.hauntedForest);
			GameMod.setPlayerXCoor(-3);
			GameMod.setPlayerYCoor(6);
		}

		if (place.equals("forest")) {
			Location.setPlace(Location.forestClearing);
			GameMod.setPlayerXCoor(-3);
			GameMod.setPlayerYCoor(13);
		}

		if (place.equals("crastors")) {
			Location.setPlace(Location.crastorsKeep);
			GameMod.setPlayerXCoor(-5);
			GameMod.setPlayerYCoor(5);
		}

		if (place.equals("crastor's")) {
			Location.setPlace(Location.crastorsKeep);
			GameMod.setPlayerXCoor(-5);
			GameMod.setPlayerYCoor(5);
		}

		if (place.equals("cave")) {
			Location.setPlace(Location.cave);
			GameMod.setPlayerXCoor(14);
			GameMod.setPlayerYCoor(16);
		}

		if (place.equals("north")) {
			Location.setPlace(Location.northForestTrail);
			GameMod.setPlayerXCoor(9);
			GameMod.setPlayerYCoor(17);
		}

		if (place.equals("forests")) {
			Location.setPlace(Location.forestsEdge);
			GameMod.setPlayerXCoor(0);
			GameMod.setPlayerYCoor(19);
		}

		if (place.equals("hills")) {
			Location.setPlace(Location.hills);
			GameMod.setPlayerXCoor(-7);
			GameMod.setPlayerYCoor(25);
		}

		if (place.equals("fist")) {
			Location.setPlace(Location.fistOfTheFirstMen);
			GameMod.setPlayerXCoor(-10);
			GameMod.setPlayerYCoor(26);
		}

		if (place.equals("antler")) {
			Location.setPlace(Location.antlerRiver);
			GameMod.setPlayerXCoor(-5);
			GameMod.setPlayerYCoor(25);
		}
	}

	public static void take(String thing) {
		if (thing.equals("longsword")) {
			Inventory.add(Inventory.longsword);
			GameMod.setHasLongsword(true);
		}
		if (thing.equals("lantern")) {
			Inventory.add(Inventory.lantern);
			GameMod.setHasLantern(true);
		}
		if (thing.equals("oldletter")) {
			Inventory.add(Inventory.oldletter);
			GameMod.setHasOldLetter(true);
			System.out.println(">'Now get out of here, you're upsetting my wives!' screeched Crastor");
		}
		if (thing.equals("firestarter")) {
			Inventory.add(Inventory.firestarter);
			GameMod.setHasFireStarter(true);
		}
		if (thing.equals("pot")) {
			Inventory.add(Inventory.pot);
			GameMod.setHasPot(true);
		}
		if (thing.equals("bow")) {
			Inventory.add(Inventory.bow);
			GameMod.setHasBow(true);
		}
		if (thing.equals("dragonglass")) {
			Inventory.add(Inventory.dragonGlassDagger);
			GameMod.setHasDragonGlassDagger(true);
		}
		if (thing.equals("bearmeat")) {
			Inventory.add(Inventory.bearmeat);
			GameMod.setHasBearMeat(true);
		}
		if (thing.equals("cookedbearmeat")) {
			Inventory.add(Inventory.cookedbearmeat);
			GameMod.setHasCookedBearMeat(true);
		}
	}

	public static void drop(String thing) {
		if (thing.equals("longsword")) {
			Inventory.drop(Inventory.longsword);
			GameMod.setHasLongsword(false);
		}
		if (thing.equals("lantern")) {
			Inventory.drop(Inventory.lantern);
			GameMod.setHasLantern(false);
		}
		if (thing.equals("oldletter")) {
			Inventory.drop(Inventory.oldletter);
			GameMod.setHasOldLetter(false);
		}
		if (thing.equals("firestarter")) {
			Inventory.drop(Inventory.firestarter);
			GameMod.setHasFireStarter(false);
		}
		if (thing.equals("pot")) {
			Inventory.drop(Inventory.pot);
			GameMod.setHasPot(false);
		}
		if (thing.equals("bow")) {
			Inventory.drop(Inventory.bow);
			GameMod.setHasBow(false);
		}
		if (thing.equals("dragonglass")) {
			Inventory.drop(Inventory.dragonGlassDagger);
			GameMod.setHasDragonGlassDagger(false);
		}
		if (thing.equals("bearmeat")) {
			Inventory.drop(Inventory.bearmeat);
			GameMod.setHasBearMeat(false);
		}
		if (thing.equals("cookedbearmeat")) {
			Inventory.drop(Inventory.cookedbearmeat);
			GameMod.setHasCookedBearMeat(false);
		}
	}

	public static void talk(String person) {
		if (person.equals("crastor")) {
			GameMod.setTalkedToCrastor(true);
		}
		if (person.equals("jon")) {
			GameMod.setTalkedToJon(true);
		}
	}
}
