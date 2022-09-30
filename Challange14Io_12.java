package ch14_12.iobinread;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//modification in prev example
//working with bytes
//reading bytes  form location.dat that we created earlier
//input stream filesinputstream
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
//        try (DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))) {
//            for (Location location : locations.values()) {
//                locFile.writeInt(location.getLocationID());
//                locFile.writeUTF(location.getDescription());
//                System.out.println("Writing location " + location.getLocationID() + " : " + location.getDescription());
//                System.out.println("Writing " + (location.getExits().size() - 1) + " exits.");
//                locFile.writeInt(location.getExits().size() - 1);
//                for (String direction : location.getExits().keySet()) {
//                    if (!direction.equalsIgnoreCase("Q")) {
//                        System.out.println("\t\t" + direction + "," + location.getExits().get(direction));
//                        locFile.writeUTF(direction);
//                        locFile.writeInt(location.getExits().get(direction));
//                    }
//                }
//            }
//        }
    }

    static {

        try(DataInputStream locFile = new DataInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {
            boolean eof = false;
            while(!eof) {
                try {
                    Map<String, Integer> exits = new LinkedHashMap<>();
                    int locID = locFile.readInt();
                    String description = locFile.readUTF();
                    int numExits = locFile.readInt();
                    System.out.println("Read location " + locID + " : " + description);
                    //System.out.println("Found " + numExits + " exits");
                    for(int i=0; i<numExits; i++) {
                        String direction = locFile.readUTF();
                        int destination = locFile.readInt();
                        exits.put(direction, destination);
                        System.out.println("\t\t" + direction + "," + destination);
                    }
                    locations.put(locID, new Location(locID, description, exits));

                } catch(EOFException e) {
                    eof = true;
                }

            }
        } catch(IOException io) {
            System.out.println("IO Exception");
        }
//        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("locations_big.txt")))) {
//            scanner.useDelimiter(",");
//            while(scanner.hasNextLine()) {
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String description = scanner.nextLine();
//                System.out.println("Imported loc: " + loc + ": " + description);
//                Map<String, Integer> tempExit = new HashMap<>();
//                locations.put(loc, new Location(loc, description, tempExit));
//            }
//
//        } catch(IOException e) {
//            e.printStackTrace();
//        }
//
//        // Now read the exits
//        try (BufferedReader dirFile = new BufferedReader(new FileReader("directions_big.txt"))) {
//            String input;
//            while((input = dirFile.readLine()) != null) {
//                String[] data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String direction = data[1];
//                int destination = Integer.parseInt(data[2]);
//
//                System.out.println(loc + ": " + direction + ": " + destination);
//                Location location = locations.get(loc);
//                location.addExit(direction, destination);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    }


//
////output
//Read location 0 : YOU ARE SITTING IN FRONT OF A COMPUTER LEARNING JAVA.
//        Read location 1 : YOU ARE STANDING AT THE END OF A ROAD BEFORE A SMALL BRICK BUILDING. AROUND YOU IS A FOREST. A SMALL STREAM FLOWS OUT OF THE BUILDING AND DOWN A GULLY.
//        W,2
//        U,2
//        E,3
//        S,4
//        D,4
//        N,5
//        Read location 2 : YOU HAVE WALKED UP A HILL, STILL IN THE FOREST. THE ROAD SLOPES BACK DOWN THE OTHER SIDE OF THE HILL. THERE IS A BUILDING IN THE DISTANCE.
//        E,1
//        S,5
//        Read location 3 : YOU ARE INSIDE A BUILDING, A WELL HOUSE FOR A LARGE SPRING.
//        W,1
//        Read location 4 : YOU ARE IN A VALLEY IN THE FOREST BESIDE A STREAM TUMBLING ALONG A ROCKY BED.
//        N,1
//        E,5
//        W,5
//        U,5
//        S,7
//        D,7
//        Read location 5 : YOU ARE IN OPEN FOREST, WITH A DEEP VALLEY TO ONE SIDE.
//        E,4
//        D,4
//        W,5
//        S,5
//        N,6
//        Read location 6 : YOU ARE IN OPEN FOREST NEAR BOTH A VALLEY AND A ROAD.
//        N,1
//        E,4
//        W,4
//        D,4
//        S,5
//        Read location 7 : AT YOUR FEET ALL THE WATER OF THE STREAM SPLASHES INTO A 2-INCH SLIT IN THE ROCK. DOWNSTREAM THE STREAMBED IS BARE ROCK.
//        N,4
//        E,5
//        W,5
//        S,8
//        Read location 8 : YOU ARE IN A 20-FOOT DEPRESSION FLOORED WITH BARE DIRT. SET INTO THE DIRT IS A STRONG STEEL GRATE MOUNTED IN CONCRETE. A DRY STREAMBED LEADS INTO THE DEPRESSION.
//        E,5
//        W,5
//        S,5
//        N,7
//        Read location 9 : YOU ARE IN A SMALL CHAMBER BENEATH A 3X3 STEEL GRATE TO THE SURFACE. A LOW CRAWL OVER COBBLES LEADS INWARD TO THE WEST.
//        W,10
//        Read location 10 : YOU ARE CRAWLING OVER COBBLES IN A LOW PASSAGE. THERE IS A DIM LIGHT AT THE EAST END OF THE PASSAGE.
//        E,9
//        W,11
//        Read location 11 : YOU ARE IN A DEBRIS ROOM FILLED WITH STUFF WASHED IN FROM THE SURFACE. A LOW WIDE PASSAGE WITH COBBLES BECOMES PLUGGED WITH MUD AND DEBRIS HERE, BUT AN AWKWARD CANYON LEADS UPWARD AND WEST. A NOTE ON THE WALL SAYS "MAGIC WORD XYZZY".
//        E,10
//        U,12
//        W,12
//        Read location 12 : YOU ARE IN AN AWKWARD SLOPING EAST/WEST CANYON.
//        D,11
//        E,11
//        U,13
//        W,13
//        Read location 13 : YOU ARE IN A SPLENDID CHAMBER THIRTY FEET HIGH. THE WALLS ARE FROZEN RIVERS OF ORANGE STONE. AN AWKWARD CANYON AND A GOOD PASSAGE EXIT FROM EAST AND WEST SIDES OF THE CHAMBER.
//        E,12
//        W,14
//        Read location 14 : AT YOUR FEET IS A SMALL PIT BREATHING TRACES OF WHITE MIST. AN EAST PASSAGE ENDS HERE EXCEPT FOR A SMALL CRACK LEADING ON.
//        E,13
//        D,15
//        W,16
//        Read location 15 : YOU ARE AT ONE END OF A VAST HALL STRETCHING FORWARD OUT OF SIGHT TO THE WEST. THERE ARE OPENINGS TO EITHER SIDE. NEARBY, A WIDE STONE STAIRCASE LEADS DOWNWARD. THE HALL IS FILLED WITH WISPS OF WHITE MIST SWAYING TO AND FRO ALMOST AS IF ALIVE. A COLD WIND BLOWS UP THE STAIRCASE. THERE IS A PASSAGE AT THE TOP OF A DOME BEHIND YOU.
//        S,18
//        W,17
//        D,19
//        N,19
//        U,14
//        Read location 16 : THE CRACK IS FAR TOO SMALL FOR YOU TO FOLLOW.
//        E,14
//        Read location 17 : YOU ARE ON THE EAST BANK OF A FISSURE SLICING CLEAR ACROSS THE HALL. THE MIST IS QUITE THICK HERE, AND THE FISSURE IS TOO WIDE TO JUMP.
//        E,15
//        Read location 18 : THIS IS A LOW ROOM WITH A CRUDE NOTE ON THE WALL. THE NOTE SAYS, "YOU WON'T GET IT UP THE STEPS".
//        N,15
//        Read location 19 : YOU ARE IN THE HALL OF THE MOUNTAIN KING, WITH PASSAGES OFF IN ALL DIRECTIONS.
//        U,15
//        E,15
//        N,32
//        Read location 20 : YOU ARE AT THE BOTTOM OF THE PIT WITH A BROKEN NECK.
//        Read location 21 : YOU DIDN'T MAKE IT.
//        Read location 22 : THE DOME IS UNCLIMBABLE.
//        Read location 23 : YOU ARE AT THE WEST END OF THE TWOPIT ROOM. THERE IS A LARGE HOLE IN THE WALL ABOVE THE PIT AT THIS END OF THE ROOM.
//        E,67
//        W,68
//        D,25