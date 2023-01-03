package UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Enum.Directions;
import model.Location;
import model.Queen;

public class QueenMoveTest {
	private Queen queen;

	// "setup" method
	@BeforeEach
	public void setUp() {
//	    intial location is board side
		queen = new Queen();
	}

	@Test
	//id:13
	//check if the method shortestDistance return the short distance by given two locations
	public void testShortestDistance() {
		queen.setLocation(new Location(0, 0));
		double distance = queen.shortestDistance(queen.getLocation(), new Location(0, 4));
		assertEquals(4, distance);
	}

	@Test
	//id:14
	//check the legality of queen move 
	public void testStrightMoveQueen() {
		int expectedOutput = 0;
		int actualOutput = queen.StrightMoveQueen(Directions.UP);
		assertEquals(expectedOutput, actualOutput);
	}
	// reset the queen object
	@AfterEach
	public void tearDown() {
		queen = new Queen();
	}

}
