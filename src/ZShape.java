import java.awt.Color;


public class ZShape extends AbstractPiece {
	
	public ZShape(int r, int c, Grid g) {
		
		super();
		grid = g;
		square = new Square[PIECE_COUNT];
		ableToMove = true;

		// Create the squares
		square[0] = new Square(g, r - 1, c - 1, Color.RED, true);
		square[1] = new Square(g, r - 1, c, Color.RED, true);
		square[2] = new Square(g, r , c, Color.RED, true);
		square[3] = new Square(g, r , c + 1, Color.RED, true);
	}

}
