package Chess;
import java.util.ArrayList;

//Horse can move two steps in one direction and then one step at 90 degrees
//it can also jump over occupied squares
public class Horse extends Piece{
	
	//constructor
	public Horse(int mine) {
		super(mine);
	}
	
	//finds the possible moves of the horse (knight) in all directions, 2 steps + 1 step, using Helper method
	public ArrayList<Square> myMoves(Square p, Board b){
		ArrayList<Square> moves = new ArrayList<Square>();
		knightMove(p.x +2, p.y -1, moves,b);
		knightMove(p.x -1, p.y +2, moves,b); 		
		knightMove(p.x +1, p.y +2, moves,b); 		
		knightMove(p.x +2, p.y +1, moves,b); 		
		knightMove(p.x +1, p.y -2, moves,b); 
		knightMove(p.x -2, p.y +1, moves,b); 		
		knightMove(p.x -2, p.y -1, moves,b); 
		knightMove(p.x -1, p.y -2, moves,b); 		
		return moves;
	}

	//Helper method of possibleMoves method
	public void knightMove(int x, int y, ArrayList<Square> sqList, Board b){
		Piece c;
		if (x >= 0 && x < 8 && y >= 0 && y < 8) {
			c = b.getBoard()[x][y];
			if (c == null) {
				sqList.add(new Square(x,y));
			}else if(player != c.player)
				sqList.add(new Square(x,y));
		}
	}
	
	//Knight is assigned  base value of 320
	public int getBaseValue() {
		return 320; 
	}
	
	//invoked by board evaluation method of AIEngine and uses the pre-defined PieceSquareMatrix values
	public int getPlaceValue(int x, int y) {
		if(player == 1){
			return PieceSquareMatrix.horse[7-x][7-y]; 
		}
			return PieceSquareMatrix.horse[x][y];
	}

}