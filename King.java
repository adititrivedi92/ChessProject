package Chess;
import java.util.ArrayList;

//King can move one step in any direction over unoccupied pieces 
//King can never move in a position where he is 'checked'
public class King extends Piece{
	//constructor
	public King(int mine) {
		super(mine);
	}
	
	//method to determine all the possible moves for the King
	public ArrayList<Square> myMoves(Square p, Board b){

		ArrayList<Square> moves = new ArrayList<Square>() ;
		int i, j;
		Piece c;
		
		i = p.x - 1;
		j = p.y + 1;
		if (p.y != 7) {
			for (int k = 0; k < 3; k++) {
				if (i >= 0 && i < 8) {
					c = b.getBoard() [i][j];
					if (c == null)
						moves.add(new Square(i, j));
					else if (player != c.player)
						moves.add(new Square(i, j));
				}
				i++;
			}
		}

		i = p.x - 1;
		j = p.y - 1;
		if (p.y != 0) {
			for (int k = 0; k < 3; k++) {
				if (i >= 0 && i < 8) {
					c = b.getBoard() [i][j];
					if (c == null)
						moves.add(new Square(i, j));
					else if (player != c.player)
						moves.add(new Square(i, j));
				}
				i++;
			}
		}

		if(p.x != 0){
			c = b.getBoard() [p.x - 1][ p.y];
			if (c == null)
				moves.add(new Square(p.x - 1, p.y));
				else if (player != c.player)
					moves.add(new Square(p.x -1 ,p.y));
			}

		if(p.x != 7){
			c = b.getBoard() [p.x + 1][ p.y];
			if (c == null)
				moves.add(new Square(p.x+1,p.y));
				else if (player != c.player)
					moves.add(new Square(p.x + 1, p.y));
			}
		return moves;
	}
	
	//King is assigned base value of 20000
	public int getBaseValue() {
		return 20000;
	}

	//invoked by board evaluation method of AIEngine and uses the pre-defined PieceSquareMatrix values
	public int getPlaceValue(int x, int y) {
		if(player == 1){
			return PieceSquareMatrix.king[7-x][7-y]; 
		}
		return PieceSquareMatrix.king[x][y];
	}
}