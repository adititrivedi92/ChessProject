package Chess;
import java.util.ArrayList;

//Pawn can move only forward one step 
//except for the first move it may move two steps forward
public class Pawn extends Piece{
	
	//constructor
	public Pawn(int mine) {
		super(mine);
	}

	//method to find all possible moves of the pawn
	public ArrayList<Square> myMoves(Square p,Board b){
		ArrayList<Square> moves = new ArrayList<Square>();
		Piece pc1, pc2;

		//check if human player is playing
		if (player == 1) {
			if(p.x != 0 && p.y != 7){
				pc1 = b.getBoard()[p.x -1][ p.y +1];
				if(pc1 != null && pc1.player != 1){
					moves.add(new Square(p.x -1, p.y+1));
				}
			}

			if(p.x != 7 && p.y != 7){
				pc1 = b.getBoard()[p.x +1][ p.y +1];
				if(pc1 != null &&  pc1.player != 1){
					moves.add(new Square(p.x +1, p.y+1));
				}
			}

			if (p.y != 7) {
				pc1 = b.getBoard()[p.x][ p.y + 1];
				if (pc1 == null)
					moves.add(new Square(p.x, p.y+1));
			}

			if (p.y == 1) {
				pc1 = b.getBoard()[p.x][ p.y + 1];
				pc2 = b.getBoard() [p.x][ p.y + 2];
				if (pc1 == null & pc2 == null)
					moves.add(new Square(p.x , p.y+2));
				}
		}
			
		// for Computer AI turn
		else {
			if(p.x != 0 && p.y != 0){		
				pc1 = b.getBoard()[p.x -1][ p.y -1];
				if(pc1 != null && pc1.player == 1){
					moves.add(new Square(p.x -1, p.y-1));
				}
			}

			if(p.x != 7 && p.y != 0){
				pc1 = b.getBoard()[p.x +1][ p.y -1];
				if(pc1 != null && pc1.player == 1){
					moves.add(new Square(p.x +1, p.y-1));
				}
			}

			if (p.y != 0) {
				pc1 = b.getBoard() [p.x][ p.y - 1];
				if (pc1 == null)
					moves.add(new Square(p.x , p.y-1));
				}

			if (p.y == 6) {
				pc1 = b.getBoard() [p.x][ p.y - 1];
				pc2 = b.getBoard() [p.x][ p.y - 2];
				if (pc1 == null & pc2 == null)
					moves.add(new Square(p.x, p.y-2));
				}
		}
		return moves;
	}
		
	//pawn is assigned base value of 100
	public int getBaseValue() {
		return 100;
	}

	//invoked by board evaluation method of AIEngine and uses the pre-defined PieceSquareMatrix values
	public int getPlaceValue(int x, int y) {
		if(player == 1){
			return PieceSquareMatrix.pawn[7-x][7-y]; 
		}
		return PieceSquareMatrix.pawn[x][y];
	}
}