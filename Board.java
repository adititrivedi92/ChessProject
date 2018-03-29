package Chess;

//class to set up the Chess Board
public class Board {
	private Piece[][] board;
	boolean isWhiteTurn = true;
	boolean isWhiteCheck = false;
	boolean isBlackCheck = false;
	public boolean[][] wThreat; 
	public boolean[][] bThreat; 
	
	//constructor
	public Board(){
		board = new Piece[8][8];
		wThreat = new boolean[8][8];
		bThreat = new boolean[8][8];
		for(int i = 0; i<8; i++){
			for (int j = 0; j<8; j++){
			wThreat[i][j] = false;
			bThreat[i][j] = false;
			}
		}	
	}
	
	//sets up initial chess board with Piece objects
	public void setInitialBoard(){
		Piece[][] board = new Piece[8][8];
		
		for(int i = 0; i < 8; i++){
			board[i][1] = new Pawn(1);
			board[i][6] = new Pawn(2);
		}
		board[0][0] = new Rook(1);
		board[1][0] = new Horse(1);
		board[2][0] = new Bishop(1);
		board[3][0] = new King(1);
		board[4][0] = new Queen(1);
		board[5][0] = new Bishop(1);
		board[6][0] = new Horse(1);
		board[7][0] = new Rook(1);
		board[0][7] = new Rook(2);
		board[1][7] = new Horse(2);
		board[2][7] = new Bishop(2);
		board[3][7] = new King(2);
		board[4][7] = new Queen(2);
		board[5][7] = new Bishop(2);
		board[6][7] = new Horse(2);
		board[7][7] = new Rook(2);
		this.board = board;
	}
	
	public Piece[][] getBoard() {
		return board;
	}
	
	public void setBoard(Piece[][] b) {
		board = b;
	}
	
	//alter board configuration by moving the piece from source to destination
	public void move(Square src, Square dest){
		board[dest.x][dest.y] = board[src.x][src.y];
		board[src.x][src.y] = null;
	}
	
	public Piece getPieceAt(int x, int y){
		if(x < 0 || x > 7 || y < 0 || y > 7){
			return null;
		}
			else
				return board[x][y];
	}
	
	//method to display Chess Board at any configuration
	public void displayBoard(){
		System.out.println("CONFIGURATION OF CHESS BOARD : ");
		for(int i = 8; i > 0; i--){
			System.out.println("___________________________________________________");
			System.out.printf("%d->",(i));System.out.print("| ");
			for(int j = 8 ; j > 0 ; j--){
				if(ChessGame.board.getBoard()[j-1][i-1] != null){
					if(ChessGame.board.getBoard()[j-1][i-1].player == 1)
						System.out.printf("%s|  ", "w_"+ChessGame.board.getBoard()[j-1][i-1].getClass().getSimpleName().charAt(0));
					else
						System.out.printf("%s|  ", "b_"+ChessGame.board.getBoard()[j-1][i-1].getClass().getSimpleName().charAt(0));
				}
				else
					System.out.print("   |  ");
			}
			System.out.println();
		}	
		System.out.println("___________________________________________________");
		System.out.print("    ");
		for( char c= 'A'; c<= 'H'; c++)
			System.out.printf(" %c    ",c);
		System.out.println(); 
	}
}
