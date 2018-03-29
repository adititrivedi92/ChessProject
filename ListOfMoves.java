package Chess;
import java.util.ArrayList;

//class to generate a set of moves 
public class ListOfMoves {
	
	// method to generate all possible moves for the current configuration of the Board and put them in an ArrayList
	//this method is invoked by the AIEngine
	public static  ArrayList<Move> makeAMove(int playerTurn, Board b){
		ArrayList<Move> moves = new ArrayList<Move>();
		Piece[][] board = b.getBoard();

		for(int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++) {
				if(board[j][i] != null){
					Piece piece = board[j][i]; 
					if(piece.player == playerTurn){
						for(Square p: piece.myMoves(new Square(j,i),b)){
							Square to = new Square(p.x, p.y);
							Square from = new Square(j,i);
							Move move = new Move(from, to);
							if(move.getDestPiece() != null  ){
								moves.add(0, move);
							}else{
								moves.add(move);
							}
						}
					}
				}
			}
		}
		return moves;
	}
}

