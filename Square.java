package Chess;

//class to represent each cell of the board
public class Square {
	public int x;
	public int y;
	
	public Square(int x1, int y1){
		x = x1;
		y = y1;
	}
	
	public String toString(){
		return String.format("(%d,%d)", x,y);
	}
	
	public boolean equals(Object obj) {
	        if (obj instanceof Square){
	            Square p = (Square) obj;
	            if(p.x == x && p.y == y){
	            	return true;
	            	
	            }
	        }
	     return false;
	  }
}