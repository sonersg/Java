
public class PlayingCat {

	public static boolean isCatPlaying(boolean summer,int temperature){
		
		if(summer==true && temperature>=25 && temperature<=45)
			return true;
		else if(summer==false && temperature>=25 && temperature<=35)
			return true;
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
