import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;


public class TetrisTest {
	
	@Test
	public void testCheckRows() {
		// Create a grid with some full rows
		Grid grid = new Grid();
		// add a getBoard to the Grid class (getBoard
		// should be used for testing only
		Square[][] board = grid.getBoard();
		
		for (int col = 0; col < Grid.WIDTH; col ++) {
			board[1][col].setColor(Color.RED);
		}
		// call check rows
		grid.checkRows();
		// check that the full rows have been removed
		for (int row = 0; row < Grid.HEIGHT; row ++) {
			for (int col = 0; col < Grid.WIDTH; col ++) {
				assertFalse(grid.isSet(row, col));
			}
		}
	}
	@Test
	public void testMovement() {
		Grid grid = new Grid();
		Square[][] board = grid.getBoard();
		LShape L = new LShape(1, Grid.WIDTH / 2 - 1, grid);
		//Test Left col
		
		for(int row = 0; row < Grid.HEIGHT; row++){
			assertFalse(board[row][0].canMove(Direction.LEFT));
		}

		//Test Every other col Left movement
		for(int col = 1; col < Grid.WIDTH; col++){
			for(int row = 0; row < Grid.HEIGHT; row++){
			assertTrue(!board[row][col].canMove(Direction.LEFT));
			}
		
		}
		
		//Tests Right Col
				for(int row = 0; row < Grid.HEIGHT; row++){
					assertFalse(board[row][Grid.WIDTH-1].canMove(Direction.RIGHT));
				}
		
		//Test every other col Right Movement
				for(int col = 0; col < Grid.WIDTH-1; col++){
					for(int row = 0; row < Grid.HEIGHT; row++){
					assertTrue(!board[row][col].canMove(Direction.RIGHT));
					}
				
				}
				
		//Test Downward Motion
				for(int row = 0; row < Grid.HEIGHT-1; row++){
					for(int col = 0; col < Grid.WIDTH; col++){
						assertFalse(board[row][col].canMove(Direction.DOWN));
					}
				}
		//Can the bottom row move?
				for(int col = 0; col < Grid.WIDTH; col++){
					assertFalse(board[Grid.HEIGHT-1][col].canMove(Direction.DOWN));
				}
		//Can a shape move to the bottom?
				for(int row = 0; row < Grid.HEIGHT-1; row++){
					for(int col = 0; col < Grid.WIDTH; col++){
						assertFalse(board[row][col].canMove(Direction.BOTTOM));
					}
				}
		//Can the L shape move?
			assertTrue(L.canMove(Direction.DOWN));
			assertTrue(L.canMove(Direction.LEFT));	
			assertTrue(L.canMove(Direction.RIGHT));	
			assertTrue(L.canMove(Direction.BOTTOM));	

			
			
	}
	
	@Test
	public void testRotation(){
		Grid grid = new Grid();
		Square[][] board = grid.getBoard();
		
		//testing for LShape
		AbstractPiece L= new LShape(1, Grid.WIDTH / 2 - 1, grid);
		for (int i = 0 ; i<4; i++){
		Square list =  L.arrayOfSquares(i);
		
		for(int row = 0; row < Grid.HEIGHT-1; row++){
			for(int col = 0; col < Grid.WIDTH; col++){	
				assertTrue(board[row][col].checkBounds(list));
			}
		}
		}
		
		AbstractPiece J= new JShape(1, Grid.WIDTH / 2 - 1, grid);
		for (int i = 0 ; i<4; i++){
		Square list =  J.arrayOfSquares(i);
		
		for(int row = 0; row < Grid.HEIGHT-1; row++){
			for(int col = 0; col < Grid.WIDTH; col++){	
				assertTrue(board[row][col].checkBounds(list));
			}
		}
		}
		
		AbstractPiece S = new SShape(1, Grid.WIDTH / 2 - 1, grid);
		for (int i = 0 ; i<4; i++){
		Square list =  S.arrayOfSquares(i);
		
		for(int row = 0; row < Grid.HEIGHT-1; row++){
			for(int col = 0; col < Grid.WIDTH; col++){	
				assertFalse(board[row][col].checkBounds(list));
			}
		}
		}
		AbstractPiece Z= new ZShape(1, Grid.WIDTH / 2 - 1, grid);
		for (int i = 0 ; i<4; i++){
		Square list =  Z.arrayOfSquares(i);
		
		for(int row = 0; row < Grid.HEIGHT-1; row++){
			for(int col = 0; col < Grid.WIDTH; col++){	
				assertFalse(board[row][col].checkBounds(list));
			}
		}
		}
		
		AbstractPiece T = new TShape(1, Grid.WIDTH / 2 - 1, grid);
		for (int i = 0 ; i<4; i++){
		Square list =  T.arrayOfSquares(i);
		
		for(int row = 0; row < Grid.HEIGHT-1; row++){
			for(int col = 0; col < Grid.WIDTH; col++){	
				assertTrue(board[row][col].checkBounds(list));
			}
		}
		}
		
		AbstractPiece B = new BarShape(1, Grid.WIDTH / 2 - 1, grid);
		for (int i = 0 ; i<4; i++){
		Square list =  B.arrayOfSquares(i);
		
		for(int row = 0; row < Grid.HEIGHT-1; row++){
			for(int col = 0; col < Grid.WIDTH; col++){	
				assertTrue(board[row][col].checkBounds(list));
			}
		}
		}
		
		AbstractPiece Sq = new SquareShape(1, Grid.WIDTH / 2 - 1, grid);
		for (int i = 0 ; i<4; i++){
		Square list =  Sq.arrayOfSquares(i);
		
		for(int row = 0; row < Grid.HEIGHT-1; row++){
			for(int col = 0; col < Grid.WIDTH; col++){	
				assertTrue(board[row][col].checkBounds(list));
			}
		}
		}
	}
	
}
