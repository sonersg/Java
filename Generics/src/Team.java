import java.util.ArrayList;


public class Team<T extends Player> implements Comparable<Team<T>>{

	private String name;
	int played = 0;
	int won = 0;
	int lost = 0;
	int tied = 0;
	private ArrayList<T> members = new ArrayList<>();

	public Team(String name) {
		super();
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean addPlayer(T player){
		if(members.contains(player)){
			System.out.println( player.getName() + " is already on the team");
			return false;
		}else{
			members.add(player);
			System.out.println(((Player) player).getName() + " picked for the team");
			return true;
		}
	}
	
	public int numPlayers(){
		return this.members.size();
	}
	
	public void matchResult(Team<T> opponent, int ourScore, int theirScore){
		
		String message;
		if(ourScore < theirScore){
			message = " lost to";
			lost++;
		}else if(ourScore == theirScore){
			message = " drew with";
			tied++;
		}else{
			message = " beat";
			won++;
		}
			
			
		played++;
		
		if(opponent != null){
			System.out.println(this.getName() + message + opponent.getName());
			opponent.matchResult(null, theirScore, ourScore);
		}
			
	}
	
	public int ranking(){
		return won*2+tied;
	}

	public int compareTo(Team<T> team) {
		if(this.ranking() > team.ranking())
			return -1;
		else if (this.ranking() < team.ranking())
			return 1;
		else
			return 0;
	}
	
}
