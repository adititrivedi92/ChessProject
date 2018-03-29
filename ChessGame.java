package Chess;
import java.util.ArrayList;
import java.util.Scanner;

//creates AIEngine, ChessGameEngine objects and initializes the chess board
//monitors the turn of players - human or computer - indicated by variable 'turn'
public class ChessGame {
	private static ChessGameEngine chessGameEngine;
	private static AIEngine aiEngine;
	static Board board;
	static int turn = 1; // 1 is player (white), 2 is AI (black)
	
	public static void main(String[] args) {
		chessGameEngine = new ChessGameEngine();	
		aiEngine = new AIEngine();
		int captured= 0;
		Move m, m1 = null;
		Piece p = null;
		int depth;
		Scanner sc = new Scanner(System.in);
		board = new Board();
		board.setInitialBoard();
		System.out.print("INITIAL ");
		board.displayBoard();
		
		//ask user for depth of search
		System.out.println("Enter the depth of search for the AI engine - any integer from 1 to 5");
		depth = sc.nextInt();
		//continue while game is not over
		while(!chessGameEngine.checkMate()){
			//System.out.println("tURN = "+ turn);
			boolean validMove = false;
			if(turn == 1){
				while(!validMove){
						m= movePiece();
						m1 = m;
						p = m1.getDestPiece();
						validMove = chessGameEngine.DoMove(m, turn);
				}
			}
				else{ 
					aiEngine.findBestMove(depth, turn);
				}	
			if (turn ==1){
				 System.out.print("After YOUR move ");
				 if(p!= null)
					 System.out.println("Your " + m1.getSrcPiece().getClass().getSimpleName() +" captured opponent's " +m1.getDestPiece().getClass().getSimpleName());
			}
			board.displayBoard();
			turn = (turn ==1)?  2: 1;
		}
	}
	

	static Move movePiece(){
		int x1,y1, x2, y2;
		char c;
		Square p1, p2;
		Scanner sc = new Scanner(System.in);
		System.out.println("Your turn, make a move");
		System.out.println("Which piece do you want to move - give column# followed by row #");
		String src = sc.nextLine();
		src.trim();
		x1 = get_X(src.charAt(0));
		c= src.charAt(1);
		y1 = Integer.parseInt(Character.toString(c))-1;
		System.out.println("Specify target or destination for the piece you just chose in the same format as above ");
		String dest = sc.nextLine();
		dest.trim();
		x2 = get_X(dest.charAt(0));
		c=dest.charAt(1);
		y2 = Integer.parseInt(Character.toString(c))-1;
		p1 = new Square(x1, y1);
		p2 = new Square (x2, y2);
		return new Move(p1, p2);
	}
	
	static int get_X(char xValue){
		int xCoord = -1;
		switch(xValue){
			case 'A': 
				xCoord = 7;
				break;
			case 'B': 
				xCoord = 6;
				break;
			case 'C': 
				xCoord = 5;
				break;
			case 'D': 
				xCoord = 4;
				break;
			case 'E': 
				xCoord = 3;
				break;
			case 'F': 
				xCoord = 2;
				break;
			case 'G': 
				xCoord = 1;
				break;
			case 'H': 
				xCoord = 0;
		}
		return xCoord;
	}
	
}
