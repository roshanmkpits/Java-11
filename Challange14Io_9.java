package ch14_9.iodemo;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

//modification in prev example
//reading big data
//example using buffered writer
 class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if(exits != null) {
            this.exits = new LinkedHashMap<String, Integer>(exits);
        } else {
            this.exits = new LinkedHashMap<String, Integer>();
        }
        this.exits.put("Q", 0);
    }

//    public void addExit(String direction, int location) {
//        exits.put(direction, location);
//    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new LinkedHashMap<String, Integer>(exits); //for maintain order
    }
    protected void addExit(String direction, int location) {
        exits.put(direction, location);
    }
}


 class Challange14Io {

    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) throws IOException {
        try(BufferedWriter locFile = new BufferedWriter(new FileWriter("locations.txt"));
            BufferedWriter dirFile = new BufferedWriter(new FileWriter("directions.txt"))) {
            for(Location location : locations.values()) {
                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for(String direction : location.getExits().keySet()) {
                    if(!direction.equalsIgnoreCase("Q")) {
                        dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                    }
                }
            }
        }
    }

    static {
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("locations_big.txt")))) {
            scanner.useDelimiter(",");
            while(scanner.hasNextLine()) {
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                System.out.println("Imported loc: " + loc + ": " + description);
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(loc, new Location(loc, description, tempExit));
            }

        } catch(IOException e) {
            e.printStackTrace();
        }

        // Now read the exits
        try (BufferedReader dirFile = new BufferedReader(new FileReader("directions_big.txt"))) {
            String input;
            while((input = dirFile.readLine()) != null) {
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);

                System.out.println(loc + ": " + direction + ": " + destination);
                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }



//output

