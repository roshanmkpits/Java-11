package ch14_3.iodemo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
//modification in prev example
//above java 7
//adding two resources in try
// example using filewriter
//and try catch finally block
 class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if(exits != null) {
            this.exits = new HashMap<String, Integer>(exits);
        } else {
            this.exits = new HashMap<String, Integer>();
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
        return new HashMap<String, Integer>(exits);
    }
}


 class Challange14Io {

    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) throws IOException {

        try(FileWriter locFile = new FileWriter("locations.txt");
            FileWriter dirFile = new FileWriter("directions.txt")) {
            for(Location location : locations.values()) {
                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for(String direction : location.getExits().keySet()) {
                    dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                }
            }
        }
//
//        try(FileWriter locFile = new FileWriter("locations.txt")) {
//            for(Location location : locations.values()) {
//                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//            }
//        }
//        FileWriter locFile = null;
//        try {
//            locFile = new FileWriter("locations.txt");
//            for(Location location : locations.values()) {
//                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//            }
//        } catch(IOException e) {
//            System.out.println("In catch block");
//            e.printStackTrace();
//        } finally {
//            System.out.println("in finally block");
//            try {
//                if(locFile != null) {
//                    System.out.println("Attempting to close locfile");
//                    locFile.close();
//                }
//            } catch(IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    static {
        Map<String, Integer> tempExit = new HashMap<String, Integer>();
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java",null));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest",tempExit));

    }


}
//output

//in finally block
//        Attempting to close locfile

//data written to file locations.txt
//0,You are sitting in front of a computer learning Java
//        1,You are standing at the end of a road before a small brick building
//        2,You are at the top of a hill
//        3,You are inside a building, a well house for a small spring
//        4,You are in a valley beside a stream
//        5,You are in the forest

//data written in second file directions.txt
//0,Q,0
//        1,Q,0
//        1,S,4
//        1,E,3
//        1,N,5
//        1,W,2
//        2,Q,0
//        2,N,5
//        3,Q,0
//        3,W,1