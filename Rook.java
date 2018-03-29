package Chess;
import java.util.ArrayList;

//Rook can move over any number of unoccupied squares horizontally or vertically
public class Rook extends Piece{
	//constructor
	public Rook(int mine) {
		super(mine);
	}
	
	//find possible moves for the Rook for the current configuration
	public ArrayList<Square> myMoves(Square p,Board b){
		ArrayList<Square> moves = new ArrayList<Square>();
		Piece piece;
		int i;

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

		return moves;
	}

	public void isInDanger(Square p, Board b) {
		boolean[][] danger;
		int X, Y;
		X = p.x;
		Y = p.y;
		if(this.player == 1){
			danger = b.wThreat;
		}
		else{
			danger = b.bThreat;
		}
			
		for(int x = X+1 ;x<8;x++){
			addSenseDanger(b, danger, Y, x);
		}

		for(int x = X-1; x >=0; x--){
			addSenseDanger(b,danger, Y,x);
		}

		for(int y = Y+1; y < 8; y++){
			addSenseDanger(b,danger, y,X);
		}
		
		for(int y = Y-1; y >=0; y--){
			addSenseDanger(b,danger, y, X);
		}
	}

	private void addSenseDanger(Board b, boolean[][] danger, int y, int x) {
		Piece target =b.getBoard()[x][y];
		if(target == null){
			danger[x][y] = true;
		}else if(b.getBoard()[x][y] != null) {
			System.out.println(b.getBoard()[x][y].getClass().getSimpleName());
			if(target.player != player){
				danger[x][y] = true;
				return;
			}else{
				return;
		} 

	}
}
	//Rook is assigned a base value of 500
	public int getBaseValue() {
		return 500; 
	}
	
	//invoked by board evaluation method of AIEngine and uses the pre-defined PieceSquareMatrix values
	public int getPlaceValue(int x, int y) {
		if(player == 1){
			return PieceSquareMatrix.rook[7-x][7-y]; 
		}
		return PieceSquareMatrix.rook[x][y];
	}
}