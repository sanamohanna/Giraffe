package UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Enum.Directions;
import model.Knight;
import model.Location;

class KnightMoveTest {

	@Test
	void level1KnightMoveRRDTest() {
		Throwable exception = assertThrows(
	            IllegalArgumentException.class, () -> {
	              Knight knight = new Knight(new Location(0, 0));
	    knight.level1Move(Directions.LEFT, Directions.RIGHT, Directions.DOWN, "0", "0");
	            }
	    );
		
			assertEquals("illegal Move", exception.getMessage());
	}

	@Test
	void level1KnightMoveRRUTest() {
		Knight knight = new Knight(new Location(0, 0));
		Location actualLocation = knight.level1Move(Directions.RIGHT, Directions.RIGHT, Directions.UP, "0", "1");
		Location expectedLocation = new Location(2, 0);
		assertEquals(expectedLocation, actualLocation);
	}

	@Test
	void level2KnightMoveRRD_RTest() {
		Knight knight = new Knight(new Location(0, 0));
		Location actualLocation = knight.level2Move(Directions.RIGHT, Directions.RIGHT, Directions.DOWN_RIGHT, "0", "0");
		Location expectedLocation = new Location(3, 1);
		assertEquals(expectedLocation, actualLocation);
	}

	@Test
	void level2KnightMoveRRU_RTest() {
		Knight knight = new Knight(new Location(0, 0));
		Location actualLocation = knight.level2Move(Directions.RIGHT, Directions.RIGHT, Directions.UP_RIGHT, "0", "0");
		Location expectedLocation = new Location(3, 7);
		assertEquals(expectedLocation, actualLocation);
	}

	@Test
	void knightAllValidMoveLevel1Test() {
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
		ArrayList<Location> expectedLocations = new ArrayList<Location>();
		for (int i = 0; i < actualLocations.size(); i++) {
			System.out.println("the actual:" + actualLocations.get(i));
		}
		expectedLocations.add(new Location(1, 4));
		expectedLocations.add(new Location(3, 4));
		expectedLocations.add(new Location(1, 0));
		expectedLocations.add(new Location(3, 0));
		expectedLocations.add(new Location(4, 3));
		expectedLocations.add(new Location(4, 1));
		expectedLocations.add(new Location(0, 3));
		expectedLocations.add(new Location(0, 1));
		for (int i = 0; i < expectedLocations.size(); i++) {
			System.out.println("the expected:" + expectedLocations.get(i));
		}
		assertEquals(expectedLocations, actualLocations);
	}
	}
