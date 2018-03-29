package Chess;
import java.util.ArrayList;
import java.util.List;

//Bishop can move only diagonally over unoccupied squares - any number of cells
public class Bishop extends Piece{
	//constructor
	public Bishop(int mine) {
		super(mine);
	}
	
	//finds possible moves for the Rook and stores in ArrayList moves and returns the same
	public ArrayList<Square> myMoves(Square p,Board b){
		ArrayList<Square> moves = new ArrayList<Square>() ;
		int x,y;
		Piece piece;
		
		x = p.x;
		y = p.y;
		//Bishop can move in all four directions, so all the feasible moves are added to the list one direction at at time
		while(true) {
			x=x-1;
			y=y+1;
			if( y>= 8 || x < 0)
				break;
			piece = b.getBoard()[x][y];
			if(piece == null)
				moves.add(new Square(x, y));
			else{
				if(player != piece.player)
					moves.add(new Square(x, y));
				break;
			}
		}
		x = p.x;
		y = p.y;
		while(true) {
			x=x+1;
			y=y+1;
			if(x >= 8 || y >= 8)
				break;
			piece = b.getBoard()[x][y];
			if(piece == null)
				moves.add(new Square(x, y));
			else{
				if(player != piece.player)
					moves.add(new Square(x, y));
					break;
			}
		}
		x = p.x;
		y = p.y;
		while(true) {
			x=x-1;
			y=y-1;
			if(x < 0 || y < 0)
				break;
			piece = b.getBoard()[x][y];
			if(piece == null)
				moves.add(new Square(x, y));
			else{
				if(player != piece.player)
					moves.add(new Square(x, y));
				break;
			}
		}
		x = p.x;
		y = p.y;
		while(true) {
			x=x+1;
			y=y-1;
			if(x >= 8 || y < 0)
				break;
			piece = b.getBoard()[x][y];
			if(piece == null)
				moves.add(new Square(x, y));
			else{
				if(player != piece.player)
					moves.add(new Square(x, y));
				break;
			}
		}
		return moves;
	}

	//Bishop is assigned a value of 330
	public int getBaseValue() {
		return 330;
	}
	
	//invoked by board evaluation method of AIEngine and uses the pre-defined PieceSquareMatrix values
	public int getPlaceValue(int x, int y) {
		if(player == 1){
			return PieceSquareMatrix.bishop[7-x][7-y]; 
		}
		return PieceSquareMatrix.bishop[x][y];
	}

}
