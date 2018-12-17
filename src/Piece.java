import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


public interface Piece {

	void move(Direction direction);
	void draw(Graphics g);
	Point[] getLocations();
	Color getColor();
	boolean canMove(Direction direction);
	void rotate();
	
	
	
	
}
