import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


public abstract class AbstractPiece implements Piece{

	protected boolean ableToMove; // can this piece move
	protected Square[] square; // the squares that make up this piece
	protected static final int PIECE_COUNT = 4;
	protected Grid grid; // the board this piece is on
	
	
	
	/**
	 * Draws the piece on the given Graphics context
	 */
	public void draw(Graphics g) {
		for (int i = 0; i < PIECE_COUNT; i++) {
			square[i].draw(g);
		}
	}
	
	
	/**
	 * Moves the piece if possible Freeze the piece if it cannot move down
	 * anymore
	 * 
	 * @param direction
	 *            the direction to move
	 */
	public void move(Direction direction) {
		if (canMove(direction)) {
		if(direction == Direction.BOTTOM){
			while(canMove(direction)){
				for (int i = 0; i < PIECE_COUNT; i++)
					square[i].move(Direction.DOWN);
			}
		}
			for (int i = 0; i < PIECE_COUNT; i++)
				square[i].move(direction);
		}
		// if we couldn't move, see if because we're at the bottom
		else if (direction == Direction.DOWN) {
			ableToMove = false;
		}
	}
	
	/**
	 * Returns the (row,col) grid coordinates occupied by this Piece
	 * 
	 * @return an Array of (row,col) Points
	 */
	public Point[] getLocations() {
		Point[] points = new Point[PIECE_COUNT];
		for (int i = 0; i < PIECE_COUNT; i++) {
			points[i] = new Point(square[i].getRow(), square[i].getCol());
		}
		return points;
	}

	/**
	 * Return the color of this piece
	 */
	public Color getColor() {
		// all squares of this piece have the same color
		return square[0].getColor();
	}
	
	/**
	 * Returns if this piece can move in the given direction
	 * 
	 */
	public boolean canMove(Direction direction) {
		if (!ableToMove)
			return false;
		
		// Each square must be able to move in that direction
		boolean answer = true;
		for (int i = 0; i < PIECE_COUNT; i++) {
			answer = answer && square[i].canMove(direction);
		}

		return answer;
	}
	
	private void moveTwice(Square c, Direction d1, Direction d2){
		if( d1 == d2){
		for(int i = 0; i < 2; i++){
			if(c.canMove(d1)){
				c.move(d1);
				} else break;
			}
		}else {
			if(c.canMove(d1)){
				c.move(d1);
				if(c.canMove(d2)){
					c.move(d2);
				}
			} 
		}
		
	}
	
	
	
	
	public void rotate(){
		for(Square c : square){
			if(c.checkBounds(square[1])){
			//All pieces aside from squareshape and bar
			if(c.getRow() == (square[1].getRow() - 1) && c.getCol() == (square[1].getCol() - 1)){
				moveTwice(c, Direction.RIGHT, Direction.RIGHT);
			} else if (c.getRow() == (square[1].getRow() - 1) && c.getCol() == (square[1].getCol())){
				moveTwice(c, Direction.DOWN, Direction.RIGHT);
			} else if (c.getRow() == (square[1].getRow() - 1) && c.getCol() == (square[1].getCol() + 1)){
				moveTwice(c, Direction.DOWN, Direction.DOWN);
			} else if (c.getRow() == (square[1].getRow()) && c.getCol() == (square[1].getCol() + 1)){
				moveTwice(c, Direction.DOWN, Direction.LEFT);
			} else if (c.getRow() == (square[1].getRow() + 1) && c.getCol() == (square[1].getCol() + 1)){
				moveTwice(c, Direction.LEFT, Direction.LEFT);
			} else if (c.getRow() == (square[1].getRow() + 1) && c.getCol() == (square[1].getCol())){
				moveTwice(c, Direction.LEFT, Direction.UP);
			} else if (c.getRow() == (square[1].getRow() + 1) && c.getCol() == (square[1].getCol() - 1)){
				moveTwice(c, Direction.UP, Direction.UP);
			} else if (c.getRow() == (square[1].getRow()) && c.getCol() == (square[1].getCol() - 1)){
				moveTwice(c, Direction.UP, Direction.RIGHT);
			} 
			//Specific to bar piece.
			else if (c.getRow() == (square[1].getRow()) && c.getCol() == (square[1].getCol() + 2)){
				moveTwice(c, Direction.DOWN, Direction.DOWN);
				moveTwice(c, Direction.LEFT, Direction.LEFT);
			} else if (c.getRow() == (square[1].getRow() + 2) && c.getCol() == (square[1].getCol())){
				moveTwice(c, Direction.UP, Direction.UP);
				moveTwice(c, Direction.LEFT, Direction.LEFT);				
			} else if (c.getRow() == (square[1].getRow()) && c.getCol() == (square[1].getCol() -2)){
				moveTwice(c, Direction.UP, Direction.UP);
				moveTwice(c, Direction.RIGHT, Direction.RIGHT);
			} else if (c.getRow() == (square[1].getRow() - 2) && c.getCol() == (square[1].getCol())){
				moveTwice(c, Direction.DOWN, Direction.DOWN);
				moveTwice(c, Direction.RIGHT, Direction.RIGHT);

				}
			
			
			}
		}
	}	
	public Square arrayOfSquares(int i){
		
		return square[i];
	}
	
}
	

	
