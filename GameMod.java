import java.util.*;
import java.io.*;

public class GameMod {
	//game variables
	public static List<Item> inventory = new ArrayList<Item>();
	public static boolean youWon = false;

	//location variables
	private static int initialXPos;
	private static int initialYPos;
	private Location location;
	private static int playerXCoord;
	private static int playerYCoord;
	//event booleans
	public static boolean isDead = false;
	private static boolean crastorIsAlive = true;
	private static boolean talkedToCrastor = false;
	private static boolean bearSeesYou = false;
	private static boolean fightTheWight = false;
	private static boolean talkedToJon = false;
	private static boolean dwightIsDead = false;
	private static boolean bearIsAlive = true;
	private static boolean whiteWalkerTriggered = false;
	private static boolean whiteWalkerDefeated = false;
	//item booleans
	private static boolean hasLongsword = false;
	private static boolean hasLantern = false;
	private static boolean hasOldLetter = false;
	private static boolean hasFireStarter = false;
	private static boolean hasPot = false; //lol
	private static boolean hasBow = false;
	private static boolean hasDragonGlassDagger = false;
	private static boolean hasBearMeat = false;
	private static boolean hasCookedBearMeat = false;
	private static boolean usedLongsword = false;
	private static boolean usedLantern = false;
	private static boolean usedFireStarter = false;
	private static boolean usedPot = false;  
	private static boolean usedBow = false;
	private static boolean usedDragonGlassDagger = false;
	private static boolean usedBearMeat = false;
	private static boolean usedCookedBearMeat = false;



	//This class takes in an action, and will return the corresponding text. Also contains all getters/setters that change the game state


	GameMod() {

	}
	/*Given an action, modifyGame will return the corresponding text update. For instance, if given deadAction, modifyGame will return the text
	that tells you the game is over*/
	
	public static String modifyGame(Action action) {
		//if a user enters a command the game doesn't recognize, it will tell you
		if (action.equals(Processor.noAction)) {
			return Text.wrongInput;
		}
		//game over
		if (action.equals(Processor.deadAction)) {
			return Text.gameOver;
		}
		//text for killing Castor, if the player so chooses
		if (action.equals(Processor.killedCrastorAction)) {
			crastorIsAlive = false;
			return Text.killedCrastor;
		}
		//text for successfully defeating Dwight the Wight
		if (action.equals(Processor.killedDwightAction)) {
			dwightIsDead = true;
			return Text.killedDwight;
		}
		//player killed the bear!
		if (action.equals(Processor.killedBearAction)) {
			bearIsAlive = false;
			return Text.killedBear;
		}
		//the player defeated the White Walker
		if (action.equals(Processor.killedWhiteWalkerAction)) {
			return Text.killedWhiteWalker;
		}
		//cooking bear meat
		if (action.equals(Processor.cookedBearMeatAction)) {
			return Text.cookBearMeat;
		}
		//if the player hasn't talked to Jon yet, the game will tell you that you need to
		if (action.equals(Processor.haventTalkedToJonAction)) {
			return Text.needToTalkToJon;
		}

		//Will check to make sure you are in the keep before allowing you to talk to Jon
		if (action.equals(Processor.talkedToJonAction)) {
			if ((playerXCoord == 0) && (playerYCoord == 2)) {
			return Text.jonGivingMission;
			}else {
				return Text.notNearJon;
			}
		}
		//
		if (action.equals(Processor.talkedToCrastorAction)) {
			return Text.crastorGivingOldLetter;
		}

		if (action.equals(Processor.fastTravelAction)) {
			return Location.reportLocation();
		}

		if (action.equals(Processor.lookAction)) {
			return Location.reportLocation();
		}

		if (action.equals(Processor.printCoordinatesAction)) {
			return "You are at " + getPlayerXCoor() + "," + getPlayerYCoor();
		}
		//the 'examine' function will print out the description of the item on its own, so no need to do it here
		if (action.equals(Processor.examineItemAction)) {
			return ">";
		}

		if (action.equals(Processor.examineBodyAction)) {
			return Text.itsAWight;
		}

		if (action.equals(Processor.takeItemAction)) {
			return Text.putInInventory;
		}

		if (action.equals(Processor.alreadyHaveItemAction)) {
			return Text.alreadyHaveIt;
		}

		if (action.equals(Processor.checkInventoryAction)) {
			return Inventory.currentInventory();
		}

		if (action.equals(Processor.useItemAction)) {
			return "Now what?";
		}

		if (action.equals(Processor.ateCookedBearMeatAction)) {
			return Text.ateCookedBearMeat;
		}

		if (action.equals(Processor.movementAction)) {
			if (Location.environment.equals(Text.deserted)) {
				return Text.gameOver;
			}		
			return Location.reportLocation();

		}
		if (action.equals(Processor.endGameAction)) {
			youWon = true;
			return Text.endGame;
		}
		if (action.equals(Processor.jonSnowKnowsHowToKillYouAction)) {
			isDead = true;
			return Text.jonSnowKnowsHowToKillYou;
			
		}else {
			return "blah";
		}
		
	}
	//general
	public static int getInitialXPos() {
		return initialXPos;
	}
	public static int getInitialYPos() {
		return initialYPos;
	}

