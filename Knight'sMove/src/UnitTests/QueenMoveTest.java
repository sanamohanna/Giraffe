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
		queen = new Queen();
	}

	@Test
	public void testShortestDistance() {
		queen.setLocation(new Location(0, 0));
		double distance = queen.shortestDistance(queen.getLocation(), new Location(0, 4));
		assertEquals(4, distance);
	}

	@Test
	public void testStrightMoveQueen() {
//    intial location is board side
		int expectedOutput = 0;
		int actualOutput = queen.StrightMoveQueen(Directions.UP);
		assertEquals(expectedOutput, actualOutput);
	}

	@AfterEach
	public void tearDown() {
		queen = new Queen();
	}

}
