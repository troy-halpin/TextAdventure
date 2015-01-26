public class Location {
	private int xPos;
	private int yPos;
	public static Action left = new Action();
	public static Action right = new Action();
	public static Action north = new Action();
	public static Action south = new Action();
	public static Action east = new Action();
	public static Action west = new Action();
	public static String environment = "";
	//fast travel to locations using x,y
	private static Location place;
	public static Location behindCastleBlack = new Location(0,-1);
	public static Location castleBlack = new Location(0,0);
	public static Location westernWallPath = new Location(-4,0);
	public static Location easternWallPath = new Location(4,0);
	public static Location shadowKeep = new Location(13,5);
	public static Location eastWatch = new Location(11,5);
	public static Location davyJonesLocker = new Location(-15,10);
	public static Location eastForestTrail = new Location(13,7);
	public static Location hauntedForest = new Location(-3,6);
	public static Location forestClearing = new Location(-3,13);
	public static Location crastorsKeep = new Location(-5,5);
	public static Location cave = new Location(14,16);
	public static Location northForestTrail = new Location(9,17);
	public static Location forestsEdge = new Location(0,19);
	public static Location hills = new Location(-7,25);
	public static Location fistOfTheFirstMen = new Location(-10,26);
	public static Location antlerRiver = new Location(-5,25);
	public static Location bySnow = new Location(0,2);
	

	/* The Location class handles player location as well as the game map*/


	Location(int xPos, int yPos) {
	}


	public static void changeXPos(Action direction) {
		if (direction == Action.left) {
			GameMod.setPlayerXCoor(GameMod.getPlayerXCoor() - 1);
		}
		if (direction == Action.right) {
			GameMod.setPlayerXCoor(GameMod.getPlayerXCoor() + 1);
		}
		if (direction == Action.east) {
			GameMod.setPlayerXCoor(GameMod.getPlayerXCoor() + 1);
		}
		if (direction == Action.west) {
			GameMod.setPlayerXCoor(GameMod.getPlayerXCoor() - 1);
		}
	}

	public static void changeYPos(Action direction) {
		if (direction == Action.south) {
			GameMod.setPlayerYCoor(GameMod.getPlayerYCoor() - 1);

		}
		if (direction == Action.north) {
			GameMod.setPlayerYCoor(GameMod.getPlayerYCoor() + 1);
		}
	}

	public static String getLocation() {
		//castle black
		environment=(Text.castleBlackDescription);
		if (((GameMod.getPlayerXCoor() == 0) && (GameMod.getPlayerYCoor() == 2))
			&& (GameMod.getTalkedToJon() == false)) {
			environment = Text.bySnow;
			place = bySnow;
		}

		//leaving castle black
		if (GameMod.getPlayerYCoor() < 0) {
			environment = Text.desertionWarning;
			place = behindCastleBlack;
		}
		//behind castle black
		if (GameMod.getPlayerYCoor() < -1) {
			GameMod.setIsDead(true);
			environment = Text.deserted;
			place = behindCastleBlack;

		}
		//leaving castle black
		//north boundary
		if ((((GameMod.getPlayerXCoor() > 3)  || (GameMod.getPlayerXCoor() < -3)) 
			&& (GameMod.getPlayerYCoor() == 3))
			//west boundary
			|| ((((GameMod.getPlayerYCoor() >= 0)  || (GameMod.getPlayerYCoor() < 3)) 
			&& (GameMod.getPlayerXCoor() == -3)))
			//east boundary
			|| ((((GameMod.getPlayerYCoor() >= 0)  || (GameMod.getPlayerYCoor() < 3)) 
			&& (GameMod.getPlayerXCoor() == 3)))) {
			environment = Text.leftCastleBlack;
			place = castleBlack;
		}
		//path along west side wall
		if ((GameMod.getPlayerXCoor() < -3) && (GameMod.getPlayerXCoor() > -13) 
			&& (GameMod.getPlayerYCoor() > 3) && (GameMod.getPlayerYCoor() < 5)) {
			environment = Text.alongWallWest;
			place = westernWallPath;
		}
		//path along east side wall
		if ((GameMod.getPlayerXCoor() < 10) && (GameMod.getPlayerXCoor() > 3) 
			&& (GameMod.getPlayerYCoor() < 5)) {
			environment = Text.alongWallEast;
			place = easternWallPath;

			//the fire starter and pot
			if ((GameMod.getPlayerXCoor() == 7) && (GameMod.getPlayerYCoor() < 6)
				&& (GameMod.getHasFireStarter() == false) && (GameMod.getHasPot()==false)) {
				environment = Text.nearFireStarterAndPot;
			}

		}
		//shadow keep
		if ((GameMod.getPlayerXCoor() < -13) && (GameMod.getPlayerXCoor() > -18) 
			&& (GameMod.getPlayerYCoor() < 6)) {
			environment = Text.kickedOutOfShadowkeep;
			place = shadowKeep;
			GameMod.setPlayerXCoor(-13);
			GameMod.setPlayerYCoor(6);
		}
		//eastwatch
		if ((GameMod.getPlayerXCoor() < 16) && (GameMod.getPlayerXCoor() > 9) 
			&& (GameMod.getPlayerYCoor() < 6)) {
			environment = Text.kickedOutOfEastwatch;
			place = eastWatch;
			GameMod.setPlayerXCoor(13);
			GameMod.setPlayerYCoor(6);
		}
		//western boundary river
		if ((GameMod.getPlayerXCoor() < -13) && (GameMod.getPlayerYCoor() > 6)) {
			environment = Text.cantSwimInTheRiver;
			place = davyJonesLocker;
			GameMod.setIsDead(true);
		}
		//east forest trail
		if (((GameMod.getPlayerXCoor() > 10) && (GameMod.getPlayerXCoor() < 15))
		&& ((GameMod.getPlayerYCoor() > 6) && (GameMod.getPlayerYCoor() < 15))) {
			environment = Text.eastForestTrail;
			place = eastForestTrail;
		}
		//trying to leave eastern forest trail boundaries
		if (((GameMod.getPlayerXCoor() == 10) || (GameMod.getPlayerXCoor() == 15))
		&& ((GameMod.getPlayerYCoor() > 6) && (GameMod.getPlayerYCoor() < 15))) {
			environment = Text.cantGetThroughTheTrees;
			place = eastForestTrail;
			GameMod.setPlayerXCoor(13);
		}
		//Haunted Forest
		if (((GameMod.getPlayerXCoor() <= 3) && (GameMod.getPlayerXCoor() >= -13)) 
		&& ((GameMod.getPlayerYCoor() > 3) && (GameMod.getPlayerYCoor() < 18))) {
			environment = Text.inTheHauntedForest;
			place = hauntedForest;

			//forest clearing
			if (((GameMod.getPlayerXCoor() < 0) && (GameMod.getPlayerXCoor() >= -5)) 
			&& ((GameMod.getPlayerYCoor() > 12) && (GameMod.getPlayerYCoor() < 17))) {

				//wight
				if (GameMod.getDwightIsDead() == false) {
					environment = Text.forestClearing;
				}
				if (GameMod.getDwightIsDead() == true) {
					environment = Text.forestClearingWithDeadDwight;
				}
			}

			//Crastor's Keep
			if (((GameMod.getPlayerXCoor() < -4) && (GameMod.getPlayerXCoor() >= -7)) 
			&& ((GameMod.getPlayerYCoor() > 4) && (GameMod.getPlayerYCoor() < 9))) {
				if (GameMod.getCrastorIsAlive() == true) {
					environment = Text.crastorsKeepAlive;
					if (GameMod.getTalkedToCrastor() == true) {
						environment = Text.timeToLeave;
					}
					place = crastorsKeep;
				}
				//if you have already killed crastor
				if (GameMod.getCrastorIsAlive() == false) {
					environment = Text.crastorsKeepDead;
					place = crastorsKeep;

				}
			}
		}
		//south-facing cave entrance/exit
		if (((GameMod.getPlayerXCoor() > 10) && (GameMod.getPlayerXCoor() < 15))
			&& (GameMod.getPlayerYCoor() == 15)) {
			if (place.equals(eastForestTrail)) {
				environment = Text.southCaveEntrance;
				place = cave;
			}
			if (place.equals(cave)) {
				environment = Text.eastForestTrail;
				place = eastForestTrail;
			}
		}

		//inside cave
		if (((GameMod.getPlayerXCoor() > 10) && (GameMod.getPlayerXCoor() < 16))
			&& ((GameMod.getPlayerYCoor() > 15) && (GameMod.getPlayerYCoor() < 22))) {
			if (GameMod.getUsedLantern() == false) {
				environment = Text.inDarkCave;
			}else {
				if (GameMod.getBearIsAlive() == false) {
					environment = Text.caveNoBear;
				}
				environment = Text.caveIsLit;
				GameMod.setBearSeesYou(true);

			}
			place = cave;
		
			//right wall boundary
			if (((GameMod.getPlayerYCoor() > 15) && (GameMod.getPlayerYCoor() < 22))
				&& (GameMod.getPlayerXCoor() == 15)) {
				environment = Text.caveWall;
				GameMod.setPlayerXCoor(14);
				place = cave;
			}
			//back wall boundary
			if (((GameMod.getPlayerXCoor() > 10) && (GameMod.getPlayerXCoor() < 15))
				&& (GameMod.getPlayerXCoor() == 22)) {
				environment = Text.caveWall;
				GameMod.setPlayerYCoor(21);
				place = cave;
			}
			//midcave dividing wall
			if (((GameMod.getPlayerYCoor() > 16) && (GameMod.getPlayerYCoor() < 20))
				&& (GameMod.getPlayerXCoor() == 12)) {
				environment = Text.caveWall;
				GameMod.setPlayerXCoor(13);
				place = cave;
			}
			//west cave wall
			if (((GameMod.getPlayerYCoor() > 17) && (GameMod.getPlayerYCoor() < 23))
				&& (GameMod.getPlayerXCoor() == 10)) {
				environment = Text.caveWall;
				if (place.equals(cave)) {
					GameMod.setPlayerXCoor(11);
				}
				if (place.equals(northForestTrail)) {
					GameMod.setPlayerXCoor(9);
				}
			}

		}
		//west cave entrance/exit
		if (((GameMod.getPlayerYCoor() > 14) && (GameMod.getPlayerYCoor() < 18))
			&& (GameMod.getPlayerXCoor() == 10)) {
			if (place.equals(northForestTrail)) {
				environment = Text.westCaveEntrance;
			}
			if (place.equals(cave)) {
				environment = Text.northForestTrail;
				place = northForestTrail;
			}
		}
		//north forest trail
		if (((GameMod.getPlayerXCoor() <= 10) && (GameMod.getPlayerXCoor() > 2))
		&& ((GameMod.getPlayerYCoor() > 14) && (GameMod.getPlayerYCoor() < 17))) {
			environment = Text.northForestTrail;
			place = northForestTrail;
		}
		//north forest trail boundaries
		if (((GameMod.getPlayerYCoor() == 14) || (GameMod.getPlayerYCoor() == 18))
		&& ((GameMod.getPlayerXCoor() <= 10) && (GameMod.getPlayerXCoor() > 2))) {
			environment = Text.cantGetThroughTheTrees;
			place = northForestTrail;
			GameMod.setPlayerYCoor(16);
		}
		//forest's edge
		if (((GameMod.getPlayerXCoor() <= 3) && (GameMod.getPlayerXCoor() >= -13)) 
		&& ((GameMod.getPlayerYCoor() >= 18) && (GameMod.getPlayerYCoor() < 24))) {
			environment = Text.forestsEdge;
			place = forestsEdge;
		}
		//forest's edge east boundary
		if (((GameMod.getPlayerYCoor() > 17) && (GameMod.getPlayerYCoor() <= 24))
		&& (GameMod.getPlayerXCoor() == 3)) {
			environment = Text.eastForestsEdgeEdge;
			place = forestsEdge;
		}
		//hills
		if (((GameMod.getPlayerXCoor() <= -6) && (GameMod.getPlayerXCoor() >= -13)) 
		&& ((GameMod.getPlayerYCoor() >= 24) && (GameMod.getPlayerYCoor() <= 30))) {
			environment = Text.hills;
			place = hills;
			//fist of the first men
			if ((((GameMod.getPlayerXCoor() <= -8) && (GameMod.getPlayerXCoor() >= -13)) 
			&& ((GameMod.getPlayerYCoor() >= 26) && (GameMod.getPlayerYCoor() <= 30)))
			&& (GameMod.getHasDragonGlassDagger() == false)) {
				environment = Text.fistOfTheFirstMen;
				place = fistOfTheFirstMen;
				//near dagger
				if ((((GameMod.getPlayerXCoor() <= -8) && (GameMod.getPlayerXCoor() >= -13))
				&& (GameMod.getPlayerYCoor() == 28)) 
				&& (GameMod.getHasDragonGlassDagger() == false)) {
					environment = Text.byDragonGlassDagger;
				}
			}
			//fist once you have dagger
			if ((((GameMod.getPlayerXCoor() <= -8) && (GameMod.getPlayerXCoor() >= -13)) 
			&& ((GameMod.getPlayerYCoor() >= 26) && (GameMod.getPlayerYCoor() <= 30)))
			&& (GameMod.getHasDragonGlassDagger() == true)) {
				environment = Text.fistWithDagger;
				//fist with dagger, white walker appears
				if ((((GameMod.getPlayerXCoor() <= -8) && (GameMod.getPlayerXCoor() >= -13)) 
				&& ((GameMod.getPlayerYCoor() >= 26) && (GameMod.getPlayerYCoor() <= 30)))
				&& (GameMod.getHasDragonGlassDagger() == true)) {
					environment = Text.whiteWalkerAttacks;
					GameMod.setWhiteWalkerTriggered(true);
				}
			}
		}
		if (((GameMod.getPlayerXCoor() <= -6) && (GameMod.getPlayerXCoor() >= 15)) 
		&& ((GameMod.getPlayerYCoor() >= 24) && (GameMod.getPlayerYCoor() <= 26))) {
			environment = Text.antlerRiver;
			place = antlerRiver;
		}

		return environment;
	}

	public static Location getPlace() {
		return place;
	}

	public static void setPlace(Location loc) {
		place = loc;
	}

	public static String reportLocation() {

		return getLocation();
	}

	public static String printPlace() {
		return place.toString();
	}

}
