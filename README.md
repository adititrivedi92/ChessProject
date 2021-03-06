# ChessProject
Java implementation of AI Chess game using a search scheme with alpha-beta pruning

## **Development Environment**

This project was developed in the Eclipse IDE; to run this program download the code and import it to Eclipse. The latest version for the Eclipse IDE can be found [here](http://www.eclipse.org/downloads/eclipse-packages/)

## **Description of the classes**

- **_ChessGame.java_** <br />
This is the driver class which contains the main method. The white pieces prefixed with "w_" refer to users (player 1) pieces and the pieces prefixed with "_b" refer to the computer's pieces. The user is prompted for inputting the depth of search for the AI Engine. The game starts with player number 1, which is the human player. The user is asked to make a move in terms of source(from) and destination(to) locations mentioned as col-row. After the human move is made and validated, the computer makes a move and then human and computer take turns one by one.

- **_Piece.java_** <br />
This is an abstract class to describe a chess piece. All other classes, representing different type of chess pieces - Bishop, Horse(Knight), King, Pawn, Queen and Rook inherit from this class. This class has two data members - player which can have value 1 or 2, indicating a piece belonging to human player and a piece belonging to computer player respectively. Besides this it has a variable notFirstMove which is used to determine if this is the first move or not for the Pawn. There are three abstract methods implemented in the classes which inherit from this class:
   - *myMoves()*: generates an array list of the valid moves for the piece according to the rules of the game.
   - *getBaseValue()*: returns the base value of the piece depending on the type of the piece
   - *getPlaceValue()*: returns the rank/score of the piece depending on its current position on the chess board

- **_PieceSquareMatrix.java_** <br />
This class stores a 2-dimensional array for each type of piece. Piece square matrix stores scores/ranks for each type of piece at different positions on the chess board. Built with the help of the[chessprogrammingwiki] (https://chessprogramming.wikispaces.com)

- **_Bishop.java, Horse.java, King.java, Pawn.java, Queen.java, Rook.java_** <br />
All these classes extend the Piece class. The implementation of the myMoves method is added according to the chess game rules in each of these classes. *getPlaceValue()* returns the positional value and retrieves data from Piece square tables specified in the PieceSquareMatrix class as described above. *getBaseValue()* returns the value of the piece as follows:
   - Pawn - 100
   - Horse - 320
   - Bishop - 330
   - Rook - 500
   - Queen - 900
   - King - 20000<br />

- **_Square.java_** <br />
This class represents each cell of the board in terms of x and y coordinates. This class is used to build the objects of the Move class. A method called equals has been implemented for this class to compare if two objects refer to the same entity.

- **_Move.java_** <br />
This class is used to construct the move objects. Each move object has a source and destination of the move. Both source and destination are of the type Square. Besides the constructor, this class has method to print the move in a user friendly manner

- **_ListOfMoves.java_** <br />
This class has to data members, it just has one method called *makeAMove()* which generates all possible moves for the current configuration of the board and returns these moves in an array list. This method is invoked by the AIEngine class.

- **_Board.java_** <br />
This class models the description of the board as a 2-dimensional (8x8) array of Pieces. This class has method to initialize the board to its initial configuration and display the board configuration on the console. Besides the getter and setter methods for its data members this class contains move method, which moves the selected piece from source to destination. 

- **_ChessGameEngine.java_** <br />
This class forms the core of the moves made by human player.  It has one static variable cge of its own class type and a list of active pieces. The main method of this class is *DoMove()* which accepts the parameters - move object (which specifies the source and destination of the move) and the player number. This method executes the move specified in the move object with help of other methods:
     - *validateSrc()*: validates the source of move in all respects 
     - *validateDest()*: validates the destination of the move in all respects 
     - *movePromotion()*: makes the move and promotes the pawn if eligible to Queen <br />

- **_AIEngine.java_** <br />
This class forms the brain of the computer moves and the *findBestMove()* method is invoked by the driver class (ChessGame.java) when it the turn of the computer player. This uses alphabeta pruning algorithm to determine the best move. The level of depth of the search of best move for the *findBestMove()* method is inputted from the user while launching the game. 

## Board Evaluation

The board evaluation strategy is based on the base value of the piece and its positional value. The base value is predefined for each type of piece and positional value is calculated by a method called getPlaceValue which retrieves data from Piece square tables specified for each type of piece. *PieceSquareMatrix* stores scores/ranks for each type of piece at different positions on the chess board. Rank value is added to previous rank value for the player who is taking the turn and reduced for the opponent. The board evaluation method is used in the alpha beta algorithm for determining the best move.


## **References**
https://chessprogramming.wikispaces.com/Simplified+evaluation+function<br />
http://www.chessbin.com/post/Piece-Square-Table<br />
https://www.chessprogramming.net/using-excel-to-help-create-piece-square-tables/<br />
https://medium.freecodecamp.org/simple-chess-ai-step-by-step-1d55a9266977<br />


