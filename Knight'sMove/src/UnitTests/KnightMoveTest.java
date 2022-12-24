package UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Enum.Directions;
import model.Knight;
import model.Location;

class KnightMoveTest {

	@Test
	void level1Test() {
		Knight knight = new Knight(new Location(0, 0));
		Location c = knight.level1Move(Directions.RIGHT, Directions.RIGHT, Directions.DOWN, "0", "0");
		Location locationExpected = new Location(2, 1);
		assertEquals(locationExpected, c);
	}

	@Test
	void level2Test() {
		Knight knight = new Knight(new Location(0, 0));
		Location c = knight.level2Move(Directions.RIGHT, Directions.RIGHT, Directions.DOWN_RIGHT, "0", "0");
		Location locationExpected = new Location(3, 1);
		assertEquals(locationExpected, c);
	}

	@Test
	void allValidMoveLevel1Test() {
		/*
		 * 0,3 (up up right)
		 * 0,1 (up up left )
		 * 1,0 (left left up)
		 * 1,4 (right right up)
		 * 3,0 (left left down)
		 * 3,4 (right right down)
		 * 4,1 (down down left)
		 * 4,3 (down down right)
		 * 
		 */
		Knight knight = new Knight(new Location(2, 2));
		ArrayList<Location> actualLocations = knight.allValidMovesLevel1(knight);
		ArrayList<Location> locationExpected = new ArrayList<Location>();
		for (int i = 0; i < actualLocations.size(); i++) {
			System.out.println("the actual:" + actualLocations.get(i));
		}
		locationExpected.add(new Location(1, 4));
		locationExpected.add(new Location(3, 4));
		locationExpected.add(new Location(1, 0));
		locationExpected.add(new Location(3, 0));
		locationExpected.add(new Location(4, 3));
		locationExpected.add(new Location(4, 1));
		locationExpected.add(new Location(0, 3));
		locationExpected.add(new Location(0, 1));
		for (int i = 0; i < locationExpected.size(); i++) {
			System.out.println("the expected:" + locationExpected.get(i));
		}
		assertEquals(locationExpected, actualLocations);
	}

}
