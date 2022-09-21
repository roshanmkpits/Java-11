////Create a simple interface that allows an object to be saved to some sort of storage medium.
//mplement the following:
//
//        1.  ISaveable (interface)
//
//        -  It has two methods:
//
//        -  write(), takes no arguments and returns a List containing objects of type String.
//
//        -  read(), takes a List of type String and doesn't return anything.
//
//
//
//        2.  Player (class)
//
//        -  It has four fields. Two Strings called name and weapon. Two ints called hitPoints and strength.
//
//        -  A constructor that accepts a String (name) and two ints (hitPoints and strength). It initialises name, hitPoints and strength with the newly passed in values. It initialises weapon with the default weapon "Sword".
//
//        -  And eleven methods:
//
//        -  Getters and setters for all four fields.
//
//        -  write(), same as interface. Return a List of the fields in the order they appear in toString().
//
//        -  read(), same as interface. Store the values in the List, in the order they appear in toString(). Make sure the List is not null and the size() is greater than 0 before storing the values.
//
//        -  toString(), Players overriding toString() method. It takes no arguments and returns a String in the following format:
//
//        Player{name='Tim', hitPoints=10, strength=15, weapon='Sword'}
//
//
//        3.  Monster (class)
//
//        -  It has three fields. One String called name and Two ints called hitPoints and strength.
//
//        -  A constructor that accepts a String (name) and two ints (hitPoints and strength). It initialises name, hitPoints and strength with the newly passed in values.
//
//        -  And six methods:
//
//        -  Only getters for the three fields.
//
//        -  write(), same as interface. Return a List of the fields in the order they appear in toString().
//
//        -  read(), same as interface. Store the values in the List, in the order they appear in toString(). Make sure the List is not null and the size() is greater than 0 before storing the values.
//
//        -  toString(), Monsters overriding toString() method. It takes no arguments and returns a String in the following format:
//
//        Monster{name='Werewolf', hitPoints=20, strength=40}
//
//
//        TIP:  Player and Monster need to implement ISaveable.
//
//        TIP:  Be extremely careful with the spelling of the names of the fields, constructors and methods.
//
//        TIP:  Be extremely careful about spaces and spelling in the returned String from the toString() method.
//
//
//
//        NOTE:  All fields are private.
//
//        NOTE:  Both constructors are public.
//
//        NOTE:  All methods are public.
//
//        NOTE:  There are no static members.
//
//        NOTE:  Do not add a main method to the solution code.
//
//        NOTE:  If you get an error from the Evaluate class, it's most likely the constructor. Check if you've added a constructor or if the constructor has the right arguments.

import java.util.ArrayList;
import java.util.List;

interface ISaveable{
    public List<String> write();
    public void read(List<String> savedValues);

}

class Player implements ISaveable{
    private String name;
    private int hitPoints;
    private int strength;
    private String weapon;

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.weapon = "Sword";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                ", weapon='" + weapon + '\'' +
                '}';
    }

    @Override
    public List<String> write() {
        List<String> savedValues = new ArrayList<String>();
        savedValues.add(0, this.name);
        savedValues.add(1, "" + this.hitPoints);
        savedValues.add(2, "" + this.strength);
        savedValues.add(3, this.weapon);
        return savedValues;

    }

    @Override
    public void read(List<String> savedValues) {
        if(savedValues != null && savedValues.size() > 0){
            this.name = savedValues.get(0);
            this.hitPoints = Integer.parseInt(savedValues.get(1));
            this.strength = Integer.parseInt(savedValues.get(2));
            this.weapon = savedValues.get(3);
        }

    }
}

class Monster implements ISaveable{
    private String name;
    private int hitPoints;
    private int strength;

    public Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                '}';
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<String>();
        values.add(0, this.name);
        values.add(1, "" + this.hitPoints);
        values.add(2, "" + this.strength);
        return values;

    }

    @Override
    public void read(List<String> readValues) {
        if(readValues != null && readValues.size() > 0){
            this.name = readValues.get(0);
            this.hitPoints = Integer.parseInt(readValues.get(1));
            this.strength = Integer.parseInt(readValues.get(2));
        }

    }
}

public class Challange9Player {
    public static void main(String[] args) {

    }
}