//     Imported loc: 0: YOU ARE SITTING IN FRONT OF A COMPUTER LEARNING JAVA.
//        Imported loc: 1: YOU ARE STANDING AT THE END OF A ROAD BEFORE A SMALL BRICK BUILDING. AROUND YOU IS A FOREST. A SMALL STREAM FLOWS OUT OF THE BUILDING AND DOWN A GULLY.
//        Imported loc: 2: YOU HAVE WALKED UP A HILL, STILL IN THE FOREST. THE ROAD SLOPES BACK DOWN THE OTHER SIDE OF THE HILL. THERE IS A BUILDING IN THE DISTANCE.
//        Imported loc: 3: YOU ARE INSIDE A BUILDING, A WELL HOUSE FOR A LARGE SPRING.
//        Imported loc: 4: YOU ARE IN A VALLEY IN THE FOREST BESIDE A STREAM TUMBLING ALONG A ROCKY BED.
//        Imported loc: 5: YOU ARE IN OPEN FOREST, WITH A DEEP VALLEY TO ONE SIDE.
//        Imported loc: 6: YOU ARE IN OPEN FOREST NEAR BOTH A VALLEY AND A ROAD.
//        Imported loc: 7: AT YOUR FEET ALL THE WATER OF THE STREAM SPLASHES INTO A 2-INCH SLIT IN THE ROCK. DOWNSTREAM THE STREAMBED IS BARE ROCK.
//        Imported loc: 8: YOU ARE IN A 20-FOOT DEPRESSION FLOORED WITH BARE DIRT. SET INTO THE DIRT IS A STRONG STEEL GRATE MOUNTED IN CONCRETE. A DRY STREAMBED LEADS INTO THE DEPRESSION.
//        Imported loc: 9: YOU ARE IN A SMALL CHAMBER BENEATH A 3X3 STEEL GRATE TO THE SURFACE. A LOW CRAWL OVER COBBLES LEADS INWARD TO THE WEST.
//        Imported loc: 10: YOU ARE CRAWLING OVER COBBLES IN A LOW PASSAGE. THERE IS A DIM LIGHT AT THE EAST END OF THE PASSAGE.
//        Imported loc: 11: YOU ARE IN A DEBRIS ROOM FILLED WITH STUFF WASHED IN FROM THE SURFACE. A LOW WIDE PASSAGE WITH COBBLES BECOMES PLUGGED WITH MUD AND DEBRIS HERE, BUT AN AWKWARD CANYON LEADS UPWARD AND WEST. A NOTE ON THE WALL SAYS "MAGIC WORD XYZZY".
//        Imported loc: 12: YOU ARE IN AN AWKWARD SLOPING EAST/WEST CANYON.
//        Imported loc: 13: YOU ARE IN A SPLENDID CHAMBER THIRTY FEET HIGH. THE WALLS ARE FROZEN RIVERS OF ORANGE STONE. AN AWKWARD CANYON AND A GOOD PASSAGE EXIT FROM EAST AND WEST SIDES OF THE CHAMBER.
//        Imported loc: 14: AT YOUR FEET IS A SMALL PIT BREATHING TRACES OF WHITE MIST. AN EAST PASSAGE ENDS HERE EXCEPT FOR A SMALL CRACK LEADING ON.
//        Imported loc: 15: YOU ARE AT ONE END OF A VAST HALL STRETCHING FORWARD OUT OF SIGHT TO THE WEST. THERE ARE OPENINGS TO EITHER SIDE. NEARBY, A WIDE STONE STAIRCASE LEADS DOWNWARD. THE HALL IS FILLED WITH WISPS OF WHITE MIST SWAYING TO AND FRO ALMOST AS IF ALIVE. A COLD WIND BLOWS UP THE STAIRCASE. THERE IS A PASSAGE AT THE TOP OF A DOME BEHIND YOU.
//        Imported loc: 16: THE CRACK IS FAR TOO SMALL FOR YOU TO FOLLOW.
//        Imported loc: 17: YOU ARE ON THE EAST BANK OF A FISSURE SLICING CLEAR ACROSS THE HALL. THE MIST IS QUITE THICK HERE, AND THE FISSURE IS TOO WIDE TO JUMP.
//        Imported loc: 18: THIS IS A LOW ROOM WITH A CRUDE NOTE ON THE WALL. THE NOTE SAYS, "YOU WON'T GET IT UP THE STEPS".
//        Imported loc: 19: YOU ARE IN THE HALL OF THE MOUNTAIN KING, WITH PASSAGES OFF IN ALL DIRECTIONS.
//        Imported loc: 20: YOU ARE AT THE BOTTOM OF THE PIT WITH A BROKEN NECK.
//        Imported loc: 21: YOU DIDN'T MAKE IT.
//        Imported loc: 22: THE DOME IS UNCLIMBABLE.
//        Imported loc: 23: YOU ARE AT THE WEST END OF THE TWOPIT ROOM. THERE IS A LARGE HOLE IN THE WALL ABOVE THE PIT AT THIS END OF THE ROOM.
//        Imported loc: 24: YOU ARE AT THE BOTTOM OF THE EASTERN PIT IN THE TWOPIT ROOM. THERE IS A SMALL POOL OF OIL IN ONE CORNER OF THE PIT.
//        Imported loc: 25: YOU ARE AT THE BOTTOM OF THE WESTERN PIT IN THE TWOPIT ROOM. THERE IS A LARGE HOLE IN THE WALL ABOUT 25 FEET ABOVE YOU.
//        Imported loc: 26: YOU CLAMBER UP THE PLANT AND SCURRY THROUGH THE HOLE AT THE TOP.
//        Imported loc: 27: YOU ARE ON THE WEST SIDE OF THE FISSURE IN THE HALL OF MISTS.
//        Imported loc: 28: YOU ARE IN A LOW N/S PASSAGE AT A HOLE IN THE FLOOR. THE HOLE GOES DOWN TO AN E/W PASSAGE.
//        Imported loc: 29: YOU ARE IN THE SOUTH SIDE CHAMBER.
//        Imported loc: 30: YOU ARE IN THE WEST SIDE CHAMBER OF THE HALL OF THE MOUNTAIN KING. A PASSAGE CONTINUES WEST AND UP HERE.
//        Imported loc: 31: >$<
//        Imported loc: 32: YOU CAN'T GET BY THE SNAKE.
//        Imported loc: 33: YOU ARE IN A LARGE ROOM, WITH A PASSAGE TO THE SOUTH, A PASSAGE TO THE WEST, AND A WALL OF BROKEN ROCK TO THE EAST. THERE IS A LARGE 'Y2' ON A ROCK IN THE ROOM'S CENTER.
//        Imported loc: 34: YOU ARE IN A JUMBLE OF ROCK, WITH CRACKS EVERYWHERE.
//        Imported loc: 35: YOU'RE AT A LOW WINDOW OVERLOOKING A HUGE PIT, WHICH EXTENDS UP OUT OF SIGHT. A FLOOR IS INDISTINCTLY VISIBLE OVER 50 FEET BELOW. TRACES OF WHITE MIST COVER THE FLOOR OF THE PIT, BECOMING THICKER TO THE RIGHT. MARKS IN THE DUST AROUND THE WINDOW WOULD SEEM TO INDICATE THAT SOMEONE HAS BEEN HERE RECENTLY. DIRECTLY ACROSS THE PIT FROM YOU AND 25 FEET AWAY THERE IS A SIMILAR WINDOW LOOKING INTO A LIGHTED ROOM. A SHADOWY FIGURE CAN BE SEEN THERE PEERING BACK AT YOU.
//        Imported loc: 36: YOU ARE IN A DIRTY BROKEN PASSAGE. TO THE EAST IS A CRAWL. TO THE WEST IS A LARGE PASSAGE. ABOVE YOU IS A HOLE TO ANOTHER PASSAGE.
//        Imported loc: 37: YOU ARE ON THE BRINK OF A SMALL CLEAN CLIMBABLE PIT. A CRAWL LEADS WEST.
//        Imported loc: 38: YOU ARE IN THE BOTTOM OF A SMALL PIT WITH A LITTLE STREAM, WHICH ENTERS AND EXITS THROUGH TINY SLITS.
//        Imported loc: 39: YOU ARE IN A LARGE ROOM FULL OF DUSTY ROCKS. THERE IS A BIG HOLE IN THE FLOOR. THERE ARE CRACKS EVERYWHERE, AND A PASSAGE LEADING EAST.
//        Imported loc: 40: YOU HAVE CRAWLED THROUGH A VERY LOW WIDE PASSAGE PARALLEL TO AND NORTH OF THE HALL OF MISTS.
//        Imported loc: 41: YOU ARE AT THE WEST END OF HALL OF MISTS. A LOW WIDE CRAWL CONTINUES WEST AND ANOTHER GOES NORTH. TO THE SOUTH IS A LITTLE PASSAGE 6 FEET OFF THE FLOOR.
//        Imported loc: 42: YOU ARE IN A MAZE OF TWISTY LITTLE PASSAGES, ALL ALIKE.
//        Imported loc: 43: YOU ARE IN A MAZE OF TWISTY LITTLE PASSAGES, ALL ALIKE.
//        Imported loc: 44: YOU ARE IN A MAZE OF TWISTY LITTLE PASSAGES, ALL ALIKE.
//        Imported loc: 45: YOU ARE IN A MAZE OF TWISTY LITTLE PASSAGES, ALL ALIKE.
//        Imported loc: 46: DEAD END
//        Imported loc: 47: DEAD END
//        Imported loc: 48: DEAD END
//        Imported loc: 49: YOU ARE IN A MAZE OF TWISTY LITTLE PASSAGES, ALL ALIKE.
//        Imported loc: 50: YOU ARE IN A MAZE OF TWISTY LITTLE PASSAGES, ALL ALIKE.
//        Imported loc: 51: YOU ARE IN A MAZE OF TWISTY LITTLE PASSAGES, ALL ALIKE.
//        Imported loc: 52: YOU ARE IN A MAZE OF TWISTY LITTLE PASSAGES, ALL ALIKE.
//        Imported loc: 53: YOU ARE IN A MAZE OF TWISTY LITTLE PASSAGES, ALL ALIKE.
//        Imported loc: 54: DEAD END
//        Imported loc: 55: YOU ARE IN A MAZE OF TWISTY LITTLE PASSAGES, ALL ALIKE.
//        Imported loc: 56: DEAD END
//        Imported loc: 57: YOU ARE ON THE BRINK OF A THIRTY FOOT PIT WITH A MASSIVE ORANGE COLUMN DOWN ONE WALL. YOU COULD CLIMB DOWN HERE BUT YOU COULD NOT GET BACK UP. THE MAZE CONTINUES AT THIS LEVEL.
//        Imported loc: 58: DEAD END
//        Imported loc: 59: YOU HAVE CRAWLED THROUGH A VERY LOW WIDE PASSAGE PARALLEL TO AND NORTH OF THE HALL OF MISTS.
//        Imported loc: 60: YOU ARE AT THE EAST END OF A VERY LONG HALL APPARENTLY WITHOUT SIDE CHAMBERS. TO THE EAST A LOW WIDE CRAWL SLANTS UP. TO THE NORTH A ROUND TWO FOOT HOLE SLANTS DOWN.
//        Imported loc: 61: YOU ARE AT THE WEST END OF A VERY LONG FEATURELESS HALL. THE HALL JOINS UP WITH A NARROW NORTH/SOUTH PASSAGE.
//        Imported loc: 62: YOU ARE AT A CROSSOVER OF A HIGH N/S PASSAGE AND A LOW E/W ONE.
//        Imported loc: 63: DEAD END
//        Imported loc: 64: YOU ARE AT A COMPLEX JUNCTION. A LOW HANDS AND KNEES PASSAGE FROM THE NORTH JOINS A HIGHER CRAWL FROM THE EAST TO MAKE A WALKING PASSAGE GOING WEST. THERE IS ALSO A LARGE ROOM ABOVE. THE AIR IS DAMP HERE.
//        Imported loc: 65: YOU ARE IN BEDQUILT, A LONG EAST/WEST PASSAGE WITH HOLES EVERYWHERE. TO EXPLORE AT RANDOM SELECT NORTH, SOUTH, UP, OR DOWN.
//        Imported loc: 66: YOU ARE IN A ROOM WHOSE WALLS RESEMBLE SWISS CHEESE. OBVIOUS PASSAGES GO WEST, EAST, NE, AND NW. PART OF THE ROOM IS OCCUPIED BY A LARGE BEDROCK BLOCK.
//        Imported loc: 67: YOU ARE AT THE EAST END OF THE TWOPIT ROOM. THE FLOOR HERE IS LITTERED WITH THIN ROCK SLABS, WHICH MAKE IT EASY TO DESCEND THE PITS. THERE IS A PATH HERE BYPASSING THE PITS TO CONNECT PASSAGES FROM EAST AND WEST. THERE ARE HOLES ALL OVER, BUT THE ONLY BIG ONE IS ON THE WALL DIRECTLY OVER THE WEST PIT WHERE YOU CAN'T GET TO IT.
//        Imported loc: 68: YOU ARE IN A LARGE LOW CIRCULAR CHAMBER WHOSE FLOOR IS AN IMMENSE SLAB FALLEN FROM THE CEILING (SLAB ROOM). EAST AND WEST THERE ONCE WERE LARGE PASSAGES, BUT THEY ARE NOW FILLED WITH BOULDERS. LOW SMALL PASSAGES GO NORTH AND SOUTH, AND THE SOUTH ONE QUICKLY BENDS WEST AROUND THE BOULDERS.
//        Imported loc: 69: YOU ARE IN A SECRET N/S CANYON ABOVE A LARGE ROOM.
//        Imported loc: 70: YOU ARE IN A SECRET N/S CANYON ABOVE A SIZABLE PASSAGE.
//        Imported loc: 71: YOU ARE IN A SECRET CANYON AT A JUNCTION OF THREE CANYONS, BEARING NORTH, SOUTH, AND SE. THE NORTH ONE IS AS TALL AS THE OTHER TWO COMBINED.
//        Imported loc: 72: YOU ARE IN A LARGE LOW ROOM. CRAWLS LEAD NORTH, SE, AND SW.
//        Imported loc: 73: DEAD END CRAWL.
//        Imported loc: 74: YOU ARE IN A SECRET CANYON WHICH HERE RUNS E/W. IT CROSSES OVER A VERY TIGHT CANYON 15 FEET BELOW. IF YOU GO DOWN YOU MAY NOT BE ABLE TO GET BACK UP.
//        Imported loc: 75: YOU ARE AT A WIDE PLACE IN A VERY TIGHT N/S CANYON.
//        Imported loc: 76: THE CANYON HERE BECOMES TOO TIGHT TO GO FURTHER SOUTH.
//        Imported loc: 77: YOU ARE IN A TALL E/W CANYON. A LOW TIGHT CRAWL GOES 3 FEET NORTH AND SEEMS TO OPEN UP.
//        Imported loc: 78: THE CANYON RUNS INTO A MASS OF BOULDERS -- DEAD END.
//        Imported loc: 79: THE STREAM FLOWS OUT THROUGH A PAIR OF 1 FOOT DIAMETER SEWER PIPES. IT WOULD BE ADVISABLE TO USE THE EXIT.
//        Imported loc: 80: YOU ARE IN A MAZE OF TWISTY LITTLE PASSAGES, ALL ALIKE.
//        Imported loc: 81: DEAD END
//        Imported loc: 82: DEAD END
//        Imported loc: 83: YOU ARE IN A MAZE OF TWISTY LITTLE PASSAGES, ALL ALIKE.
//        Imported loc: 84: YOU ARE IN A MAZE OF TWISTY LITTLE PASSAGES, ALL ALIKE.
//        Imported loc: 85: DEAD END
//        Imported loc: 86: DEAD END
//        Imported loc: 87: YOU ARE IN A MAZE OF TWISTY LITTLE PASSAGES, ALL ALIKE.
//        Imported loc: 88: YOU ARE IN A LONG, NARROW CORRIDOR STRETCHING OUT OF SIGHT TO THE WEST. AT THE EASTERN END IS A HOLE THROUGH WHICH YOU CAN SEE A PROFUSION OF LEAVES.
//        Imported loc: 89: THERE IS NOTHING HERE TO CLIMB. USE "UP" OR "OUT" TO LEAVE THE PIT.
//        Imported loc: 90: YOU HAVE CLIMBED UP THE PLANT AND OUT OF THE PIT.
//        Imported loc: 91: YOU ARE AT THE TOP OF A STEEP INCLINE ABOVE A LARGE ROOM. YOU COULD CLIMB DOWN HERE, BUT YOU WOULD NOT BE ABLE TO CLIMB UP. THERE IS A PASSAGE LEADING BACK TO THE NORTH.
//        Imported loc: 92: YOU ARE IN THE GIANT ROOM. THE CEILING HERE IS TOO HIGH UP FOR YOUR LAMP TO SHOW IT. CAVERNOUS PASSAGES LEAD EAST, NORTH, AND SOUTH. ON THE WEST WALL IS SCRAWLED THE INSCRIPTION, "FEE FIE FOE FOO" [SIC].
//        Imported loc: 93: THE PASSAGE HERE IS BLOCKED BY A RECENT CAVE-IN.
//        Imported loc: 94: YOU ARE AT ONE END OF AN IMMENSE NORTH/SOUTH PASSAGE.
//        Imported loc: 95: YOU ARE IN A MAGNIFICENT CAVERN WITH A RUSHING STREAM, WHICH CASCADES OVER A SPARKLING WATERFALL INTO A ROARING WHIRLPOOL WHICH DISAPPEARS THROUGH A HOLE IN THE FLOOR. PASSAGES EXIT TO THE SOUTH AND WEST.
//        Imported loc: 96: YOU ARE IN THE SOFT ROOM. THE WALLS ARE COVERED WITH HEAVY CURTAINS, THE FLOOR WITH A THICK PILE CARPET. MOSS COVERS THE CEILING.
//        Imported loc: 97: THIS IS THE ORIENTAL ROOM. ANCIENT ORIENTAL CAVE DRAWINGS COVER THE WALLS. A GENTLY SLOPING PASSAGE LEADS UPWARD TO THE NORTH, ANOTHER PASSAGE LEADS SE, AND A HANDS AND KNEES CRAWL LEADS WEST.
//        Imported loc: 98: YOU ARE FOLLOWING A WIDE PATH AROUND THE OUTER EDGE OF A LARGE CAVERN. FAR BELOW, THROUGH A HEAVY WHITE MIST, STRANGE SPLASHING NOISES CAN BE HEARD. THE MIST RISES UP THROUGH A FISSURE IN THE CEILING. THE PATH EXITS TO THE SOUTH AND WEST.
//        Imported loc: 99: YOU ARE IN AN ALCOVE. A SMALL NW PATH SEEMS TO WIDEN AFTER A SHORT DISTANCE. AN EXTREMELY TIGHT TUNNEL LEADS EAST. IT LOOKS LIKE A VERY TIGHT SQUEEZE. AN EERIE LIGHT CAN BE SEEN AT THE OTHER END.
//        Imported loc: 100: YOU ARE IN A SMALL CHAMBER LIT BY AN EERIE GREEN LIGHT. AN EXTREMELY NARROW TUNNEL EXITS TO THE WEST. A DARK CORRIDOR LEADS NE.
//        Imported loc: 101: YOU ARE IN THE DARK-ROOM. A CORRIDOR LEADING SOUTH IS THE ONLY EXIT.
//        Imported loc: 102: YOU ARE IN AN ARCHED HALL. A CORAL PASSAGE ONCE CONTINUED UP AND EAST FROM HERE, BUT IS NOW BLOCKED BY DEBRIS. THE AIR SMELLS OF SEA WATER.
//        Imported loc: 103: YOU ARE IN A LARGE ROOM CARVED OUT OF SEDIMENTARY ROCK. THE FLOOR AND WALLS ARE LITTERED WITH BITS OF SHELLS IMBEDDED IN THE STONE. A SHALLOW PASSAGE PROCEEDS DOWNWARD, AND A SOMEWHAT STEEPER ONE LEADSUP. A LOW HANDS AND KNEES PASSAGE ENTERS FROM THE SOUTH.
//        Imported loc: 104: YOU ARE IN A LONG SLOPING CORRIDOR WITH RAGGED SHARP WALLS.
//        Imported loc: 105: YOU ARE IN A CUL-DE-SAC ABOUT EIGHT FEET ACROSS.
//        Imported loc: 106: YOU ARE IN AN ANTEROOM LEADING TO A LARGE PASSAGE TO THE EAST. SMALL PASSAGES GO WEST AND UP. THE REMNANTS OF RECENT DIGGING ARE EVIDENT. A SIGN IN MIDAIR HERE SAYS "CAVE UNDER CONSTRUCTION BEYOND THIS POINT. PROCEED AT OWN RISK. [WITT CONSTRUCTION COMPANY]"
//        Imported loc: 107: YOU ARE IN A MAZE OF TWISTY LITTLE PASSAGES, ALL DIFFERENT.
//        Imported loc: 108: YOU ARE AT WITT'S END. PASSAGES LEAD OFF IN *ALL* DIRECTIONS.
//        Imported loc: 109: YOU ARE IN A NORTH/SOUTH CANYON ABOUT 25 FEET ACROSS. THE FLOOR IS COVERED BY WHITE MIST SEEPING IN FROM THE NORTH. THE WALLS EXTEND UPWARD FOR WELL OVER 100 FEET. SUSPENDED FROM SOME UNSEEN POINT FAR ABOVE YOU, AN ENORMOUS TWO-SIDED MIRROR IS HANGING PARALLEL TO AND MIDWAY BETWEEN THE CANYON WALLS. (THE MIRROR IS OBVIOUSLY PROVIDED FOR THE USE OF THE DWARVES, WHO AS YOU KNOW, ARE EXTREMELY VAIN.) A SMALL WINDOW CAN BE SEEN IN EITHER WALL, SOME FIFTY FEET UP.
//        Imported loc: 110: YOU ARE AT A LOW WINDOW OVERLOOKING A HUGE PIT, WHICH EXTENDS UP OUT OF SIGHT. A FLOOR IS INDISTINCTLY VISIBLE OVER 50 FEET BELOW. TRACES OF WHITE MIST COVER THE FLOOR OF THE PIT, BECOMING THICKER TO THE LEFT. MARKS IN THE DUST AROUND THE WINDOW WOULD SEEM TO INDICATE THAT SOMEONE HAS BEEN HERE RECENTLY. DIRECTLY ACROSS THE PIT FROM YOU AND 25 FEET AWAY THERE IS A SIMILAR WINDOW LOOKING INTO A LIGHTED ROOM. A SHADOWY FIGURE CAN BE SEEN THERE PEERING BACK AT YOU.
//        Imported loc: 111: A LARGE STALACTITE EXTENDS FROM THE ROOF AND ALMOST REACHES THE FLOOR BELOW. YOU COULD CLIMB DOWN IT, AND JUMP FROM IT TO THE FLOOR, BUT HAVING DONE SO YOU WOULD BE UNABLE TO REACH IT TO CLIMB BACK UP.
//        Imported loc: 112: YOU ARE IN A LITTLE MAZE OF TWISTING PASSAGES, ALL DIFFERENT.
//        Imported loc: 113: YOU ARE AT THE EDGE OF A LARGE UNDERGROUND RESERVOIR. AN OPAQUE CLOUD OF WHITE MIST FILLS THE ROOM AND RISES RAPIDLY UPWARD. THE LAKE IS FED BY A STREAM, WHICH TUMBLES OUT OF A HOLE IN THE WALL ABOUT 10 FEET OVERHEAD AND SPLASHES NOISILY INTO THE WATER SOMEWHERE WITHIN THE MIST. THE ONLY PASSAGE GOES BACK TOWARD THE SOUTH.
//        Imported loc: 114: DEAD END
//        Imported loc: 115: YOU ARE AT THE NORTHEAST END OF AN IMMENSE ROOM, EVEN LARGER THAN THE GIANT ROOM. IT APPEARS TO BE A REPOSITORY FOR THE "ADVENTURE" PROGRAM. MASSIVE TORCHES FAR OVERHEAD BATHE THE ROOM WITH SMOKY YELLOW LIGHT. SCATTERED ABOUT YOU CAN BE SEEN A PILE OF BOTTLES (ALL OF THEM EMPTY), A NURSERY OF YOUNG BEANSTALKS MURMURING QUIETLY, A BED OF OYSTERS, A BUNDLE OF BLACK RODS WITH RUSTY STARS ON THEIR ENDS, AND A COLLECTION OF BRASS LANTERNS. OFF TO ONE SIDE A GREAT MANY DWARVES ARE SLEEPING ON THE FLOOR, SNORING LOUDLY. A SIGN NEARBY READS: "DO NOT DISTURB THE DWARVES!" AN IMMENSE MIRROR IS HANGING AGAINST ONE WALL, AND STRETCHES TO THE OTHER END OF THE ROOM, WHERE VARIOUS OTHER SUNDRY OBJECTS CAN BE GLIMPSED DIMLY IN THE DISTANCE.
//        Imported loc: 116: YOU ARE AT THE SOUTHWEST END OF THE REPOSITORY. TO ONE SIDE IS A PIT FULL OF FIERCE GREEN SNAKES. ON THE OTHER SIDE IS A ROW OF SMALL WICKER CAGES, EACH OF WHICH CONTAINS A LITTLE SULKING BIRD. IN ONE CORNER IS A BUNDLE OF BLACK RODS WITH RUSTY MARKS ON THEIR ENDS. A LARGE NUMBER OF VELVET PILLOWS ARE SCATTERED ABOUT ON THE FLOOR. A VAST MIRROR STRETCHES OFF TO THE NORTHEAST. AT YOUR FEET IS A LARGE STEEL GRATE, NEXT TO WHICH IS A SIGN WHICH READS, "TREASURE VAULT. KEYS IN MAIN OFFICE."
//        Imported loc: 117: YOU ARE ON ONE SIDE OF A LARGE, DEEP CHASM. A HEAVY WHITE MIST RISING UP FROM BELOW OBSCURES ALL VIEW OF THE FAR SIDE. A SW PATH LEADS AWAY FROM THE CHASM INTO A WINDING CORRIDOR.
//        Imported loc: 118: YOU ARE IN A LONG WINDING CORRIDOR SLOPING OUT OF SIGHT IN BOTH DIRECTIONS.
//        Imported loc: 119: YOU ARE IN A SECRET CANYON WHICH EXITS TO THE NORTH AND EAST.
//        Imported loc: 120: YOU ARE IN A SECRET CANYON WHICH EXITS TO THE NORTH AND EAST.
//        Imported loc: 121: YOU ARE IN A SECRET CANYON WHICH EXITS TO THE NORTH AND EAST.
//        Imported loc: 122: YOU ARE ON THE FAR SIDE OF THE CHASM. A NE PATH LEADS AWAY FROM THE CHASM ON THIS SIDE.
//        Imported loc: 123: YOU ARE IN A LONG EAST/WEST CORRIDOR. A FAINT RUMBLING NOISE CAN BE HEARD IN THE DISTANCE.
//        Imported loc: 124: THE PATH FORKS HERE. THE LEFT FORK LEADS NORTHEAST. A DULL RUMBLING SEEMS TO GET LOUDER IN THAT DIRECTION. THE RIGHT FORK LEADS SOUTHEAST DOWN A GENTLE SLOPE. THE MAIN CORRIDOR ENTERS FROM THE WEST.
//        Imported loc: 125: THE WALLS ARE QUITE WARM HERE. FROM THE NORTH CAN BE HEARD A STEADY ROAR, SO LOUD THAT THE ENTIRE CAVE SEEMS TO BE TREMBLING. ANOTHER PASSAGE LEADS SOUTH, AND A LOW CRAWL GOES EAST.
//        Imported loc: 126: YOU ARE ON THE EDGE OF A BREATH-TAKING VIEW. FAR BELOW YOU IS AN ACTIVE VOLCANO, FROM WHICH GREAT GOUTS OF MOLTEN LAVA COME SURGING OUT, CASCADING BACK DOWN INTO THE DEPTHS. THE GLOWING ROCK FILLS THE FARTHEST REACHES OF THE CAVERN WITH A BLOOD-RED GLARE, GIVING EVERY- THING AN EERIE, MACABRE APPEARANCE. THE AIR IS FILLED WITH FLICKERING SPARKS OF ASH AND A HEAVY SMELL OF BRIMSTONE. THE WALLS ARE HOT TO THE TOUCH, AND THE THUNDERING OF THE VOLCANO DROWNS OUT ALL OTHER SOUNDS. EMBEDDED IN THE JAGGED ROOF FAR OVERHEAD ARE MYRIAD TWISTED FORMATIONS COMPOSED OF PURE WHITE ALABASTER, WHICH SCATTER THE MURKY LIGHT INTO SINISTER APPARITIONS UPON THE WALLS. TO ONE SIDE IS A DEEP GORGE, FILLED WITH A BIZARRE CHAOS OF TORTURED ROCK WHICH SEEMS TO HAVE BEEN CRAFTED BY THE DEVIL HIMSELF. AN IMMENSE RIVER OF FIRE CRASHES OUT FROM THE DEPTHS OF THE VOLCANO, BURNS ITS WAY THROUGH THE GORGE, AND PLUMMETS INTO A BOTTOMLESS PIT FAR OFF TO YOUR LEFT. TO THE RIGHT, AN IMMENSE GEYSER OF BLISTERING STEAM ERUPTS CONTINUOUSLY FROM A BARREN ISLAND IN THE CENTER OF A SULFUROUS LAKE, WHICH BUBBLES OMINOUSLY. THE FAR RIGHT WALL IS AFLAME WITH AN INCANDESCENCE OF ITS OWN, WHICH LENDS AN ADDITIONAL INFERNAL SPLENDOR TO THE ALREADY HELLISH SCENE. A DARK, FOREBODING PASSAGE EXITS TO THE SOUTH.
//        Imported loc: 127: YOU ARE IN A SMALL CHAMBER FILLED WITH LARGE BOULDERS. THE WALLS ARE VERY WARM, CAUSING THE AIR IN THE ROOM TO BE ALMOST STIFLING FROM THE HEAT. THE ONLY EXIT IS A CRAWL HEADING WEST, THROUGH WHICH IS COMING A LOW RUMBLING.
//        Imported loc: 128: YOU ARE WALKING ALONG A GENTLY SLOPING NORTH/SOUTH PASSAGE LINED WITH ODDLY SHAPED LIMESTONE FORMATIONS.
//        Imported loc: 129: YOU ARE STANDING AT THE ENTRANCE TO A LARGE, BARREN ROOM. A SIGN POSTED ABOVE THE ENTRANCE READS: "CAUTION! BEAR IN ROOM!"
//        Imported loc: 130: YOU ARE INSIDE A BARREN ROOM. THE CENTER OF THE ROOM IS COMPLETELY EMPTY EXCEPT FOR SOME DUST. MARKS IN THE DUST LEAD AWAY TOWARD THE FAR END OF THE ROOM. THE ONLY EXIT IS THE WAY YOU CAME IN.
//        Imported loc: 131: YOU ARE IN A MAZE OF TWISTING LITTLE PASSAGES, ALL DIFFERENT.
//        Imported loc: 132: YOU ARE IN A LITTLE MAZE OF TWISTY PASSAGES, ALL DIFFERENT.
//        Imported loc: 133: YOU ARE IN A TWISTING MAZE OF LITTLE PASSAGES, ALL DIFFERENT.
//        Imported loc: 134: YOU ARE IN A TWISTING LITTLE MAZE OF PASSAGES, ALL DIFFERENT.
//        Imported loc: 135: YOU ARE IN A TWISTY LITTLE MAZE OF PASSAGES, ALL DIFFERENT.
//        Imported loc: 136: YOU ARE IN A TWISTY MAZE OF LITTLE PASSAGES, ALL DIFFERENT.
//        Imported loc: 137: YOU ARE IN A LITTLE TWISTY MAZE OF PASSAGES, ALL DIFFERENT.
//        Imported loc: 138: YOU ARE IN A MAZE OF LITTLE TWISTING PASSAGES, ALL DIFFERENT.
//        Imported loc: 139: YOU ARE IN A MAZE OF LITTLE TWISTY PASSAGES, ALL DIFFERENT.
////        Imported loc: 140: DEAD ENDed loc: 5: You are in the forest
//Imported loc: 140: DEAD END
//        1: W: 2
//        1: U: 2
//        1: E: 3
//        1: S: 4
//        1: D: 4
//        1: N: 5
//        2: E: 1
//        2: S: 5
//        3: W: 1
//        4: N: 1
//        4: E: 5
//        4: W: 5
//        4: U: 5
//        4: S: 7
//        4: D: 7
//        5: E: 4
//        5: D: 4
//        5: W: 5
//        5: S: 5
//        5: N: 6
//        6: N: 1
//        6: E: 4
//        6: W: 4
//        6: D: 4
//        6: S: 5
//        7: N: 4
//        7: E: 5
//        7: W: 5
//        7: S: 8
//        8: E: 5
//        8: W: 5
//        8: S: 5
//        8: N: 7
//        9: W: 10
//        10: E: 9
//        10: W: 11
//        11: E: 10
//        11: U: 12
//        11: W: 12
//        12: D: 11
//        12: E: 11
//        12: U: 13
//        12: W: 13
//        13: E: 12
//        13: W: 14
//        14: E: 13
//        14: D: 15
//        14: W: 16
//        15: S: 18
//        15: W: 17
//        15: D: 19
//        15: N: 19
//        15: U: 14
//        16: E: 14
//        17: E: 15
//        18: N: 15
//        19: U: 15
//        19: E: 15
//        19: N: 32
//        23: E: 67
//        23: W: 68
//        23: D: 25
//        24: U: 67
//        25: U: 23
//        27: N: 40
//        27: W: 41
//        28: S: 19
//        28: N: 33
//        28: D: 36
//        29: N: 19
//        30: E: 19
//        30: W: 62
//        30: U: 62
//        33: S: 28
//        33: E: 34
//        33: W: 35
//        34: D: 33
//        34: U: 15
//        35: E: 33
//        36: E: 37
//        36: U: 28
//        36: W: 39
//        37: W: 36
//        37: D: 38
//        38: U: 37
//        39: E: 36
//        39: D: 64
//        41: S: 42
//        41: U: 42
//        41: E: 27
//        41: N: 59
//        41: W: 60
//        42: U: 41
//        42: N: 42
//        42: E: 43
//        42: S: 45
//        42: W: 80
//        43: W: 42
//        43: S: 44
//        43: E: 45
//        44: E: 43
//        44: D: 48
//        44: S: 50
//        44: N: 82
//        45: W: 42
//        45: N: 43
//        45: E: 46
//        45: S: 47
//        45: U: 87
//        45: D: 87
//        46: W: 45
//        47: E: 45
//        48: U: 44
//        49: E: 50
//        49: W: 51
//        50: E: 44
//        50: W: 49
//        50: D: 51
//        50: S: 52
//        51: W: 49
//        51: U: 50
//        51: E: 52
//        51: S: 53
//        52: W: 50
//        52: E: 51
//        52: S: 52
//        52: U: 53
//        52: N: 55
//        52: D: 86
//        53: W: 51
//        53: N: 52
//        53: S: 54
//        54: W: 53
//        55: W: 52
//        55: N: 55
//        55: D: 56
//        55: E: 57
//        56: U: 55
//        57: D: 13
//        57: W: 55
//        57: S: 58
//        57: N: 83
//        57: E: 84
//        58: E: 57
//        60: E: 41
//        60: U: 41
//        60: W: 61
//        60: N: 62
//        60: D: 62
//        61: E: 60
//        61: N: 62
//        62: W: 60
//        62: N: 63
//        62: E: 30
//        62: S: 61
//        63: S: 62
//        64: U: 39
//        64: W: 65
//        64: N: 103
//        64: E: 106
//        65: E: 64
//        65: W: 66
//        65: U: 39
//        65: N: 71
//        65: D: 106
//        66: NE: 65
//        66: W: 67
//        66: E: 96
//        67: E: 66
//        67: W: 23
//        67: D: 24
//        68: S: 23
//        68: U: 69
//        68: N: 65
//        69: D: 68
//        69: S: 119
//        69: N: 109
//        70: N: 71
//        70: D: 65
//        70: S: 111
//        71: SE: 65
//        71: S: 70
//        71: N: 110
//        72: SW: 118
//        72: N: 73
//        72: SE: 97
//        73: S: 72
//        74: E: 19
//        74: W: 121
//        74: D: 75
//        75: S: 76
//        75: N: 77
//        76: N: 75
//        77: E: 75
//        77: W: 78
//        77: N: 66
//        78: S: 77
//        80: N: 42
//        80: W: 80
//        80: S: 80
//        80: E: 81
//        81: W: 80
//        82: S: 44
//        83: S: 57
//        83: E: 84
//        83: W: 85
//        84: N: 57
//        84: W: 83
//        84: NW: 114
//        85: E: 83
//        86: U: 52
//        87: U: 45
//        87: D: 45
//        88: D: 25
//        88: E: 25
//        88: W: 92
//        91: N: 95
//        91: D: 72
//        92: S: 88
//        92: E: 93
//        92: N: 94
//        93: S: 92
//        94: S: 92
//        95: S: 94
//        95: W: 91
//        96: W: 66
//        97: SE: 66
//        97: W: 72
//        97: U: 98
//        97: N: 98
//        98: S: 97
//        98: W: 99
//        99: NW: 98
//        99: E: 100
//        100: W: 99
//        100: NE: 101
//        101: S: 100
//        102: D: 103
//        103: U: 102
//        103: D: 104
//        103: S: 64
//        104: U: 103
//        104: D: 105
//        105: U: 104
//        106: U: 64
//        106: W: 65
//        106: E: 108
//        107: S: 131
//        107: SW: 132
//        107: NE: 133
//        107: SE: 134
//        107: U: 135
//        107: NW: 136
//        107: E: 137
//        107: W: 138
//        107: N: 139
//        107: D: 61
//        108: E: 106
//        109: S: 69
//        109: N: 113
//        110: W: 71
//        111: N: 70
//        111: D: 45
//        112: SW: 131
//        112: N: 132
//        112: E: 133
//        112: NW: 134
//        112: SE: 135
//        112: NE: 136
//        112: W: 137
//        112: D: 138
//        112: U: 139
//        112: S: 140
//        113: S: 109
//        114: SE: 84
//        115: SW: 116
//        116: NE: 115
//        117: SW: 118
//        118: D: 72
//        118: U: 117
//        119: N: 69
//        120: N: 69
//        120: E: 74
//        121: E: 74
//        122: NE: 123
//        123: W: 122
//        123: E: 124
//        124: W: 123
//        124: NE: 125
//        124: SE: 128
//        124: D: 128
//        125: S: 124
//        125: N: 126
//        125: E: 127
//        126: S: 125
//        127: W: 125
//        128: N: 124
//        128: U: 124
//        128: S: 129
//        128: D: 129
//        129: W: 128
//        129: U: 128
//        129: E: 130
//        130: W: 129
//        131: W: 107
//        131: SE: 132
//        131: NW: 133
//        131: SW: 134
//        131: NE: 135
//        131: U: 136
//        131: D: 137
//        131: N: 138
//        131: S: 139
//        131: E: 112
//        132: NW: 107
//        132: U: 131
//        132: N: 133
//        132: S: 134
//        132: W: 135
//        132: SW: 136
//        132: NE: 137
//        132: E: 138
//        132: D: 139
//        132: SE: 112
//        133: U: 107
//        133: D: 131
//        133: W: 132
//        133: NE: 134
//        133: SW: 135
//        133: E: 136
//        133: N: 137
//        133: NW: 138
//        133: SE: 139
//        133: S: 112
//        134: NE: 107
//        134: N: 131
//        134: NW: 132
//        134: SE: 133
//        134: E: 135
//        134: D: 136
//        134: S: 137
//        134: U: 138
//        134: W: 139
//        134: SW: 112
//        135: N: 107
//        135: SE: 131
//        135: D: 132
//        135: S: 133
//        135: E: 134
//        135: W: 136
//        135: SW: 137
//        135: NE: 138
//        135: NW: 139
//        135: U: 112
//        136: E: 107
//        136: W: 131
//        136: U: 132
//        136: SW: 133
//        136: D: 134
//        136: S: 135
//        136: NW: 137
//        136: SE: 138
//        136: NE: 139
//        136: N: 112
//        137: SE: 107
//        137: NE: 131
//        137: S: 132
//        137: D: 133
//        137: U: 134
//        137: NW: 135
//        137: N: 136
//        137: SW: 138
//        137: E: 139
//        137: W: 112
//        138: D: 107
//        138: E: 131
//        138: NE: 132
//        138: U: 133
//        138: W: 134
//        138: N: 135
//        138: S: 136
//        138: SE: 137
//        138: SW: 139
//        138: NW: 112
//        139: SW: 107
//        139: NW: 131
//        139: E: 132
//        139: W: 133
//        139: N: 134
//        139: D: 135
//        139: SE: 136
//        139: U: 137
//        139: S: 138
//        139: NE: 112
//        140: N: 112
