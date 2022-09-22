import java.util.ArrayList;

abstract class Playerg {
    private String name;

    public Playerg(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
 class BaseballPlayer extends Playerg {
     public BaseballPlayer(String name) {
         super(name);
     }
 }

 class SoccerPlayer extends Playerg {

     public SoccerPlayer(String name) {
         super(name);
     }
 }

class FootballPlayer extends Playerg {

     public FootballPlayer(String name) {
         super(name);
     }
 }

 class Team {
     private String name;
     int played = 0;
     int won = 0;
     int lost = 0;
     int tied = 0;

     private ArrayList<Playerg> members = new ArrayList<>();

     public Team(String name) {
         this.name = name;
     }

     public String getName() {
         return name;
     }

     public boolean addPlayer(Playerg player) {
         if (members.contains(player)) {
             System.out.println(player.getName() + " is already on this team");
             return false;
         } else {
             members.add(player);
             System.out.println(player.getName() + " picked for team " + this.name);
             return true;
         }
     }

     public int numPlayers() {
         return this.members.size();
     }

     public void matchResult(Team opponent, int ourScore, int theirScore) {
         if(ourScore > theirScore) {
             won++;
         } else if(ourScore == theirScore) {
             tied++;
         } else {
             lost++;
         }
         played++;
         if(opponent != null) {
             opponent.matchResult(null, theirScore, ourScore);
         }
     }

     public int ranking() {
         return (won * 2) + tied;
     }

 }



 public class Challange10GenricPlayer {
     public static void main(String[] args) {
         FootballPlayer joe = new FootballPlayer("Joe");
         BaseballPlayer pat = new BaseballPlayer("Pat");
         SoccerPlayer beckham = new SoccerPlayer("Beckham");

         Team adelaideCrows = new Team("Adelaide Crows");
         adelaideCrows.addPlayer(joe);
         adelaideCrows.addPlayer(pat);
         adelaideCrows.addPlayer(beckham);

         System.out.println(adelaideCrows.numPlayers());
     }
}
//  o/p
//     Joe picked for team Adelaide Crows
//        Pat picked for team Adelaide Crows
//        Beckham picked for team Adelaide Crows
//        3