package Chess;
import java.util.ArrayList;
import java.util.List;

//class which implements that validates and implements the moves
public class ChessGameEngine {
	public static ChessGameEngine cge;
	public List<Piece> activePieces;

	public ChessGameEngine(){
		cge = this;
		activePieces = new ArrayList<Piece>();
	}
	
	//method to carry on the move validation as specified in the driver program or when invoked by AIEngine logic
	//these are accomplished with help of two helper methods
	public boolean DoMove(Move move, int player) {
		boolean srcValid= false, destValid = false;
		srcValid =validateSrc(move.getSrc().x, move.getSrc().y, player);
		if( srcValid){
			destValid = validateDest(move);
		}	
		if (srcValid && destValid){
			movePromotion(move, player);
			return true;
		}
		else 
			return false;
		
	}
	
	public void rollBack(Move move, int player) {
		validateSrc(move.getDest().x, move.getDest().y, player);
		reversePromotion(move);
	}
	
	//helper method of DoMove to validate source - checks for valid coordinates, empty cell selection, opponents piece selection
	private boolean validateSrc(int x, int y, int player) {
		if(x < 0 || x > 7 || y < 0 || y > 7){
			System.out.println("You have given incorrect values of the source coordinates");
			return false;
		}
		
		if (ChessGame.board.getBoard()[x][y] == null){
			System.out.println("Source coordinates selected by you is an empty cell");
			return false;
		}
		
		if (ChessGame.board.getBoard() [x][y].player != player){
			//ChessGame.board.displayBoard();
			//System.exit(1);
			System.out.println("You selected opponents piece - please select your own piece");
			return false;
		}
		return true;
	}
	
	//helper method of DoMove to validate destination - checks for valid coordinates, own piece at destination and invalid move of piece
	private boolean validateDest(Move move) {
		Square newPos = move.getDest();
		if(newPos.x < 0 || newPos.x > 7 || newPos.y < 0 || newPos.y > 7){
			System.out.println("Your destination coordinates are invalid");
			return false;
		}
		
		if(move.getDestPiece() != null && move.getSrcPiece().player == move.getDestPiece().player){
			System.out.println("You are trying to capture your own piece");
			return false;
		}

		if(!move.getSrcPiece().myMoves(move.getSrc(), ChessGame.board).contains(newPos)){
			System.out.println("Move is invalid for the selected piece");
			return false;
		}
		return true;
	}
	
	//method for pawn promotion - promotes pawn to queen if eligible
	private void movePromotion(Move move, int player){
		int captured = 0;
		if(move.getDestPiece() != null){
			activePieces.remove(move.getDestPiece());
			if(move.getDestPiece() instanceof King){
				System.out.println("King is checkmated ");
				System.exit(1);
			}
			else {
				if(player ==1 )
					captured = 1;
			}
		}
		if(move.getSrcPiece() instanceof Pawn){
			if(move.getDest().y == 7){
				setTrigger (move.getSrc().x, move.getSrc().y, new Queen(1));
				System.out.println("Your Pawn has been promoted to Queen");
			}
			else if(move.getDest().y == 0){
				setTrigger ( move.getSrc().x, move.getSrc().y, new Queen(2));
				System.out.println("Computer AI's has been promoted to Queen");
			}
		}
		ChessGame.board.move(move.getSrc(), move.getDest());
	}
	
	//method to reverse the move 
	private void reversePromotion(Move move){
		if(move.getSrcPiece() instanceof Pawn){
			if(move.getDest().y == 7){
				setTrigger ( move.getDest().x, move.getDest().y, move.getSrcPiece());
			}
			else if(move.getDest().y == 0){
				setTrigger ( move.getDest().x, move.getDest().y, move.getSrcPiece());
			}
		}
		//roll back the move
		ChessGame.board.move(move.getDest(), move.getSrc());
		setTrigger ( move.getDest().x, move.getDest().y, move.getDestPiece());
	}
	
	public void setTrigger(int x, int y, Piece piece){
		ChessGame.board.getBoard() [x][y] = piece;
		activePieces.add(piece);
	}
	
	//check if King is checkmated and the game is over
	public boolean checkMate(){
		int wKing = 0;
		int bKing = 0;
		for(int i = 8; i >= 0; i--){
			for(int j = 8 ; j > 0 ; j--){
			 if(ChessGame.board.getBoard()[j-1][i-1] instanceof King && ChessGame.board.getBoard()[j-1][i-1].player == 1){
				 	wKing = 1;
				}
				if(ChessGame.board.getBoard()[j-1][i-1] instanceof King && ChessGame.board.getBoard()[j-1][i-1].player == 2){
					bKing = 1;
				}
				if(wKing ==1 && bKing ==1 ){
					return false;
				}
			}
		}
		return true;
	}
}