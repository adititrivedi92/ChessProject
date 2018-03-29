package Chess;

import java.util.ArrayList;
//Queen can move over unoccupied places in any direction
//forward backward and both diagonals
public class Queen extends Piece{
	
	//constructor
	public Queen(int mine) {
		super(mine);
	}
	//method to find all possible moves of the queen
	public ArrayList<Square> myMoves(Square p,Board b){
		ArrayList<Square> moves = new ArrayList<Square>();
		int i,x,y;
		Piece piece;
		
		i = p.y;
		while(true){
			i++;
			if (i >= 8)
				break;
				piece = b.getBoard()[p.x][i];
			if(piece == null)
				moves.add(new Square(p.x, i));
				else{
					if(piece.player != player)
						moves.add(new Square(p.x, i));
				break;
			}
		}

		i = p.y;
		while(true){
			i--;
			if (i < 0)
				break;
			piece = b.getBoard()[p.x][i];
			if(piece == null)
				moves.add(new Square(p.x, i));
				else{
					if(piece.player != player)
						moves.add(new Square(p.x, i));
				break;
			}
		}
		
		i = p.x;
		while(true){
			i++;
			if (i >= 8)
				break;
			piece = b.getBoard()[i][p.y];
			if(piece == null)
				moves.add(new Square(i, p.y));
				else{
					if(piece.player != player)
						moves.add(new Square(i, p.y));
				break;
			}
		}

		i = p.x;
		while(true){
			i--;
			if (i < 0)
				break;
			piece = b.getBoard()[i][p.y];
			if(piece == null)
				moves.add(new Square(i, p.y));
				else{
					if(piece.player != player)
						moves.add(new Square(i, p.y));
				break;
			}
		}

		
		
		x = p.x;
		y = p.y;
		while(true) {
			x--;
			y++;
			if(x < 0 || y>= 8)
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
			x++;
			y++;
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
			x--;
			y--;
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
			x++;
			y--;
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
	
	//Queen is assigned base value of 900
	public int getBaseValue() {
		return 900; 
	}
	
	//invoked by board evaluation method of AIEngine and uses the pre-defined PieceSquareMatrix values
	public int getPlaceValue(int x, int y) {
		if(player == 1){
			return PieceSquareMatrix.queen[7-x][7-y]; //Should give the opposite positional score
		}
		return PieceSquareMatrix.queen[x][y];
	}
}