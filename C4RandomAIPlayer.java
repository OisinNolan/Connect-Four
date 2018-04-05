import java.util.Random;

public class C4RandomAIPlayer extends ConnectPlayer{
	
	public C4RandomAIPlayer(char piece) {
		super.piece = piece;
		super.isHuman = false;
	}
	
	public int chooseColumn(int maxColumnIndex) {
		Random r = new Random();
		return r.nextInt(maxColumnIndex);
	}
}
