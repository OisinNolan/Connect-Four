
public abstract class ConnectPlayer {
	
	char piece;
	boolean isHuman;
	int number;
	
	abstract int chooseColumn(int maxColumnIndex);
	
	char getPiece() {
		return this.piece;
	}
	
	int getNumber() {
		return this.number;
	}
}
