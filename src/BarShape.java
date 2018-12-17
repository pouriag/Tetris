import java.awt.Color;


public class BarShape extends AbstractPiece {

	public BarShape(int r, int c, Grid g) {
		
		super();
		grid = g;
		square = new Square[PIECE_COUNT];
		ableToMove = true;

		// Create the squares
		square[0] = new Square(g, r - 1, c - 1, Color.CYAN, true);
		square[1] = new Square(g, r - 1, c, Color.CYAN, true);
		square[2] = new Square(g, r - 1, c + 1, Color.CYAN, true);
		square[3] = new Square(g, r - 1, c + 2, Color.CYAN, true);
	}
	
}