	public static int getPlayerXCoor() {
		return playerXCoord;
	}

	public static int getPlayerYCoor() {
		return playerYCoord;
	}

	public static void setPlayerXCoor(int newX) {
		playerXCoord = newX;
	}

	public static void setPlayerYCoor(int newY) {
		playerYCoord = newY;
	}

	public static void setIsDead(boolean bool) {
		isDead = bool;
	}
	public static boolean getIsDead() {
		return isDead;
	}

	//events
	public static void setBearSeesYou(boolean bool) {
		bearSeesYou = bool;
	}
	public static boolean getBearSeesYou() {
		return bearSeesYou;
	}
	public static void setBearIsAlive(boolean bool) {
		bearIsAlive = bool;
	}
	public static boolean getBearIsAlive() {
		return bearIsAlive;
	}
	public static void setFightTheWight(boolean bool) {
		fightTheWight = bool;
	}
	public static boolean getFightTheWight() {
		return fightTheWight;
	}
	public static void setTalkedToJon(boolean bool) {
		talkedToJon = bool;
	}
	public static boolean getTalkedToJon() {
		return talkedToJon;
	}
	public static void setTalkedToCrastor(boolean bool) {
		talkedToCrastor = bool;
	}
	public static boolean getTalkedToCrastor() {
		return talkedToCrastor;
	}
	public static void setDwightIsDead(boolean bool) {
		dwightIsDead = bool;
	}
	public static boolean getDwightIsDead() {
		return dwightIsDead;
	}
	public static void setWhiteWalkerTriggered(boolean bool) {
		whiteWalkerTriggered = bool;
	}
	public static boolean getWhiteWalkerTriggered() {
		return whiteWalkerTriggered;
	}
	public static void setCrastorIsAlive(boolean bool) {
		crastorIsAlive = bool;
	}
	public static boolean getCrastorIsAlive() {
		return crastorIsAlive;
	}
	public static void setWhiteWalkerDefeated(boolean bool) {
		whiteWalkerDefeated = bool;
	}
	public static boolean getWhiteWalkerDefeated() {
		return whiteWalkerDefeated;
	}


	//items
	public static boolean getHasLongsword() {
		return hasLongsword;
	}
	public static void setHasLongsword(boolean bool) {
		hasLongsword = bool;
	}

	public static boolean getHasLantern() {
		return hasLantern;
	}
	public static void setHasLantern(boolean bool) {
		hasLantern = bool;
	}

	public static boolean getHasOldLetter() {
		return hasOldLetter;
	}
	public static void setHasOldLetter(boolean bool) {
		hasOldLetter = bool;
	}

	public static boolean getHasFireStarter() {
		return hasFireStarter;
	}
	public static void setHasFireStarter(boolean bool) {
		hasFireStarter = bool;
	}

	public static boolean getHasPot() {
		return hasPot;
	}
	public static void setHasPot(boolean bool) {
		hasPot = bool;
	}

	public static boolean getHasBow() {
		return hasBow;
	}
	public static void setHasBow(boolean bool) {
		hasBow = bool;
	}

	public static boolean getHasDragonGlassDagger() {
		return hasDragonGlassDagger;
	}
	public static void setHasDragonGlassDagger(boolean bool) {
		hasDragonGlassDagger = bool;
	}

	public static boolean getHasBearMeat() {
		return hasBearMeat;
	}
	public static void setHasBearMeat(boolean bool) {
		hasBearMeat = bool;
	}

	public static boolean getHasCookedBearMeat() {
		return hasCookedBearMeat;
	}
	public static void setHasCookedBearMeat(boolean bool) {
		hasCookedBearMeat = bool;
	}

	public static boolean getUsedLongsword() {
		return usedLongsword;
	}
	public static void setUsedLongsword(boolean bool) {
		usedLongsword = bool;
	}

	public static boolean getUsedLantern() {
		return usedLantern;
	}
	public static void setUsedLantern(boolean bool) {
		usedLantern = bool;
	}

	public static boolean getUsedFireStarter() {
		return usedFireStarter;
	}
	public static void setUsedFireStarter(boolean bool) {
		usedFireStarter = bool;
	}

	public static boolean getUsedPot() {
		return usedPot;
	}
	public static void setUsedPot(boolean bool) {
		usedPot = bool;
	}

	public static boolean getUsedBow() {
		return usedBow;
	}
	public static void setUsedBow(boolean bool) {
		usedBow = bool;
	}

	public static boolean getUsedDragonGlassDagger() {
		return usedDragonGlassDagger;
	}
	public static void setUsedDragonGlassDagger(boolean bool) {
		usedDragonGlassDagger = bool;
	}

	public static boolean getUsedBearMeat() {
		return usedBearMeat;
	}
	public static void setUsedBearMeat(boolean bool) {
		usedBearMeat = bool;
	}

	public static boolean getUsedCookedBearMeat() {
		return usedCookedBearMeat;
	}
	public static void setUsedCookedBearMeat(boolean bool) {
		usedCookedBearMeat = bool;
	}
}
