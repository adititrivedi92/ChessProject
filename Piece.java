package Chess;
import java.util.ArrayList;

//Abstract class to represent the Pieces of the Chess Board
public abstract class Piece {
	public int player;
	public boolean notFirstMove;
	
	public Piece(int mine){
		player = mine;
	}
	
	public abstract ArrayList<Square> myMoves(Square p, Board b);
	public abstract int getBaseValue();
	public abstract int getPlaceValue(int x, int y);
	
}