package Chess;
import java.util.ArrayList;

//class to make moves by the computer
public class AIEngine {
		int mctr,lctr;
		int l0,l1,l2,l3,l4,l5,l6,l7,l8;
		Move aiMove;
		ChessGameEngine cge = new ChessGameEngine();

		public  int[] findBestMove(int depth, int playerTurn) {
			mctr =0;
			lctr =0;
			l0=0; l1=0; l2=0; l3=0; l4=0; l5=0; l6=0; l7=0; l8=0;
			int value = alphaBetaMax(depth, playerTurn, Integer.MIN_VALUE, Integer.MAX_VALUE);
			cge.DoMove(aiMove, playerTurn);
			System.out.print("COMPUTER AI chose a counter move as follows : ");
			System.out.print(aiMove);
			return new int[] {mctr, lctr};
		}
		
		//identifies the best move and returns a rank
		public int alphaBetaMax(int lDepth, int playerTurn, int alpha, int beta) {
			Move maxMove = null;
			ArrayList<Move> moves;
			
			switch(lDepth){
			case 8: l8++; break;
			case 7: l7++; break;
			case 6: l6++; break;
			case 5: l5++; break;
			case 4: l4++; break;
			case 3: l3++; break;
			case 2: l2++; break;
			case 1: l1++; break;
			}
			mctr++;
			if(lDepth == 0){
				lctr++;
				return evaluateConfiguration();
			}
			
			//identify best move
			moves = ListOfMoves.makeAMove(playerTurn, ChessGame.board); 
			for (Move move : moves) {
				int	rank = -1;
				try {
					cge.DoMove(move, playerTurn);
					int tempTurn = (playerTurn ==1)?  2: 1;
					rank = alphaBetaMin(lDepth -1, tempTurn, alpha, beta); //change score to rank***
					cge.rollBack(move, playerTurn);
				} catch (Exception e) {
					e.printStackTrace();
					}
				if(rank >= beta){
					return beta;
				}
				if(rank > alpha){
					maxMove = move;
					alpha = rank;
				}
			}
			if(maxMove != null){
				aiMove = maxMove;
			}
			return alpha;
		}

		public  int alphaBetaMin(int lDepth, int playerTurn, int alpha, int beta) {
			Move minMove = null;
			ArrayList<Move> moves;
			
			switch(lDepth){
			case 8: l8++; break;
			case 7: l7++; break;
			case 6: l6++; break;
			case 5: l5++; break;
			case 4: l4++; break;
			case 3: l3++; break;
			case 2: l2++; break;
			case 1: l1++; break;
			}

			if(lDepth == 0){
				lctr++;
				return evaluateConfiguration();
			}
			moves = ListOfMoves.makeAMove(playerTurn, ChessGame.board); 
			for (Move move : moves) {
				int	rank = -1;
				try {
					cge.DoMove(move, playerTurn);
					int tempTurn = (playerTurn ==1)?  2: 1;
					rank = alphaBetaMax(lDepth -1, tempTurn, alpha, beta);
					cge.rollBack(move, playerTurn);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(rank <= alpha){
					return alpha;
				}
				if(rank < beta){
					minMove = move;
					beta = rank;
				}
			}
			if(minMove != null){
				aiMove = minMove;
			}
			return beta;
		}
		
		//method for board evaluation to return the rank for each possible configuration
		public int evaluateConfiguration(){
			int rank = 0;
			for(int i = 0; i < 8; i++){
				for(int j = 0; j < 8; j++){
					Piece p = ChessGame.board.getBoard()[i][j];
					if(p != null){
						if(p.player == ChessGame.turn){
							rank += (p.getBaseValue() + p.getPlaceValue(i,j));
						}
						else{
							rank -= (p.getBaseValue() + p.getPlaceValue(i,j));
							}
					}
				}
			}
		return rank;
		}
		
	
}
