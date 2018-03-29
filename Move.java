package Chess;

//class to construct a move object from source and destination coordinates
//the object consists of coordinates and objects(Pieces) at source and destination
public class Move {
	private int score;
	private Square src;
	private Square dest;
	private Piece srcPiece;
	private Piece destPiece;
	
	//constructor
	//is invoked by the game driver to create an object from pair of position coordinates - source and destination
	public Move(Square s, Square d){
		src = s;
		dest= d;
		if(ChessGame.board.getPieceAt(src.x, src.y) != null){
			srcPiece = ChessGame.board.getPieceAt(src.x, src.y);
		}
		if(ChessGame.board.getPieceAt(dest.x, dest.y) != null){
			destPiece = ChessGame.board.getPieceAt(dest.x, dest.y);
		}
	}
	
	public Square getSrc() {
		return src;
	}

	public Square getDest() {
		return dest;
	}

	public Piece getSrcPiece() {
		return srcPiece;
	}

	public Piece getDestPiece() {
		return destPiece;
	}

	public int getScore() {
		return score;
	}
	
	//prints user friendly message on the console with help of helper method convertDestRow
	public String toString(){
		String comment = "";
		char c = convertDestRow(src.x);
		char c1 = convertDestRow(dest.x);
		if(destPiece != null){
			comment = " captured your " + destPiece.getClass().getSimpleName(); 
		}
		
		return  srcPiece.getClass().getSimpleName() +" moved from " + c + (src.y+1) +" to "+ c1 +(dest.y+1) + comment+" the current ";
	}

	//helper method for toString	
	private char convertDestRow(int row) {
			switch(row){
				case 0: return 'H';
				case 1: return 'G';
				case 2: return 'F';
				case 3: return 'E';
				case 4: return 'D';
				case 5: return 'C';
				case 6: return 'B';
				case 7: return 'A';
			}
			return 'X';
	}

}
