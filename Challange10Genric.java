package genric3;
import java.util.ArrayList;


//System.out.println(((Playerg)player).getName() + " is already on this team");
//change typecasting
// by changing this class Team <T extends Playerg>{
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

class Team <T extends Playerg>{
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player) {
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
public class Challange10Genric {
    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
        adelaideCrows.addPlayer(joe);
//        adelaideCrows.addPlayer(pat);//error trying to add other than FootballPlayer
//        adelaideCrows.addPlayer(beckham);////error trying to add other than FootballPlayer
        adelaideCrows.addPlayer(joe);

        System.out.println(adelaideCrows.numPlayers());
    }
}
//output
//Joe picked for team Adelaide Crows
//        Joe is already on this team
//        1