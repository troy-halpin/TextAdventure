public class Processor {
public static Action noAction = new Action();
public static Action movementAction = new Action();
public static Action deadAction = new Action();
public static Action useItemAction = new Action();
public static Action examineItemAction = new Action();
public static Action examineBodyAction = new Action();
public static Action fastTravelAction = new Action();
public static Action printCoordinatesAction = new Action();
public static Action takeItemAction = new Action();
public static Action alreadyHaveItemAction = new Action();
public static Action lookAction = new Action();
public static Action checkInventoryAction = new Action();
public static Action haventTalkedToJonAction = new Action();
public static Action talkedToJonAction = new Action();
public static Action talkedToCrastorAction = new Action();
public static Action killedCrastorAction = new Action();
public static Action killedDwightAction = new Action();
public static Action killedBearAction = new Action();
public static Action cookedBearMeatAction = new Action();
public static Action ateCookedBearMeatAction = new Action();
public static Action killedWhiteWalkerAction = new Action();
public static Action endGameAction = new Action();
public static Action jonSnowKnowsHowToKillYouAction = new Action();


	/*The processor takes in the individual words the user has typed and will eventually return the effect of the user's input.
	In parseCommand() the input is split into a string array, and everything is converted to lower-case. The array is then fed to 
	determineAction() which will look for keywords, like "go", "attack", "take" etc. Upon recognizing one, the game will check the
	gamestate to determine what should be done. This is saved as an action object, and fed to the GameMod class, which will return
	the specific text for that action in that particular gamestate.*/

	public Processor() {

	}

	public String processCommand(String command) {
		//parse commands into words
		String[] words = parseCommand(command);

		//modify game state and return something to print
		return GameMod.modifyGame(determineAction(words));
	}

	public String[] parseCommand(String command) {
		command.toLowerCase();
		return command.split(" ");
	}

	public Action determineAction(String[] words) {

		if (GameMod.isDead != true) {

			//try to catch array bounds exceptions to keep the game running	
			try {
				if (words[0].equals("go")) {
					//die if you walk in the dark
					if ((Location.getPlace() == Location.cave) && 
						(GameMod.getUsedLantern() == false)) {
						System.out.println(Text.triedToWalkInDarkCave);
						return deadAction;
					}

					//die if don't attack bear
					if ((Location.getPlace() == Location.cave) 
					&& (GameMod.getBearSeesYou() == true)
					&& (GameMod.getBearIsAlive() == true)) {
						System.out.println(Text.triedToRunFromBear);
						return deadAction;
					}

					//die if don't fight Dwight
					if ((GameMod.getFightTheWight() == true)
					&& (GameMod.getDwightIsDead() == false)) {
						System.out.println(Text.triedToRunFromDwight);
						return deadAction;
					}

					//die if run from white walker
					if ((GameMod.getWhiteWalkerTriggered() == true)
					&& (GameMod.getWhiteWalkerDefeated() == false)) {
						System.out.println(Text.triedToRunFromWhiteWalker);
						return deadAction;
					}
					//die if dkilled Crastor and return to any Night's Watch stronghold
					if (((Location.getPlace() == Location.castleBlack) || (Location.getPlace() == Location.shadowKeep)
					|| ((Location.getPlace() == Location.eastWatch))) && (GameMod.getBearSeesYou() == true)) {
						System.out.println(Text.caughtAfterTreason);
						return deadAction;
					}

					Action.go(words[1]);
					return movementAction;
					}
			} catch(ArrayIndexOutOfBoundsException ex) {
					System.out.println(">Yo, go where?");
			}
			try {
				if (words[0].equals("examine"))  {
					
					//examine
 					if (words[1].equals("longsword") ||
					words[1].equals("lantern") ||
					words[1].equals("oldletter") ||
					words[1].equals("firestarter") ||
					words[1].equals("pot") ||
					words[1].equals("bow") ||
					words[1].equals("bearmeat") ||
					words[1].equals("cookedbearmeat")) {
					Action.examine(words[1]);
 					return examineItemAction;
 					} 					

 					//looks at body
 					if (words[1].equals("body")) {
 						return examineBodyAction;
 					}
 					
				}
				//"examine" with no target
			} catch(ArrayIndexOutOfBoundsException ex2) {
					System.out.println(">Examine what?");
			}
			//repeats surroundings description
			if (words[0].equals("look")) {
				return lookAction;
			}
			//will list what you are carrying
			if ((words[0].equals("check")) && (words[1].equals("inventory"))) {
				return checkInventoryAction;
			}

			if (words[0].equals("use")) {

				Action.use(words[1]);
				return useItemAction;
			}

			if (words[0].equals("take")) {

				if (((words[1].equals("longsword"))	|| (words[1].equals("lantern")))
					&& (GameMod.getTalkedToJon() == false)) {
					return haventTalkedToJonAction;
				}

				if (words[1].equals("cookedbearmeat")) {
					return noAction;
				}

				if ((words[1].equals("oldletter")) && (GameMod.getTalkedToCrastor() == false)) {
					return noAction;
				}

				if ((words[1].equals("bow")) && (GameMod.getDwightIsDead() == false)) {
					return noAction;
				}
				//if you try to take something you already have
				if (
					((GameMod.getHasLongsword() == true) && (words[1].equals("longsword"))) ||
					((GameMod.getHasLantern() == true) && (words[1].equals("lantern"))) ||
					((GameMod.getHasOldLetter() == true) && (words[1].equals("oldletter"))) ||
					((GameMod.getHasFireStarter() == true) && (words[1].equals("firestarter"))) ||
					((GameMod.getHasPot() == true) && (words[1].equals("pot"))) ||
					((GameMod.getHasBow() == true) && (words[1].equals("bow"))) ||
					((GameMod.getHasBearMeat() == true) && (words[1].equals("bearmeat"))) ||
					((GameMod.getHasCookedBearMeat() == true) && (words[1].equals("cookedbearmeat"))) 
					) {
					return alreadyHaveItemAction;
				}

				if ( !( (words[1].equals(("longsword"))) || (words[1].equals(("lantern"))) || (words[1].equals(("oldletter"))) 
				|| (words[1].equals(("firestarter"))) || (words[1].equals(("bow"))) || (words[1].equals(("pot")))
				|| (words[1].equals(("dragonglass"))) || (words[1].equals(("bearmeat"))) || (words[1].equals(("cookedbearmeat"))) ) ) {
					return noAction;
				}else {
					Action.take(words[1]);
					return takeItemAction;
				}
		
			}	
			//'goto' and 'getlocation' were primarily used while building the map, but leaving them in for the curious. Also helps if people want to make the map
			if (words[0].equals("goto")) {
				Action.fastTravel(words[1]);
				return fastTravelAction;
			}

			if (words[0].equals("getlocation")) {
				return printCoordinatesAction;
			}
			// try/catch to make sure you can talk to the right people
			try {
				if ((words[0].equals("talk")) && (words[1].equals("to"))) {
					if ((words[2].equals("jon")) || (words.equals("snow"))) {
						if (GameMod.getWhiteWalkerDefeated() == true) {
							return endGameAction;
						}else {
							Action.talk(words[2]);
							return talkedToJonAction;
						}
					}
					if ((words[2].equals("crastor"))) {
					Action.talk(words[2]);
					return talkedToCrastorAction;
					}

					//hopefully more people
				}
			} catch(ArrayIndexOutOfBoundsException ex3) {
					System.out.println(">Talk to whom?");
			}
			//"attack <enemy> with <item>" is the assumed statement. 
			try {
				if (words[0].equals("attack")) {
					//cant attack with a letter
					if (words[3].equals("oldletter")) {
						return noAction;
					}
					//atacking jon makes him kill you
					if (words[1].equals("jon")) {
						System.out.println(Text.jonKilledYou);
						return deadAction;
					}
					//attack crastor
					if (words[1].equals("crastor")) {
						if (words[3].equals("longsword")) {
							GameMod.setCrastorIsAlive(false);
							System.out.println("You attacked Crastor with your " + words[3]);
							return killedCrastorAction;
						} else if (words[3].equals("bow")) {
							GameMod.setCrastorIsAlive(false);
							System.out.println("You attacked Crastor with your " + words[3]);
							return killedCrastorAction;
						} else if (words[3].equals("dragonglass")) {
							GameMod.setCrastorIsAlive(false);
							System.out.println("You attacked Crastor with your " + words[3]);
							return killedCrastorAction;
						} else {
							System.out.println("You attacked Crastor with your " + words[3]);
							System.out.println(Text.crastorKilledYou);
							return deadAction;
						}
					}
					//attack wight
					if (words[1].equals("dwight")) {
						if (words[3].equals("lantern")) {
							GameMod.setCrastorIsAlive(false);
							System.out.println("You attacked Dwight with your " + words[3]);
							System.out.println(Text.superEffective);
							return killedDwightAction;
						}else if (words[3].equals("firestarter")) {
							GameMod.setCrastorIsAlive(false);
							System.out.println("You attacked Dwight with your " + words[3]);
							System.out.println(Text.superEffective);
							return killedDwightAction;
						}else {
							System.out.println("You attacked Dwight with your " + words[3]);
							System.out.println(Text.dwightKilledYou);
							return deadAction;
						}
					}
					//attack bear
					if (words[1].equals("bear")) {
						if (words[3].equals("longsword")) {
							GameMod.setBearIsAlive(false);
							System.out.println("You attacked the bear with your " + words[3]);
							return killedBearAction;
						}else if (words[3].equals("bow")) {
							GameMod.setBearIsAlive(false);
							System.out.println("You attacked the bear with your " + words[3]);
							return killedBearAction;
						}else if (words[3].equals("dragonglass")) {
							GameMod.setBearIsAlive(false);
							System.out.println("You attacked the bear with your " + words[3]);
							return killedBearAction;
						} else {
							System.out.println("You attacked the bear with your " + words[3]);
							System.out.println(Text.crastorKilledYou);
							return deadAction;
						}
					}
					//attack white walker
					if (words[1].equals("white")) {
						if (words[4].equals("dragonglass")) {
							GameMod.setWhiteWalkerDefeated(true);
							System.out.println("You attacked the White Walker with your dragonglass dagger");
							System.out.println(Text.superEffective);
							return killedWhiteWalkerAction;
						} else {
							System.out.println(Text.whiteWalkerKilledYou);
							return deadAction;
						}
					}
				}
			} catch(ArrayIndexOutOfBoundsException ex4) {
				System.out.println("Attack whom with what?");
			}
			//cook food
			try {
				if (words[0].equals("cook")) {
					if (words[1].equals("bearmeat")) {
						BearMeat.use();
						return cookedBearMeatAction;
					}else {
						return noAction;
					}
				}
			} catch (ArrayIndexOutOfBoundsException ex5) {
				System.out.println(">Cook what?");
			}

			try {
				if (words[0].equals("eat")) {
					if (words[1].equals("bearmeat")) {
						System.out.println(Text.ateRawBeatMeat);
						return deadAction;
					}
					if (words[1].equals("cookedbearmeat")) {
						CookedBearMeat.use();
						return ateCookedBearMeatAction;
					}else {
						return noAction;
					}
				}
			} catch (ArrayIndexOutOfBoundsException ex6) {
				System.out.println(">Eat what?");
			}
			//Jon Snow doesn't like it when you tell him he knows nothing
			if ((words[0].equals("you")) &&
			(words[1].equals("know")) &&
			(words[2].equals("nothing")) &&
			(words[3].equals("jon")) &&
			(words[4].equals("snow"))) {
				return jonSnowKnowsHowToKillYouAction;
			}else {
				return noAction;
			}
		}

		if (GameMod.isDead == true) {
			return deadAction;
		} else {
			return noAction;
		}

	}
}
