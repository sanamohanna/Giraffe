package UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Enum.Directions;
import model.Location;
import model.Queen;

class QueenMoveTestTest {
	@Test
	public void testShortestDistance() {
		Queen queen = new Queen();
		queen.setLocation(new Location(0, 0));
		double distance = queen.shortestDistance(queen.getLocation(), new Location(0, 4));
		assertEquals(4, distance);
	}
	@Test
	public void testStrightMoveQueen() {
//    intial location is board side
		Queen queen = new Queen();
	    int expectedOutput = 0;
	    int actualOutput = queen.StrightMoveQueen(Directions.UP);
	    assertEquals(expectedOutput, actualOutput);
	}
	
}
