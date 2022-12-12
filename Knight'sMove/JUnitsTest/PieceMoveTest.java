import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Enum.Directions;
import model.Location;
import model.Piece;
import model.SysData;

class PieceMoveTest {

	@Test
	void strightPieceMoveUPTest() {
		Location location1 = new Location(0,0);
		Piece piece1 = new Piece(location1);
		piece1.StrightMove(Directions.UP);
		Location locationExpected1 = new Location(0,7);
		assertEquals(locationExpected1,piece1.getLocation());
	}
	@Test
	void strightPieceMoveDOWNTest() {
		Location location2 = new Location(0,0);
		Piece piece2 = new Piece(location2);
		piece2.StrightMove(Directions.DOWN);
		Location locationExpected2 = new Location(0,1);
		assertEquals(locationExpected2,piece2.getLocation());
	}
	@Test
	void strightPieceMoveLEFTTest() {
		Location location3 = new Location(0,0);
		Piece piece3 = new Piece(location3);
		piece3.StrightMove(Directions.LEFT);
		Location locationExpected3 = new Location(7,0);
		assertEquals(locationExpected3,piece3.getLocation());
	}
	@Test
	void strightPieceMoveRIGHTTest() {
		Location location4 = new Location(0,0);
		Piece piece4 = new Piece(location4);
		piece4.StrightMove(Directions.RIGHT);
		Location locationExpected4 = new Location(1,0);
		assertEquals(locationExpected4,piece4.getLocation());	
	}
}
